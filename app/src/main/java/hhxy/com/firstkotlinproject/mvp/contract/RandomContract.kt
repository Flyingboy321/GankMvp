package hhxy.com.firstkotlinproject.mvp.contract

import hhxy.com.firstkotlinproject.bean.FuckGoods
import hhxy.com.firstkotlinproject.bean.JsonResult
import io.reactivex.Observable

/**
 * Created by Administrator on 2018/10/19.
 * rendom功能mvp接口回调部分 对于具体的一次网络请求数据分别实现以下三个接口
 */
interface RandomContract {

    //    调用view层，得到数据（数据在view层处理）
    interface View {
        fun onRandom(goods: FuckGoods)
    }

    //    调用model层，获取网络数据（数据在presenter层处理）
    interface Model {
        fun getRandom(type: String): Observable<JsonResult<List<FuckGoods>>>
    }

    //    调用presenter，在view层中通过presenter调用该方法，方法内部实现调用model层方法
    interface Presenter {
        fun getRandom(type: String)
    }

}