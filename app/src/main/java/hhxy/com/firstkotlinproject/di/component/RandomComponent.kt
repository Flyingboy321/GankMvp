package hhxy.com.firstkotlinproject.di.component

import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import hhxy.com.firstkotlinproject.mvp.contract.RandomContract
import hhxy.com.firstkotlinproject.ui.activity.MainActivity

/**
 * Created by Administrator on 2018/10/19.
 * 单独提供Random相关注入对象
 */
@Subcomponent(modules = [RandomModule::class])
interface RandomComponent {
    fun inject(activity: MainActivity)
}


@Module
class RandomModule(private val mView: RandomContract.View) {
    @Provides
    fun provideView(): RandomContract.View {
        return mView
    }
}
