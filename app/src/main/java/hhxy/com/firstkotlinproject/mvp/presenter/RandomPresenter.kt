package hhxy.com.firstkotlinproject.mvp.presenter

import android.util.Log
import hhxy.com.firstkotlinproject.bean.FuckGoods
import hhxy.com.firstkotlinproject.bean.JsonResult
import hhxy.com.firstkotlinproject.mvp.contract.RandomContract
import hhxy.com.firstkotlinproject.mvp.model.RandomModel
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/**
 * Created by Administrator on 2018/10/18.
 * 这里Randompresenter 使用@inject 自动注入，通过构造创建对象时，
 * 如遇到参数对象，会在当前所依赖component中查询是否提供返回值为参数类型，如果没有，则查询是否有相关参数类构造被@inject标注，
 * 有，直接创建，没有，继续按上述依次查询
 */
class RandomPresenter
@Inject
constructor(private val mModel: RandomModel,
            private val mView: RandomContract.View) : RandomContract.Presenter {
    override fun getRandom(type: String) {
/*        mModel.getRandom(type).observeOn(AndroidSchedulers.mainThread())
                .subscribe({ res ->
                    if (!res.error) {
//                        获取数据成功，将回调数据传入view中
                        mView.onRandom(res.results[0])
                        Log.e("okhttp", "成功了啊")
                    }
                }, {})*/
        mModel.getRandom(type).observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<JsonResult<List<FuckGoods>>> {
                    override fun onComplete() {
                        Log.e("okhttp", "onComplete")

                    }

                    override fun onSubscribe(d: Disposable?) {
                        Log.e("okhttp", "onSubscribe")
                    }

                    override fun onNext(value: JsonResult<List<FuckGoods>>) {
                        Log.e("okhttp", "onNext")
                        if (!value.error) {
                            mView.onRandom(value.results[0])
                        } else {
                            Log.e("okhttp", "json格式异常")
                        }
                    }

                    override fun onError(e: Throwable?) {
                        Log.e("okhttp", "onError" + "===" + e.toString())
                    }

                })
    }
}
