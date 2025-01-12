package tests.elements;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;


public class TextBoxTest extends tests.TestBase {

    TextBoxPage textBox = new TextBoxPage();
    @Test
    void successfulFillInAndSubmitFullFormTest() {
        String fullNameUser = "Ruslan";
        String email = "rg@mail.ru";
        String currentAddress = "Moscow";
        String permanentAddress = "Moscow";
        textBox.openPage()
                .setFullName(fullNameUser)
                .setEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .submitForm()
                .confirmData(fullNameUser, email, currentAddress, permanentAddress);
    }
}
