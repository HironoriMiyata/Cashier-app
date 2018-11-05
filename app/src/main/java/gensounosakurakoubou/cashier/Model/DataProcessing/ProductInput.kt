package gensounosakurakoubou.cashier.Model.DataProcessing

import gensounosakurakoubou.cashier.Model.DB.ProductDB.SaveProduct

class ProductInput() {
    fun productInput(name: String, priceString: String) {
        val saveProduct = SaveProduct()
        val priceInt = Integer.parseInt(priceString)
        saveProduct.saveProduct(name, priceInt)
    }
}