document.addEventListener(
    "DOMContentLoaded",
    function () {

        const form =
            document.getElementById("studentForm");

        const dob =
            document.getElementById("dob");

        const year =
            document.getElementById(
                "year_of_passing"
            );

        const mobile =
            document.getElementById(
                "mobilenumber"
            );


        /*
         * Get today's date.
         */

        const today =
            new Date()
                .toISOString()
                .split("T")[0];


        /*
         * DOB cannot be a future date.
         */

        dob.max = today;


        /*
         * Passing year cannot be
         * greater than current year.
         */

        const currentYear =
            new Date().getFullYear();

        year.max = currentYear;


        /*
         * Mobile number:
         * Allow only digits.
         */

        mobile.addEventListener(
            "input",
            function () {

                this.value =
                    this.value.replace(
                        /\D/g,
                        ""
                    );

            }
        );


        /*
         * Form validation.
         */

        form.addEventListener(
            "submit",
            function (event) {

                const mobileValue =
                    mobile.value.trim();

                const passingYear =
                    parseInt(
                        year.value,
                        10
                    );


                /*
                 * Validate mobile number.
                 */

                if (
                    !/^[0-9]{10,15}$/
                        .test(mobileValue)
                ) {

                    event.preventDefault();

                    alert(
                        "Please enter a valid mobile number containing 10-15 digits."
                    );

                    mobile.focus();

                    return;
                }


                /*
                 * Validate passing year.
                 */

                if (
                    Number.isNaN(passingYear) ||
                    passingYear < 1950 ||
                    passingYear > currentYear
                ) {

                    event.preventDefault();

                    alert(
                        "Please enter a valid year of passing."
                    );

                    year.focus();

                    return;
                }


                /*
                 * Validate DOB.
                 */

                if (
                    dob.value &&
                    dob.value > today
                ) {

                    event.preventDefault();

                    alert(
                        "Date of birth cannot be in the future."
                    );

                    dob.focus();

                    return;
                }

            }
        );

    }
);