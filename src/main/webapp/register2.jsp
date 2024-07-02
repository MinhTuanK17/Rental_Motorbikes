<%-- 
    Document   : register
    Created on : May 25, 2024, 4:58:16 PM
    Author     : DiepTCNN
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Carbook - Free Bootstrap 4 Template by Colorlib</title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
        <link rel="stylesheet" href="css/animate.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">
        <link rel="stylesheet" href="css/aos.css">
        <link rel="stylesheet" href="css/ionicons.min.css">
        <link rel="stylesheet" href="css/bootstrap-datepicker.css">
        <link rel="stylesheet" href="css/jquery.timepicker.css">
        <link rel="stylesheet" href="css/flaticon.css">
        <link rel="stylesheet" href="css/icomoon.css">
        <link rel="stylesheet" href="css/style.css">
        <link href="https://cdn.jsdelivr.net/npm/remixicon@4.1.0/fonts/remixicon.css" rel="stylesheet" />
        <style>
            @import url("https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap");

            :root {
                --primary-color: #2015ea;
                --primary-color-light: #6861f1;
                --secondary-color: #c0dbea;
                --text-dark: #020617;
                --text-light: #94a3b8;
                --white: #ffffff;
                --max-width: 1200px;
            }

            .border-md {
                border-width: 20px;
            }

            .form-control::placeholder {
                color: #ccc;
                font-weight: bold;
                font-size: 0.9rem;
            }

            .register {
                background: linear-gradient(243.4deg, rgb(2, 184, 175) 13%, rgb(4, 111, 212) 98%);
                color: white;
                border-radius: 10px;
            }

            .register:hover {
                background: linear-gradient(243.4deg, rgb(0, 132, 255) 13%, rgb(8, 126, 120) 98%);
                color: white;
            }

            .info input {
                border: 5px solid white;
                border-radius: 20px;
                box-shadow: #76C8B4 0 0 5px;
                width: 100%;
                padding: 2%;
            }
            .info select {
                border: 5px solid white;
                border-radius: 20px;
                box-shadow: #76C8B4 0 0 5px;
                width: 100%;
                padding: 2%;
            }

            /*            .formRegister {
                            width: 1300px;
                            height: 655px;
                        }*/

            .logoImg img {
                width: 127%;
                /*border-radius: 100px;*/
            }

            .img-fluid {
                max-width: none !important;
            }

            /*            .container{
                            display: flex;
                            justify-content: center;
                            width: 200%;
                        }*/
            #password-eye {
                color: var(--primary-color);
            }

            .inputRow {
                width: 100%;
                display: flex;
                align-items: center;
                border-radius: 5px;
            }

            .eye {
                width: 100%;
                /*                max-width: 80%;*/
            }

            .inputRow.input-error .tooltip {
                visibility: visible;
                opacity: 1;
            }

            .inputRow input {
                position: relative;
            }

            .inputRow span {
                position: absolute;
                right: 30px;
                cursor: pointer;
            }

            .error-message {
                color: red;
                font-size: 0.9rem;
                display: none;
                margin-left: 5%;
            }
            .password-strength {
                font-size: 0.9rem;
                display: none;
                margin-left: 5%;
            }

            .weak {
                color: red;
            }

            .medium {
                color: orange;
            }

            .strong {
                color: green;
            }
        </style>
    </head>

    <body>
        <div class="container">
            <div class="row py-5 align-items-center formRegister">
                <!-- For Demo Purpose -->
                <div class="col-md-5 pr-lg-5 mb-md-0 logoImg" data-aos="zoom-in">
                    <img src="images/register3.png" style="" alt="" class="img-fluid mb-3 d-none d-md-block">
                </div>

                <!-- Registration Form -->
                <div class="col-md-7 col-lg-6 ml-auto" data-aos="fade-left">
                    <form action="register" method="post" onsubmit="return validatePhoneNumber()">
                        <div class="row">
                            <!-- First Name -->
                            <div class="col-lg-6 mb-4 info" data-aos="fade-up">
                                <input id="firstName" type="text" name="firstname" placeholder="Firstname" required>
                            </div>

                            <!-- Last Name -->
                            <div class="input-group col-lg-6 mb-4 info" data-aos="fade-up" data-aos-delay="100">
                                <input id="lastName" type="text" name="lastname" placeholder="LastName" required>
                            </div>
                            <div class="input-group col-lg-6 mb-4 info" data-aos="fade-up" data-aos-delay="100">
                                <select id="gender" name="gender" class="inputRow">
                                    <option disabled selected>Gender</option>
                                    <option value="Nam">Nam</option>
                                    <option value="Nữ">Nữ</option>
                                    <option value="unknown">Không xác định</option>
                                </select>
                            </div>
                            <!-- Username -->
                            <div class="input-group col-lg-6 mb-4 info" data-aos="fade-up" data-aos-delay="400">
                                <input id="Username" type="text" name="username" placeholder="Username" required>
                            </div>

                            <!-- Email Address -->
                            <div class="input-group col-lg-12 mb-4 info" data-aos="fade-up" data-aos-delay="200">
                                <input id="email" type="email" name="email" placeholder="Email" required>
                            </div>

                            <!-- Phone Number -->
                            <div class="input-group col-lg-12 mb-4 info" data-aos="fade-up" data-aos-delay="300">
                                <input id="phoneNumber" type="tel" name="phone" placeholder="PhoneNumber" required>
                                <span class="error-message" id="phone-error">*Số điện thoại phải có 10 chữ số.</span>
                            </div>

                            <!-- Password -->
                            <div class="col-lg-6 mb-4 info inputRow" data-aos="fade-up" data-aos-delay="500">
                                <input type="password" class="eye" name="password" id="password" value="" placeholder="Password" maxlength="30" required />
                                <span id="password-eye-1"><i class="ri-eye-off-line"></i></span>

                            </div>


                            <!-- Password Confirmation -->
                            <div class="col-lg-6 mb-4 info inputRow" data-aos="fade-up" data-aos-delay="600">
                                <input type="password" class="eye" name="passwordConfirmation" id="passwordConfirmation" value="" placeholder="Re-Password" maxlength="30" required />
                                <span id="password-eye-2"><i class="ri-eye-off-line"></i></span>
                            </div>
                            
                            <span class="password-strength" id="password-strength">*</span>
                            
                            <!-- Submit Button -->
                            <div class="form-group col-lg-12 mx-auto mb-0" data-aos="zoom-in" data-aos-delay="700">
                                <button type="submit" name="register-submit" id="register-submit" class="btn btn-block py-2 register font-weight-bold" data-aos="zoom-in" data-aos-delay="700">Register</button>
                            </div>


                            <!-- Divider Text -->
                            <div class="form-group col-lg-12 mx-auto d-flex align-items-center my-4" data-aos="zoom-in" data-aos-delay="800">
                                <div class="border-bottom w-100 ml-5"></div>
                                <span class="px-2 small text-muted font-weight-bold text-muted">OR</span>
                                <div class="border-bottom w-100 mr-5"></div>
                            </div>

                            <!-- Already Registered -->
                            <div class="text-center w-100" data-aos="fade-up" data-aos-delay="1000">
                                <p class="text-muted font-weight-bold">Already have an account? <a href="login2.jsp" class="ml-2" style="color: #0A8EBF;">Login</a></p>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <script src="js/register.js"></script>
        <script src="js/aos.js"></script>
        <script>
                        AOS.init({
                            duration: 400, // Duration of animation in milliseconds
                            once: true // Whether animation should happen only once
                        });
        </script>

        <script>
            document.addEventListener("DOMContentLoaded", () => {
                const phoneInput = document.getElementById("phoneNumber");
                const phoneError = document.getElementById("phone-error");
                const passwordInput = document.getElementById("password");
                const passwordError = document.getElementById("password-error");
                const passwordStrength = document.getElementById("password-strength");

                phoneInput.addEventListener("input", () => {
                    if (phoneInput.value.length === 10 || phoneInput.value.length === 0) {
                        phoneError.style.display = "none";
                    } else {
                        phoneError.style.display = "block";
                    }
                });


                passwordInput.addEventListener("input", () => {
                    const password = passwordInput.value;
                    

                    if (password.length > 10) {
                        passwordStrength.textContent = "Mật khẩu mạnh";
                        passwordStrength.className = "password-strength strong";
                    } else if (password.length >= 8) {
                        passwordStrength.textContent = "Mật khẩu vừa";
                        passwordStrength.className = "password-strength medium";
                    } else if (password.length > 0) {
                        passwordStrength.textContent = "Mật khẩu yếu";
                        passwordStrength.className = "password-strength weak";
                    } else {
                        passwordStrength.textContent = "";
                    }
                    passwordStrength.style.display = password.length > 0 ? "block" : "none";
                });

                const togglePasswordVisibility = (inputId, iconId) => {
                    const passwordInput = document.getElementById(inputId);
                    const icon = document.getElementById(iconId).querySelector("i");
                    const isVisible = passwordInput.type === "text";
                    passwordInput.type = isVisible ? "password" : "text";
                    icon.classList.toggle("ri-eye-line", !isVisible);
                    icon.classList.toggle("ri-eye-off-line", isVisible);
                };

                const passwordBtn1 = document.getElementById("password-eye-1");
                const passwordBtn2 = document.getElementById("password-eye-2");
                passwordBtn1.addEventListener("click", () => togglePasswordVisibility("password", "password-eye-1"));
                passwordBtn2.addEventListener("click", () => togglePasswordVisibility("passwordConfirmation", "password-eye-2"));
            });

        </script>
    </body>

</html>
