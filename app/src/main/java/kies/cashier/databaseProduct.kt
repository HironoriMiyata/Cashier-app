package kies.cashier



lateinit var  oldProductList : MutableList<String>

fun startDatabaseProduct():MutableList<String>{
    oldProductList = mutableListOf()
    //val read =  ReadProdcut()
    //oldProductList =  read.readProduct("product")

    oldProductList.add("+")

    return oldProductList
}

