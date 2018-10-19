package hhxy.com.javalib.kotlinfile

/**
 * Created by Administrator on 2018/10/10.
 */
class KotlinTest1 {
    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    fun varageSum(vararg a: Int): Int {
        var sum = 0
        for (c in a) {
            sum = sum + c;
        }
        return sum
    }
}