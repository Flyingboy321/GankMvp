package hhxy.com.firstkotlinproject.bean

/**
 * Created by Administrator on 2018/10/18.
 */
data class FuckGoods(
        val _id: String,
        val createdAt: String,
        val desc: String,
        val images: Array<String>,
        val publishedAt: String,
        val source: String,
        val type: String,
        val url: String,
        val used: Boolean,
        val who: String
) {
    fun hasImg(): Boolean {
        return images != null && images.isNotEmpty()
    }

    fun createTime() = createdAt.substring(0, 10)

}