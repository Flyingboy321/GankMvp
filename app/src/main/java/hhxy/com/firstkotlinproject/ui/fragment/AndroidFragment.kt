package hhxy.com.firstkotlinproject.ui.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import hhxy.com.firstkotlinproject.R
import hhxy.com.firstkotlinproject.databinding.FragmentViewRecyclerBinding

/**
 * Created by Administrator on 2018/10/19.
 */
class AndroidFragment : BaseBindingFragment<FragmentViewRecyclerBinding>() {


    /**
     * 创建databinding对象
     * */
    override fun creatDataBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): FragmentViewRecyclerBinding {
        return DataBindingUtil.inflate(inflater, R.layout.fragment_view_recycler, container, false)
    }

    override fun initView() {

    }

    companion object {
        /**
         * 获取fragment对象
         * */
        val ANDROID = "ANDROID"

        fun newInstance(): AndroidFragment {
            val fragment = AndroidFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment

        }
    }

}