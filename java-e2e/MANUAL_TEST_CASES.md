# Manual Test Cases - Qashier HQ Staff Management

> **Manual Test Case Documentation for Add/Edit/Delete Staff Features**

---

## 📋 Table of Contents

- [Test Environment](#test-environment)
- [Test Data](#test-data)
- [Pre-requisites](#pre-requisites)
- [Test Cases Overview](#test-cases-overview)
- [Functional Test Cases](#functional-test-cases)
  - [User Registration](#user-registration)
  - [User Login](#user-login)
  - [Add Staff](#add-staff)
  - [Edit Staff](#edit-staff)
  - [Delete Staff](#delete-staff)
- [Non-Functional Test Cases](#non-functional-test-cases)
- [Test Summary](#test-summary)

---

## Test Environment

| Parameter | Details |
|-----------|---------|
| **Application URL** | https://hq.qashier.com/#/ |
| **Test Environment** | Production |
| **Browser Compatibility** | Chrome, Firefox, Safari, Edge |
| **Mobile Compatibility** | iOS Safari, Chrome Mobile |
| **Resolution** | 1920x1080, 1366x768, Mobile (375x667) |

---

## Test Data

### Valid Test Credentials
- **Email**: test369@gmail.com
- **Password**: test@123

### Sample Staff Data
- **Staff Name**: John Doe, Jane Smith, Mike Wilson
- **Staff PIN**: 1234, 5678, 9999
- **Hourly Rate**: 10-15 RM
- **Role**: Cashier, Manager, Server

---

## Pre-requisites

1. ✅ Valid Qashier HQ account created
2. ✅ Active internet connection
3. ✅ Supported browser installed
4. ✅ Account has appropriate permissions for staff management
5. ✅ No existing staff (for clean testing) OR existing staff documented

---

## Test Cases Overview

| Priority | Category | Total Cases | Critical | High | Medium | Low |
|----------|----------|-------------|----------|------|--------|-----|
| **P1** | User Registration | 8 | 3 | 3 | 2 | 0 |
| **P2** | User Login | 7 | 4 | 2 | 1 | 0 |
| **P1** | Add Staff | 12 | 5 | 4 | 3 | 0 |
| **P1** | Edit Staff | 10 | 4 | 3 | 3 | 0 |
| **P1** | Delete Staff | 8 | 4 | 2 | 2 | 0 |
| **P2** | UI/UX | 6 | 0 | 2 | 4 | 0 |
| **P3** | Performance | 4 | 0 | 1 | 2 | 1 |
| **TOTAL** | | **55** | **20** | **17** | **17** | **1** |

---

## Functional Test Cases

---

### User Registration

#### **TC-REG-001: User Registration with Valid Data**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-REG-001 |
| **Priority** | Critical |
| **Module** | User Registration |
| **Pre-condition** | User is not already registered |
| **Test Data** | Email: newuser@test.com, Password: Test@1234, Business Name: Test Business, Owner Name: John Doe |

**Test Steps:**
1. Navigate to https://hq.qashier.com/#/signup
2. Enter valid email address
3. Enter valid password (minimum 8 characters)
4. Enter business name
5. Enter owner name
6. Leave phone number field empty (optional)
7. Fill other required fields with random valid text
8. Click "Sign Up" button

**Expected Result:**
- ✅ Registration successful
- ✅ User redirected to dashboard or verification page
- ✅ Success message displayed
- ✅ Confirmation email sent (if applicable)

**Post-condition:** User account created successfully

---

#### **TC-REG-002: User Registration with Invalid Email**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-REG-002 |
| **Priority** | High |
| **Module** | User Registration |
| **Test Data** | Email: invalidemail.com, testuser@, @test.com |

**Test Steps:**
1. Navigate to signup page
2. Enter invalid email format
3. Fill other fields with valid data
4. Attempt to sign up

**Expected Result:**
- ❌ Registration fails
- ⚠️ Error message: "Please enter a valid email address"
- 🔄 User remains on signup page

---

#### **TC-REG-003: User Registration with Weak Password**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-REG-003 |
| **Priority** | High |
| **Module** | User Registration |
| **Test Data** | Password: 123, abc, test |

**Test Steps:**
1. Navigate to signup page
2. Enter valid email
3. Enter weak password (< 8 characters, no special chars)
4. Fill other required fields
5. Attempt to sign up

**Expected Result:**
- ❌ Registration fails
- ⚠️ Password validation error displayed
- 📝 Password requirements shown

---

#### **TC-REG-004: User Registration with Duplicate Email**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-REG-004 |
| **Priority** | Critical |
| **Module** | User Registration |
| **Test Data** | Email: test369@gmail.com (existing user) |

**Test Steps:**
1. Navigate to signup page
2. Enter email that already exists
3. Fill other fields with valid data
4. Attempt to sign up

**Expected Result:**
- ❌ Registration fails
- ⚠️ Error: "Email already registered" or similar
- 🔗 Link to login page provided

---

#### **TC-REG-005: User Registration with Empty Required Fields**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-REG-005 |
| **Priority** | High |
| **Module** | User Registration |
| **Test Data** | Leave email/password/business name empty |

**Test Steps:**
1. Navigate to signup page
2. Leave required fields empty
3. Attempt to sign up

**Expected Result:**
- ❌ Registration fails
- ⚠️ Field validation errors displayed
- 🎯 Focus moved to first empty required field

---

#### **TC-REG-006: User Registration - Phone Number Optional**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-REG-006 |
| **Priority** | Medium |
| **Module** | User Registration |
| **Test Data** | All required fields valid, phone number empty |

**Test Steps:**
1. Navigate to signup page
2. Fill all required fields
3. Leave phone number field empty
4. Click sign up

**Expected Result:**
- ✅ Registration successful without phone number
- 📱 No error for missing phone number

---

#### **TC-REG-007: User Registration - Special Characters in Name**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-REG-007 |
| **Priority** | Medium |
| **Module** | User Registration |
| **Test Data** | Owner Name: John@Doe#123, Test$User |

**Test Steps:**
1. Enter names with special characters
2. Complete registration

**Expected Result:**
- ⚠️ System should either accept or show validation error
- 📝 Clear guidance on allowed characters

---

#### **TC-REG-008: User Registration - SQL Injection Attempt**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-REG-008 |
| **Priority** | Critical |
| **Module** | User Registration - Security |
| **Test Data** | Email: test' OR '1'='1, Name: '; DROP TABLE users; -- |

**Test Steps:**
1. Enter SQL injection strings in input fields
2. Attempt registration

**Expected Result:**
- 🛡️ Input sanitized and treated as plain text
- ❌ No SQL injection occurs
- ✅ Registration either succeeds with sanitized data or fails with validation error

---

### User Login

#### **TC-LOGIN-001: Login with Valid Credentials**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-LOGIN-001 |
| **Priority** | Critical |
| **Module** | Authentication |
| **Pre-condition** | User account exists |
| **Test Data** | Email: test369@gmail.com, Password: test@123 |

**Test Steps:**
1. Navigate to https://hq.qashier.com/#/login
2. Enter valid email address
3. Enter valid password
4. Click "Login" button

**Expected Result:**
- ✅ Login successful
- 🏠 User redirected to dashboard
- 👤 User profile/name displayed
- 🔑 Session token created

**Post-condition:** User is authenticated and on dashboard

---

#### **TC-LOGIN-002: Login with Invalid Email**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-LOGIN-002 |
| **Priority** | Critical |
| **Module** | Authentication |
| **Test Data** | Email: nonexistent@test.com, Password: anypassword |

**Test Steps:**
1. Navigate to login page
2. Enter non-existent email
3. Enter any password
4. Click login

**Expected Result:**
- ❌ Login fails
- ⚠️ Error: "Invalid email or password"
- 🔄 User remains on login page
- 🛡️ No information about which field is wrong (security)

---

#### **TC-LOGIN-003: Login with Invalid Password**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-LOGIN-003 |
| **Priority** | Critical |
| **Module** | Authentication |
| **Test Data** | Email: test369@gmail.com, Password: wrongpassword |

**Test Steps:**
1. Navigate to login page
2. Enter valid email
3. Enter wrong password
4. Click login

**Expected Result:**
- ❌ Login fails
- ⚠️ Generic error message (not revealing which field is wrong)
- 🔄 User remains on login page

---

#### **TC-LOGIN-004: Login with Empty Credentials**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-LOGIN-004 |
| **Priority** | High |
| **Module** | Authentication |
| **Test Data** | Empty email and password |

**Test Steps:**
1. Navigate to login page
2. Leave both fields empty
3. Click login

**Expected Result:**
- ❌ Login button disabled OR validation error shown
- ⚠️ "Email and password are required"
- 🎯 Focus on email field

---

#### **TC-LOGIN-005: Login - Password Masking**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-LOGIN-005 |
| **Priority** | High |
| **Module** | Authentication - Security |
| **Test Data** | Any password |

**Test Steps:**
1. Navigate to login page
2. Enter password
3. Observe password field

**Expected Result:**
- 🔒 Password characters masked as dots/asterisks
- 👁️ "Show/Hide password" toggle available
- 📝 No password visible in page source

---

#### **TC-LOGIN-006: Login - Remember Me Functionality**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-LOGIN-006 |
| **Priority** | Medium |
| **Module** | Authentication |
| **Test Data** | Valid credentials |

**Test Steps:**
1. Login with "Remember Me" checked
2. Close browser
3. Reopen and navigate to application

**Expected Result:**
- ✅ User remains logged in (if feature exists)
- 🏠 OR redirected to dashboard automatically

---

#### **TC-LOGIN-007: Session Timeout**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-LOGIN-007 |
| **Priority** | Medium |
| **Module** | Authentication - Session Management |
| **Pre-condition** | User logged in |

**Test Steps:**
1. Login successfully
2. Leave application idle for extended period (30+ minutes)
3. Try to perform an action

**Expected Result:**
- ⏱️ Session expires after timeout period
- 🔒 User logged out automatically
- 🔄 Redirected to login page
- ⚠️ "Session expired" message shown

---

### Add Staff

#### **TC-ADD-001: Add Staff with All Valid Required Fields**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-ADD-001 |
| **Priority** | Critical |
| **Module** | Staff Management - Add |
| **Pre-condition** | User logged in, on Staff Management page |
| **Test Data** | Name: John Doe, PIN: 1234, Hourly Rate: 12 RM |

**Test Steps:**
1. Navigate to "Staff Management" from left sidebar
2. Click "Staff Management" in dropdown
3. Click "ADD STAFF" button
4. Enter staff name: "John Doe"
5. Enter hourly rate: "12"
6. Enter staff PIN: "1234"
7. Enter confirm PIN: "1234"
8. Click "CONFIRM" button
9. Verify staff appears in list

**Expected Result:**
- ✅ Staff added successfully
- ✅ Staff name "John Doe" visible in staff list
- ✅ Hourly rate displayed correctly
- ✅ Success notification shown
- ✅ Form closes automatically

**Post-condition:** New staff exists in system

---

#### **TC-ADD-002: Add Staff with Empty Name Field**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-ADD-002 |
| **Priority** | Critical |
| **Module** | Staff Management - Add |
| **Test Data** | Name: (empty), PIN: 1234, Hourly Rate: 12 |

**Test Steps:**
1. Click "ADD STAFF"
2. Leave name field empty
3. Fill other required fields
4. Click "CONFIRM"

**Expected Result:**
- ❌ Staff not added
- ⚠️ Validation error: "Name is required"
- 🎯 Focus on name field
- 📝 Form remains open

---

#### **TC-ADD-003: Add Staff with Invalid PIN Format**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-ADD-003 |
| **Priority** | High |
| **Module** | Staff Management - Add |
| **Test Data** | PIN: abc, 12, 12345 (if 4-digit required) |

**Test Steps:**
1. Click "ADD STAFF"
2. Enter valid name
3. Enter invalid PIN format
4. Attempt to confirm

**Expected Result:**
- ❌ Validation error for PIN field
- ⚠️ Message indicating valid PIN format
- 🔢 Only numeric input allowed

---

#### **TC-ADD-004: Add Staff with Mismatched PIN Confirmation**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-ADD-004 |
| **Priority** | High |
| **Module** | Staff Management - Add |
| **Test Data** | PIN: 1234, Confirm PIN: 5678 |

**Test Steps:**
1. Click "ADD STAFF"
2. Fill staff details
3. Enter PIN: 1234
4. Enter Confirm PIN: 5678
5. Click "CONFIRM"

**Expected Result:**
- ❌ Staff not added
- ⚠️ Error: "PINs do not match"
- 🔄 User must re-enter matching PINs

---

#### **TC-ADD-005: Add Staff with Duplicate PIN**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-ADD-005 |
| **Priority** | Critical |
| **Module** | Staff Management - Add |
| **Pre-condition** | Staff with PIN 1234 already exists |
| **Test Data** | PIN: 1234 (duplicate) |

**Test Steps:**
1. Add first staff with PIN 1234
2. Attempt to add another staff with same PIN 1234

**Expected Result:**
- ❌ Duplicate prevented OR allowed (depends on business rules)
- ⚠️ If not allowed: Error message shown
- 📝 Clear guidance on PIN uniqueness requirement

---

#### **TC-ADD-006: Add Staff with Negative Hourly Rate**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-ADD-006 |
| **Priority** | High |
| **Module** | Staff Management - Add |
| **Test Data** | Hourly Rate: -10 |

**Test Steps:**
1. Click "ADD STAFF"
2. Enter negative hourly rate
3. Fill other fields
4. Click "CONFIRM"

**Expected Result:**
- ❌ Validation error
- ⚠️ "Hourly rate must be positive"
- 💰 Only positive numbers accepted

---

#### **TC-ADD-007: Add Staff with Zero Hourly Rate**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-ADD-007 |
| **Priority** | Medium |
| **Module** | Staff Management - Add |
| **Test Data** | Hourly Rate: 0 |

**Test Steps:**
1. Enter hourly rate as 0
2. Fill other fields
3. Attempt to add staff

**Expected Result:**
- System either accepts 0 or shows validation error
- 📝 Clear business rule on minimum rate

---

#### **TC-ADD-008: Add Staff with Very Long Name**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-ADD-008 |
| **Priority** | Medium |
| **Module** | Staff Management - Add |
| **Test Data** | Name: 500+ character string |

**Test Steps:**
1. Enter extremely long name (500+ chars)
2. Fill other fields
3. Attempt to add

**Expected Result:**
- ✂️ Name truncated to max length OR
- ⚠️ Validation error with character limit
- 📊 Character counter displayed

---

#### **TC-ADD-009: Add Staff with Special Characters in Name**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-ADD-009 |
| **Priority** | Medium |
| **Module** | Staff Management - Add |
| **Test Data** | Name: John@Doe#123, O'Brien, José |

**Test Steps:**
1. Enter name with special characters, apostrophes, accents
2. Complete add staff process

**Expected Result:**
- ✅ Special characters handled correctly
- 📝 Name displayed properly in list
- 🌐 Unicode characters supported

---

#### **TC-ADD-010: Add Staff - Cancel Button Functionality**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-ADD-010 |
| **Priority** | High |
| **Module** | Staff Management - Add |

**Test Steps:**
1. Click "ADD STAFF"
2. Fill some fields
3. Click "CANCEL" or close dialog
4. Re-open add staff dialog

**Expected Result:**
- ✅ Dialog closes without saving
- 🔄 No staff added to list
- 🧹 Form cleared when reopened

---

#### **TC-ADD-011: Add Multiple Staff in Sequence**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-ADD-011 |
| **Priority** | High |
| **Module** | Staff Management - Add |
| **Test Data** | Staff 1: John, Staff 2: Jane, Staff 3: Mike |

**Test Steps:**
1. Add first staff member
2. Verify addition successful
3. Immediately add second staff
4. Verify both in list
5. Add third staff
6. Verify all three displayed

**Expected Result:**
- ✅ All staff members added successfully
- 📋 All appear in correct order in list
- 🔄 No data corruption or mixing

---

#### **TC-ADD-012: Add Staff - Form Field Validation Order**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-ADD-012 |
| **Priority** | Medium |
| **Module** | Staff Management - Add |

**Test Steps:**
1. Click "ADD STAFF"
2. Click "CONFIRM" without filling anything
3. Observe validation message order

**Expected Result:**
- ⚠️ Validation errors shown in logical order
- 🎯 Focus moves to first invalid field
- 📝 All validation errors visible or one-by-one

---

### Edit Staff

#### **TC-EDIT-001: Edit Staff Name Successfully**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-EDIT-001 |
| **Priority** | Critical |
| **Module** | Staff Management - Edit |
| **Pre-condition** | At least one staff exists in list |
| **Test Data** | Original: John Doe, New: Jane Smith |

**Test Steps:**
1. Click on existing staff in list
2. Edit dialog opens with pre-filled data
3. Change name from "John Doe" to "Jane Smith"
4. Keep other fields unchanged
5. Click "CONFIRM"
6. Verify name updated in list

**Expected Result:**
- ✅ Staff name updated successfully
- ✅ New name "Jane Smith" displayed in list
- ✅ Other details remain unchanged
- ✅ Success notification shown

**Post-condition:** Staff details updated in database

---

#### **TC-EDIT-002: Edit Staff Hourly Rate**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-EDIT-002 |
| **Priority** | Critical |
| **Module** | Staff Management - Edit |
| **Test Data** | Original Rate: 10 RM, New Rate: 15 RM |

**Test Steps:**
1. Click on staff entry
2. Change hourly rate from 10 to 15
3. Click "CONFIRM"
4. Verify rate updated

**Expected Result:**
- ✅ Hourly rate updated
- 💰 New rate reflected in staff list
- 📊 If shown, updated in any reports

---

#### **TC-EDIT-003: Edit Staff PIN**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-EDIT-003 |
| **Priority** | High |
| **Module** | Staff Management - Edit |
| **Test Data** | Original PIN: 1234, New PIN: 5678 |

**Test Steps:**
1. Open staff edit dialog
2. Change PIN from 1234 to 5678
3. Confirm PIN change
4. Save changes

**Expected Result:**
- ✅ PIN updated successfully
- 🔐 New PIN works for staff login (if applicable)
- 📝 PIN confirmation required

---

#### **TC-EDIT-004: Edit Staff - Clear Name Field**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-EDIT-004 |
| **Priority** | High |
| **Module** | Staff Management - Edit |

**Test Steps:**
1. Open staff edit dialog
2. Clear the name field (delete all text)
3. Attempt to save

**Expected Result:**
- ❌ Update fails
- ⚠️ Validation error: "Name is required"
- 🔄 Changes not saved

---

#### **TC-EDIT-005: Edit Staff - No Changes Made**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-EDIT-005 |
| **Priority** | Medium |
| **Module** | Staff Management - Edit |

**Test Steps:**
1. Click on staff entry
2. Don't change any fields
3. Click "CONFIRM"

**Expected Result:**
- ✅ Dialog closes successfully
- 📝 No error messages
- 🔄 Data remains unchanged
- ⚡ No unnecessary API calls

---

#### **TC-EDIT-006: Edit Staff - Change Multiple Fields Simultaneously**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-EDIT-006 |
| **Priority** | Critical |
| **Module** | Staff Management - Edit |
| **Test Data** | Change name, PIN, and hourly rate all at once |

**Test Steps:**
1. Open staff edit dialog
2. Change name: John → Mike
3. Change PIN: 1234 → 9999
4. Change hourly rate: 10 → 14
5. Click "CONFIRM"
6. Verify all changes saved

**Expected Result:**
- ✅ All fields updated successfully
- ✅ All changes reflected in staff list
- 📊 Data consistency maintained

---

#### **TC-EDIT-007: Edit Staff - Cancel After Making Changes**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-EDIT-007 |
| **Priority** | High |
| **Module** | Staff Management - Edit |

**Test Steps:**
1. Open staff edit dialog
2. Make changes to fields
3. Click "CANCEL" or close dialog
4. Verify staff details in list

**Expected Result:**
- ❌ Changes discarded
- 🔄 Original data remains unchanged
- ✅ Staff list shows old values

---

#### **TC-EDIT-008: Edit Staff - Dialog Pre-population**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-EDIT-008 |
| **Priority** | High |
| **Module** | Staff Management - Edit |

**Test Steps:**
1. Click on staff entry in list
2. Observe edit dialog fields

**Expected Result:**
- ✅ All fields pre-populated with current values
- 📝 Name field shows current name
- 🔢 PIN field shows current PIN (masked or visible)
- 💰 Hourly rate shows current rate

---

#### **TC-EDIT-009: Edit Staff - Change to Duplicate PIN**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-EDIT-009 |
| **Priority** | Medium |
| **Module** | Staff Management - Edit |
| **Pre-condition** | Two staff members exist with different PINs |
| **Test Data** | Change Staff A's PIN to match Staff B's PIN |

**Test Steps:**
1. Edit Staff A
2. Change PIN to match existing Staff B's PIN
3. Attempt to save

**Expected Result:**
- Depends on business rules:
  - ❌ Either: Error "PIN already in use"
  - ✅ Or: Allow duplicate PINs

---

#### **TC-EDIT-010: Edit Staff - Negative Hourly Rate**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-EDIT-010 |
| **Priority** | Medium |
| **Module** | Staff Management - Edit |
| **Test Data** | Change rate to -5 |

**Test Steps:**
1. Open staff edit dialog
2. Enter negative hourly rate
3. Attempt to save

**Expected Result:**
- ❌ Validation error
- ⚠️ "Hourly rate must be positive"
- 🔄 Changes not saved

---

### Delete Staff

#### **TC-DELETE-001: Delete Staff Successfully**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-DELETE-001 |
| **Priority** | Critical |
| **Module** | Staff Management - Delete |
| **Pre-condition** | At least one staff exists in list |
| **Test Data** | Staff: John Doe |

**Test Steps:**
1. Click on staff entry in list
2. Click "DELETE" button in dialog
3. Confirmation dialog appears
4. Click "CONFIRM" in delete confirmation
5. Verify staff removed from list
6. Check for "No data available" message if last staff

**Expected Result:**
- ✅ Staff deleted successfully
- ✅ Staff no longer appears in list
- ✅ "No data available" shown if list empty
- ✅ Success notification displayed

**Post-condition:** Staff record removed from system

---

#### **TC-DELETE-002: Delete Staff - Cancel Confirmation**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-DELETE-002 |
| **Priority** | High |
| **Module** | Staff Management - Delete |
| **Pre-condition** | At least one staff exists |

**Test Steps:**
1. Click on staff entry
2. Click "DELETE" button
3. Confirmation dialog appears
4. Click "CANCEL" or close confirmation dialog
5. Verify staff still in list

**Expected Result:**
- ❌ Deletion cancelled
- ✅ Staff remains in list
- ✅ Staff data unchanged
- 🔄 Edit dialog may close or remain open

---

#### **TC-DELETE-003: Delete Last Remaining Staff**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-DELETE-003 |
| **Priority** | Critical |
| **Module** | Staff Management - Delete |
| **Pre-condition** | Only one staff member exists |

**Test Steps:**
1. Click on the only staff member
2. Delete the staff
3. Confirm deletion
4. Observe staff list

**Expected Result:**
- ✅ Staff deleted successfully
- ✅ "No data available" message displayed
- 📋 Empty list shown
- ✅ "ADD STAFF" button still functional

---

#### **TC-DELETE-004: Delete Staff - Confirmation Dialog Content**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-DELETE-004 |
| **Priority** | Medium |
| **Module** | Staff Management - Delete |

**Test Steps:**
1. Click on staff
2. Click "DELETE"
3. Read confirmation dialog message

**Expected Result:**
- ⚠️ Clear warning message displayed
- 📝 Staff name shown in confirmation (if possible)
- 🔘 "Confirm" and "Cancel" buttons clearly labeled
- ❗ Consequences of deletion mentioned

---

#### **TC-DELETE-005: Delete Multiple Staff in Sequence**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-DELETE-005 |
| **Priority** | High |
| **Module** | Staff Management - Delete |
| **Pre-condition** | Three or more staff members exist |

**Test Steps:**
1. Delete first staff
2. Verify deletion
3. Immediately delete second staff
4. Verify deletion
5. Delete third staff
6. Verify all deleted

**Expected Result:**
- ✅ All deletions successful
- 📋 Staff count decreases correctly
- 🔄 No system errors or freezes
- 💾 Data consistency maintained

---

#### **TC-DELETE-006: Delete Staff - Close Edit Dialog After Delete**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-DELETE-006 |
| **Priority** | Medium |
| **Module** | Staff Management - Delete |

**Test Steps:**
1. Click on staff
2. Edit dialog opens
3. Click "DELETE"
4. Confirm deletion
5. Observe UI state

**Expected Result:**
- ✅ Staff deleted
- ✅ Edit dialog closes automatically
- ✅ Confirmation dialog closes
- 🔄 User returned to staff list view

---

#### **TC-DELETE-007: Delete Staff - Verify Permanent Deletion**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-DELETE-007 |
| **Priority** | High |
| **Module** | Staff Management - Delete |

**Test Steps:**
1. Note staff details before deletion
2. Delete staff
3. Refresh page
4. Check if staff reappears

**Expected Result:**
- ✅ Staff permanently deleted
- ❌ Staff does not reappear after refresh
- 💾 Database record removed
- 🔄 No data recovery without backup

---

#### **TC-DELETE-008: Delete Staff - Permission Check**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-DELETE-008 |
| **Priority** | Medium |
| **Module** | Staff Management - Delete (Security) |
| **Pre-condition** | User with limited permissions (if applicable) |

**Test Steps:**
1. Login with limited permission user
2. Attempt to delete staff

**Expected Result:**
- Depends on permission model:
  - ❌ If restricted: Delete button disabled or hidden
  - ⚠️ If restricted: Error message on attempt
  - ✅ If allowed: Deletion successful

---

## Non-Functional Test Cases

---

### UI/UX Test Cases

#### **TC-UI-001: Responsive Design - Mobile View**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-UI-001 |
| **Priority** | Medium |
| **Module** | UI/UX |

**Test Steps:**
1. Access application on mobile device (iPhone, Android)
2. Test all staff management features
3. Verify form layouts

**Expected Result:**
- ✅ Layout adapts to mobile screen
- 📱 Buttons easily tappable
- 📝 Forms scrollable and usable
- 🔍 Text readable without zooming

---

#### **TC-UI-002: Accessibility - Keyboard Navigation**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-UI-002 |
| **Priority** | High |
| **Module** | UI/UX - Accessibility |

**Test Steps:**
1. Navigate application using only keyboard
2. Tab through all interactive elements
3. Use Enter/Space to activate buttons
4. Navigate staff list and forms

**Expected Result:**
- ⌨️ All elements keyboard accessible
- 🎯 Clear focus indicators
- ↹ Logical tab order
- ✅ Can perform all actions without mouse

---

#### **TC-UI-003: Form Field Placeholder Text**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-UI-003 |
| **Priority** | Low |
| **Module** | UI/UX |

**Test Steps:**
1. Open add/edit staff dialog
2. Observe form fields before entering data

**Expected Result:**
- 📝 Helpful placeholder text displayed
- 💡 Examples shown (e.g., "Enter 4-digit PIN")
- 🎨 Placeholder text distinguishable from entered text

---

#### **TC-UI-004: Loading States**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-UI-004 |
| **Priority** | Medium |
| **Module** | UI/UX |

**Test Steps:**
1. Perform actions (add/edit/delete)
2. Observe UI during API calls

**Expected Result:**
- ⏳ Loading indicator shown during operations
- 🚫 Buttons disabled during processing
- ⏱️ No duplicate submissions possible
- 📊 Clear feedback when action completes

---

#### **TC-UI-005: Error Message Display**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-UI-005 |
| **Priority** | Medium |
| **Module** | UI/UX |

**Test Steps:**
1. Trigger various validation errors
2. Trigger server errors (disconnect internet)
3. Observe error messages

**Expected Result:**
- ⚠️ Error messages clearly visible
- 📝 Messages in plain language
- 🎨 Consistent error styling
- ❌ Close/dismiss option available

---

#### **TC-UI-006: Staff List Sorting and Display**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-UI-006 |
| **Priority** | Medium |
| **Module** | UI/UX |
| **Pre-condition** | Multiple staff exist |

**Test Steps:**
1. Add 5+ staff members
2. Observe list order
3. Check if sorting options available

**Expected Result:**
- 📋 Staff displayed in logical order
- 🔤 Alphabetical or chronological sorting
- 📊 Consistent list item formatting
- 🎨 Clear visual separation between items

---

### Performance Test Cases

#### **TC-PERF-001: Page Load Time**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-PERF-001 |
| **Priority** | Medium |
| **Module** | Performance |

**Test Steps:**
1. Clear browser cache
2. Navigate to Staff Management
3. Measure time to full page load

**Expected Result:**
- ⚡ Page loads within 3 seconds
- 📊 Staff list visible quickly
- 🖼️ No layout shifts during load

---

#### **TC-PERF-002: Form Submission Response Time**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-PERF-002 |
| **Priority** | High |
| **Module** | Performance |

**Test Steps:**
1. Fill out add staff form
2. Submit form
3. Measure time until success confirmation

**Expected Result:**
- ⏱️ Response within 2 seconds
- 📈 Staff appears in list immediately
- 🔄 Smooth transition, no lag

---

#### **TC-PERF-003: Large Staff List Performance**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-PERF-003 |
| **Priority** | Medium |
| **Module** | Performance |
| **Pre-condition** | 50+ staff members in system |

**Test Steps:**
1. Load staff management with many entries
2. Scroll through list
3. Perform add/edit/delete operations

**Expected Result:**
- 📋 List renders efficiently
- 🖱️ Smooth scrolling
- 🚀 Operations not slowed by list size
- 💻 Pagination or virtual scrolling implemented

---

#### **TC-PERF-004: Concurrent User Operations**
| Field | Details |
|-------|---------|
| **Test Case ID** | TC-PERF-004 |
| **Priority** | Low |
| **Module** | Performance - Concurrency |
| **Pre-condition** | Two users logged into same account |

**Test Steps:**
1. User A adds staff
2. User B simultaneously edits different staff
3. User A deletes staff while User B adds new staff

**Expected Result:**
- 🔄 Changes synchronized correctly
- ❌ No data conflicts or corruption
- 📊 Both users see consistent data
- 🔁 Auto-refresh or notification of changes

---

## Test Summary

### Coverage Matrix

| Feature | Positive Cases | Negative Cases | Edge Cases | Security Cases | Total |
|---------|---------------|----------------|------------|----------------|-------|
| User Registration | 2 | 4 | 1 | 1 | 8 |
| User Login | 2 | 3 | 2 | 0 | 7 |
| Add Staff | 3 | 6 | 3 | 0 | 12 |
| Edit Staff | 5 | 3 | 2 | 0 | 10 |
| Delete Staff | 4 | 2 | 2 | 0 | 8 |
| UI/UX | 6 | 0 | 0 | 0 | 6 |
| Performance | 4 | 0 | 0 | 0 | 4 |
| **TOTAL** | **26** | **18** | **10** | **1** | **55** |

---

### Test Execution Guidelines

#### **Priority Levels:**
- 🔴 **Critical (P1)**: Must pass before release - Core functionality
- 🟠 **High (P2)**: Should pass - Important features and validations
- 🟡 **Medium (P3)**: Nice to pass - User experience improvements
- 🟢 **Low (P4)**: Can be deferred - Edge cases and enhancements

#### **Testing Approach:**
1. **Smoke Testing**: Execute all Critical (P1) test cases first
2. **Regression Testing**: After any code change, run P1 and P2 cases
3. **Full Test Suite**: Before major releases, execute all 55 test cases
4. **Exploratory Testing**: Supplement with ad-hoc testing for edge cases

#### **Defect Severity:**
- **Critical**: System crash, data loss, security breach
- **Major**: Core feature not working, blocking user workflow
- **Minor**: UI issues, minor functional glitches
- **Trivial**: Cosmetic issues, minor UX improvements

---

### Test Environment Checklist

Before starting manual testing, ensure:

- [ ] Test account credentials available
- [ ] Browser(s) installed and updated
- [ ] Network connection stable
- [ ] Test data prepared
- [ ] Previous test data cleaned up (if needed)
- [ ] Defect tracking tool accessible
- [ ] Test case document reviewed
- [ ] Testing time allocated (3-4 hours for full suite)

---

### Known Limitations

1. **Lite Plan Restriction**: Test account limited to 1 staff member
   - Must delete existing staff before adding new one
   - Cannot test multiple staff scenarios fully

2. **Test Data Persistence**: 
   - Tests modify actual production-like data
   - Cleanup required between test runs

3. **Permission Testing**:
   - Limited ability to test different user roles
   - May require multiple test accounts

---

## Appendix

### Test Data Templates

#### Sample Staff Data Set 1:
| Name | PIN | Hourly Rate | Notes |
|------|-----|-------------|-------|
| Alice Johnson | 1111 | 10 RM | Standard case |
| Bob Smith | 2222 | 15 RM | Higher rate |
| Charlie Brown | 3333 | 8 RM | Lower rate |

#### Sample Staff Data Set 2 (Edge Cases):
| Name | PIN | Hourly Rate | Notes |
|------|-----|-------------|-------|
| José María | 4444 | 12 RM | Special characters |
| O'Brien | 5555 | 11 RM | Apostrophe |
| 李明 (Li Ming) | 6666 | 13 RM | Unicode characters |

---

### Common Issues and Workarounds

| Issue | Workaround |
|-------|-----------|
| Staff limit reached | Delete existing staff before adding new |
| Session timeout | Re-login and continue testing |
| Network errors | Verify connection, retry operation |
| Form not submitting | Check for validation errors, check console |

---

### References

- **Application URL**: https://hq.qashier.com
- **Signup URL**: https://hq.qashier.com/#/signup
- **Login URL**: https://hq.qashier.com/#/login
- **Test Account**: test369@gmail.com / test@123

---

**Document Version**: 1.0  
**Last Updated**: December 18, 2025  
**Author**: QA Team  
**Status**: Approved for Testing

---

**END OF MANUAL TEST CASES DOCUMENT**

