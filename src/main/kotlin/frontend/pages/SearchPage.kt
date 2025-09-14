package org.example.pages.simpleWine

import io.qameta.allure.Step
import frontend.elements.list.ProductItemHelper
import frontend.elements.list.CatalogItemObject

class SearchPage {
    private val productItemHelper get() = ProductItemHelper()

    @Step("Get product items")
    fun getProductItems(): List<CatalogItemObject> {
        return productItemHelper.getProductItems()
    }

}