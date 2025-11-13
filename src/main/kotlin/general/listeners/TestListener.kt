package general.listeners

import com.codeborne.selenide.Screenshots
import com.codeborne.selenide.Selenide
import frontend.helpers.InitDriverProvider
import io.qameta.allure.Attachment
import org.junit.platform.engine.TestExecutionResult
import org.junit.platform.launcher.TestExecutionListener
import org.junit.platform.launcher.TestIdentifier
import org.junit.platform.launcher.TestPlan

class TestListener : TestExecutionListener {

    override fun testPlanExecutionStarted(testPlan: TestPlan) {
        println("|----- START -----|\n")
        println("Initializing RemoteWebDriver or run in LocalBrowser...").also { InitDriverProvider() } // Read details in InitDriverProvider.kt
    }

    override fun executionFinished(testIdentifier: TestIdentifier, testExecutionResult: TestExecutionResult) {
        if (testIdentifier.isTest) println("Finish: ${testIdentifier.displayName}")
        if (testExecutionResult.status == TestExecutionResult.Status.FAILED && testIdentifier.displayName != "JUnit Jupiter") {
            attachScreenshot()
        }
    }

    override fun executionSkipped(testIdentifier: TestIdentifier, reason: String) {
        if (testIdentifier.isTest) println("Ignore: ${testIdentifier.displayName}\nReason: $reason")
    }

    override fun testPlanExecutionFinished(testPlan: TestPlan) {
        Selenide.closeWebDriver()
        println("|----- FINISH -----|")
    }

    @Attachment(value = "{name}", type = "image/png")
    fun attachScreenshot(name: String = "SCREENSHOT"): ByteArray? {
        return Screenshots.takeScreenShotAsFile()?.readBytes()
    }
}
