# Automation project
[![](https://img.shields.io/badge/-LinkedIn-blue?style=flat&logo=Linkedin&logoColor=white)](https://www.linkedin.com/in/romsper/) [![](https://img.shields.io/static/v1?label=Telegram&message=%23&logo=Telegram&color=%23fe8e86)](http://t.me/romsper_qa_buddy) ![](https://komarev.com/ghpvc/?username=romsper) 

### Description

This repository contains several examples of **Automation testing** frameworks and projects using different programming languages **Kotlin** and **TypeScript/JavaScript** and tools. You can use these examples as a starting point for your own automation projects or as a reference for best practices in Automation testing.

### GitHub Actions

You can find examples of **GitHub Actions** workflows for running tests in the `.github/workflows` folder.

### Kotlin
  - [kotlin-retrofit](https://github.com/romsper/qa-automation-bases/tree/kotlin-junit5-retrofit) - Kotlin | Retrofit | Selenide | JDBC | Exposed | JUnit 6 | Allure
  - [kotlin-playwright](https://github.com/romsper/qa-automation-base/tree/kotlin-junit5-playwright) - Kotlin | Playwright | JUnit 5 | Allure
  - [kotlin-appium](https://github.com/romsper/qa-automation-bases/tree/kotlin-junit5-appium) - Kotlin | Appium with Selenide | JUnit5 | Allure | Allure EE | TestRail
  - [kotlin-testng-rest-assured](https://github.com/romsper/qa-automation-bases/tree/kotlin-testng-rest-assured) - Kotlin | Rest-Assured | Selenide | TestNG | Allure

### TypeScript/JavaScript
  - [ts-playwright](https://github.com/romsper/qa-automation-bases/tree/typescript-playwright-allure) - TypeScript | Playwright | Axios | Allure
  - [js-mocha-chai](https://github.com/romsper/qa-automation-bases/tree/js-mocha-chai) - JS | Mocha | Chai | Allure
  
#### Frameworks 

[Kotlin](https://kotlinlang.org/docs/reference/) - modern programming language that makes developers happier. It is fully interoperable with Java and is officially supported for Android development.

[JUnit5](https://junit.org/junit5/docs/current/user-guide/) - one of the most popular testing frameworks for Java/Kotlin projects. You can also try [TestNG](https://testng.org/doc/) if you prefer it more.

[JUnit6](https://docs.junit.org/current/overview.html) - the next generation of JUnit. It aims to provide a more modern and flexible testing framework for Java/Kotlin projects.

[Selenide](https://selenide.org/) - powerful framework for UI testing. It is built on top of Selenium WebDriver and provides a simple and concise API for writing stable and maintainable UI tests.

[Playwright](https://playwright.dev) - modern framework for UI testing that supports multiple browsers and platforms. **Selenide** is more stable and comfortable, but Playwright is more modern and faster.

[Appium](https://appium.io/) - open-source framework for mobile application testing. It supports both Android and iOS platforms and allows you to write tests using various programming languages, including Kotlin.

[Retrofit](https://square.github.io/retrofit/) - type-safe HTTP client for Android and Java/Kotlin. It makes it easy to consume RESTful web services. It's much faster and easier than Rest-Assured. Also, you can try [Feign](https://github.com/OpenFeign/feign).

[Rest-Assured](https://rest-assured.io/) - popular Java/Kotlin library for testing RESTful web services. It provides a simple and intuitive API for making HTTP requests and validating responses. **Retrofit** is a better choice and more modern.

[Axios](https://axios-http.com/) - promise-based HTTP client for the browser and Node.js. It provides an easy-to-use API for making HTTP requests and handling responses. It's much more modern and better than **Playwright API** requests.

[Kotest](https://github.com/kotest/kotest) - powerful testing framework for Kotlin with a lot of useful features and integrations. You can use it as an alternative to [AssertJ](https://joel-costigliola.github.io/assertj/).

[Allure](https://allurereport.org) - flexible lightweight multi-language test report tool with the possibility to integrate with many popular CI services such as Jenkins, TeamCity, GitHub Actions, and others.

#### Notes

Almost all tests have `TAGS` annotation that allows you to run specific groups of tests. You can find more information about it in the [User Guide](https://docs.junit.org/current/writing-tests/tagging-and-filtering.html).

### Browsers for UI tests

Recommended to use **Docker** and **Docker-Compose** to run **Selenoid** and **Selenoid-UI** for UI tests.
- [Selenoid and Selenoid-UI](https://aerokube.com/selenoid/latest/#_quick_start) installation guide

### Allure Report

To view the **Allure** report after test execution you need to run the following command in the project root folder:
```bash
$ allure serve build/allure-results
```
or
```bash
$ allure serve build/allure-results --host localhost --port 9999
```

To generate the **Allure** report without starting a local server use:
```bash
$ allure generate build/allure-results
```
Then open the generated report from the `build/allure-report` folder and click `index.html`.

### Allure + Grafana

You can integrate **Allure** with **Grafana** in order to have a dashboard with historical test results.

#### How to use it for Grafana:
  - Generate **allure-report** by `$ allure generate allure-results`
  - Install **InfluxDB** (use **Docker**)
  - Get a file for **InfluxDB** in `/allure-report/export/influxDbData.txt`
  - Install **Grafana** (use **Docker**)
  - Integrate **InfluxDB** to **Grafana**
  - Send the report to **InfluxDB** by 
  - `$ curl -XPOST 'http://<host>/write?db=<db name>' --data-binary @allure-report/export/influxDbData.txt`
  - Check **Grafana** 
  - ***PROFIT***
