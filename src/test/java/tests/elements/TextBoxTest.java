package tests.elements;

import org.junit.jupiter.api.Test;
import pages.TestBase;
import pages.TextBoxPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest extends TestBase {

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
