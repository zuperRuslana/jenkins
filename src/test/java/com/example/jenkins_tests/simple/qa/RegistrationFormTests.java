package com.example.jenkins_tests.simple.qa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests extends TestBase {
        @Test
        void fillFormTest() {
            step("Open registrations form", () -> {
                open("/automation-practice-form");
                $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
                executeJavaScript("$('footer').remove()");
                executeJavaScript("$('#fixedban').remove()");
            });
            step("Fill form", () -> {
                $("#firstName").setValue("Alex");
                $("#lastName").setValue("Egorov");
                $("#userEmail").setValue("alex@egorov.com");
                $("#genterWrapper").$(byText("Other")).click(); // best
                $("#userNumber").setValue("1234567890");
                $("#dateOfBirthInput").click();
                $(".react-datepicker__month-select").selectOption("July");
                $(".react-datepicker__year-select").selectOption("2008");
                $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
                $("#subjectsInput").setValue("Math").pressEnter();
                $("#hobbiesWrapper").$(byText("Sports")).click(); // best
                $("#uploadPicture").uploadFromClasspath("image.img/1.png");
                $("#currentAddress").setValue("Some address 1");
                $("#state").click();
                $("#stateCity-wrapper").$(byText("NCR")).click();
                $("#city").click();
                $("#stateCity-wrapper").$(byText("Delhi")).click();
                $("#submit").click();
            });
            step("Check form results", () -> {
                $(".modal-dialog").should(appear);
                $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

                $(".table-responsive table").shouldHave(text("Alex"), text("Egorov"),
                        text("alex@egorov.com"), text("1234567890"));
            });

        }
    }

