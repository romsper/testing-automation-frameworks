package frontend.helpers

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.sleep
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

open class BaseTest {

    @BeforeEach
    fun openBrowser() {
        Selenide.open("/")
        sleep(15000)
    }

    @AfterEach
    fun clearBrowser() {
        Selenide.clearBrowserCookies()
        Selenide.clearBrowserLocalStorage()
    }
}