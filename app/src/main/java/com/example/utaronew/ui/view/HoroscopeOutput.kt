package com.example.utaronew.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.utaronew.R
import com.example.utaronew.databinding.GoroOutputBinding
import com.example.utaronew.ui.view_models.DailyGoroVM

class HoroscopeOutput : Fragment() {

    private lateinit var binding: GoroOutputBinding

    private lateinit var dailyGoroVM: DailyGoroVM

    private lateinit var sign:String


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = GoroOutputBinding.inflate(inflater, container, false)
        sign = arguments?.getString("sign").toString()
        dailyHoro(sign)

        binding.collapsingToolbar.apply {
            setExpandedTitleTextAppearance(R.style.goro_output_heading)
            setCollapsedTitleTextAppearance(R.style.change_pass)
        }
        sign = arguments?.getString("sign").toString()

        binding.collapsingToolbar.title = sign

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.floatbtn.setOnClickListener{
            findNavController().popBackStack()
        }
    }



    fun dailyHoro(sign:String){

        //val dailyGoroApi = DailyGoroApi.create().getHoroscopeToday(sign)

        val dailyGoroVM = ViewModelProvider(requireActivity()).get(DailyGoroVM::class.java)

        dailyGoroVM.getGoro(sign)!!.observe(requireActivity()) { binding.desc.text = it.horoscope }
//        dailyGoroApi.enqueue( object : Callback<DailyGoroTodayModel> {
//            override fun onResponse(
//                call: Call<DailyGoroTodayModel>,
//                response: Response<DailyGoroTodayModel>
//            ) {
//                Log.d("testLogs", "OnResponse Success ${response.body()?.sign}")
//                binding.desc.text = response.body()?.horoscope.toString()
//            }
//t
//            override fun onFailure(call: Call<DailyGoroTodayModel>, t: Throwable) {
//                Log.d("testLogs", "OnFailure : ${t?.message}")
//            }
//        })
    }
}
