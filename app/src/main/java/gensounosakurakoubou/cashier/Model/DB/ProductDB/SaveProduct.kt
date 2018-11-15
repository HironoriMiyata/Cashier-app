package gensounosakurakoubou.cashier.Model.DB.ProductDB


import gensounosakurakoubou.cashier.Model.DB.Product
import io.realm.Realm

class SaveProduct {
    lateinit var realm: Realm
    fun saveProduct(productName: String, productPrice: Int,cost:Int) {
        val loadId = LoadProductID()
        realm = Realm.getDefaultInstance()
        val id = loadId.findLoadProductID()
        realm.beginTransaction()
        val product = realm.createObject(Product::class.java, id)
        //カウントは計算で使うので最初は０にすること
        product.productName = productName
        product.productPrice = productPrice
        product.productCount = 0
        product.productCost= cost
        realm.commitTransaction()
        realm.close()
    }
}