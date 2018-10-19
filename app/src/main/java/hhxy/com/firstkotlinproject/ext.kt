package hhxy.com.firstkotlinproject

import android.content.Context
import android.widget.Toast

/**
 * Created by Administrator on 2018/10/19.
 * 扩展context对象 添加方法获取ApiComponent对象以及弹出Toast方法
 */
fun Context.getMainComponent() = App.Companion.instance.apiComponent


fun Context.toast(msg: String, length: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, msg, length).show()
}
