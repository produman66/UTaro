package com.example.utaronew

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.utaronew.databinding.LoveMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class LoveMain : Fragment() {

    lateinit var binding: LoveMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = LoveMainBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var btnNavView: BottomNavigationView = binding.root.findViewById(R.id.bottonNavView)
        btnNavView.selectedItemId = R.id.botton_favorite

        btnNavView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.botton_goro -> {
                    findNavController().navigate(R.id.goroscopMain)
                    true
                }
                R.id.botton_card -> {
                    findNavController().navigate(R.id.taroMain)
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