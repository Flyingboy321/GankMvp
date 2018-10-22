package hhxy.com.firstkotlinproject.ui.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import hhxy.com.firstkotlinproject.bean.FuckGoods
import hhxy.com.firstkotlinproject.databinding.ItemFuckgoodsBinding
import hhxy.com.firstkotlinproject.ui.glideconfit.GlideApp

/**
 * Created by Administrator on 2018/10/22.
 */
class FuckGoodsAdapter(private val mList: List<FuckGoods>, private val context: Context) : BaseBindingAdapter<ItemFuckgoodsBinding>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): DataBoundViewHolder<ItemFuckgoodsBinding> {
        return DataBoundViewHolder(ItemFuckgoodsBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: DataBoundViewHolder<ItemFuckgoodsBinding>, position: Int) {
        super.onBindViewHolder(holder, position)
        with(holder.mbinding) {
            mList[position]
            tvTitle.text = mList[position].desc
            tvCreater.text = mList[position].who
            tvCreatTime.text = mList[position].createTime()
            if (mList[position].hasImg()) {
                GlideApp.with(context).load(mList[position].images[0]).transition(DrawableTransitionOptions.withCrossFade()).into(ivSource)
            }

        }

    }

    override fun getItemCount(): Int {
        return mList.size
    }

}