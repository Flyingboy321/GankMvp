package hhxy.com.firstkotlinproject.ui.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import hhxy.com.firstkotlinproject.R
import hhxy.com.firstkotlinproject.databinding.FragmentGirlBinding

/**
 * Created by Administrator on 2018/10/19.
 */
class GirlFragment : BaseBindingFragment<FragmentGirlBinding>() {
    override fun creatDataBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): FragmentGirlBinding {
        return DataBindingUtil.inflate(inflater, R.layout.fragment_girl, container, false)
    }

    override fun initView() {
    }

    companion object {
        val Girl = "Girl"
        fun newInstance(): GirlFragment {
            val fragment = GirlFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }
}