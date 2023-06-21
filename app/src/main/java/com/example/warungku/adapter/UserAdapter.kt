package com.example.warungku.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.warungku.R
import com.example.warungku.data.entity.User

class UserAdapter(var list: List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    private lateinit var dialog: Dialog

    fun setDialog(dialog: Dialog){
        this.dialog = dialog
    }

    interface Dialog {
        fun onClick(position: Int)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var productCode: TextView
        var productName: TextView
        var price: TextView
        var stock: TextView

        init {
            productCode = view.findViewById(R.id.product_code)
            productName = view.findViewById(R.id.product_name)
            price = view.findViewById(R.id.price)
            stock = view.findViewById(R.id.stock)
            view.setOnClickListener{
                dialog.onClick(layoutPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_user, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.productCode.text = list[position].productCode
        holder.productName.text = list[position].productName
        holder.price.text = list[position].price
        holder.stock.text = list[position].stock
    }


}