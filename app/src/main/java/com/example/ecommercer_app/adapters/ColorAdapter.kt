package com.example.ecommercer_app.adapters

import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.ecommercer_app.databinding.ColorRvItemBinding

class ColorAdapter : RecyclerView.Adapter<ColorAdapter.ColorHolder>() {
    private var selectedPosition = -1

    inner class ColorHolder(private val binding: ColorRvItemBinding) : ViewHolder(binding.root){
        fun bind(color: Int,position: Int){
            val  imageDrawable = ColorDrawable(color)
            binding.imagesColor.setImageDrawable(imageDrawable)
            if (position == selectedPosition){
                binding.apply {
                    imagesShadow.visibility = View.VISIBLE
                    imagePicker.visibility = View.VISIBLE
                }
            }else{
                binding.apply {
                    imagesShadow.visibility = View.INVISIBLE
                    imagePicker.visibility = View.INVISIBLE
                }

            }
        }

    }

    private val diffCallback = object  :  DiffUtil.ItemCallback<Int>(){
        override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this,diffCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorHolder {
        return ColorHolder(
            ColorRvItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: ColorHolder, position: Int) {
        val  color = differ.currentList[position]
        holder.bind(color,position)
        holder.itemView.setOnClickListener {
            if (selectedPosition >= 0) notifyItemChanged(selectedPosition)
            selectedPosition = holder.adapterPosition
            notifyItemChanged(selectedPosition)
            onItemClick?.invoke(color)
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    var  onItemClick: ((Int) -> Unit)? = null
}