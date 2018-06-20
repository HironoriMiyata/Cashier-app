package kies.cashier.Model.DataProcessing

import kies.cashier.Model.DB.LoadProductName

class ProductNameList(){
    lateinit var  oldProductList : List<String>

    fun startDatabaseProduct():MutableList<String>{
        val loadProdcutName = LoadProductName()
        var productNameList = mutableListOf<String>()
        oldProductList = loadProdcutName.loadProductNmae()
        oldProductList = productNameList
        productNameList.add("+")

        return productNameList
    }
}