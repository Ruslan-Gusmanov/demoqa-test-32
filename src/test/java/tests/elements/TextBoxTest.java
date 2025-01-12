package tests.elements;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;


public class TextBoxTest extends tests.TestBase {

    private String
            fullNameUser = "Ruslan",
            email = "rg@mail.ru",
            currentAddress = "Moscow",
            permanentAddress = "Moscow";

    TextBoxPage textBox = new TextBoxPage();
    @Test
    void successfulFillInAndSubmitFullFormTest() {
        textBox.openPage()
                .setFullName(fullNameUser)
                .setEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .submitForm()
                .confirmData(fullNameUser, email, currentAddress, permanentAddress);
    }
}
