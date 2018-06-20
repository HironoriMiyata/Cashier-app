package kies.cashier

import kies.cashier.Model.DB.LoadProductName


lateinit var  oldProductList : List<String>

fun startDatabaseProduct():MutableList<String>{
    val loadProdcutName = LoadProductName()
    var productNameList = mutableListOf<String>()
    oldProductList = loadProdcutName.loadProductNmae()
    oldProductList = productNameList
    productNameList.add("+")

    return productNameList
}

