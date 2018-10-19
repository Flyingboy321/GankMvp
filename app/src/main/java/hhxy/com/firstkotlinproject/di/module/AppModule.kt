package hhxy.com.firstkotlinproject.di.module

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by Administrator on 2018/10/19.
 */
@Module
class AppModule(private val context: Context) {
    /**
     * 获取context对象
     * */
    @Provides
    fun provideContext() = this.context

}