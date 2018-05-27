package kies.cashier



lateinit var  oldProductList : MutableList<String>

fun startDatabaseProduct():MutableList<String>{
    oldProductList = mutableListOf()

   var addName:String = "Nw"
    oldProductList.add(addName)
    oldProductList.add("+")

    return oldProductList
}

