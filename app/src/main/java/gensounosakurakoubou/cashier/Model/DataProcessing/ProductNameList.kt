package gensounosakurakoubou.cashier.Model.DataProcessing

import gensounosakurakoubou.cashier.Model.DB.ProductDB.LoadProductName

class ProductNameList() {


    fun startDatabaseProduct(): MutableList<String> {
        val loadProdcutName = LoadProductName()
        var productNameList = loadProdcutName.loadProductName()

        productNameList.add("+")

        return productNameList
    }
}