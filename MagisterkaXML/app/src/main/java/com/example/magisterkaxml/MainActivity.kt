package com.example.magisterkaxml

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.magisterkaxml.databinding.ActivityMainBinding
import com.example.magisterkaxml.ui.ForYouAdapter
import com.example.magisterkaxml.sales.SalesAdapter
import com.example.magisterkaxml.ui.StoryAdapter
import com.example.magisterkaxml.sales.ForYouItem
import com.example.magisterkaxml.sales.ImplementData
import com.example.magisterkaxml.sales.SaleItem

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val storyList: List<StoryItem> = listOf(

        StoryItem(R.drawable.panda, "Panda"),
        StoryItem(R.drawable.pumpkin, "Dynie"),
        StoryItem(R.drawable.brokul, "Brokuły"),
        StoryItem(R.drawable.frytki, "Frytki"),
        StoryItem(R.drawable.jajko, "Jajka"),
        StoryItem(R.drawable.kawa, "Kawa"),
        StoryItem(R.drawable.mieso, "Mięso"),
        StoryItem(R.drawable.pieczywo, "Pieczywo"),
        StoryItem(R.drawable.pizza, "Pizza"),
        StoryItem(R.drawable.ramen, "Ramen"),
        StoryItem(R.drawable.taco, "Taco"),
        StoryItem(R.drawable.tost, "Tost"),
    )
    val forYouItemList: List<ForYouItem> =
        listOf(
            ForYouItem(
                image = R.drawable.pumpkin,
                requirement = "z aplikacją Mój Sklep",
                saleVariant = "2 + 1 GRATIS",
                pricePerItem = "2,32,szt.",
                theLowestPrice = "2.32 0% więcej",
                regularPrice = "3.48 33% taniej",
                product = "Dynia",
                details = "cena za 1 szt. przy zakupie 3 szt.",
                expiration = "04:00:00",
                limit = "3 szt",
            ),
            ForYouItem(
                R.drawable.brokul,
                requirement = "z aplikacją Mój Sklep",
                saleVariant = "DRUGI 64% TANIEJ",
                pricePerItem = "7,99,szt.",
                theLowestPrice = "11.90 32% mniej",
                regularPrice = "11.90 32% taniej",
                product = "Brokuły",
                details = "cena za 1 szt. przy zakupie 2 szt.",
                expiration = "05:50:00",
                limit = "4 szt",
            ),
            ForYouItem(
                image = R.drawable.mieso,
                requirement = "Kółko Krzyżyk",
                saleVariant = "59% TANIEJ",
                pricePerItem = "9,75,kg",
                theLowestPrice = "23.90 59% mniej",
                regularPrice = "23.90 59% taniej",
                product = "Świeży filet z piersi kurczaka",
                details = "/kg",
                expiration = "02:15:00",
                limit = "3 kg",
            ),
            ForYouItem(
                image = R.drawable.kawa,
                requirement = "Zdrapka",
                saleVariant = "53% TANIEJ",
                pricePerItem = "5,99,opak.",
                theLowestPrice = "12.99 53% mniej",
                regularPrice = "12.99 53% taniej",
                product = "Kawa, opak. 500g",
                details = "/szt",
                expiration = "02:15:00",
                limit = "1 szt.",
            ),
            ForYouItem(
                image = R.drawable.pumpkin,
                requirement = "z aplikacją Mój Sklep",
                saleVariant = "2 + 1 GRATIS",
                pricePerItem = "2,32,szt.",
                theLowestPrice = "2.32 0% więcej",
                regularPrice = "3.48 33% taniej",
                product = "Dynia",
                details = "cena za 1 szt. przy zakupie 3 szt.",
                expiration = "04:00:00",
                limit = "3 szt",
            ),
            ForYouItem(
                R.drawable.brokul,
                requirement = "z aplikacją Mój Sklep",
                saleVariant = "DRUGI 64% TANIEJ",
                pricePerItem = "7,99,szt.",
                theLowestPrice = "11.90 32% mniej",
                regularPrice = "11.90 32% taniej",
                product = "Brokuły",
                details = "cena za 1 szt. przy zakupie 2 szt.",
                expiration = "05:50:00",
                limit = "4 szt",
            ),
            ForYouItem(
                image = R.drawable.mieso,
                requirement = "Kółko Krzyżyk",
                saleVariant = "59% TANIEJ",
                pricePerItem = "9,75,kg",
                theLowestPrice = "23.90 59% mniej",
                regularPrice = "23.90 59% taniej",
                product = "Świeży filet z piersi kurczaka",
                details = "/kg",
                expiration = "02:15:00",
                limit = "3 kg",
            ),
            ForYouItem(
                image = R.drawable.kawa,
                requirement = "Zdrapka",
                saleVariant = "53% TANIEJ",
                pricePerItem = "5,99,opak.",
                theLowestPrice = "12.99 53% mniej",
                regularPrice = "12.99 53% taniej",
                product = "Kawa, opak. 500g",
                details = "/szt",
                expiration = "02:15:00",
                limit = "1 szt.",
            )
        )
    val salesList: List<ImplementData> = listOf( SaleItem("1")) + forYouItemList
//val salesList: List<ImplementData> =  forYouItemList


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupStoryRecycleView(binding.story.storyRv)
        setupForYouRecycleView(binding.foryou.ForYouRv)


    }

    private fun setupStoryRecycleView(recyclerView: RecyclerView) {
        val adapter = StoryAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.HORIZONTAL,false)
        adapter.setData(storyList)
    }
    private fun setupForYouRecycleView(recyclerView: RecyclerView) {
        val adapter = ForYouAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.HORIZONTAL,false)
        adapter.setData(forYouItemList)
    }


}