package gensounosakurakoubou.cashier.Model.DB.ProductDB

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

open class Product : RealmObject() {

    @PrimaryKey
    var productId: Int = 0
    @Required
    var productName: String = ""
    var productPrice: Int = 0
    var productCount: Int = 0
    var productCost:Int = 0
}
