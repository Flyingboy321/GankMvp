package hhxy.com.firstkotlinproject.mvp.model

import hhxy.com.firstkotlinproject.api.GankApi
import hhxy.com.firstkotlinproject.bean.FuckGoods
import hhxy.com.firstkotlinproject.bean.JsonResult
import hhxy.com.firstkotlinproject.mvp.contract.FuckGoodsContract
import hhxy.com.firstkotlinproject.ui.fragment.AndroidFragment
import hhxy.com.firstkotlinproject.ui.fragment.GirlFragment
import hhxy.com.firstkotlinproject.ui.fragment.IOSFragment
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Administrator on 2018/10/22.
 */
class FuckGoodsModel @Inject constructor(val api: GankApi) : FuckGoodsContract.Model {
    override fun getData(page: Int, type: String): Observable<JsonResult<List<FuckGoods>>> {
        when (type) {
            AndroidFragment.ANDROID -> return api.getAndroidData(page)
            IOSFragment.IOS -> return api.getIOSData(page)
            GirlFragment.Girl -> return api.getCirlData(page)
            else -> return api.getAndroidData(page)
        }
    }
}