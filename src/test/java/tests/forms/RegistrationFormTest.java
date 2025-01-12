package tests.forms;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.TestData;


public class RegistrationFormTest extends tests.TestBase {


    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();



    @Test
    void fullFillFormTest() {
        registrationPage
                .openPage()
                .removeBanner()
                .setFirstName(testData.setFirstName)
                .setLastName(testData.setLastName)
                .setUserEmail(testData.setUserEmail)
                .setUserGender(testData.setUserGender)
                .setUserNumber(testData.setUserNumber)
                .setDateOfBirth(testData.userBirthDay, testData.userBirthMonth, testData.userBirthYear)
                .setSubject(testData.setSubject)
                .setHobbies(testData.setHobbies)
                .setPicture(testData.setPicture)
                .setAddress(testData.setAddress)
                .setState(testData.setState)
                .setCity(testData.setCity)
                .setSubmit()

                .checkResult("Student Name", testData.setFirstName + " " + testData.setLastName)
                .checkResult("Student Email", testData.setUserEmail)
                .checkResult("Gender", testData.setUserGender)
                .checkResult("Mobile", testData.setUserNumber)
                .checkResult("Date of Birth", testData.userBirthDay + " " +  testData.userBirthMonth + "," + testData.userBirthYear)
                .checkResult("Subjects", testData.setSubject)
                .checkResult("Hobbies", testData.setHobbies)
                .checkResult("Picture", testData.setPicture)
                .checkResult("Address", testData.setAddress)
                .checkResult("State and City", testData.setState + " " + testData.setCity);
    }

@Test
void minFillFormTest() {
    registrationPage
            .openPage()
            .removeBanner()
            .setFirstName(testData.setFirstName)
            .setLastName(testData.setLastName)
            .setUserGender(testData.setUserGender)
            .setUserNumber(testData.setUserNumber)
            .setSubject(testData.setSubject)
            .setHobbies(testData.setHobbies)
            .setPicture(testData.setPicture)
            .setAddress(testData.setAddress)
            .setState(testData.setState)
            .setCity(testData.setCity)
            .setSubmit()

            .checkResult("Student Name", testData.setFirstName + " " + testData.setLastName)
            .checkResult("Gender", testData.setUserGender)
            .checkResult("Mobile", testData.setUserNumber)
            .checkResult("Subjects", testData.setSubject)
            .checkResult("Hobbies", testData.setHobbies)
            .checkResult("Picture", testData.setPicture)
            .checkResult("Address", testData.setAddress)
            .checkResult("State and City", testData.setState + " " + testData.setCity);
    }
    @Test
    void negativeFillFormTest() {
        registrationPage
                .openPage()
                .removeBanner()
                .setFirstName(testData.setFirstName)
                .setUserGender(testData.setUserGender)
                .setUserNumber(testData.setUserNumber)
                .setSubmit()
                .validateLastUserField();
    }
}