package gensounosakurakoubou.cashier.Model.DB.ProductDB


import io.realm.Realm

class SaveProduct {
    lateinit var realm: Realm
    fun saveProduct(productName: String, productPrice: Int,cost:Int) {
        val loadId = LoadProductID()
        realm = Realm.getDefaultInstance()
        var id = loadId.findLoadProductID()
        realm.beginTransaction()
        //ここに追加や更新の入れる
        val product = realm.createObject(Product::class.java, id)

        product.productName = productName
        product.productPrice = productPrice
        product.productCount = 0
        product.productCost= cost
        realm.commitTransaction()
        realm.close()
    }
}