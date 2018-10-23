package hhxy.com.firstkotlinproject.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import hhxy.com.firstkotlinproject.bean.FuckGoods
import hhxy.com.firstkotlinproject.databinding.ItemGirlBinding
import hhxy.com.firstkotlinproject.ui.glideconfit.GlideApp

/**
 * Created by Administrator on 2018/10/23.
 */
class GirlAdapter(val context: Context, val mList: ArrayList<FuckGoods>) : BaseBindingAdapter<ItemGirlBinding>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): DataBoundViewHolder<ItemGirlBinding> {
        return DataBoundViewHolder(ItemGirlBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: DataBoundViewHolder<ItemGirlBinding>, position: Int) {
        super.onBindViewHolder(holder, position)
        var fuckGoods = mList[position]
        var url = fuckGoods.url

        with(holder.mbinding) {
            if (url != null) {
                GlideApp.with(context)
                        .load(url)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(ivSource)
            }
        }
    }
}