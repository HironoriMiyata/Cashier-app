package gensounosakurakoubou.cashier.Model.DB.AccountingDB


import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import java.util.*


open class Accounting: RealmObject(){
    @PrimaryKey
    var accountingId: Int = 0
   /* @Required
    var accountingDay: Calendar? = null
    var cost: Int = 0
    var sales: Int = 0
*/
}