package kies.cashier.Model.DB

import io.realm.Realm




class  LoadProductID(){
    lateinit var realm: Realm
    fun  loadProductID():List<Int>{
        realm = Realm.getDefaultInstance()

        val  productID = realm.where(Product::class.java).findAll()
        var idList = mutableListOf<Int>()
        for (id in productID){
            idList.add(id.productId)
        }
        realm.close()
        idList.sorted()
        return idList
    }

    fun findLoadProductID():Int{
        var id = 0
        var productID  = loadProductID()


        try {
            while (id == productID[id]){
                id++
            }
        } catch (e:IndexOutOfBoundsException ){
            return id
        }


        return id
    }
}
