package com.example.magisterkaxml.ui

import android.content.res.ColorStateList
import android.content.res.Resources
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.magisterkaxml.R
import com.example.magisterkaxml.sales.ForYouItem
import com.example.magisterkaxml.databinding.ItemForyouBinding
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.CornerSize
import com.google.android.material.shape.ShapeAppearanceModel

class ForYouAdapter : RecyclerView.Adapter<ForYouAdapter.ViewHolder>() {

    lateinit var binding: ItemForyouBinding
    var forYouList = emptyList<ForYouItem>()

    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        var image = binding.image
        var requirement = binding.requirement
        var card_requirement = binding.cardRequirement
        var saleVariant = binding.saleVariant
        var cardVariant = binding.cardVariant
        var pricePerItemPLN = binding.pricePerItemPLN
        var pricePerItemGR = binding.pricePerItemGR
        var pricePerItemUnit = binding.pricePerItemUnit
        var cardPerItem = binding.cardPerItem
        var theLowestPrice = binding.theLowestPrice
        var product = binding.product
        var details = binding.details
        var expiration = binding.expiration
        var limit = binding.limit
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemForyouBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return forYouList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            image.setImageResource(forYouList[position].image)
            requirement.text = forYouList[position].requirement

            saleVariant.text = forYouList[position].saleVariant
            var shapeAppearanceModelTop: ShapeAppearanceModel.Builder =
                ShapeAppearanceModel().toBuilder()
            shapeAppearanceModelTop.setTopLeftCorner(
                CornerFamily.ROUNDED,
                CornerSize { return@CornerSize 25F })
                .setTopRightCorner(
                    CornerFamily.ROUNDED,
                    CornerSize { return@CornerSize 25F }
                )
            var shapeAppearanceModelBottom: ShapeAppearanceModel.Builder =
                ShapeAppearanceModel().toBuilder()
            shapeAppearanceModelBottom.setBottomLeftCorner(
                CornerFamily.ROUNDED,
                CornerSize { return@CornerSize 25F })
                .setBottomRightCorner(
                    CornerFamily.ROUNDED,
                    CornerSize { return@CornerSize 25F }
                )
            cardVariant.shapeAppearanceModel = shapeAppearanceModelTop.build()
            cardPerItem.shapeAppearanceModel = shapeAppearanceModelBottom.build()
            val splittedText = forYouList[position].pricePerItem.split(",")
            pricePerItemPLN.text = splittedText[0]
            pricePerItemGR.text = splittedText[1]
            pricePerItemUnit.text = splittedText[2]
            val lowestPrice = "najniższa cena: ${forYouList[position].theLowestPrice}\n" +
                    " cena regularna: ${forYouList[position].regularPrice}"
            theLowestPrice.text = lowestPrice
            product.text = forYouList[position].product
            details.text = forYouList[position].details
            expiration.text = forYouList[position].expiration
            val limitText = "Limit ${forYouList[position].limit}"
            limit.text = limitText
        }





    }

    fun setData(forYouList: List<ForYouItem>) {
        this.forYouList = forYouList
    }

}