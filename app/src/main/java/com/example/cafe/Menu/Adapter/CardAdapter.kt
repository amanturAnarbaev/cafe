package com.example.cafe.Menu.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cafe.Menu.CardModel
import com.example.cafe.databinding.ItemCardBinding

class CardAdapter(private val list: List<CardModel>) :
    RecyclerView.Adapter<CardAdapter.CardViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(
            ItemCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.onBind(list[position])


    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class CardViewHolder(private val binding: ItemCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")

        fun onBind(cardModel: CardModel) {
            binding.text.text = cardModel.name + " || " + cardModel.price + "  soms"
        }

    }
}