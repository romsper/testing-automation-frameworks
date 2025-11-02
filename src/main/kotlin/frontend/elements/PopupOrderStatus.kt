package frontend.elements

import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.SelenideElement
import frontend.helpers.Wrappers.Companion.byDataTestId
import io.qameta.allure.Step

class PopupOrderStatus {
    private val txtTitle: SelenideElement get() = element(byDataTestId("order-popup-title"))
    private val txtOrderId: SelenideElement get() = element(byDataTestId("order-popup-id"))
    private val txtStatus: SelenideElement get() = element(byDataTestId("order-popup-status"))
    private val btnClose: SelenideElement get() = element(byDataTestId("order-popup-close"))

    @Step("Get order popup title")
    fun getTitle(): String {
        return txtTitle.text
    }

    @Step("Get order ID from popup")
    fun getOrderId(): String {
        return txtOrderId.text.filter { it.isDigit() }
    }

    @Step("Get order status from popup")
    fun getStatus(): String {
        return txtStatus.text
    }

    @Step("Close order popup")
    fun closePopup(): PopupOrderStatus {
        btnClose.click()
        return this
    }
}