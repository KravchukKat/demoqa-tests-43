package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTests {

    @BeforeAll
    static void beforeAll() {
//        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void successfulRegistrationTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Egorov");
        $("#userEmail").setValue("alex@egorov.com");
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("89227751265");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--020:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("cat.jpg");
        $("#currentAddress").setValue("Some street 1");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Noida").pressEnter();
        $("#submit").click();

        $(".table-responsive").$(byText("Name")).parent().shouldHave(exactText("Alex" + " " + "Egorov"));
        $(".table-responsive").$(byText("Email")).parent().shouldHave(text("alex@egorov.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Other"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("89227751265"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("12 January,1990"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Math"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("cat.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Some street 1"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Noida"));
        $("#closeLargeModal").click();

    }
}