package kies.cashier.Model.DataProcessing

import kies.cashier.Model.DB.LoadProductName

class ProductNameList(){


    fun startDatabaseProduct():MutableList<String>{
        val loadProdcutName = LoadProductName()
        var productNameList:MutableList<String> = loadProdcutName.loadProductNmae()

        productNameList.add("+")

        return productNameList
    }
}