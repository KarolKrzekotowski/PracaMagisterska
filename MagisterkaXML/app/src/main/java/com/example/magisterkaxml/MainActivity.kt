package com.example.magisterkaxml

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.magisterkaxml.databinding.ActivityMainBinding
import com.example.magisterkaxml.ui.ForYouAdapter
import com.example.magisterkaxml.ui.StoryAdapter
import com.example.magisterkaxml.sales.ForYouItem
import com.example.magisterkaxml.ui.forYouItemList

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




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Lista z okrągłymi elementami
        setupStoryRecycleView(binding.story.storyRv)
        // Lista Tylko dla Ciebie
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