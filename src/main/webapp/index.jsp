<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>

<html lang="en">

<head>

    <meta charset="UTF-8">

    <meta
        name="viewport"
        content="width=device-width, initial-scale=1.0">

    <title>Student Registration Portal</title>

    <link
        rel="stylesheet"
        href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

<div class="page-wrapper">

    <div class="registration-container">


        <!-- ========================================= -->
        <!-- LEFT BRANDING SECTION -->
        <!-- ========================================= -->

        <section class="intro-section">

            <div class="intro-background-circle circle-one"></div>

            <div class="intro-background-circle circle-two"></div>


            <!-- Logo -->

            <div class="brand">

                <div class="brand-icon">
                    🎓
                </div>

                <div>

                    <strong>
                        EduPortal
                    </strong>

                    <span>
                        Student Registration
                    </span>

                </div>

            </div>


            <!-- Main Introduction -->

            <div class="intro-content">

                <div class="small-label">
                    STUDENT REGISTRATION
                </div>

                <h1>

                    Start Your
                    <br>

                    Academic Journey
                    <br>

                    With Us

                </h1>

                <div class="heading-line"></div>

                <p>

                    Fill in your details to create
                    your student profile. All
                    information is securely stored
                    and handled with care.

                </p>

            </div>


            <!-- Education Illustration -->

            <div class="education-illustration">

                <div class="books">

                    <div class="book book-one"></div>

                    <div class="book book-two"></div>

                    <div class="book book-three"></div>

                    <div class="book book-four"></div>

                </div>

                <div class="graduation-cap">

                    <div class="cap-top"></div>

                    <div class="cap-base"></div>

                    <div class="tassel"></div>

                </div>

            </div>


            <!-- Features -->

            <div class="features">

                <div class="feature">

                    <div class="feature-icon">
                        ✓
                    </div>

                    <div>

                        <strong>
                            Secure & Safe
                        </strong>

                        <span>
                            Protected information
                        </span>

                    </div>

                </div>


                <div class="feature">

                    <div class="feature-icon">
                        ⚡
                    </div>

                    <div>

                        <strong>
                            Quick Registration
                        </strong>

                        <span>
                            Simple and fast
                        </span>

                    </div>

                </div>


                <div class="feature">

                    <div class="feature-icon">
                        ★
                    </div>

                    <div>

                        <strong>
                            Student Portal
                        </strong>

                        <span>
                            Easy registration
                        </span>

                    </div>

                </div>

            </div>

        </section>


        <!-- ========================================= -->
        <!-- RIGHT FORM SECTION -->
        <!-- ========================================= -->

        <section class="form-section">


            <div class="form-header">

                <div class="user-icon">
                    ♙
                </div>

                <h2>
                    Student Registration
                </h2>

                <p>
                    Please fill in the details below
                </p>

            </div>


            <!-- Success Message -->

            <%

                String status =
                        request.getParameter("status");

                if ("success".equals(status)) {

            %>

            <div class="message success-message">

                <div class="message-icon">
                    ✓
                </div>

                <div>

                    <strong>
                        Registration successful
                    </strong>

                    <span>
                        Student details have been saved successfully.
                    </span>

                </div>

            </div>

            <%

                }

                if ("error".equals(status)) {

            %>

            <div class="message error-message">

                <div class="message-icon">
                    !
                </div>

                <div>

                    <strong>
                        Registration failed
                    </strong>

                    <span>
                        Please check your details and try again.
                    </span>

                </div>

            </div>

            <%

                }

            %>


            <!-- ========================================= -->
            <!-- FORM -->
            <!-- ========================================= -->

            <form
                id="studentForm"
                action="${pageContext.request.contextPath}/form"
                method="post">


                <div class="form-grid">


                    <!-- First Name -->

                    <div class="input-group">

                        <label for="firstName">

                            First Name

                            <span>*</span>

                        </label>

                        <div class="input-wrapper">

                            <span class="input-icon">
                                ♙
                            </span>

                            <input
                                type="text"
                                id="firstName"
                                name="firstName"
                                placeholder="Enter first name"
                                maxlength="100"
                                autocomplete="given-name"
                                required>

                        </div>

                    </div>


                    <!-- Last Name -->

                    <div class="input-group">

                        <label for="lastName">

                            Last Name

                            <span>*</span>

                        </label>

                        <div class="input-wrapper">

                            <span class="input-icon">
                                ♙
                            </span>

                            <input
                                type="text"
                                id="lastName"
                                name="lastName"
                                placeholder="Enter last name"
                                maxlength="100"
                                autocomplete="family-name"
                                required>

                        </div>

                    </div>


                    <!-- Date of Birth -->

                    <div class="input-group">

                        <label for="dob">

                            Date of Birth

                            <span>*</span>

                        </label>

                        <div class="input-wrapper">

                            <span class="input-icon">
                                ▣
                            </span>

                            <input
                                type="date"
                                id="dob"
                                name="dob"
                                required>

                        </div>

                    </div>


                    <!-- Gender -->

                    <div class="input-group">

                        <label for="gender">

                            Gender

                            <span>*</span>

                        </label>

                        <div class="input-wrapper">

                            <span class="input-icon">
                                ♙
                            </span>

                            <select
                                id="gender"
                                name="gender"
                                required>

                                <option value="">
                                    Select gender
                                </option>

                                <option value="Male">
                                    Male
                                </option>

                                <option value="Female">
                                    Female
                                </option>

                                <option value="Other">
                                    Other
                                </option>

                            </select>

                        </div>

                    </div>


                    <!-- Highest Qualification -->

                    <div class="input-group full-width">

                        <label for="highestqualification">

                            Highest Qualification

                            <span>*</span>

                        </label>

                        <div class="input-wrapper">

                            <span class="input-icon">
                                🎓
                            </span>

                            <select
                                id="highestqualification"
                                name="highestqualification"
                                required>

                                <option value="">
                                    Select highest qualification
                                </option>

                                <option value="10th">
                                    10th
                                </option>

                                <option value="12th">
                                    12th
                                </option>

                                <option value="Diploma">
                                    Diploma
                                </option>

                                <option value="B.Tech">
                                    B.Tech
                                </option>

                                <option value="BCA">
                                    BCA
                                </option>

                                <option value="B.Sc">
                                    B.Sc
                                </option>

                                <option value="BBA">
                                    BBA
                                </option>

                                <option value="M.Tech">
                                    M.Tech
                                </option>

                                <option value="MCA">
                                    MCA
                                </option>

                                <option value="MBA">
                                    MBA
                                </option>

                                <option value="M.Sc">
                                    M.Sc
                                </option>

                                <option value="Other">
                                    Other
                                </option>

                            </select>

                        </div>

                    </div>


                    <!-- Year of Passing -->

                    <div class="input-group">

                        <label for="year_of_passing">

                            Year of Passing

                            <span>*</span>

                        </label>

                        <div class="input-wrapper">

                            <span class="input-icon">
                                ▣
                            </span>

                            <input
                                type="number"
                                id="year_of_passing"
                                name="year_of_passing"
                                placeholder="e.g. 2024"
                                min="1950"
                                required>

                        </div>

                    </div>


                    <!-- Mobile Number -->

                    <div class="input-group">

                        <label for="mobilenumber">

                            Mobile Number

                            <span>*</span>

                        </label>

                        <div class="input-wrapper">

                            <span class="input-icon">
                                ☎
                            </span>

                            <input
                                type="tel"
                                id="mobilenumber"
                                name="mobilenumber"
                                placeholder="Enter mobile number"
                                maxlength="15"
                                autocomplete="tel"
                                required>

                        </div>

                    </div>


                </div>


                <!-- Submit -->

                <button
                    type="submit"
                    class="submit-button">

                    <span>
                        Submit Application
                    </span>

                    <span class="submit-arrow">
                        →
                    </span>

                </button>


                <p class="privacy-note">

                    By submitting this application,
                    you confirm that the information
                    provided is accurate.

                </p>


            </form>

        </section>

    </div>

</div>


<script
    src="${pageContext.request.contextPath}/js/validation.js">
</script>

</body>

</html>