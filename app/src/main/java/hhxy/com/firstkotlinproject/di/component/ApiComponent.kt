package hhxy.com.firstkotlinproject.di.component

import dagger.Component
import hhxy.com.firstkotlinproject.App
import hhxy.com.firstkotlinproject.di.module.ApiModule
import javax.inject.Singleton

/**
 * Created by Administrator on 2018/10/19.
 * 此component为父类component，如果所有相关组件应该在此基础上面扩展
 */

@Singleton
@Component(modules = [(ApiModule::class)])
interface ApiComponent {
    fun inject(app: App)
    //    获取扩展子类component方法
    fun plus(randomModule: RandomModule): RandomComponent
}