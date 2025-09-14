package frontend.helpers

import backend.helpers.Properties.Companion.properties
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.WebDriverProvider
import org.openqa.selenium.Capabilities
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.LocalFileDetector
import org.openqa.selenium.remote.RemoteWebDriver
import java.net.URL

open class InitDriverProvider : WebDriverProvider {

    init {
        println("Properties: $properties")

        Configuration.timeout = 15000
        Configuration.pageLoadStrategy = "normal"
        Configuration.reopenBrowserOnFail = true
        Configuration.baseUrl = properties.frontendUrl

//        Proxy configuration for Selenide
//        Configuration.proxyEnabled = true
//        Configuration.proxyHost =
//        Configuration.fileDownload = FileDownloadMode.PROXY
    }

    /*
    Moon doesn't work with normal browsers on ARM64 or MacBooks (Apple Silicon) CPU.
    So, you can modify the Moon values.yaml file to use the Chromium, etc. images instead.
    (https://aerokube.com/moon/latest/#install-kubernetes:~:text=Using%20ARM64%2Dcompatible%20browser%20images)
     */

    // This is example for Production Ready Chrome browser.
    override fun createDriver(capabilities: Capabilities): RemoteWebDriver {
        return when (properties.browserName) {
            "chrome" -> {
                ChromeOptions().apply {
                    setCapability("browserVersion", properties.browserVersion)
                    setCapability(
                        "moon:options",
                        mapOf(
                            "headless" to false,
                            "enableVNC" to true,
                            "acceptInsecureCerts" to true,
                            "screenResolution" to "1920x1080"
                        )
                    )
                    addArguments("--disable-gpu")
                    addArguments("window-size=1920,1080")
                }
            }

            else -> throw Error("Browser is not defined")
        }
            .run { RemoteWebDriver(URL(properties.moonHost), this) }
            .apply { this.fileDetector = LocalFileDetector() }
    }
}
