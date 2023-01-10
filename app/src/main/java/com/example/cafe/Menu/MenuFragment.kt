package com.example.cafe.Menu

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.cafe.Menu.Adapter.CardAdapter
import com.example.cafe.Menu.Adapter.MenuAdapter
import com.example.cafe.OnClicker
import com.example.cafe.R
import com.example.cafe.databinding.FragmentMenuBinding

class MenuFragment : Fragment(), OnClicker {
    private lateinit var binding: FragmentMenuBinding

    private var quantity: Int = 0
    private var amount: Int = 0
    private var chequeNumber: Int = 0

    private val cardList = ArrayList<CardModel>()
    private val cardAdapter: CardAdapter get() = CardAdapter(cardList)

    private val list = ArrayList<MenuModel>()
    private val adapter: MenuAdapter
        get() = MenuAdapter(list, this)

    private lateinit var navArgs: MenuFragmentArgs

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.finishBtn.setOnClickListener {
            chequeNumber += 1
            findNavController().navigate(
                MenuFragmentDirections.actionMenuFragmentToChequeFragment(
                    "adress",
                    chequeNumber.toString(),
                    "time ",
                    quantity.toString(),
                    navArgs.table.toString()
                )
            )
        }

        binding.menuRecycler.adapter = adapter
        loadImage()

        binding.cardRecycler.adapter = cardAdapter
        cardList.add(CardModel("3242", "revretvt"))

        arguments?.let {
            navArgs = MenuFragmentArgs.fromBundle(it)
        }

        val meneger = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        binding.menuRecycler.layoutManager = meneger


        binding.cancelBtn.setOnClickListener {
            quantity = 0
            amount = 0
            binding.orderQuantity.text = quantity.toString()
            binding.orderAmount.text = amount.toString()
        }
    }


    private fun loadImage() {
        list.add(MenuModel(R.drawable.ic_four, "40", "burger1"))
        list.add(MenuModel(R.drawable.ic_four, "70", "burger4"))
        list.add(MenuModel(R.drawable.ic_four, "80", "burger5"))
        list.add(MenuModel(R.drawable.ic_four, "30", "burger7"))
        list.add(MenuModel(R.drawable.ic_four, "60", "burger9"))


    }

    @SuppressLint("SetTextI18n")
    override fun onClick(position: Int) {
        val menu: MenuModel = adapter.getMenu(position)

        this.amount += 1
        binding.orderAmount.text = amount.toString()

        quantity += menu.price.toInt()
        binding.orderQuantity.text = (quantity).toString()


        // cannot add items for cardList


    }


}