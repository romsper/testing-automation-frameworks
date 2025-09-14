package backend.helpers

import java.util.Properties


@Suppress("JAVA_CLASS_ON_COMPANION")
class Properties {

    companion object {
        val properties: Props by lazy {
            val resourceStream = javaClass.getResourceAsStream(System.getProperty("prop_file", "/example.properties"))
                ?: throw IllegalArgumentException("Property file not found: ${System.getProperty("prop_file")}")

            val prop = Properties().apply { load(resourceStream) }

            Props(
                browserName = prop.getProperty("browser.name"),
                browserVersion = prop.getProperty("browser.version"),
                frontendUrl = prop.getProperty("frontend.url"),
                backendUrl = prop.getProperty("backend.url"),
                moonHost = prop.getProperty("moon.host"),
            )
        }
    }

    data class Props(
        var browserName: String,
        var browserVersion: String,
        var frontendUrl: String,
        var backendUrl: String,
        var moonHost: String,
    )
}
