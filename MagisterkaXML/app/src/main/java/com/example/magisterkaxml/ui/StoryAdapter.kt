package com.example.magisterkaxml.ui

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.magisterkaxml.StoryItem
import com.example.magisterkaxml.databinding.StoryItemBinding

class StoryAdapter: RecyclerView.Adapter<StoryAdapter.ViewHolder>() {
    private var storyList = emptyList<StoryItem>()
    lateinit var binding: StoryItemBinding
    inner class ViewHolder(item:View): RecyclerView.ViewHolder(item){
        var image : ImageView = binding.storyImage
        var description: TextView = binding.storyDescription
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryAdapter.ViewHolder {
        binding = StoryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: StoryAdapter.ViewHolder, position: Int) {
        holder.description.text = storyList[position].description
        holder.image.setImageResource(storyList[position].image)
    }

    override fun getItemCount(): Int {
        return storyList.size
    }

    fun setData(storyList: List<StoryItem>){
        this.storyList = storyList
        notifyDataSetChanged()
    }
}