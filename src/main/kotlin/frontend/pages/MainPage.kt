package frontend.pages

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.element
import io.qameta.allure.Step
import frontend.elements.HeaderElements
import frontend.helpers.Wrappers.Companion.byDataTestGroup

class MainPage {
    private val btnPopupConfirm get() = element(byDataTestGroup("age-popup-btn"))

    @Step("Open main page")
    fun open(): MainPage {
        Selenide.open("/")
        return this
    }

    @Step("Confirm age popup")
    fun clickAgePopup(): MainPage {
        btnPopupConfirm.click()
        return this
    }

    @Step("Click on header link")
    fun goToHeader(): HeaderElements {
        return HeaderElements()
    }
}
