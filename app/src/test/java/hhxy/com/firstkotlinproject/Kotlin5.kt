package hhxy.com.firstkotlinproject

/**
 * Created by Administrator on 2018/10/10.
 * 类和对象部分
 */

open class Kotlin5 constructor(name: String, city: String, contray: String) {

    //    如果在类中有主构造方法后，定义次构造方法时需要直接或间接代理主构造方法 使用this关键字
    constructor(name: String, city: String, contray: String, a: String) : this(name, city, contray) {
        this.name = name
    }

    //    可以有一个主构造函数也可不写
    open var name: String = "微丶凉"
        get() = field
        set(value) {
            if (value.length < 3) {
                field = "设置名字小于3"
            } else {
                field = value
            }
        }
    open var city: String = "杭州"
    var contray: String

    init {
//        构造器的初始化块，可以对相关成员变量初始化赋值
        this.name = name
        this.city = city
        this.contray = contray
    }

    //  嵌套类不具有外部类的引用，内部类使用inner修饰，持有外部类对象的引用
    //    定义个空类
    inner class Empty {
        fun functionInner() {
//            使用this@类名 代替外部类引用this 消除奇异
            this@Kotlin5.function()
        }

    }

    //    成员方法 如果实现子类重写使用open修饰
    open fun function() {
        SystemUtils.println("我是通过构造方法创建对象调用方法")
        SystemUtils.println(this)

    }

    override fun toString(): String {
        return this.name + this.city + this.contray
    }


}
