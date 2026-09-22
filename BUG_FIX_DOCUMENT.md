# Student Registration Bug Fix Document

## Summary

The student registration form was redirecting to the error state with the message:

- Registration failed
- Please check your details and try again.

This happened during form submission even when the input looked valid. The issue was traced to the backend database layer rather than the JSP form itself.

## Problem Investigation

The following steps were taken to identify the root cause:

1. Reviewed the submit flow in the servlet.
   - The form action posts to `/form`.
   - In `StudentServlet.doPost()`, the servlet builds a `Student` object from request parameters and calls `studentService.registerStudent(student)`.
   - Any exception thrown here is caught and redirected to `?status=error`.

2. Examined the service validation logic.
   - `StudentService.validate()` checks required fields, DOB, year, and mobile number.
   - The service itself was not the source of the failure for valid input.

3. Inspected the repository insert logic.
   - `JdbcStudentRepository.save()` used a SQL insert against the table `"formDetails"`.
   - The repository did not ensure the table existed before inserting.

4. Validated the database state.
   - Confirmed that the PostgreSQL instance was running.
   - Confirmed the database `projectForm` existed.
   - Checked the actual schema for the table and verified the app expected table structure.

5. Reproduced the issue with a regression test.
   - A new test dropped the `formDetails` table, then attempted to save a valid student.
   - The test reproduced the failure path before the fix.

## Root Cause

The application attempted to insert data into the `public."formDetails"` table without ensuring that the table existed.

If the table was missing or had not been created yet, the JDBC insert threw a SQL exception. That exception was caught in the servlet and converted into the generic error message shown to the user.

## Code Changes Made

### 1) Added table creation guard in the repository
File:
- `src/main/java/com/studentform/repository/JdbcStudentRepository.java`

What changed:
- Added `CREATE TABLE IF NOT EXISTS "formDetails" (...)` before the insert.
- Kept the insert logic intact.
- This ensures the app can recover even when the table is missing.

### 2) Added regression test
File:
- `src/test/java/com/studentform/repository/JdbcStudentRepositoryTest.java`

What the test verifies:
- Drop the table if it exists.
- Save a valid student.
- Confirm that the repository creates the table and persists the record without throwing.

## Result

After the fix, the registration flow no longer fails simply because the database table was absent. The application initializes the table automatically before saving, and the project test suite passes successfully.

## Verification Evidence

The project was verified with the command:

```bash
cd /home/sushobhit/devops/student_portal && mvn test -q; echo EXIT:$?
```

Observed result:

```text
EXIT:0
```

This confirms the fix and the regression test both pass.
