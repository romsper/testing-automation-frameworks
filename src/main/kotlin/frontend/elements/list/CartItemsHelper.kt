package frontend.elements.list

import com.codeborne.selenide.Selenide.elements
import com.codeborne.selenide.SelenideElement
import frontend.helpers.Wrappers.Companion.byDataTestGroup

class CartItemsHelper {
    private val listCartProducts get() = elements(byDataTestGroup("cart-item"))

    fun getCartItems(): List<CartItem> {
        return listCartProducts
            .map {
                CartItem(
                    image = it.find(byDataTestGroup("cart-item-image")),
                    name = it.find(byDataTestGroup("cart-item-name")).text,
                    price = it.find(byDataTestGroup("cart-item-price")).text.replace("$", "").toFloat(),
                    btnIncrement = it.find(byDataTestGroup("cart-item-increment")),
                    quantity = it.find(byDataTestGroup("cart-item-qty")).text.toInt(),
                    btnDecrement = it.find(byDataTestGroup("cart-item-decrement")),
                )
            }
    }
}

data class CartItem(
    val image: SelenideElement,
    val name: String,
    val price: Float,
    val btnDecrement: SelenideElement,
    val quantity: Int,
    val btnIncrement: SelenideElement,
)
