package com.example.espressouitests

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

private const val ARG_NAME = "arg_name"
private const val ARG_AGE = "arg_age"
private const val ARG_CITY = "arg_city"

class ResultFragment : Fragment() {
    private var argName: String? = null
    private var argAge: String? = null
    private var argCity: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            argName = it.getString(ARG_NAME)
            argAge = it.getString(ARG_AGE)
            argCity = it.getString(ARG_CITY)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val resultText = view.findViewById<TextView>(R.id.resultText)

        val name = arguments?.getString(ARG_NAME).orEmpty()
        val age = arguments?.getString(ARG_AGE).orEmpty()
        val city = arguments?.getString(ARG_CITY).orEmpty()

        resultText.text = "$name, $age лет, город $city"
    }

    companion object {
        @JvmStatic
        fun newInstance(name: String, age: String, city: String) =
            ResultFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_NAME, name)
                    putString(ARG_AGE, age)
                    putString(ARG_CITY, city)
                }
            }
    }
}