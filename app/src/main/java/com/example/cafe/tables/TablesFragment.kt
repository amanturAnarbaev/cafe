package com.example.cafe.tables

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.cafe.OnClicker
import com.example.cafe.R
import com.example.cafe.databinding.FragmentTablesBinding
import com.example.cafe.tables.Adapter.TableAdapter

class TablesFragment : Fragment(), OnClicker {
    private lateinit var binding: FragmentTablesBinding
    private val list = ArrayList<TableModel>()
    private val adapter = TableAdapter(list, this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTablesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tablesRecycler.adapter = adapter

        val meneger = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        binding.tablesRecycler.layoutManager = meneger

        loadImage()
    }

    private fun loadImage() {
        list.add(TableModel(R.drawable.ic_one))
        list.add(TableModel(R.drawable.ic_two))
        list.add(TableModel(R.drawable.ic_three))
        list.add(TableModel(R.drawable.ic_four))
    }

    override fun onClick(position: Int) {
        findNavController().navigate(
            TablesFragmentDirections.actionTablesFragmentToMenuFragment(
                position + 1
            )
        )
    }


}