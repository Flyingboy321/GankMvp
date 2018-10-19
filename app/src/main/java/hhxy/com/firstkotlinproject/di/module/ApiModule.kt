package hhxy.com.firstkotlinproject.di.module

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import hhxy.com.firstkotlinproject.api.GankApi
import io.reactivex.schedulers.Schedulers
import okhttp3.Cache
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import javax.inject.Singleton

/**
 * Created by Administrator on 2018/10/19.
 * 创建APImodule，用来返回网络请求需要的对象
 * 且包含获取context对象module
 */
@Module(includes = [AppModule::class])
class ApiModule {

    /**
     * 创建retrofit对象
     * */
    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: HttpUrl, client: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder().client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
    }

    /**
     * 创建baseURL对象
     * */
    @Provides
    fun provideBaseUrl() = HttpUrl.parse("http://gank.io/api/")

    @Provides
    fun provideOkhttp(context: Context, interceptor: HttpLoggingInterceptor): OkHttpClient {

        val cacheSize = 1024 * 1024 * 10L
        val cacheDir = File(context.cacheDir, "http")
        val cache = Cache(cacheDir, cacheSize)
        var httpClient = OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(interceptor).build()
        return httpClient
    }

    /**
     * 提供日志拦截器对象
     * */
    @Provides
    fun provideInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor { msg ->
            Log.d("okhttp", msg)
        }
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    /**
     * 提供Gson解析对象
     * */
    @Provides
    fun provideGson() = GsonBuilder().create()

    /**
     * 提供API接口对象
     * */
    @Provides
    fun provideApi(retrofit: Retrofit): GankApi {
        var create = retrofit.create(GankApi::class.java)
        return create
    }


}