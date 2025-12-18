# Test Cases - Qashier HQ Staff Management

## Test Case Summary

| Priority | Test Case ID | Test Case Name | Status |
|----------|--------------|----------------|--------|
| Critical | TC-001 | Verify Login to Qashier HQ | ✅ Automated |
| Critical | TC-002 | Verify Add Staff with Valid Data | ✅ Automated |
| Critical | TC-003 | Verify Staff Appears in List After Add | ✅ Automated |
| Critical | TC-004 | Verify Edit Staff Details | ✅ Automated |
| Critical | TC-005 | Verify Staff Updates in List After Edit | ✅ Automated |
| Critical | TC-006 | Verify Delete Staff | ✅ Automated |
| Critical | TC-007 | Verify Staff Removed from List After Delete | ✅ Automated |
| High | TC-008 | Verify Pre-test Cleanup (Handle Existing Staff) | ✅ Automated |
| High | TC-009 | Verify Staff Form Fields Validation | ✅ Automated |
| Medium | TC-010 | Verify Random Data Generation for Staff | ✅ Automated |

**Total Automated Test Cases: 10**

---

## Detailed Test Cases

### **CRITICAL PRIORITY**

#### **TC-001: Verify Login to Qashier HQ**
- **Priority**: Critical
- **Type**: Functional
- **Preconditions**: 
  - Valid credentials (HQ_EMAIL, HQ_PASSWORD)
  - Chrome browser available
  - Internet connection
- **Test Steps**:
  1. Navigate to https://hq.qashier.com/#/
  2. Enter valid email
  3. Enter valid password
  4. Click Submit/Login
- **Expected Result**: 
  - User successfully logged in
  - Redirected to dashboard
  - Staff Management menu visible
- **Actual Result**: ✅ Pass
- **Automation Status**: Automated

---

#### **TC-002: Verify Add Staff with Valid Data**
- **Priority**: Critical
- **Type**: Functional
- **Preconditions**: 
  - User logged in
  - Navigated to Staff Management
  - No existing staff (or cleaned up)
- **Test Steps**:
  1. Click "Add Staff" button
  2. Enter staff name (random: AutoStaff_XXXXX)
  3. Enter hourly rate (random: 8-15 RM)
  4. Enter staff PIN (random: 4-digit)
  5. Confirm staff PIN
  6. Click "CONFIRM" button
- **Expected Result**: 
  - Staff added successfully
  - Dialog closes
  - Success message displayed (implicit)
- **Actual Result**: ✅ Pass
- **Automation Status**: Automated

---

#### **TC-003: Verify Staff Appears in List After Add**
- **Priority**: Critical
- **Type**: Functional
- **Preconditions**: 
  - TC-002 completed successfully
- **Test Steps**:
  1. Wait for staff list to refresh
  2. Search for newly added staff name in the list
- **Expected Result**: 
  - Staff name visible in staff list
  - Staff details are correct
- **Actual Result**: ✅ Pass
- **Automation Status**: Automated

---

#### **TC-004: Verify Edit Staff Details**
- **Priority**: Critical
- **Type**: Functional
- **Preconditions**: 
  - Staff exists in the system (TC-002 completed)
- **Test Steps**:
  1. Click on staff entry in the list
  2. Edit dialog opens with existing data
  3. Change hourly rate to new value
  4. Click "CONFIRM" button
- **Expected Result**: 
  - Staff details updated successfully
  - Dialog closes
  - Changes saved
- **Actual Result**: ✅ Pass
- **Automation Status**: Automated

---

#### **TC-005: Verify Staff Updates in List After Edit**
- **Priority**: Critical
- **Type**: Functional
- **Preconditions**: 
  - TC-004 completed successfully
- **Test Steps**:
  1. Wait for staff list to refresh
  2. Verify staff still exists in list
  3. Check updated details (hourly rate)
- **Expected Result**: 
  - Staff still visible in list
  - Updated hourly rate reflected
- **Actual Result**: ✅ Pass
- **Automation Status**: Automated

---

#### **TC-006: Verify Delete Staff**
- **Priority**: Critical
- **Type**: Functional
- **Preconditions**: 
  - Staff exists in the system
- **Test Steps**:
  1. Click on staff entry in the list
  2. Edit dialog opens
  3. Click "Delete" button
  4. Delete confirmation dialog appears
  5. Click "Confirm" button in delete dialog
- **Expected Result**: 
  - Staff deleted successfully
  - Both dialogs close
  - Staff removed from system
- **Actual Result**: ✅ Pass
- **Automation Status**: Automated

---

#### **TC-007: Verify Staff Removed from List After Delete**
- **Priority**: Critical
- **Type**: Functional
- **Preconditions**: 
  - TC-006 completed successfully
- **Test Steps**:
  1. Wait for staff list to refresh
  2. Verify "No data available" message appears
  3. Confirm staff no longer in list
- **Expected Result**: 
  - "No data available" message displayed
  - Staff list is empty
  - No staff entries visible
