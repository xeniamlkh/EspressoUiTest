package com.example.espressouitests

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class InputFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_input, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameInput = view.findViewById<EditText>(R.id.nameInput)
        val ageInput = view.findViewById<EditText>(R.id.ageInput)
        val cityInput = view.findViewById<EditText>(R.id.cityInput)
        val submitButton = view.findViewById<Button>(R.id.submitButton)

        submitButton.setOnClickListener {

            val name = nameInput.text.toString()
            val age = ageInput.text.toString()
            val city = cityInput.text.toString()

            val resultFragment = ResultFragment.newInstance(
                name = name,
                age = age,
                city = city
            )

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, resultFragment)
                .addToBackStack(null)
                .commit()
        }
    }
}