package com.example.finaluri.Fragment

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.finaluri.R

class LeafFragment:Fragment(R.layout.fragment_leaf) {

    private lateinit var Button : Button
    private lateinit var Text: TextView
    private lateinit var Height:EditText
    private lateinit var Weight:EditText
    private lateinit var Image:ImageView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Button = view.findViewById(R.id.button)
        Text = view.findViewById(R.id.textView)
        Height = view.findViewById(R.id.height)
        Weight = view.findViewById(R.id.weight)
        Image = view.findViewById(R.id.imageView2)



        Button.setOnClickListener {
            val simagle= Height.text.toString()
            val wona=Weight.text.toString()

            if (simagle.isEmpty()||wona.isEmpty()){
               Toast.makeText(getActivity(),"Error!",Toast.LENGTH_SHORT).show()
            }else{

                val result = wona.toDouble()/(simagle.toDouble()*simagle.toDouble())
                val rounded = String.format("%.1f", result)
                Text.text=rounded

                if (rounded.toDouble()<18.5) {
                    Image.setImageResource(R.drawable.dzvali_da_tyavi)
                    Text.text = rounded + " - ძვალი და ტყავი"
                }
                else if (rounded.toDouble()>=18.5 && rounded.toDouble()<=24.9) {
                    Text.text = rounded + " - ნორმალური"
                    Image.setImageResource(R.drawable.bmikalkulatori)
                }
                else if (rounded.toDouble()>=25 && rounded.toDouble()<=29.9){
                    Text.text=rounded + " - ცოტა დაიკელი"
                    Image.setImageResource(R.drawable.cota_gaxdi)
                    }
                else {
                    Text.text=rounded + " - ჯვარი გწერია"
                    Image.setImageResource(R.drawable.gmertma_dagifaros)
                }


            }


        }
    }

}