package com.example.warungku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.warungku.data.AppDatabase
import com.example.warungku.data.entity.User

class EditorActivity : AppCompatActivity() {
    private lateinit var productCode : EditText
    private lateinit var productName : EditText
    private lateinit var price : EditText
    private lateinit var stock : EditText
    private lateinit var btnSave: Button
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)
        productCode = findViewById(R.id.product_code)
        productName = findViewById(R.id.product_name)
        price = findViewById(R.id.price)
        stock = findViewById(R.id.stock)
        btnSave = findViewById(R.id.btn_save)

        database = AppDatabase.getInstance(applicationContext)

        val intent = intent.extras
        if (intent!=null){
            val id = intent.getInt("id", 0)
            val user = database.userDao().get(id)

            productCode.setText(user.productCode)
            productName.setText(user.productName)
            price.setText(user.price)
            stock.setText(user.stock)

        }

        btnSave.setOnClickListener {
            if (productCode.text.isNotEmpty() && productName.text.isNotEmpty() && price.text.isNotEmpty() && stock.text.isNotEmpty()){
                if (intent!=null){
                    // coding edit data
                    database.userDao().update(
                        User(
                            intent.getInt("id", 0),
                            productCode.text.toString(),
                            productName.text.toString(),
                            price.text.toString(),
                            stock.text.toString()
                        )

                    )
                } else {
                    // coding tambah data
                    database.userDao().insertAll(
                        User(
                            null,
                            productCode.text.toString(),
                            productName.text.toString(),
                            price.text.toString(),
                            stock.text.toString()
                        )
                    )
                }
                finish()
            } else {
                Toast.makeText(applicationContext, "Silahkan isi semua data dengan valid", Toast.LENGTH_SHORT).show()
            }
        }
    }
}