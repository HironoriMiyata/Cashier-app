package gensounosakurakoubou.cashier.Model.DataProcessing

import gensounosakurakoubou.cashier.Model.DB.ProductDB.SaveProduct

class ProductInput {
    fun productInput(name: String, priceString: String,cost:String) {
        val saveProduct = SaveProduct()
        val priceInt = Integer.parseInt(priceString)
        val costInt = Integer.parseInt(cost)
        saveProduct.saveProduct(name, priceInt,costInt)
    }
}