package frontend.pages

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.element
import io.qameta.allure.Step
import frontend.elements.HeaderElements
import frontend.elements.list.ProductItem
import frontend.elements.list.ProductItemsHelper
import frontend.helpers.Wrappers.Companion.byDataTestId

class MainPage {
    private val txtTitle get() = element(byDataTestId("main-image-text"))
    private val listPopularProducts get() = ProductItemsHelper().getProductItems()

    @Step("Open main page")
    fun open(): MainPage {
        Selenide.open("/")
        return this
    }

    @Step("Navigate to header")
    fun navigateToHeader(): HeaderElements {
        return HeaderElements()
    }

    @Step("Get title text")
    fun getTitleText(): String {
        return txtTitle.text
    }

    @Step("Get popular products")
    fun getPopularProducts(): List<ProductItem> {
        return listPopularProducts
    }
}
