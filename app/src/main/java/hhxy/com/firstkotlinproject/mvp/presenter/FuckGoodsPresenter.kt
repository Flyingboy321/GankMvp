package hhxy.com.firstkotlinproject.mvp.presenter

import android.util.Log
import hhxy.com.firstkotlinproject.bean.FuckGoods
import hhxy.com.firstkotlinproject.bean.JsonResult
import hhxy.com.firstkotlinproject.mvp.contract.FuckGoodsContract
import hhxy.com.firstkotlinproject.mvp.model.FuckGoodsModel
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/**
 * Created by Administrator on 2018/10/22.
 */
class FuckGoodsPresenter @Inject constructor(val mModel: FuckGoodsModel,
                                             val mView: FuckGoodsContract.View) : FuckGoodsContract.Presenter {
    override fun getData(page: Int, type: String) {
        mModel.getData(page, type).observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<JsonResult<List<FuckGoods>>> {
                    override fun onComplete() {

                    }

                    override fun onSubscribe(d: Disposable?) {
                    }

                    override fun onNext(value: JsonResult<List<FuckGoods>>) {
                        if (!value.error && value.results.isNotEmpty()) {
                            mView.setData(value.results)
                        } else {
                            Log.e("okhttp", "json格式异常")
                        }
                    }

                    override fun onError(e: Throwable?) {

                    }

                })

    }


}