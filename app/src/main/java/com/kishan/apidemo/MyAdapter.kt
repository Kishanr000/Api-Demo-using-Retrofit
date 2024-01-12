package com.kishan.apidemo

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kishan.apidemo.apimodel.Quote

class MyAdapter(val context: Activity, val quotesarraylist : List<Quote>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var quotes : TextView
        var author : TextView

        init {
            quotes = itemView.findViewById(R.id.txtQuotes)
            author = itemView.findViewById(R.id.txtAuthor)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.cardview, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return quotesarraylist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var currentItem = quotesarraylist[position]
        holder.quotes.text = currentItem.quote
        holder.author.text = currentItem.author
    }
}