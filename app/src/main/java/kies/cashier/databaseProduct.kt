package kies.cashier

import kies.cashier.Model.DB.LoadProductName


lateinit var  oldProductList : List<String>

fun startDatabaseProduct():List<String>{
    val loadProdcutName = LoadProductName()
    var productNameList = mutableListOf<String>()
    oldProductList = loadProdcutName.loadProductNmae()
    oldProductList = productNameList
    productNameList.add("+")

    return oldProductList
}

