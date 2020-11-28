data class ProductIssues(
    val productId : Int,
    val skuId : Int,
    val productName : String,
    val action : String,
    val qty : Int,
    val reason : String
)