- **Actual Result**: ✅ Pass
- **Automation Status**: Automated
- **Assertion**: Explicit assertion added to verify deletion

---

### **HIGH PRIORITY**

#### **TC-008: Verify Pre-test Cleanup (Handle Existing Staff)**
- **Priority**: High
- **Type**: Functional
- **Preconditions**: 
  - User logged in
  - Navigated to Staff Management
- **Test Steps**:
  1. Check for "No data available" message
  2. If message NOT found, detect existing staff
  3. Delete existing staff
  4. Verify "No data available" appears after deletion
- **Expected Result**: 
  - Existing staff detected and deleted
  - Staff list cleared for fresh test
  - System ready for test execution
- **Actual Result**: ✅ Pass
- **Automation Status**: Automated
- **Business Context**: Handles Lite plan 1-staff limitation

---

#### **TC-009: Verify Staff Form Fields Validation**
- **Priority**: High
- **Type**: Functional
- **Preconditions**: 
  - Add Staff dialog opened
- **Test Steps**:
  1. Verify Name input field is present and editable
  2. Verify Hourly Rate input field accepts numeric values
  3. Verify Staff PIN input field accepts 4-digit numbers
  4. Verify Confirm Staff PIN field accepts 4-digit numbers
  5. Verify CONFIRM button is clickable
- **Expected Result**: 
  - All form fields are present
  - Fields accept correct data types
  - Form can be submitted
- **Actual Result**: ✅ Pass
- **Automation Status**: Automated (implicit validation)

---

### **MEDIUM PRIORITY**

#### **TC-010: Verify Random Data Generation for Staff**
- **Priority**: Medium
- **Type**: Functional
- **Preconditions**: 
  - Test execution started
- **Test Steps**:
  1. Generate random staff name (AutoStaff_XXXXX format)
  2. Generate random 4-digit PIN (1000-9999)
  3. Generate random hourly rate (8.0-15.0 RM)
  4. Verify data is unique per test run
- **Expected Result**: 
  - Unique staff name generated using timestamp
  - Random PIN within valid range
  - Random hourly rate within acceptable range
  - Data differs between test runs
- **Actual Result**: ✅ Pass
- **Automation Status**: Automated
- **Purpose**: Ensures test repeatability and data independence

---

## Test Execution Summary

### **Automated Test Coverage**
- **Total Test Cases**: 10
- **Critical Priority**: 7 test cases (70%)
- **High Priority**: 2 test cases (20%)
- **Medium Priority**: 1 test case (10%)
- **Pass Rate**: 100% (10/10)

### **Test Execution Flow**
1. TC-001: Login
2. TC-008: Pre-test Cleanup (if needed)
3. TC-002: Add Staff
4. TC-003: Verify Staff in List
5. TC-004: Edit Staff
6. TC-005: Verify Updated Staff
7. TC-006: Delete Staff
8. TC-007: Verify Deletion (with assertion)
9. TC-009: Form Validation (implicit during TC-002)
10. TC-010: Random Data Generation (executed in @BeforeClass)

### **Risk Assessment**
- **High Risk Areas**: 
  - Lite plan 1-staff limitation (mitigated by TC-008)
  - OAuth login redirect (handled in TC-001)
  - Dialog element interception (mitigated with JavaScript click fallback)
  
- **Low Risk Areas**:
  - Form validation (stable UI)
  - Data generation (controlled randomization)

---

## Test Data

### **Test Environment**
- **URL**: https://hq.qashier.com/#/
- **Browser**: Chrome (latest)
- **Test Account**: Configured via environment variables
- **Account Type**: Lite plan (1 staff limit)

### **Test Data Used**
- **Staff Name**: Dynamic (AutoStaff_<timestamp>)
- **Hourly Rate**: Random (8.0 - 15.0 RM)
- **Staff PIN**: Random (4-digit: 1000-9999)

---

## Notes

1. **Test Case Consolidation**: All test cases are executed in a single test method (`testAddStaffFlow`) due to:
   - Sequential dependencies (Edit/Delete require Add first)
   - Business constraint (Lite plan: 1 staff only)
   - Efficient execution (single login/navigation)

2. **Explicit Assertions**:
   - TC-007 includes explicit assertion for "No data available"
   - Ensures deletion is truly successful
   - Test fails if deletion doesn't work

3. **Test Repeatability**:
   - Pre-test cleanup (TC-008) ensures clean state
   - Post-test deletion (TC-006/TC-007) allows repeated runs
   - Random data prevents conflicts

4. **Future Enhancements** (Manual Testing Required):
   - Negative test cases (invalid data, empty fields)
   - Cancel operations
   - Multiple staff management (requires upgraded plan)
   - Concurrent user testing
   - Performance testing

---

**Document Version**: 1.0  
**Last Updated**: December 17, 2025  
**Automation Framework**: Selenium WebDriver + Java + TestNG  
**Test Author**: QA Team

