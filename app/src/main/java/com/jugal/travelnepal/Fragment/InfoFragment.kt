package com.jugal.travelnepal.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.jugal.travelnepal.MapsActivity
import com.jugal.travelnepal.R


class InfoFragment : Fragment() {
    private lateinit var btnlocation : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_info, container, false)

        btnlocation = view.findViewById(R.id.btnLocation)
        btnlocation.setOnClickListener {
            startActivity(Intent(context, MapsActivity::class.java))
        }

//        btnlogout.setOnClickListener {
//            startActivity(Intent(context, LoginActivity::class.java))
//
//        }
        return view
    }

}