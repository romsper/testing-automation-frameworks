package frontend.elements

import com.codeborne.selenide.Selenide.element
import frontend.elements.list.CartItemsHelper
import frontend.elements.list.CartItem
import frontend.helpers.Wrappers.Companion.byDataTestId
import io.qameta.allure.Step

class CartHeaderElements {
    private val txtTotalPrice get() = element(byDataTestId("cart-total-price"))
    private val btnCheckout get() = element(byDataTestId("cart-checkout"))
    private val listCartProducts get() = CartItemsHelper().getCartItems()

    @Step("Get products in cart")
    fun getCartProducts(): List<CartItem> {
        return listCartProducts
    }

    @Step("Get total price in cart")
    fun getTotalPrice(): Float {
        return txtTotalPrice.text.replace("Total: $", "").toFloat()
    }

    @Step("Click checkout button")
    fun clickCheckout(): PopupOrderStatus {
        btnCheckout.click()
        return PopupOrderStatus()
    }
}