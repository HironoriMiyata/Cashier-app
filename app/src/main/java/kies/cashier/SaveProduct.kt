package kies.cashier


import io.realm.Realm

class  SaveProduct(){
    lateinit var realm: Realm
     fun saveProduct(productName:String,productValue: Int ) {
        realm = Realm.getDefaultInstance()

        realm.beginTransaction()
        //ここに追加や更新の入れる
         val product = realm.createObject(Product::class.java)
         product.productId = 1
         product.productName = productName
         product.productValue = productValue
         product.productCunt = 0
         realm.commitTransaction()
         realm.close()
    }
}