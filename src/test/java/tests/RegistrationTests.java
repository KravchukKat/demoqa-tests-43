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
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void succsessfulRegistrationTest() {
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
        $(".subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("cat.jpg");
        $("#currentAddress").setValue("Some street 1");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Noida").pressEnter();
        $("#submit").click();

        $(".table-responsive").$(byText("Name")).sibling(0).shouldHave(exactText("Alex" + " " + "Egorov"));
        $(".table-responsive").$(byText("Email")).sibling(0).shouldHave(text("alex@egorov.com"));
        $(".table-responsive").$(byText("Gender")).sibling(0).shouldHave(text("Other"));
        $(".table-responsive").$(byText("Mobile")).sibling(0).shouldHave(text("89227751265"));
        $(".table-responsive").$(byText("Date of Birth")).sibling(0).shouldHave(text("12 January,1990"));
        $(".table-responsive").$(byText("Subjects")).sibling(0).shouldHave(text("Math"));
        $(".table-responsive").$(byText("Hobbies")).sibling(0).shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture")).sibling(0).shouldHave(text("cat.jpg"));
        $(".table-responsive").$(byText("Address")).sibling(0).shouldHave(text("Some street 1"));
        $(".table-responsive").$(byText("State and City")).sibling(0).shouldHave(text("NCR Noida"));
        $("#closeLargeModal").click();

    }
}