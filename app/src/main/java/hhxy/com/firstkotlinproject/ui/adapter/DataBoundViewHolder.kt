package hhxy.com.firstkotlinproject.ui.adapter

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by Administrator on 2018/10/22.
 * 抽取基类viewholder
 */
class DataBoundViewHolder<T : ViewDataBinding>(val mbinding: T) : RecyclerView.ViewHolder(mbinding.root) {

}