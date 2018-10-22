package hhxy.com.firstkotlinproject.ui.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import hhxy.com.firstkotlinproject.R
import hhxy.com.firstkotlinproject.bean.FuckGoods
import hhxy.com.firstkotlinproject.databinding.FragmentViewRecyclerBinding
import hhxy.com.firstkotlinproject.di.component.FuckGoodsModule
import hhxy.com.firstkotlinproject.getMainComponent
import hhxy.com.firstkotlinproject.mvp.contract.FuckGoodsContract
import hhxy.com.firstkotlinproject.mvp.presenter.FuckGoodsPresenter
import kotlinx.android.synthetic.main.fragment_view_recycler.*
import javax.inject.Inject

/**
 * Created by Administrator on 2018/10/19.
 */
class AndroidFragment : BaseBindingFragment<FragmentViewRecyclerBinding>(), FuckGoodsContract.View {


    //    出入presenter对象，这里通过构造方法注入
    @Inject
    lateinit var mPresenter: FuckGoodsPresenter
    private var mList = ArrayList<FuckGoods>()

    /**
     * 创建databinding对象
     * */
    override fun creatDataBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): FragmentViewRecyclerBinding {
        return DataBindingUtil.inflate(inflater, R.layout.fragment_view_recycler, container, false)
    }

    override fun initView() {
        context.getMainComponent().plus(FuckGoodsModule(this)).inject(this)

    }

    override fun setData(results: List<FuckGoods>) {

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