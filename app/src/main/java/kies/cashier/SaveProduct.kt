package kies.cashier

import android.app.Application
import io.realm.Realm

class  SaveProduct(){
    lateinit var realm: Realm
     fun saveProduct() {
        realm = Realm.getDefaultInstance()

        realm.beginTransaction()
        //ここに追加や更新の入れる
        
        realm.commitTransaction()
    }
}