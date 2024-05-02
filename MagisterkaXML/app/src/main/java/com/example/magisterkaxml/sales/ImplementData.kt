package com.example.magisterkaxml.sales

interface ImplementData{
    enum class Type(value: Int) { TypeA(0), TypeB(1) }
    fun getListItemType(): Int
}