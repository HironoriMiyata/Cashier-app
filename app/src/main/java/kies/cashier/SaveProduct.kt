package kies.cashier


import io.realm.Realm

class  SaveProduct(){
    lateinit var realm: Realm
     fun saveProduct(productName:String,productValue: Int ) {
        realm = Realm.getDefaultInstance()
        var id = 0
        realm.beginTransaction()
        //ここに追加や更新の入れる
         val product = realm.createObject(Product::class.java,id)
         product.productName = productName
         product.productValue = productValue
         product.productCunt = 0
         realm.commitTransaction()
         realm.close()
    }
}