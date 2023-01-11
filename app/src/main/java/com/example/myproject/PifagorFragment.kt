package com.example.myproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import com.example.myproject.databinding.FragmentPifagorBinding
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt


class PifagorFragment : Fragment() {
    lateinit var binding: FragmentPifagorBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPifagorBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonResult.setOnClickListener {
            if(!isFieldEmpty()){
                val result = getString(R.string.resultinfo) + getResult()
                binding.tvResult.text = result}
        }
    }


    private fun isFieldEmpty(): Boolean{
        binding.apply {
            if(edA.text.isNullOrEmpty()) edA.error = "Поле должно быть заполнено"
            if(edB.text.isNullOrEmpty()) edB.error = "Поле должно быть заполнено"
            return edA.text.isNullOrEmpty() || edA.text.isNullOrEmpty()
        }
    }
    private fun getResult(): String{
        val a: Double
        val b: Double
        binding.apply {
            a = edA.text.toString().toDouble()
            b = edB.text.toString().toDouble()
        }
        return ((sqrt((a.pow(2)+b.pow(2)))*100).roundToInt()/100.0).toString()
    }


    companion object {

        @JvmStatic
        fun newInstance() = PifagorFragment()
    }
}