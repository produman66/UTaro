package com.example.utaronew.ui.view

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.utaronew.BottomFragment
import com.example.utaronew.CostomClickListener
import com.example.utaronew.R
import com.example.utaronew.data.API.PhraseUtilites
import com.example.utaronew.data.models.Retrofit.DailyPhraseModel
import com.example.utaronew.data.GoroApplication
import com.example.utaronew.data.room.entities.GoroscopListEntities
import com.example.utaronew.databinding.GoroscopMainBinding
import com.example.utaronew.ui.adapters.GoroscopMainAdapter
import com.example.utaronew.ui.view_models.GoroscopListViewModel
import com.example.utaronew.ui.view_models.GoroscopViewModelFactory
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HoroscopeMain : Fragment(), CostomClickListener {

    lateinit var front_anim:AnimatorSet
    lateinit var back_anim:AnimatorSet
    var isFront = true

    private lateinit var binding: GoroscopMainBinding

    private val viewModel: GoroscopListViewModel by viewModels {
        GoroscopViewModelFactory((requireActivity().application as GoroApplication).repository)
    }
    private val adapter: GoroscopMainAdapter = GoroscopMainAdapter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = GoroscopMainBinding.inflate(inflater, container, false)
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = GridLayoutManager(requireContext(), 2)
        viewModel.goroAll.observe(viewLifecycleOwner, Observer { words ->
            words?.let { adapter.submitList(it) }
        })
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ////Animation card
        val scale = requireActivity().applicationContext.resources.displayMetrics.density

        binding.frontCardview.cameraDistance = 8000 * scale
        binding.backCardview.cameraDistance = 8000 * scale

        front_anim = AnimatorInflater.loadAnimator(requireActivity().applicationContext,R.animator.front_animator) as AnimatorSet
        back_anim = AnimatorInflater.loadAnimator(requireActivity().applicationContext,R.animator.back_animator) as AnimatorSet

        binding.frontCardview.setOnClickListener{
            if(isFront){
                front_anim.setTarget(binding.frontCardview)
                back_anim.setTarget(binding.backCardview)
                back_anim.start()
                front_anim.start()
                newPhrase()
                isFront=false
            }else {
                front_anim.setTarget(binding.backCardview)
                back_anim.setTarget(binding.frontCardview)
                front_anim.start()
                back_anim.start()
                isFront=true
            }
        }


        //Navigation
        val btnNavView: BottomNavigationView = view.findViewById(R.id.bottonNavView)
        btnNavView.selectedItemId = R.id.botton_goro

        btnNavView.setOnItemSelectedListener { it ->
            when (it.itemId) {
                R.id.botton_profile -> {
                    findNavController().navigate(R.id.profileMain)
                    true
                }

                R.id.botton_card -> {
                    findNavController().navigate(R.id.taroMain)
                    true
                }

                R.id.botton_favorite -> {
                    findNavController().navigate(R.id.loveMain)
                    true
                }

                else -> false
            }
        }
    }


    //Click on Item
    override fun onCustomerClick(position: Int) {
        val selectedGoro: GoroscopListEntities = adapter.currentList.get(position)
        val name = selectedGoro.name
        val desc = selectedGoro.desc
        val bottomFragment = BottomFragment.newInstance(name, desc)
        bottomFragment.show(requireFragmentManager(), "tag")
    }


    //Generation new daily phrase
    fun newPhrase(){
        val dailyPhraseApi = PhraseUtilites.create().getHoroscope()

        dailyPhraseApi.enqueue( object : Callback<DailyPhraseModel> {
            override fun onResponse(call: Call<DailyPhraseModel>?, response: Response<DailyPhraseModel>?) {
                Log.d("testLogs", "OnResponse Success ${response?.body()?.daily}")
                binding.dailyphrase.text = response?.body()?.daily.toString()
            }

            override fun onFailure (call: Call<DailyPhraseModel>?, t: Throwable?) {
                Log.d("testLogs", "OnFailure : ${t?.message}")
            }
        })
    }


}