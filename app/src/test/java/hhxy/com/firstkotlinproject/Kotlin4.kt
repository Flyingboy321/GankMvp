package hhxy.com.firstkotlinproject

/**
 * Created by Administrator on 2018/10/10.
 * 基本语法部分
 */
class Kotlin4 {
    var age: String? = "23"
    var year = age?.toInt() ?: -1
    fun varargSum(vararg a: Int): Int {
        var sum = 0
        for (b in a) {
            sum = b + sum
        }
        return sum
    }

    fun getStringLength(obj: Any): Int? {
        if (obj is String) {
            return obj.length
        }
        return null
    }

    fun rangeTest(): Unit {

//        遍历区间内数据
        for (a in 1..5 step 2) {
            SystemUtils.println(a)
        }
//        倒序
        for (b in 5 downTo 1 step 2) {
            SystemUtils.println(b)
        }

        for (c in 1 until 5) {
            SystemUtils.println(c)
        }
    }

    fun arrayTest() {
        val a = arrayOf(1, 2, 4, 0, 100)
        for ((index, value) in a.withIndex()) {
            SystemUtils.println(a.get(index))
        }
    }

    fun getMax(a: Int, b: Int): Int {
        var max: Int = 0
        max = if (a > b) a else b
        return max
    }

    //    相当java中switch表达式
    fun whenText(a: Int) {
        when (a) {
            1 -> SystemUtils.println(a)
            2 -> SystemUtils.println(a)
            3 -> SystemUtils.println(a)
            4 -> SystemUtils.println(a)
            5 -> SystemUtils.println(a)
            else -> {
                SystemUtils.println("什么都不是")
            }
        }

    }

    fun instanceTest() {
        var kotlin5 = Kotlin5("吴海军", "信阳", "中国")
        SystemUtils.println(kotlin5)
    }

    fun getKotlin4Instance(target: Kotlin4): Kotlin4 {
        return target.javaClass.newInstance()
    }


    lateinit var v: TestInterface;

    interface TestInterface {
        fun test()
    }

    fun setInterface(obj: TestInterface): Unit {
        this.v = obj
    }

    fun interfaceTest() {
//        使用对象表达式创建匿名内部类
        this.setInterface(object : TestInterface {
            override fun test() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }


}