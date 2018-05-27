package kies.cashier

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_cashier.*

class CashierActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cashier)
        val kosuuEditText : EditText = findViewById(R.id.kosuu)
        kosuuEditText.requestFocus()

        val addEditText : EditText = findViewById(R.id.addprice)
        addEditText.requestFocus()

        val productTextView:TextView = findViewById(R.id.pricetextview)
        val allProductTextView:TextView = findViewById(R.id.allpricetextview)

        var sum = 0
        var all = sum
        var add =0
        var kosuu = 1
        val buttonAdd: Button = findViewById(R.id.add) as Button
        buttonAdd.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                add = Integer.parseInt(addEditText.getText().toString())
                kosuu = Integer.parseInt(kosuuEditText.getText().toString())
                sum = sum + add * kosuu
                productTextView.setText(Integer.toString(sum))
                all = sum
                allProductTextView.setText(Integer.toString(all))
                kosuuEditText.setText("1")
                addEditText.setText("")

            }
        })
        val buttonDelete: Button = findViewById(R.id.delete) as Button
        buttonDelete.setOnClickListener(object:View.OnClickListener {
            override fun onClick(v: View?) {
                add = Integer.parseInt(addEditText.getText().toString())
                kosuu = Integer.parseInt(kosuuEditText.getText().toString())
                sum = sum - add * kosuu
                productTextView.setText(Integer.toString(sum))
                all = sum
                allProductTextView.setText(Integer.toString(all))
                kosuuEditText.setText("1")
                addEditText.setText("")
            }
        })

    }
}