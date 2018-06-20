package kies.cashier.Model.DB

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class StartDatabase: Application() {

    override fun onCreate() {
        super.onCreate()

        //Realmの初期化
        Realm.init(this)
    }

}