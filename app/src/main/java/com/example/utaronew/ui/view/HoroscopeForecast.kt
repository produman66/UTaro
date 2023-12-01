package com.example.utaronew.ui.view

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.utaronew.R
import com.example.utaronew.databinding.GoroPrognozBinding

class HoroscopeForecast : Fragment() {

    private lateinit var binding: GoroPrognozBinding

    lateinit var prognoz_na:String

    private class Horoscop(val name:String, val image:ImageView)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = GoroPrognozBinding.inflate(inflater, container, false)

        prognoz_na = arguments?.getString("name").toString()
        binding.prognozNa.text = prognoz_na

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listHoro = mutableListOf<Horoscop>()

        binding.aries.setOnClickListener{
            handleHoroscopSelection(binding.aries, listHoro, "aries")
        }
        binding.twins.setOnClickListener{
            handleHoroscopSelection(binding.twins, listHoro, "gemini")
        }
        binding.calf.setOnClickListener{
            handleHoroscopSelection(binding.calf, listHoro, "taurus")
        }
        binding.crayfish.setOnClickListener{
            handleHoroscopSelection(binding.crayfish, listHoro, "cancer")
        }
        binding.lion.setOnClickListener{
            handleHoroscopSelection(binding.lion, listHoro, "leo")
        }
        binding.girl.setOnClickListener{
            handleHoroscopSelection(binding.girl, listHoro, "virgo")
        }
        binding.fish.setOnClickListener{
            handleHoroscopSelection(binding.fish, listHoro, "pisces")
        }
        binding.scales.setOnClickListener{
            handleHoroscopSelection(binding.scales, listHoro, "libra")
        }
        binding.scorpion.setOnClickListener{
            handleHoroscopSelection(binding.scorpion, listHoro, "scorpio")
        }
        binding.strelitz.setOnClickListener{
            handleHoroscopSelection(binding.strelitz, listHoro, "sagittarius")
        }
        binding.aquarius.setOnClickListener{
            handleHoroscopSelection(binding.aquarius, listHoro, "aquarius")
        }
        binding.wildgoat.setOnClickListener{
            handleHoroscopSelection(binding.wildgoat, listHoro, "capricorn")
        }
        binding.goroToday.setOnClickListener{
            if (listHoro.size == 1){
                val args = Bundle()
                args.putString("sign", listHoro[0].name)
                findNavController().navigate(R.id.action_goroPrognoz_to_goroOutput, args)
            }else {
                Toast.makeText(requireContext(), "Выберите знак задиака", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun handleHoroscopSelection(selectedImage: ImageView, horoscopList: MutableList<Horoscop>, sign: String) {
        for (i in 0.. horoscopList.size-1) {
            // Если выбран уже добавленный элемент, удаляем его из списка и очищаем заливку
            if (horoscopList[i].image == selectedImage) {
                horoscopList.removeAt(i)
                selectedImage.setColorFilter(Color.TRANSPARENT)
                return
            }
        }

        val horoscop = Horoscop(sign, selectedImage)

        // Если в списке уже есть другой элемент, заменяем его новым
        if (horoscopList.size == 1) {
            val previousImage = horoscopList[0].image
            previousImage.setColorFilter(Color.TRANSPARENT)
            horoscopList[0] = horoscop
        } else {
            // Если в списке нет элементов, добавляем выбранный элемент
            horoscopList.add(horoscop)
        }

        // Устанавливаем зеленую заливку для выбранного элемента
        selectedImage.setColorFilter(R.color.selected)
    }
}
