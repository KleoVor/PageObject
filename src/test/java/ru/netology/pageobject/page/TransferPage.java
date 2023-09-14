package ru.netology.pageobject.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.pageobject.data.DataHelper;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class TransferPage {
    private final SelenideElement amountInput = $("[data-test-id=amount] input");
    private final SelenideElement transferFrom = $("[data-test-id=from] input");
    //   private final SelenideElement transferTo = $("[data-test-id=to] input");
    private final SelenideElement transferButton = $("[data-test-id=action-transfer]");
    public final SelenideElement cancelButton = $("[data-test-id=action-cancel]");
    private final SelenideElement transferHead = $(byText("Пополнение карты"));
    private final SelenideElement errorNotification = $("[data-test-id=error-amount-notification]");


    public TransferPage() {

        transferHead.shouldBe(Condition.visible);
    }

    public DashboardPage makeValidTransfer(String amountToTransfer, DataHelper.Card card) {
        makeTransfer(amountToTransfer, card);
        return new DashboardPage();
    }

    public void makeTransfer(String amountToTransfer, DataHelper.Card card) {
        amountInput.setValue(amountToTransfer);
        transferFrom.setValue(card.getCardNumber());
        transferButton.click();

    }

    public void checkErrorNotificationAmountVisible(){
        errorNotification.shouldBe(Condition.visible);
    }

}