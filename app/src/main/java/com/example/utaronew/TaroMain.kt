package com.example.utaronew

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.utaronew.databinding.TaroMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class TaroMain : Fragment() {

    lateinit var binding: TaroMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding =  TaroMainBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var btnNavView: BottomNavigationView = binding.root.findViewById(R.id.bottonNavView)
        btnNavView.selectedItemId = R.id.botton_card

        btnNavView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.botton_goro -> {
                    findNavController().navigate(R.id.goroscopMain)
                    true
                }
                R.id.botton_favorite -> {
                    findNavController().navigate(R.id.loveMain)
                    true
                }
                R.id.botton_profile -> {
                    findNavController().navigate(R.id.profileMain)
                    true
                }
                else -> false
            }
        }
    }
}