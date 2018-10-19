package hhxy.com.firstkotlinproject.ui.fragment

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Administrator on 2018/10/19.
 * 抽取基类fragment
 */
abstract class BaseBindingFragment<B : ViewDataBinding> : Fragment() {
    lateinit var mBinding: B
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = creatDataBinding(inflater, container, savedInstanceState)
        initView()
        return mBinding.root
    }

    /**
     * 暴露创建databinding方法
     *
     * */
    abstract fun creatDataBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): B

    abstract fun initView()

}