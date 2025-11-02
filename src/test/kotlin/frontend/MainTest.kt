package frontend

import frontend.helpers.BaseTest
import frontend.pages.MainPage
import io.kotest.matchers.shouldBe
import io.qameta.allure.Feature
import io.qameta.allure.Severity
import io.qameta.allure.SeverityLevel
import io.qameta.allure.Story
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test

@Feature("Main page")
@Story("Banner title")
@Tags(Tag("banner"), Tag("regress"))
class MainTest : BaseTest() {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Check main page banner title")
    fun checkTitleText() {
        val title = MainPage()
            .open()
            .getTitleText()

        title shouldBe "Welcome to Brew & Bean"
    }
}