package hhxy.com.firstkotlinproject.ui.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import hhxy.com.firstkotlinproject.R
import hhxy.com.firstkotlinproject.databinding.FragmentAboutBinding
import kotlinx.android.synthetic.main.fragment_about.*

/**
 * Created by Administrator on 2018/10/19.
 */
class AboutFragment : BaseBindingFragment<FragmentAboutBinding>() {

    override fun creatDataBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): FragmentAboutBinding {
        return DataBindingUtil.inflate(inflater, R.layout.fragment_about, container, false)
    }

    override fun initView() {
        val text = "Kotlin\n"
                .plus("Dagger2\n")
                .plus("Rxjava2\n")
                .plus("Retrofit\n")
                .plus("Glide4.3\n")
                .plus("DataBinding\n")
                .plus("Gson\n")

        with(mBinding) {
            tvThank.text = text
        }
    }

    companion object {
        val About = "About"
        fun newInstance(): AboutFragment {
            val fragment = AboutFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

}