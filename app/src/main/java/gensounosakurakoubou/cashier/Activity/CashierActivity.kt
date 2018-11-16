package gensounosakurakoubou.cashier.Activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.*
import gensounosakurakoubou.cashier.Model.DB.ProductDB.LoadProductName
import gensounosakurakoubou.cashier.Model.DB.ProductDB.LoadProductPrice
import gensounosakurakoubou.cashier.Model.DB.ProductDB.RenewalProductCount
import gensounosakurakoubou.cashier.Model.DB.StartDatabase
import gensounosakurakoubou.cashier.Model.DataProcessing.Cost
import gensounosakurakoubou.cashier.Model.DataProcessing.Seles
import gensounosakurakoubou.cashier.R

var sum = 0
var all = sum
var add = 0
var kosuu = 1
var addMonmy = 0
var moneyList: MutableList<String> = mutableListOf("10000", "5000", "1000", "500", "100", "50", "10", "5", "1")
var productPrice = "Noitem"


class CashierActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cashier)
        val kosuuEditText: EditText = findViewById(R.id.kosuu)
        kosuuEditText.requestFocus()
        val addEditText: EditText = findViewById(R.id.addprice)
        addEditText.requestFocus()
        val productName = LoadProductName()
        val monmyTextView: TextView = findViewById(R.id.azukari)
        val oturiTextView: TextView = findViewById(R.id.oturi)
        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, moneyList)
        val listView: ListView = findViewById(R.id.money)
        listView.adapter = arrayAdapter
        val productList: MutableList<String> = productName.loadProductName()
        val productArrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, productList)
        val productListView: ListView = findViewById(R.id.productlist)
        productListView.adapter = productArrayAdapter
        val loadProductPrice = LoadProductPrice()
        StartDatabase()

        productListView.setOnItemClickListener { parent, view, position, id ->
            val productItemTextView: TextView = view.findViewById(android.R.id.text1)
            productPrice = productItemTextView.getText().toString()
            addEditText.setText(Integer.toString(loadProductPrice.loadProductPrice(productPrice)))

        }
        val buttonAdd: Button = findViewById(R.id.add) as Button
        buttonAdd.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                addOnClickEvent(v)
            }
        })
        val buttonDelete: Button = findViewById(R.id.delete) as Button
        buttonDelete.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                deleteOnClickEvent(v)
            }
        })
        val resetDelete: Button = findViewById(R.id.reset) as Button
        resetDelete.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                resetDeleteOnClickEvent(v)
            }
        })
        listView.setOnItemClickListener { parent, view, position, id ->
            val itemTextView: TextView = view.findViewById(android.R.id.text1)
            var getMonwy = Integer.parseInt(itemTextView.getText().toString())
            addMonmy = addMonmy + getMonwy
            monmyTextView.setText("預り金" + Integer.toString(addMonmy))
            oturiTextView.setText("お釣り" + Integer.toString(addMonmy - sum))
        }

    }

    private fun addOnClickEvent(v: View?) {
        val addEditText: EditText = findViewById(R.id.addprice)
        val kosuuEditText: EditText = findViewById(R.id.kosuu)
        val productTextView: TextView = findViewById(R.id.pricetextview)
        val allProductTextView: TextView = findViewById(R.id.allpricetextview)
        val renewalProductCount = RenewalProductCount()
        val addcost = Cost()
        val addSeles = Seles()

        try {
            add = Integer.parseInt(addEditText.getText().toString())
            kosuu = Integer.parseInt(kosuuEditText.getText().toString())
        } catch (e: NumberFormatException) {

        }
        sum += addSeles.addSeles(productPrice, kosuu)
        addcost.addCost(productPrice, kosuu)//コストになってる

        if (productPrice != "Noitem") {
            renewalProductCount.renewalProductCount(productPrice, kosuu)
        }
        productTextView.setText("合計" + Integer.toString(sum))
        all = sum
        allProductTextView.setText("売り上げ合計" + Integer.toString(all))
        kosuuEditText.setText("1")
        addEditText.setText("0")
        productPrice = "Noitem"
    }

    private fun deleteOnClickEvent(v: View?) {
        val addEditText: EditText = findViewById(R.id.addprice)
        val kosuuEditText: EditText = findViewById(R.id.kosuu)
        val productTextView: TextView = findViewById(R.id.pricetextview)
        val allProductTextView: TextView = findViewById(R.id.allpricetextview)
        val subtractionCost = Cost()
        val subtractionSeles = Seles()
        add = Integer.parseInt(addEditText.getText().toString())
        kosuu = Integer.parseInt(kosuuEditText.getText().toString())
        sum = subtractionSeles.subtractionSeles(productPrice, kosuu)
        subtractionCost.subtractionCost(productPrice, kosuu)
        productTextView.setText("合計" + Integer.toString(sum))
        all = sum
        allProductTextView.setText("売り上げ合計" + Integer.toString(all))
        kosuuEditText.setText("1")
        addEditText.setText("0")
    }

    private fun resetDeleteOnClickEvent(v: View?) {
        val addEditText: EditText = findViewById(R.id.addprice)
        val kosuuEditText: EditText = findViewById(R.id.kosuu)
        val productTextView: TextView = findViewById(R.id.pricetextview)
        val allProductTextView: TextView = findViewById(R.id.allpricetextview)
        val monmyTextView: TextView = findViewById(R.id.azukari)
        val oturiTextView: TextView = findViewById(R.id.oturi)
        kosuu = Integer.parseInt(kosuuEditText.getText().toString())
        sum = 0
        addMonmy = 0
        productTextView.setText("合計" + Integer.toString(sum))
        allProductTextView.setText("売り上げ合計" + Integer.toString(all))
        monmyTextView.setText("預り金" + Integer.toString(addMonmy))
        oturiTextView.setText("お釣り" + Integer.toString(addMonmy - sum))
        kosuuEditText.setText("1")
        addEditText.setText("0")
    }
}