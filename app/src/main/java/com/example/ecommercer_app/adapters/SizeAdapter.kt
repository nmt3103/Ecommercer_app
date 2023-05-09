package com.example.ecommercer_app.adapters

import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

import com.example.ecommercer_app.databinding.SizeRvItemBinding

class SizeAdapter : RecyclerView.Adapter<SizeAdapter.SizeHolder>() {
    private var selectedPosition = -1

    inner class SizeHolder(private val binding: SizeRvItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(size : String,position: Int){
            binding.tvSize.text = size
            if (position == selectedPosition){
                binding.apply {
                    imagesShadow.visibility = View.VISIBLE
                }
            }else{
                binding.apply {
                    imagesShadow.visibility = View.INVISIBLE

                }

            }
        }

    }

    private val diffCallback = object  :  DiffUtil.ItemCallback<String>(){
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this,diffCallback)

    var  onItemClick: ((String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SizeHolder {
        return SizeHolder(
            SizeRvItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: SizeHolder, position: Int) {
        val size = differ.currentList[position]
        holder.bind(size,position)
        holder.itemView.setOnClickListener {
            if (selectedPosition >= 0) notifyItemChanged(selectedPosition)
            selectedPosition = holder.adapterPosition
            notifyItemChanged(selectedPosition)
            onItemClick?.invoke(size)
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}