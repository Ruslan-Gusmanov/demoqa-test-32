package tests.forms;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ConfirmationPage;


public class RegistrationFormTest extends tests.TestBase {
    final String
            setFirstName = "Ruslan",
            setLastName = "Gusmanov",
            setUserEmail = "rg@mail.ru",
            setUserGender = "Male",
            setUserNumber = "8927000000",
            yearOfBirth = "1989",
            monthOfbirth = "January",
            dayOfbirth = "01",
            setSubject = "Maths",
            setHobbies = "Sports",
            setPicture = "og_og_148879361322373683.jpg",
            setAddress = "Moscow",
            setState = "NCR",
            setCity = "Delhi";


    final String
            fullNameCellName = "Student Name",
            emailCellName = "Student Email",
            genderCellName = "Gender",
            phoneCellName = "Mobile",
            birthdayCellName = "Date of Birth",
            subjectCellName = "Subjects",
            hobbyCellName = "Hobbies",
            pictureCellName = "Picture",
            addressCellName = "Address",
            stateAndCityCellName = "State and City";

    RegistrationPage registrationPage = new RegistrationPage();
    ConfirmationPage confirmationPage = new ConfirmationPage();



    @Test
    void fullFillFormTest() {
        registrationPage
                .openPage()
                .removeBanner()
                .setFirstName(setFirstName)
                .setLastName(setLastName)
                .setUserEmail(setUserEmail)
                .setUserGender(setUserGender)
                .setUserNumber(setUserNumber)
                .setDateOfBirth(dayOfbirth, monthOfbirth, yearOfBirth)
                .setSubject(setSubject)
                .setHobbies(setHobbies)
                .setPicture(setPicture)
                .setAddress(setAddress)
                .setState(setState)
                .setCity(setCity)
                .setSubmit();



        confirmationPage
                .confirmPage()
                .confirmResult(fullNameCellName, setFirstName + " " + setLastName)
                .confirmResult(emailCellName, setUserEmail)
                .confirmResult(genderCellName, setUserGender)
                .confirmResult(phoneCellName, setUserNumber)
                .confirmResult(birthdayCellName, dayOfbirth + " " + monthOfbirth + "," + yearOfBirth)
                .confirmResult(subjectCellName, setSubject)
                .confirmResult(hobbyCellName, setHobbies)
                .confirmResult(pictureCellName, setPicture)
                .confirmResult(addressCellName, setAddress)
                .confirmResult(stateAndCityCellName, setState + " " + setCity);
    }

@Test
void minFillFormTest() {
    registrationPage
            .openPage()
            .removeBanner()
            .setFirstName(setFirstName)
            .setLastName(setLastName)
            .setUserGender(setUserGender)
            .setUserNumber(setUserNumber)
            .setSubject(setSubject)
            .setHobbies(setHobbies)
            .setPicture(setPicture)
            .setAddress(setAddress)
            .setState(setState)
            .setCity(setCity)
            .setSubmit();



    confirmationPage
            .confirmPage()
            .confirmResult(fullNameCellName, setFirstName + " " + setLastName)
            .confirmResult(genderCellName, setUserGender)
            .confirmResult(phoneCellName, setUserNumber)
            .confirmResult(subjectCellName, setSubject)
            .confirmResult(hobbyCellName, setHobbies)
            .confirmResult(pictureCellName, setPicture)
            .confirmResult(addressCellName, setAddress)
            .confirmResult(stateAndCityCellName, setState + " " + setCity);



}
    @Test
    void negativeFillFormTest() {
        registrationPage
                .openPage()
                .removeBanner()
                .setFirstName(setFirstName)
                .setUserGender(setUserGender)
                .setUserNumber(setUserNumber)
                .setSubmit()
                .validateLastUserField();
    }
}

