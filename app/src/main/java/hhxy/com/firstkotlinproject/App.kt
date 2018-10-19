package hhxy.com.firstkotlinproject

import android.app.Application
import hhxy.com.firstkotlinproject.di.component.ApiComponent
import hhxy.com.firstkotlinproject.di.component.DaggerApiComponent
import hhxy.com.firstkotlinproject.di.module.ApiModule
import hhxy.com.firstkotlinproject.di.module.AppModule
import javax.inject.Inject

/**
 * Created by Administrator on 2018/10/19.
 */
class App : Application() {

    init {
        instance = this
    }

    /*
    * 注入apicomponent变量
    * */
    @Inject
    lateinit var apiComponent: ApiComponent

    override fun onCreate() {
        super.onCreate()

        DaggerApiComponent.builder().apiModule(ApiModule()).appModule(AppModule(this)).build().inject(this)
    }

    /*
    * 定义伴生对象，获取Application对象
    * */
    companion object {
        lateinit var instance: App
    }
}