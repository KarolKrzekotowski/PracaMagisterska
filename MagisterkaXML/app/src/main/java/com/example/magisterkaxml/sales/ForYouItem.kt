package com.example.magisterkaxml.sales

data class ForYouItem(
    val image: Int,
    val requirement: String,
    val saleVariant: String,
    val pricePerItem: String,
    val theLowestPrice: String,
    val regularPrice: String,
    val product: String,
    val details: String,
    val expiration: String,
    val limit: String,
) : ImplementData {
    override fun getListItemType(): Int {
        return ImplementData.Type.TypeA.ordinal
    }
}
