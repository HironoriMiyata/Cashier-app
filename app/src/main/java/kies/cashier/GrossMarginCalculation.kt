package kies.cashier


    fun grossMargin(sales : Int,materialCost : Int): Int {
        val gross = sales - materialCost
        return gross
    }
