package hhxy.com.firstkotlinproject.bean

/**
 * Created by Administrator on 2018/10/18.
 * 创建通用json类
 *
 */
class JsonResult<T>(val error: Boolean, val results: T) {

}