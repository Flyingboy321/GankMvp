package hhxy.com.firstkotlinproject.api

import hhxy.com.firstkotlinproject.bean.FuckGoods
import hhxy.com.firstkotlinproject.bean.JsonResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.*

/**
 * Created by Administrator on 2018/10/18.
 */
interface GankApi {

    /**
     * 获取随机数据
     * */
    @GET("random/data/{type}/1")
    fun getRandom(@Path("type") type: String): Observable<JsonResult<List<FuckGoods>>>

    /**
     * 获取android所有数据
     * */
    @GET("data/Android/10/{page}")
    fun getAndroidData(@Path("page") page: Int): Observable<JsonResult<List<FuckGoods>>>

    /**
     * 获取ios所有数据
     * */
    @GET("data/iOS/10/{page}")
    fun getIOSData(@Path("page") page: Int): Observable<JsonResult<List<FuckGoods>>>

    /**
     * 获取福利所有数据
     * */
    @GET("data/福利/10/{page}")
    fun getCirlData(@Path("page") page: Int): Observable<JsonResult<List<FuckGoods>>>

}
