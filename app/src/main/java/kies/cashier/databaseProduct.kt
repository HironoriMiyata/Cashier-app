package kies.cashier



lateinit var  oldProductList : MutableList<String>

fun startDatabaseProduct():MutableList<String>{
    oldProductList = mutableListOf()
    oldProductList.add("+")

    return oldProductList
}

