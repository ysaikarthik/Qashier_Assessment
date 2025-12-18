# Qashier HQ - Staff Management Automation

> **Complete Test Automation Framework** for Add/Edit/Delete staff features using **Java**, **Selenium WebDriver**, and **TestNG**

[![Java](https://img.shields.io/badge/Java-17+-orange.svg)](https://www.oracle.com/java/)
[![Selenium](https://img.shields.io/badge/Selenium-4.24.0-green.svg)](https://www.selenium.dev/)
[![TestNG](https://img.shields.io/badge/TestNG-7.10.2-red.svg)](https://testng.org/)
[![Allure](https://img.shields.io/badge/Allure-2.24.0-blue.svg)](https://docs.qameta.io/allure/)

---

## 📋 Quick Links

- [Windows Setup Guide](#-windows-setup-guide)
- [Mac Setup Guide](#-mac-setup-guide)
- [Running Tests](#-running-tests)
- [Viewing Reports](#-viewing-allure-reports)
- [Troubleshooting](#-troubleshooting)

---

## 🎯 What This Project Does

Automates testing of **Staff Management** in Qashier HQ:
- ✅ **Login** to Qashier HQ
- ✅ **Add** new staff with random data
- ✅ **Edit** staff details (hourly rate)
- ✅ **Delete** staff records
- ✅ **Verify** all operations with assertions
- ✅ **Generate** beautiful test reports

**Total Test Cases**: 10 (All automated)

---

## 🪟 Windows Setup Guide

### Step 1: Install Java 17

1. **Download Java 17**:
   - Go to: https://www.oracle.com/java/technologies/downloads/#java17
   - Download **Windows x64 Installer** (`.exe` file)
   - Run the installer and follow prompts

2. **Verify Installation**:
   ```cmd
   java -version
   ```
   Expected output: `java version "17.0.x"`

3. **Set JAVA_HOME** (if needed):
   - Open **Control Panel** → **System** → **Advanced System Settings**
   - Click **Environment Variables**
   - Under **System Variables**, click **New**:
     - Variable name: `JAVA_HOME`
     - Variable value: `C:\Program Files\Java\jdk-17` (your Java installation path)
   - Find `Path` variable, click **Edit**, add: `%JAVA_HOME%\bin`
   - Click **OK** to save

### Step 2: Install Google Chrome

Download and install from: https://www.google.com/chrome/

### Step 3: Download the Project

```cmd
git clone <your-repository-url>
cd Qashier_Assessment\java-e2e
```

### Step 4: Set Environment Variables

**Option A: Command Prompt (cmd)**
```cmd
set HQ_EMAIL=test369@gmail.com
set HQ_PASSWORD=test@123
set HEADLESS=false
```

**Option B: PowerShell**
```powershell
$env:HQ_EMAIL="test369@gmail.com"
$env:HQ_PASSWORD="test@123"
$env:HEADLESS="false"
```

**Option C: Set Permanently (Recommended)**
1. Open **System Properties** → **Environment Variables**
2. Under **User Variables**, click **New** for each:
   - Variable: `HQ_EMAIL` | Value: `test369@gmail.com`
   - Variable: `HQ_PASSWORD` | Value: `test@123`
   - Variable: `HEADLESS` | Value: `false`
3. Click **OK** to save

### Step 5: Run Tests

```cmd
mvnw.cmd clean test
```

### Step 6: Install Allure (For Reports)

1. **Download Allure**:
   - Go to: https://github.com/allure-framework/allure2/releases
   - Download `allure-2.xx.x.zip`
   - Extract to `C:\allure`

2. **Add to PATH**:
   - **System Properties** → **Environment Variables**
   - Find `Path` variable, click **Edit**
   - Add: `C:\allure\bin`
   - Click **OK**

3. **Verify Installation**:
   ```cmd
   allure --version
   ```

### Step 7: View Report

**IMPORTANT: Clean old results first!**
```cmd
rmdir /s /q allure-results
mvnw.cmd clean test
allure serve allure-results
```

**Done! 🎉** The report will open in your browser automatically.

---

## 🍎 Mac Setup Guide

### Step 1: Install Homebrew (if not installed)

```bash
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
```

### Step 2: Install Java 17

```bash
brew install openjdk@17
```

**Set JAVA_HOME**:
```bash
echo 'export JAVA_HOME=/opt/homebrew/opt/openjdk@17' >> ~/.zshrc
echo 'export PATH="$JAVA_HOME/bin:$PATH"' >> ~/.zshrc
source ~/.zshrc
```

**Verify Installation**:
```bash
java -version
```
Expected output: `openjdk version "17.0.x"`

### Step 3: Install Google Chrome

Download and install from: https://www.google.com/chrome/

### Step 4: Download the Project

```bash
git clone <your-repository-url>
cd Qashier_Assessment/java-e2e
```

### Step 5: Set Environment Variables

**Option A: Temporary (Current Session Only)**
```bash
export HQ_EMAIL="test369@gmail.com"
export HQ_PASSWORD="test@123"
export HEADLESS=false
```

**Option B: Permanent (Recommended)**

Add to `~/.zshrc` (or `~/.bash_profile` if using bash):
```bash
echo 'export HQ_EMAIL="test369@gmail.com"' >> ~/.zshrc
echo 'export HQ_PASSWORD="test@123"' >> ~/.zshrc
echo 'export HEADLESS=false' >> ~/.zshrc
source ~/.zshrc
```

### Step 6: Make Maven Wrapper Executable

```bash
chmod +x mvnw
```

### Step 7: Run Tests

```bash
./mvnw clean test
```

### Step 8: Install Allure (For Reports)

```bash
brew install allure
```

**Verify Installation**:
```bash
allure --version
```

### Step 9: View Report

**IMPORTANT: Clean old results first!**
```bash
rm -rf allure-results
./mvnw clean test
allure serve allure-results
```

**Done! 🎉** The report will open in your browser automatically.

---

## ▶️ Running Tests

### Basic Test Run

**Windows:**
```cmd
mvnw.cmd clean test
```

**Mac/Linux:**
```bash
./mvnw clean test
```

### Running in Headless Mode (No Browser Window)

**Windows:**
```cmd
set HEADLESS=true
mvnw.cmd clean test
```

**Mac/Linux:**
```bash
export HEADLESS=true
./mvnw clean test
```

### Running Specific Test

**Windows:**
```cmd
mvnw.cmd test -Dtest=SimpleStaffTest
```

**Mac/Linux:**
```bash
./mvnw test -Dtest=SimpleStaffTest
```

### What Happens During Test Execution?

1. ✅ Browser opens (Chrome)
2. ✅ Navigates to Qashier HQ login page
3. ✅ Logs in with credentials
4. ✅ Goes to Staff Management
5. ✅ Checks for existing staff (deletes if found)
6. ✅ Adds new staff with random data
7. ✅ Edits the staff (updates hourly rate)
8. ✅ Deletes the staff
9. ✅ Verifies "No data available" message
10. ✅ Browser closes
11. ✅ Test results saved to `allure-results/`

**Test Duration**: ~50-60 seconds

---

## 📊 Viewing Allure Reports

### ⚠️ IMPORTANT: Always Clean Old Results First!

**Windows:**
```cmd
rmdir /s /q allure-results
```

**Mac/Linux:**
```bash
rm -rf allure-results
```

**Why?** Old test results accumulate and cause confusion (showing failed tests from previous runs).

---

### Quick Method (Auto-open in Browser)

**Windows:**
```cmd
rmdir /s /q allure-results
mvnw.cmd clean test
allure serve allure-results
```

**Mac/Linux:**
```bash
rm -rf allure-results
./mvnw clean test
allure serve allure-results
```

This will:
- ✅ Generate the report
- ✅ Start a local web server
- ✅ Open the report in your default browser automatically
- ✅ URL: `http://127.0.0.1:<random-port>`

**Press `Ctrl+C` to stop the server when done.**

---

### Generating Static HTML Report

If you want to save the report as HTML files:

**Windows:**
```cmd
allure generate allure-results --clean -o allure-report
```

**Mac/Linux:**
```bash
allure generate allure-results --clean -o allure-report
```

Then open `allure-report\index.html` (Windows) or `allure-report/index.html` (Mac) in a browser.

---

### Understanding the Allure Report

#### **Overview Tab**
- **Total tests**: 1 test method
- **Total steps**: 10 (all your test cases visible as steps)
- **Pass rate**: 100% ✅
- **Execution time**: ~50-60 seconds
- **Pie chart**: Shows pass/fail distribution

#### **Suites Tab**
Click on **`testAddStaffFlow`** to see all 10 steps:

1. ✅ **TC-010**: Generate Random Test Data for Staff
2. ✅ **TC-001**: Verify Login to Qashier HQ
3. ✅ **TC-001**: Navigate to Staff Management
4. ✅ **TC-008**: Pre-test Cleanup - Handle Existing Staff
5. ✅ **TC-002**: Add Staff with Valid Data - TC-009: Validate Form Fields
6. ✅ **TC-003**: Verify Staff Appears in List After Add
7. ✅ **TC-004**: Edit Staff Details - Update Hourly Rate
8. ✅ **TC-005**: Verify Staff Updates in List After Edit
9. ✅ **TC-006**: Delete Staff
10. ✅ **TC-007**: Verify Staff Removed from List After Delete

#### **Behaviors Tab**
- Groups test cases by feature
- Shows: `Qashier HQ` feature with all test cases

#### **Timeline Tab**
- Visual timeline of test execution
- Shows duration of each step
- Helpful for identifying slow operations

#### **Graphs Tab**
- **Status Chart**: Pass/Fail distribution
- **Severity Chart**: Test priority distribution
- **Duration Chart**: Execution time trends

#### **Screenshots** (On Failure)
- If a test fails, screenshots are automatically captured
- Visible in the failed test step details
- Shows exact state of the application at failure

---

## 📁 Project Structure

```
java-e2e/
├── .mvn/                                # Maven Wrapper files
│   └── wrapper/
│       └── maven-wrapper.properties
├── src/
│   ├── main/java/com/qashier/hq/
│   │   ├── core/
│   │   │   └── BaseTest.java           # Base setup (WebDriver, waits)
│   │   ├── pages/
│   │   │   ├── LoginPage.java          # Login page actions
│   │   │   └── StaffPage.java          # Staff management actions
│   │   ├── util/
│   │   │   └── Config.java             # Configuration & data generation
│   │   └── listeners/
│   │       └── AllureListener.java     # Screenshot capture on failure
│   └── test/
│       ├── java/com/qashier/hq/tests/
│       │   └── SimpleStaffTest.java    # Main test (all 10 test cases)
│       └── resources/
│           └── testng.xml              # TestNG configuration
├── allure-results/                      # Test results (auto-generated)
├── target/                              # Build files (auto-generated)
├── pom.xml                              # Maven dependencies
├── mvnw                                 # Maven Wrapper (Mac/Linux)
├── mvnw.cmd                             # Maven Wrapper (Windows)
├── TEST_CASES.md                        # Detailed test documentation
└── README.md                            # This file
```

---

## 🔄 Test Flow Explained

### Complete Automated Flow:

**1. TC-010: Generate Random Test Data**
   - Staff name: `AutoStaff_<timestamp>`
   - PIN: Random 4-digit number
   - Hourly rate: Random 8-15 RM

**2. TC-001: Login & Navigate**
   - Navigate to `https://hq.qashier.com/#/`
   - Enter email: `test369@gmail.com`
   - Enter password: `test@123`
   - Click login
   - Wait for dashboard
   - Navigate to Staff Management

**3. TC-008: Pre-test Cleanup**
   - Check for "No data available" message
   - If staff exists → Delete it
   - Wait for "No data available" confirmation
   - **Why?** Lite plan only allows 1 staff member

**4. TC-002 + TC-009: Add Staff with Form Validation**
   - Click "Add Staff" button
   - Fill Name field
   - Fill Hourly Rate field
   - Fill Staff PIN field
   - Fill Confirm PIN field
   - Click "CONFIRM"

**5. TC-003: Verify Staff in List**
   - Wait for staff to appear
   - Assert staff name is visible

**6. TC-004: Edit Staff Details**
   - Click on staff entry
   - Update hourly rate to new random value
   - Click "CONFIRM"

**7. TC-005: Verify Staff Updated**
   - Wait for dialog to close
   - Assert staff still in list

**8. TC-006: Delete Staff**
   - Click on staff entry
   - Click "Delete" button
   - Click "Confirm" in delete dialog

**9. TC-007: Verify Staff Deleted**
   - Wait for "No data available" message
   - **Assert** message is present ✅
   - Confirms deletion was successful

**Total Duration**: ~50-60 seconds

**Why delete after each run?**
- The test account has a "Lite plan" limit of 1 staff member
- Deleting ensures the test can run repeatedly without manual cleanup

---

## 📝 Test Cases Summary

| ID | Test Case | Priority | Status |
|----|-----------|----------|--------|
| TC-001 | Login & Navigate | Critical | ✅ Automated |
| TC-002 | Add Staff | Critical | ✅ Automated |
| TC-003 | Verify Staff in List | Critical | ✅ Automated |
| TC-004 | Edit Staff | Critical | ✅ Automated |
| TC-005 | Verify Updates | Critical | ✅ Automated |
| TC-006 | Delete Staff | Critical | ✅ Automated |
| TC-007 | Verify Deletion | Critical | ✅ Automated |
| TC-008 | Pre-test Cleanup | High | ✅ Automated |
| TC-009 | Form Validation | High | ✅ Automated |
| TC-010 | Random Data | Medium | ✅ Automated |

**See [TEST_CASES.md](TEST_CASES.md) for detailed documentation.**

---

## ⚙️ Configuration

### Environment Variables (Required)

| Variable | Description | Example | Required |
|----------|-------------|---------|----------|
| `HQ_EMAIL` | Login email | `test369@gmail.com` | ✅ Yes |
| `HQ_PASSWORD` | Login password | `test@123` | ✅ Yes |
| `HEADLESS` | Browser mode | `false` (visible) or `true` (hidden) | ❌ No (default: false) |

---

## 🐛 Troubleshooting

### ❌ Problem: "Java not found"

**Windows Solution**:
1. Download Java 17 from https://www.oracle.com/java/technologies/downloads/
2. Install it
3. Add to PATH (see [Windows Step 1](#step-1-install-java-17))

**Mac Solution**:
```bash
brew install openjdk@17
echo 'export JAVA_HOME=/opt/homebrew/opt/openjdk@17' >> ~/.zshrc
echo 'export PATH="$JAVA_HOME/bin:$PATH"' >> ~/.zshrc
source ~/.zshrc
```

---

### ❌ Problem: "HQ_EMAIL must be provided"

**Solution**: Set environment variables before running tests (see setup guides above)

---

### ❌ Problem: "Permission denied: ./mvnw" (Mac/Linux)

**Solution**:
```bash
chmod +x mvnw
./mvnw clean test
```

---

### ❌ Problem: "Allure command not found"

**Windows Solution**:
1. Download from https://github.com/allure-framework/allure2/releases
2. Extract to `C:\allure`
3. Add `C:\allure\bin` to PATH

**Mac Solution**:
```bash
brew install allure
```

---

### ❌ Problem: "Report shows old failed tests" or "13 tests instead of 1"

**Solution**: ALWAYS clean old results before generating report!

**Windows:**
```cmd
rmdir /s /q allure-results
mvnw.cmd clean test
allure serve allure-results
```

**Mac/Linux:**
```bash
rm -rf allure-results
./mvnw clean test
allure serve allure-results
```

---

### ❌ Problem: "ChromeDriver not compatible"

**Solution**: Update Google Chrome to the latest version. WebDriverManager will automatically download the matching ChromeDriver.

---

### ❌ Problem: "Test fails due to timeout"

**Solutions**:
1. Check internet connection
2. Verify credentials are correct
3. Increase timeout in `BaseTest.java` (line ~30):
   ```java
   wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // was 20
   ```
4. Check if website is accessible: https://hq.qashier.com/

---

### ❌ Problem: "Element not found" errors

**Solution**: The website UI may have changed. Check:
1. XPaths in `StaffPage.java`
2. Wait conditions in test methods
3. Run in non-headless mode to see what's happening:
   ```bash
   export HEADLESS=false  # Mac/Linux
   set HEADLESS=false     # Windows
   ```

---

## 🚀 Running in CI/CD

### GitHub Actions Example

Create `.github/workflows/tests.yml`:

```yaml
name: Selenium Tests

on: [push, pull_request]

jobs:
  test:
    runs-on: ubuntu-latest
    
    steps:
      - uses: actions/checkout@v3
      
      - name: Set up JDK 17
        uses: actions/setup-java@v3
        with:
          java-version: '17'
          distribution: 'temurin'
      
      - name: Run tests
        env:
          HQ_EMAIL: ${{ secrets.HQ_EMAIL }}
          HQ_PASSWORD: ${{ secrets.HQ_PASSWORD }}
          HEADLESS: true
        run: ./mvnw clean test
      
      - name: Generate Allure Report
        if: always()
        run: |
          sudo apt-get update
          sudo apt-get install allure
          allure generate allure-results --clean -o allure-report
      
      - name: Upload Allure Report
        if: always()
        uses: actions/upload-artifact@v3
        with:
          name: allure-report
          path: allure-report
```

**Remember**: Add `HQ_EMAIL` and `HQ_PASSWORD` to your GitHub repository secrets!

---

## 📚 Tech Stack

| Technology | Version | Purpose |
|------------|---------|---------|
| Java | 17+ | Programming language |
| Selenium | 4.24.0 | Browser automation |
| TestNG | 7.10.2 | Test framework |
| Maven | 3.9.9 | Build tool (via wrapper) |
| Allure | 2.24.0 | Test reporting |
| WebDriverManager | 5.9.2 | Auto driver management |
| Chrome | Latest | Target browser |

---

## 🎓 Learning Resources

- **Selenium Docs**: https://www.selenium.dev/documentation/
- **TestNG Docs**: https://testng.org/doc/documentation-main.html
- **Allure Docs**: https://docs.qameta.io/allure/
- **Page Object Model**: https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/

---

## 📞 Need Help?

1. ✅ Check [Troubleshooting](#-troubleshooting) section
2. ✅ Review [TEST_CASES.md](TEST_CASES.md)
3. ✅ Check test logs in `target/surefire-reports/`
4. ✅ Run in headed mode to see browser actions:
   ```bash
   export HEADLESS=false  # Mac/Linux
   set HEADLESS=false     # Windows
   ```

---

## ✅ Quick Start Checklist

- [ ] Java 17+ installed (`java -version`)
- [ ] Google Chrome installed
- [ ] Project downloaded/cloned
- [ ] Environment variables set (`HQ_EMAIL`, `HQ_PASSWORD`)
- [ ] Tests run successfully (`mvnw clean test` or `./mvnw clean test`)
- [ ] Allure installed (`allure --version`)
- [ ] Old results cleaned (`rm -rf allure-results` or `rmdir /s /q allure-results`)
- [ ] Report generated (`allure serve allure-results`)

**All done? You're ready to automate! 🎉**

---

## 📄 License

This project is for educational and testing purposes.

---

**Happy Testing! 🚀**
