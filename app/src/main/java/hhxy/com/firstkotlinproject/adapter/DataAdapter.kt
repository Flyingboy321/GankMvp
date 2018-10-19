package hhxy.com.firstkotlinproject.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import hhxy.com.firstkotlinproject.R
import hhxy.com.firstkotlinproject.adapter.DataAdapter.MyViewHolder

/**
 * Created by Administrator on 2018/7/31.
 */
class DataAdapter(var context: Context, var items: MutableList<String>) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        var inflate = LayoutInflater.from(context).inflate(R.layout.item_adapter, parent, false) as TextView
        return MyViewHolder(inflate)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var data = items[position]
        var textView = holder.itemView as TextView
        textView.text = data

    }

    class MyViewHolder(textview: TextView) : RecyclerView.ViewHolder(textview)


}