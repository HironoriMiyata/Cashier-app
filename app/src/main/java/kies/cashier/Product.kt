package kies.cashier

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

open class Product() : RealmObject() {

    @PrimaryKey
     var productId: Int = 0
    @Required
     var productName: String = ""
     var productValue: Int = 0
    var productCunt :Int = 0
}