package hhxy.com.firstkotlinproject

/**
 * Created by Administrator on 2018/10/10.
 * 继承部分
 * 1，如果子类有主构造方法，则继承是父类必须在子类主构造方法中初始化
 * 2，如果子类没有主构造方法，则需在次构造方法中通过super关键字手动调用父类的构造，初始化父类
 */
class Kotlin6 : Kotlin5, Kotlin4.TestInterface {
    override fun test() {

    }

    constructor(name: String, city: String, contray: String) : super(name, city, contray) {
        this.name = name
        this.city = city
        this.contray = contray
        SystemUtils.println(this)

    }

    constructor() : this("a", "d", "d") {

    }

    override fun toString(): String {
        return this.name + this.city + this.contray
    }

    override fun function() {

        SystemUtils.println("我是重写的")
        super.function()
    }

    companion object {
        fun getInstance(): Kotlin6 {
            return Kotlin6("sea", "xinyang", "china")
        }
    }

}