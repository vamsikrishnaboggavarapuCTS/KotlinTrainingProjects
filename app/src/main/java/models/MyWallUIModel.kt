package models

data class MyWallUIModel(
    val category: String,
    val id: String,
    val imageUrl : String?,
    val message: String,
    val name: String,
    val postType: String,
    val profile_pic: String,
    val timestamp: String,
    val hate: Int,
    val like: Int,
    val love: Int,
    val total_reactions: Int
)