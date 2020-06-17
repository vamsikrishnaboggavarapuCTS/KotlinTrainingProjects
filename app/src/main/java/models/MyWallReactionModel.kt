package models

data class MyWallReactionModelItem(
    val feed_id: String,
    val hate: Int,
    val like: Int,
    val love: Int,
    val total_reactions: Int
)