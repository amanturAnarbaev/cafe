package com.example.cafe.tables.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cafe.databinding.ItemTablesBinding
import com.example.cafe.OnClicker
import com.example.cafe.tables.TableModel

class TableAdapter(private val list: ArrayList<TableModel>,private val clicker: OnClicker) : RecyclerView.Adapter<TableAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemTablesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
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


    inner class ViewHolder(private val binding: ItemTablesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(tableModel: TableModel) {
//            binding.table.setOnClickListener {
//                clicker.onClick()
//            }
            binding.table.setImageResource(tableModel.image)

        }


    }


}


