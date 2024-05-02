package com.example.magisterkaxml.sales

data class SaleItem(
    val item: String
) : ImplementData {
    override fun getListItemType(): Int {
        return ImplementData.Type.TypeB.ordinal
    }
}
