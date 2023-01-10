package com.example.cafe.Menu.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cafe.Menu.MenuModel
import com.example.cafe.OnClicker
import com.example.cafe.databinding.ItemMenuBinding


class MenuAdapter(private val list: ArrayList<MenuModel>, private val clicker: OnClicker) :
    RecyclerView.Adapter<MenuAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
        holder.itemView.setOnClickListener {
            clicker.onClick(position)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun getMenu(position: Int): MenuModel {
        return list[position]
    }




    inner class ViewHolder(private val binding: ItemMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(menuModel: MenuModel) {

            binding.image.setImageResource(menuModel.image)
            binding.nameOfFood.text = menuModel.name
            binding.priceOfFood.text = menuModel.price


        }


    }


}
