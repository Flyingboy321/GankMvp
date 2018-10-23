package hhxy.com.firstkotlinproject.ui.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import hhxy.com.firstkotlinproject.R
import hhxy.com.firstkotlinproject.bean.FuckGoods
import hhxy.com.firstkotlinproject.databinding.FragmentGirlBinding
import hhxy.com.firstkotlinproject.di.component.FuckGoodsModule
import hhxy.com.firstkotlinproject.getMainComponent
import hhxy.com.firstkotlinproject.mvp.contract.FuckGoodsContract
import hhxy.com.firstkotlinproject.mvp.presenter.FuckGoodsPresenter
import hhxy.com.firstkotlinproject.ui.adapter.GirlAdapter
import javax.inject.Inject

/**
 * Created by Administrator on 2018/10/19.
 */
class GirlFragment : BaseBindingFragment<FragmentGirlBinding>(), FuckGoodsContract.View {


    //  创建数据展示集合
    private var mList: ArrayList<FuckGoods> = ArrayList()
    private lateinit var mRecyclerview: RecyclerView
    private var mPage = 1

    //    创建presenter
    @Inject
    lateinit var mPresenter: FuckGoodsPresenter

    override fun creatDataBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): FragmentGirlBinding {
        return DataBindingUtil.inflate(inflater, R.layout.fragment_girl, container, false)
    }

    override fun initView() {
        context.getMainComponent().plus(FuckGoodsModule(this)).inject(this)
        with(mBinding) {
            mRecyclerview = rvGirlList
            rvGirlList.layoutManager = GridLayoutManager(context, 2)
            rvGirlList.adapter = GirlAdapter(context, mList)
            rvGirlList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

                    if (!recyclerView?.canScrollVertically(1)!!) {
                        mPresenter.getData(++mPage, Girl)
                    }
                }
            })
            mPresenter.getData(mPage, Girl)
        }
    }

    //    view层获取到数据回调
    override fun setData(results: List<FuckGoods>) {
        mList.addAll(results)
        mRecyclerview.adapter.notifyDataSetChanged()

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