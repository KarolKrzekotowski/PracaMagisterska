package com.example.magisterkaxml.sales

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.magisterkaxml.databinding.ItemSaleOneBinding
import com.example.magisterkaxml.databinding.ItemSalesBinding


class SalesAdapter: RecyclerView.Adapter<SalesAdapter.BaseViewHolder>() {
    lateinit var binding : ItemSalesBinding
    lateinit var binding_one : ItemSaleOneBinding
    var forYouList = emptyList<ImplementData>()
    val tag = "dupa"


    abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: ImplementData)
    }
    inner class ViewHolderA(item: View): BaseViewHolder(item){
        override fun bind(item: ImplementData) {
            Log.i(tag,item.toString())
            val itemA = item as ForYouItem
            productImage.setImageResource(itemA.image)
            productName.text = itemA.product
            before.text = itemA.regularPrice
            present.text = itemA.regularPrice
            after.text = itemA.theLowestPrice
            gr.text = itemA.pricePerItem
            pln.text = itemA.pricePerItem
            deadline.text = itemA.expiration
        }
        var productName: TextView = binding.productName
        var productImage = binding.productImage
        var before = binding.before
        var present = binding.present
        var after = binding.after
        var gr = binding.gr
        var pln = binding.pln
        var deadline = binding.deadline
    }

    inner class ViewHolderB(item: View): BaseViewHolder(item){
        override fun bind(item: ImplementData) {
        }
    }
    override fun getItemViewType(position: Int): Int {
        return forYouList[position].getListItemType()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {

        Log.i(tag,viewType.toString())
//        Log.i(tag,viewType.)
        Log.i(tag, ImplementData.Type.TypeA.ordinal.toString())
        Log.i(tag, ImplementData.Type.TypeB.ordinal.toString())
        return when (viewType) {
            ImplementData.Type.TypeA.ordinal -> {
                binding =
                    ItemSalesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                return ViewHolderA(binding.root)
            }
            ImplementData.Type.TypeB.ordinal -> {
                binding_one =
                    ItemSaleOneBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                return ViewHolderB(binding_one.root)
            }
            else -> {
                binding =
                    ItemSalesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                return ViewHolderA(binding.root)
            }
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        Log.i(tag,position.toString())
        holder.bind(forYouList[position])


    }

    override fun getItemCount(): Int {
       return forYouList.size
    }
    fun setData(forYouList: List<ImplementData>){
        this.forYouList = forYouList
    }

}