package kies.cashier.Activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.*
import kies.cashier.Model.DB.LoadProductName
import kies.cashier.Model.DB.LoadProductPrice
import kies.cashier.Model.DataProcessing.ProductNameList
import kies.cashier.R


class CashierActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cashier)
        val kosuuEditText: EditText = findViewById(R.id.kosuu)
        kosuuEditText.requestFocus()

        val addEditText: EditText = findViewById(R.id.addprice)
        addEditText.requestFocus()
        val productName = LoadProductName()
        val productTextView: TextView = findViewById(R.id.pricetextview)
        val allProductTextView: TextView = findViewById(R.id.allpricetextview)
        var addMonmy = 0
        val monmyTextView: TextView = findViewById(R.id.azukari)
        val oturiTextView: TextView = findViewById(R.id.oturi)
        val moneyList: MutableList<String> = mutableListOf("1", "5", "10", "50", "100", "500", "1000", "2000", "5000", "10000")
        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, moneyList)
        val listView: ListView = findViewById(R.id.money)
        listView.adapter = arrayAdapter
        val productList: MutableList<String> = productName.loadProductName()
        val productArrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, productList)
        val productListView: ListView = findViewById(R.id.productlist)
        productListView.adapter = productArrayAdapter
        var sum = 0
        var all = sum
        var add = 0
        var kosuu = 1
        val loadProductPrice = LoadProductPrice()
        var productPrice = ""
        productListView.setOnItemClickListener { parent, view, position, id ->
            // 項目の TextView を取得
            val productItemTextView: TextView = view.findViewById(android.R.id.text1)

            productPrice = productItemTextView.getText().toString()
            addEditText.setText(Integer.toString(loadProductPrice.loadProductPrice(productPrice)))

        }
        val buttonAdd: Button = findViewById(R.id.add) as Button
        buttonAdd.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                try {
                    add = Integer.parseInt(addEditText.getText().toString())
                    kosuu = Integer.parseInt(kosuuEditText.getText().toString())
                } catch (e: NumberFormatException) {

                }
                sum = sum + add * kosuu
                productTextView.setText("合計" + Integer.toString(sum))
                all = sum
                allProductTextView.setText("売り上げ合計" + Integer.toString(all))
                kosuuEditText.setText("1")
                addEditText.setText("0")

            }
        })
        val buttonDelete: Button = findViewById(R.id.delete) as Button
        buttonDelete.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                add = Integer.parseInt(addEditText.getText().toString())
                kosuu = Integer.parseInt(kosuuEditText.getText().toString())
                sum = sum - add * kosuu
                productTextView.setText("合計" + Integer.toString(sum))
                all = sum
                allProductTextView.setText("売り上げ合計" + Integer.toString(all))
                kosuuEditText.setText("1")
                addEditText.setText("0")
            }
        })
        val resetDelete: Button = findViewById(R.id.reset) as Button
        resetDelete.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

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
        })



        listView.setOnItemClickListener { parent, view, position, id ->

            // 項目の TextView を取得
            val itemTextView: TextView = view.findViewById(android.R.id.text1)

            var getMonwy = Integer.parseInt(itemTextView.getText().toString())
            addMonmy = addMonmy + getMonwy
            monmyTextView.setText("預り金" + Integer.toString(addMonmy))
            oturiTextView.setText("お釣り" + Integer.toString(addMonmy - sum))
        }

    }


}