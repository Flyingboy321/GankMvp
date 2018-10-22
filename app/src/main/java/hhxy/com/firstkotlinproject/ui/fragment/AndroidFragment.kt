package hhxy.com.firstkotlinproject.ui.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import hhxy.com.firstkotlinproject.R
import hhxy.com.firstkotlinproject.bean.FuckGoods
import hhxy.com.firstkotlinproject.databinding.FragmentViewRecyclerBinding
import hhxy.com.firstkotlinproject.di.component.FuckGoodsModule
import hhxy.com.firstkotlinproject.getMainComponent
import hhxy.com.firstkotlinproject.mvp.contract.FuckGoodsContract
import hhxy.com.firstkotlinproject.mvp.presenter.FuckGoodsPresenter
import hhxy.com.firstkotlinproject.toast
import hhxy.com.firstkotlinproject.ui.adapter.BaseBindingAdapter
import hhxy.com.firstkotlinproject.ui.adapter.FuckGoodsAdapter
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
    //    记录当前页数
    private var mPage = 1


    //    创建adapter引用
    lateinit var mAdapter: FuckGoodsAdapter

    /**
     * 创建databinding对象
     * */
    override fun creatDataBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): FragmentViewRecyclerBinding {
        return DataBindingUtil.inflate(inflater, R.layout.fragment_view_recycler, container, false)
    }

    override fun initView() {

        mAdapter = FuckGoodsAdapter(mList, activity)
        context.getMainComponent().plus(FuckGoodsModule(this)).inject(this)

        with(mBinding) {
            rvAndroidList.adapter = mAdapter
            rvAndroidList.layoutManager = LinearLayoutManager(context)
            rvAndroidList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (!recyclerView?.canScrollVertically(1)!!) {
                        mPresenter.getData(++mPage, ANDROID)
                    }

                }
            })

        }

        mPresenter.getData(mPage, ANDROID)
        mAdapter.setOnItemClickListener(object : BaseBindingAdapter.OnItemClickListener {
            override fun itemClick(view: View, position: Int) {
                context.toast("条目点击了$position")
            }

        })

    }

    //    view层获取数据刷新
    override fun setData(results: List<FuckGoods>) {
        Log.e("okhttp", "fragmentandroid获取到数据")
        mList.addAll(results)
        mAdapter.notifyDataSetChanged()

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