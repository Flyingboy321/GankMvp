package hhxy.com.firstkotlinproject.ui.adapter

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

/**
 * Created by Administrator on 2018/10/22.
 */
abstract class BaseBindingAdapter<T : ViewDataBinding> : RecyclerView.Adapter<DataBoundViewHolder<T>>() {


    lateinit var mListener: OnItemClickListener
    override fun onBindViewHolder(holder: DataBoundViewHolder<T>, position: Int) {
        holder.mbinding.root.setOnClickListener { v -> mListener!!.itemClick(v, position) }
    }

    interface OnItemClickListener {
        fun itemClick(view: View, position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.mListener = listener
    }
}