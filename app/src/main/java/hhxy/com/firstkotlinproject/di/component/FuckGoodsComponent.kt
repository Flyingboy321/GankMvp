package hhxy.com.firstkotlinproject.di.component

import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import hhxy.com.firstkotlinproject.mvp.contract.FuckGoodsContract
import hhxy.com.firstkotlinproject.ui.fragment.AndroidFragment
import hhxy.com.firstkotlinproject.ui.fragment.GirlFragment
import hhxy.com.firstkotlinproject.ui.fragment.IOSFragment

/**
 * Created by Administrator on 2018/10/22.
 */

@Subcomponent(modules = [FuckGoodsModule::class])
interface FuckGoodsComponent {
    fun inject(fragment: AndroidFragment)
    fun inject(fragment: IOSFragment)
    fun inject(fragment: GirlFragment)
}


@Module
class FuckGoodsModule(val mView: FuckGoodsContract.View) {
    @Provides
    fun provideView(): FuckGoodsContract.View {
        return mView
    }
}