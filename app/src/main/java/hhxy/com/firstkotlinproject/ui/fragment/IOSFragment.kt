package hhxy.com.firstkotlinproject.ui.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import hhxy.com.firstkotlinproject.R
import hhxy.com.firstkotlinproject.bean.FuckGoods
import hhxy.com.firstkotlinproject.databinding.FragmentIosBinding
import hhxy.com.firstkotlinproject.di.component.FuckGoodsModule
import hhxy.com.firstkotlinproject.getMainComponent
import hhxy.com.firstkotlinproject.mvp.contract.FuckGoodsContract
import hhxy.com.firstkotlinproject.mvp.presenter.FuckGoodsPresenter
import hhxy.com.firstkotlinproject.ui.adapter.FuckGoodsAdapter
import javax.inject.Inject

/**
 * Created by Administrator on 2018/10/19.
 */
class IOSFragment : BaseBindingFragment<FragmentIosBinding>(), FuckGoodsContract.View {

    //    存储相关数据集合
    private var mList: ArrayList<FuckGoods> = ArrayList()
    private lateinit var mRecyclerView: RecyclerView

    //    创建presenter对象
    @Inject
    lateinit var mPresenter: FuckGoodsPresenter

    private var mPage: Int = 1

    override fun creatDataBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): FragmentIosBinding {
        return DataBindingUtil.inflate(inflater, R.layout.fragment_ios, container, false)
    }

    override fun initView() {
//        注入对象
        context.getMainComponent().plus(FuckGoodsModule(this)).inject(this)

        with(mBinding) {
            mRecyclerView = rvIosList
            rvIosList.layoutManager = LinearLayoutManager(context)
            rvIosList.adapter = FuckGoodsAdapter(mList, context)
            rvIosList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (!recyclerView?.canScrollVertically(1)!!) {
                        mPresenter.getData(++mPage, IOS)
                    }
                }
            })
        }

        mPresenter.getData(mPage, IOS)
    }

    override fun setData(results: List<FuckGoods>) {
        mList.addAll(results)
        mRecyclerView.adapter.notifyDataSetChanged()
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