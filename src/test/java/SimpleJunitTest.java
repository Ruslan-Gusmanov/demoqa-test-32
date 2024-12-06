import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SimpleJunitTest {


   @BeforeAll
   static void beforeAll() {
       Configuration.browserSize = "1920x1080"; // разрешение экрана при запуске страницы
       Configuration.baseUrl = "https://demoqa.com"; // базовый URL
       Configuration.pageLoadStrategy = "eager";
   }

    @Test
    void fillFormTest() {
        open("/automation-practice-form"); // апишка
        $("#firstName").setValue("Ruslan");
        $("#lastName").setValue("Gusmanov");
        $("#userEmail").setValue("rg@mail.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userForm #userNumber").setValue("8927000000");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1989");
        $(".react-datepicker__day.react-datepicker__day--001").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("og_og_148879361322373683.jpg");
        $("#currentAddress").setValue("Moscow");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table").shouldHave(text("Student Name")).shouldHave(text("Ruslan Gusmanov"));
        $(".table").shouldHave(text("Student Email")).shouldHave(text("rg@mail.ru"));
        $(".table").shouldHave(text("Gender")).shouldHave(text("Male"));
        $(".table").shouldHave(text("Mobile")).shouldHave(text("8927000000"));
        $(".table").shouldHave(text("Date of Birth")).shouldHave(text("01 January,1989"));
        $(".table").shouldHave(text("Subjects")).shouldHave(text("Maths"));
        $(".table").shouldHave(text("Hobbies")).shouldHave(text("Sports"));
        $(".table").shouldHave(text("Picture")).shouldHave(text("og_og_148879361322373683.jpg"));
        $(".table").shouldHave(text("Address")).shouldHave(text("Moscow"));
        $(".table").shouldHave(text("State and City")).shouldHave(text("NCR Delhi"));
    }
}
