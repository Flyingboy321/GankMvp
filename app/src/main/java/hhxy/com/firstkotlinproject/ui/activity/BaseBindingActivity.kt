package hhxy.com.firstkotlinproject.ui.activity

import android.databinding.ViewDataBinding
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import hhxy.com.firstkotlinproject.R

/**
 * Created by Administrator on 2018/10/12.
 */
abstract class BaseBindingActivity<B : ViewDataBinding> : AppCompatActivity() {

    lateinit var mBinding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = createDataBinding(savedInstanceState)
        initView()
    }

    abstract fun initView()


    //    创建binding对象
    abstract fun createDataBinding(savedInstanceState: Bundle?): B

    //    设置toolbar
    fun setupToolbar(toolbar: Toolbar) {
        toolbar.title = ""
        toolbar.setNavigationIcon(R.mipmap.ic_launcher)
    }

    //    设置菜单栏返回监听
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}