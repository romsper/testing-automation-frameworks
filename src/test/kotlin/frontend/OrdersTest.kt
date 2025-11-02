package frontend

import frontend.helpers.BaseTest
import frontend.pages.MainPage
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.shouldBe
import io.qameta.allure.Feature
import io.qameta.allure.Severity
import io.qameta.allure.SeverityLevel
import io.qameta.allure.Story
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test

@Feature("Orders")
@Story("Orders")
@Tags(Tag("orders"), Tag("regress"))
class OrdersTest : BaseTest() {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Check create order from popular products")
    fun checkCreateOrder() {
        MainPage()
            .open()
            .getPopularProducts()
            .first().btnIncrement.click()

        val popupOrder = MainPage()
            .navigateToHeader()
            .clickLink("Cart")
            .navigateToCart()
            .clickCheckout()

        val title = popupOrder.getTitle()
        val orderId = popupOrder.getOrderId()
        val orderStatus = popupOrder.getStatus()

        title shouldBe "Order Created!"
        orderId.toInt() shouldBeGreaterThan 0
        orderStatus shouldBe "Status: PENDING"
    }
}