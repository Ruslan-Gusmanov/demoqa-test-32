package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableComponent;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage{
    CalendarComponent calendarComponent = new CalendarComponent();
    TableComponent tableComponent = new TableComponent();

    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            genderWrapper = $("#genterWrapper"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            uploadPictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submitInput = $("#submit");




    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName (String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName (String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmail (String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserGender (String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber (String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth (String day, String month, String year) {

        dateOfBirthInput.click();
         calendarComponent.setDate(day,month,year);

        return this;
    }

    public RegistrationPage setSubject (String value) {

        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies (String value) {

        hobbiesInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPicture (String value) {

        uploadPictureInput.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setAddress (String value) {

        addressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState (String value) {

        stateInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setCity (String value) {

        cityInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setSubmit () {

        submitInput.click();

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        tableComponent.checkTableResult(key, value);
        return this;
    }
    public void validateLastUserField() {
        lastNameInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)")); // Проверка на hex #dc3545 в формате rgb
    }
}