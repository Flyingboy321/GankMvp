package hhxy.com.firstkotlinproject.ui.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import hhxy.com.firstkotlinproject.R
import hhxy.com.firstkotlinproject.bean.FuckGoods
import hhxy.com.firstkotlinproject.databinding.ActivityMainBinding
import hhxy.com.firstkotlinproject.di.component.RandomModule
import hhxy.com.firstkotlinproject.getMainComponent
import hhxy.com.firstkotlinproject.mvp.contract.RandomContract
import hhxy.com.firstkotlinproject.mvp.presenter.RandomPresenter
import hhxy.com.firstkotlinproject.toast
import hhxy.com.firstkotlinproject.ui.fragment.AboutFragment
import hhxy.com.firstkotlinproject.ui.fragment.AndroidFragment
import hhxy.com.firstkotlinproject.ui.fragment.GirlFragment
import hhxy.com.firstkotlinproject.ui.fragment.IOSFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URLEncoder
import javax.inject.Inject

class MainActivity : BaseBindingActivity<ActivityMainBinding>(), RandomContract.View {


    lateinit var mFragments: MutableList<Fragment>

    @Inject
    lateinit var mPresenter: RandomPresenter


    override fun createDataBinding(savedInstanceState: Bundle?): ActivityMainBinding {
        return DataBindingUtil.setContentView(this, R.layout.activity_main)
        initView()
    }

    /**
     * 初始化view方法
     * */
    override fun initView() {
        initFragments()
        getMainComponent().plus(RandomModule(this)).inject(this);
        navigationView.setOnNavigationItemSelectedListener { item ->
            var tab = 0
            when (item.itemId) {
                R.id.menu_android -> tab = 0
                R.id.menu_ios -> tab = 1
                R.id.menu_girl -> tab = 2
                R.id.menu_about -> tab = 3
            }
            item.isChecked = true
            false
        }
        floatingButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                mPresenter.getRandom("Android")
            }

        })
    }

    private fun initFragments() {
        mFragments = ArrayList()
        mFragments.add(AndroidFragment.Companion.newInstance())
        mFragments.add(IOSFragment.Companion.newInstance())
        mFragments.add(GirlFragment.Companion.newInstance())
        mFragments.add(AboutFragment.Companion.newInstance())
    }

    override fun onRandom(goods: FuckGoods) {

        val url = URLEncoder.encode(goods.url)
        toast("手气不错哦~")
    }
}
