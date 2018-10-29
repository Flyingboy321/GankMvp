package hhxy.com.firstkotlinproject.ui.activity

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import hhxy.com.firstkotlinproject.R
import hhxy.com.firstkotlinproject.databinding.ActivityImageBinding
import hhxy.com.firstkotlinproject.ui.glideconfit.GlideApp

/**
 * Created by Administrator on 2018/10/24.
 */
class ImageActivity : BaseBindingActivity<ActivityImageBinding>() {

    override fun createDataBinding(savedInstanceState: Bundle?): ActivityImageBinding {
        return DataBindingUtil.setContentView(this, R.layout.activity_image)
    }

    override fun initView() {
        var imgUrl = intent.getStringExtra(IMG)
        if (imgUrl != null) {
            GlideApp.with(this)
                    .load(imgUrl)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(mBinding.ivSource)
        }
        mBinding.ivSource.setOnClickListener { supportFinishAfterTransition() }
    }

    companion object {
        val IMG = "IMG"
        fun startActivity(context: Context, imageView: ImageView, url: String) {
            var intent = Intent(context, ImageActivity::class.java)
            intent.putExtra(IMG, url)
            if (Build.VERSION.SDK_INT > 21) {
                context.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(context as Activity, imageView, "img").toBundle())
            } else {
                context.startActivity(intent)
            }


        }
    }

}