package hhxy.com.firstkotlinproject

/**
 * Created by Administrator on 2018/7/26.
 */
class KotlinTest {
    var PI = 3.14

    var a: Double = PI + 3
    var mapList = mapOf<String, String>()
    var str: String = "test"
    var dd: MutableSet<String> = HashSet()
    var ee:Int = 10
    set(value) {
        field = value
    }


    fun sum(a: Int, b: Int): Int {


        mapList.get("ddd")
//        mapList["ddd"] =
        var c: Int = a
        var d: Int = b
        var f: Int = c + d
        var e = a//自动赋值（推断出来为int类型）
        var g = 3
        println("g = $g")
        println("result is ${a + b}")

        println(a + b)
        return a + b
    }

    //    返回值可以是int 也可以是null
    fun paraseInt(str: String): Int? {

        return str.toIntOrNull()
    }

    fun printProduct(arg1: String, arg2: String) {
        var x = paraseInt(arg1)
        var y = paraseInt(arg2)
        if (x != null && y != null) {
            println(x * y)
        } else {
            println("x 或者 y 是null")
        }
    }

    fun range(x: Int, y: Int) {
        if (x in 1..y) {
            println("x=$x  y=$y  在范围中")
        } else {
            println("x=$x  y=$y  不在范围中")
        }
    }

    fun bianli() {
        for (x in 1..5) {
            println("遍历结果$x")
        }
    }

    fun list() {
        var items = listOf<String>("apple", "banana", "android")
        for (item in items) {
            println("遍历集合结果$item")
        }
    }

    fun whenFunction() {
        var items = setOf<String>("Apple", "bannana", "android")
        var apple: String = "Apple"

        when (apple) {
            in items -> println("dd")
            is String -> println("fddfs")
            else -> println("都不符合")
        }
    }

    abstract class shape(var sides: List<Double>) {
//        var perimeter : Double get() = sides.sum()


    }

    data class Customer(var name: String, var email: String)

    fun mapList(map: Map<String, String>) {
        var turtle = Turtle("dd")
        turtle.pendown()
//        对一个对象调用多个方法
        with(turtle) {
            pendown()
            penup()
        }

        for ((k, v) in map) {
            println("遍历map集合$k  ->  $v")
        }
    }


    class Turtle {
        var str = "dkkflsdglfjs"
        constructor(i:String){
            str = i
        }

        fun pendown() {}
        fun penup() {
            var arrayOf = arrayOf("2", "3")
            var get = arrayOf.get(0)
            var arrayOfNulls = arrayOfNulls<String>(3)
            arrayOfNulls.set(1, "dd")
            for (c in str) {
                print("每次迭代值：$c")
            }
        }

        fun findMax(a: Int, b: Int): Int {
            return if (a > b) a else b
        }
    }
    /**
     * 没有类头和类体的类
     *
     * */

    class Empty


}