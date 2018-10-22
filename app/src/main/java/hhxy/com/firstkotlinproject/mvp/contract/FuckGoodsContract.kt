package hhxy.com.firstkotlinproject.mvp.contract

import hhxy.com.firstkotlinproject.bean.FuckGoods
import hhxy.com.firstkotlinproject.bean.JsonResult
import io.reactivex.Observable

/**
 * Created by Administrator on 2018/10/22.
 * 主页面的数据mvp部分接口回调
 */
interface FuckGoodsContract {

    //    view层获取数据回调
    interface View {
        fun setData(results: List<FuckGoods>)
    }

    //    model层获取对象，返回一个可观察对象
    interface Model {
        /**
         * 通用获取数据方法，需要相关类型参数，判断不同的page传入
         * */
        fun getData(page: Int, type: String): Observable<JsonResult<List<FuckGoods>>>
    }

    //    view层调用presenter方法请求数据，最后通过调用model层方法完成
    interface Presenter {
        /**
         * 通用获取数据方法，需要相关类型参数，判断不同的page传入
         * */
        fun getData(page: Int, type: String)
    }
}