package kies.cashier

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

open class Product(): RealmObject(){

    @PrimaryKey
    open var productId:Int? = null
    @Required
    open var productnName:String = ""
    open var productValue:Int = 0
}
