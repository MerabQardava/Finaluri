package com.example.finaluri.Fragment

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.finaluri.R

class LeafFragment:Fragment(R.layout.fragment_leaf) {

    private lateinit var Button : Button
    private lateinit var Text: TextView
    private lateinit var Height:EditText
    private lateinit var Weight:EditText

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Button = view.findViewById(R.id.button)
        Text = view.findViewById(R.id.textView)
        Height = view.findViewById(R.id.height)
        Weight = view.findViewById(R.id.weight)



        Button.setOnClickListener {
            val simagle= Height.text.toString()
            val wona=Weight.text.toString()

            if (simagle.isEmpty()||wona.isEmpty()){
               Toast.makeText(getActivity(),"Error!",Toast.LENGTH_SHORT).show()
            }else{

                val result = wona.toDouble()/(simagle.toDouble()*simagle.toDouble())
                val rounded = String.format("%.1f", result)
                Text.text=rounded

                if (rounded.toDouble()<18.5)
                    Text.text=rounded + " - ძვალი და ტყავი"
                else if (rounded.toDouble()>=18.5 && rounded.toDouble()<=24.9)
                    Text.text=rounded + " - ნორმალური"
                else if (rounded.toDouble()>=25 && rounded.toDouble()<=29.9)
                    Text.text=rounded + " - ცოტა დაიკელი"
                else {
                    Text.text=rounded + " - ჯვარი გწერია"
                }


            }


        }
    }

}