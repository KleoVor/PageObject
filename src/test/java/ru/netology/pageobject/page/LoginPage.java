package ru.netology.pageobject.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.pageobject.data.DataHelper;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final SelenideElement loginReg = $("[data-test-id=login] input");
    private final SelenideElement passwordReg = $("[data-test-id=password] input");
    private final SelenideElement loginButton = $("[data-test-id=action-login]");
    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        loginReg.setValue(info.getLogin());
        passwordReg.setValue(info.getPassword());
        loginButton.click();
        return new VerificationPage();
    }
}
