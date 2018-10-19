package hhxy.com.firstkotlinproject

/**
 * Created by Administrator on 2018/10/10.
 * kotlin中的泛型
 */
class Kotlin7<T>(companyNane: T) {
    private var companyNane: T

    init {
        this.companyNane = companyNane
    }

    fun getParam() {
        SystemUtils.println(companyNane)
    }

    override fun toString(): String {
        return companyNane.toString()
    }

    companion object {
        fun getInstance(): Kotlin7<String> {
            return Kotlin7("")
        }
    }

    enum class Const {
        A, B, C, D
    }
}