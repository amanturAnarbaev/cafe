package com.example.cafe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cafe.databinding.FragmentChequeBinding


class ChequeFragment : Fragment() {
    private lateinit var binding: FragmentChequeBinding

    private lateinit var navArgs: ChequeFragmentArgs


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChequeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireArguments()!!.let {
            navArgs = ChequeFragmentArgs.fromBundle(it)
        }

        binding.checkNumber.text = navArgs.checkNumber

        binding.adress.text = navArgs.adress

        binding.nedd.text = navArgs.give

        binding.time.text = navArgs.time

        binding.table.text = navArgs.table


    }

}