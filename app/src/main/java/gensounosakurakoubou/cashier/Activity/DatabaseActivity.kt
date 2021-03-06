package gensounosakurakoubou.cashier.Activity


import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.*
import gensounosakurakoubou.cashier.Model.DB.ProductDB.ProductDelete
import gensounosakurakoubou.cashier.Model.DB.StartDatabase
import gensounosakurakoubou.cashier.Model.DataProcessing.ProductInput
import gensounosakurakoubou.cashier.Model.DataProcessing.ProductNameList
import gensounosakurakoubou.cashier.R


class DatabaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_databass)
        StartDatabase()
        val inflater = this.layoutInflater.inflate(R.layout.dialog_signin, null, false)
        val productInput = ProductInput()
        val productDelete = ProductDelete()
        val dialogEditText: EditText = inflater.findViewById(R.id.product)
        dialogEditText.requestFocus()
        val dialogEditText2: EditText = inflater.findViewById(R.id.price)
        val dialogEditText3: EditText = inflater.findViewById(R.id.cost)
        val productNameList = ProductNameList()
        val prodcutList = productNameList.startDatabaseProduct()
        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, prodcutList)
        val listView: ListView = findViewById(R.id.listView)
        listView.adapter = arrayAdapter

        //追加した情報にNEWを表示させることで使いやすく
        val dialog = AlertDialog.Builder(this).apply {
            setTitle("商品情報の追加")
            setMessage("商品情報を入力してください")
            setView(inflater)
            setPositiveButton("OK", DialogInterface.OnClickListener { _, _ ->
                Toast.makeText(context, "追加しました", Toast.LENGTH_LONG).show()
                arrayAdapter.insert("New  " + dialogEditText.text, arrayAdapter.count - 1)
                productInput.productInput(dialogEditText.text.toString(), dialogEditText2.text.toString(), dialogEditText3.text.toString())
                arrayAdapter.notifyDataSetChanged()
            })
            setNegativeButton("Cancel", null)
        }.create()

        // 項目をタップしたときの処理
        listView.setOnItemClickListener { parent, view, position, id ->
            val itemTextView: TextView = view.findViewById(android.R.id.text1)
            Log.i("debug", itemTextView.text.toString())
            if (position == arrayAdapter.count - 1) {
                dialog.show()
                dialogEditText.setText("")
                dialogEditText2.setText("")
                dialogEditText3.setText("")
            }

        }

        // 項目を長押ししたときの処理
        listView.setOnItemLongClickListener { parent, view, position, id ->

            // 一番下の項目以外は長押しで削除 ＋の項目が入ってるため
            if (position == arrayAdapter.count - 1) {
                return@setOnItemLongClickListener false
            }
            AlertDialog.Builder(this).apply {
                setTitle("削除の確認")
                setMessage("本当に削除をしてもいいですか？")
                setPositiveButton("OK", DialogInterface.OnClickListener { _, _ ->
                    Toast.makeText(context, "削除しました", Toast.LENGTH_LONG).show()
                    productDelete.productDelete(arrayAdapter.getItem(position).toString())
                    arrayAdapter.remove(arrayAdapter.getItem(position))
                    arrayAdapter.notifyDataSetChanged()
                })
                setNegativeButton("Cancel", null)
                show()
            }
            return@setOnItemLongClickListener true
        }

    }


}