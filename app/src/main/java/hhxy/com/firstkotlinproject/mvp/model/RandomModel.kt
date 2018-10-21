package hhxy.com.firstkotlinproject.mvp.model

import hhxy.com.firstkotlinproject.api.GankApi
import hhxy.com.firstkotlinproject.bean.FuckGoods
import hhxy.com.firstkotlinproject.bean.JsonResult
import hhxy.com.firstkotlinproject.mvp.contract.RandomContract
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Administrator on 2018/10/19.
 */
class RandomModel
@Inject
constructor(private val api: GankApi) : RandomContract.Model {
    override fun getRandom(type: String): Observable<JsonResult<List<FuckGoods>>> {
        return api.getRandom(type)
//        测试git
    }

}