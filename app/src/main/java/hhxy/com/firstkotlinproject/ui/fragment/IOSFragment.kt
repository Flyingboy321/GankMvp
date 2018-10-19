package hhxy.com.firstkotlinproject.ui.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import hhxy.com.firstkotlinproject.R
import hhxy.com.firstkotlinproject.databinding.FragmentIosBinding

/**
 * Created by Administrator on 2018/10/19.
 */
class IOSFragment : BaseBindingFragment<FragmentIosBinding>() {

    override fun creatDataBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): FragmentIosBinding {
        return DataBindingUtil.inflate(inflater, R.layout.fragment_ios, container, false)
    }

    override fun initView() {

    }

    companion object {
        /**
         * 获取fragment对象
         * */
        val IOS = "IOS"

        fun newInstance(): IOSFragment {
            val fragment = IOSFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }


    }

}