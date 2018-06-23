package kies.cashier.Model.DB


import io.realm.Realm

class SaveProduct() {
    lateinit var realm: Realm
    fun saveProduct(productName: String, productPrice: Int) {
        val loadId = LoadProductID()
        realm = Realm.getDefaultInstance()
        var id = loadId.findLoadProductID()
        realm.beginTransaction()
        //ここに追加や更新の入れる
        val product = realm.createObject(Product::class.java, id)

        product.productName = productName
        product.productPrice = productPrice
        product.productCunt = 0
        realm.commitTransaction()
        realm.close()
    }
}