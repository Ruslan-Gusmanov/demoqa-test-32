package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {

        private SelenideElement
                header = $(".text-center"),
                nameInput = $("#userName"),
                userEmailInput = $("#userEmail"),
                currentAddressInput = $("#currentAddress"),
                permanentAddressInput = $("#permanentAddress"),
                submitButton = $("#submit"),
                nameText = $("#output #name"),
                emailText = $("#output #email"),
                currentAddressText = $("#output #currentAddress"),
                permanentAddressText = $("#output #permanentAddress");

        private final static String TEXT_BOX = "Text Box";

        public TextBoxPage openPage() {
            open("/text-box");
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
            header.shouldHave(text(TEXT_BOX));
            return this;
        }


        public TextBoxPage setFullName(String name) {
            nameInput.setValue(name);
            return this;
        }

        public TextBoxPage setEmail(String email) {
            userEmailInput.setValue(email);
            return this;
        }


        public TextBoxPage setCurrentAddress(String address) {
            currentAddressInput.setValue(address);
            return this;
        }

        public TextBoxPage setPermanentAddress(String address) {
            permanentAddressInput.setValue(address);
            return this;
        }

        public TextBoxPage submitForm() {
            submitButton.click();
            return this;
        }

        public void confirmData(String fullNameUser, String email, String currentAddress, String permanentAddress) {
            nameText.shouldHave(text(fullNameUser));
            emailText.shouldHave(text(email));
            currentAddressText.shouldHave(text(currentAddress));
            permanentAddressText.shouldHave(text(permanentAddress));

        }
    }
