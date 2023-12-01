package com.example.utaronew

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class HoroscopeInfo : Fragment(){
//    private val viewModel: GoroscopListViewModel by viewModels {
//        GoroscopViewModelFactory((requireActivity().application as GoroApplication).repository)
//    }
//
//    private val adapter:GoroscopMainAdapter = GoroscopMainAdapter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.goro_info, container, false)

//        val recyclerAdapter = view.findViewById<RecyclerView>(R.id.recyclerview1)
//        recyclerAdapter.adapter = adapter
//        recyclerAdapter.layoutManager = GridLayoutManager(requireContext(), 2)
//        viewModel.goroAll.observe(viewLifecycleOwner, Observer { words ->
//            words?.let { adapter.submitList(it) }
//        })


//        val dailyPhraseApi = DailyPhraseApi.create().getHoroscope()
//
//        //apiInterface.enqueue( Callback<List<Movie>>())
//        dailyPhraseApi.enqueue( object : Callback<DailyPhraseAPI> {
//            override fun onResponse(call: Call<DailyPhraseAPI>?, response: Response<DailyPhraseAPI>?) {
//                Log.d("testLogs", "OnResponse Success ${response?.body()?.daily}")
//            }
//
//            override fun onFailure (call: Call<DailyPhraseAPI>?, t: Throwable?) {
//                Log.d("testLogs", "OnFailure : ${t?.message}")
//            }
//        })
        return view
    }
}