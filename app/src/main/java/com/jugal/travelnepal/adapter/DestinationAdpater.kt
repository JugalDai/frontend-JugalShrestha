package com.jugal.travelnepal.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.jugal.travelnepal.Fragment.HomeFragment
import com.jugal.travelnepal.R
import com.jugal.travelnepal.api.ServiceBuilder
import com.jugal.travelnepal.entity.Destination
import com.jugal.travelnepal.repository.DestinationRepository
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DestinationAdpater (
    private val context : Context,
    private val lstDestinations : MutableList<Destination>
): RecyclerView.Adapter<DestinationAdpater.DestinationViewHolder>(){

    class DestinationViewHolder(view: View): RecyclerView.ViewHolder(view){
        var dimage : ImageView
        var dname : TextView
        var ddetails : TextView
        var dprice : TextView
        var btnBook: TextView
        init {
            dimage =view.findViewById(R.id.dimage)
            dname = view.findViewById(R.id.tvName)
            ddetails = view.findViewById(R.id.tvdetails)
            dprice = view.findViewById(R.id.tvPrice)
            btnBook = view.findViewById(R.id.tvBook)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DestinationViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.dash_layout,parent, false)
        return DestinationViewHolder(view)
    }

    override fun onBindViewHolder(holder: DestinationViewHolder, position: Int) {
        val destination = lstDestinations[position]
         Glide.with(context).load("${ServiceBuilder.BASE_URL}${destination.dimage}").into(holder.dimage)
        println("${ServiceBuilder.BASE_URL}${destination.dimage}")
        holder.dname.text = destination.dname
        holder.ddetails.text = destination.ddetails
        holder.dprice.text = destination.dprice

        val imagepath=ServiceBuilder.loadImage()+destination.dimage!!.split("\\")[1]
        Glide.with(context).load(imagepath).into(holder.dimage)

        holder.btnBook.setOnClickListener {
CoroutineScope(Dispatchers.IO).launch {


    val repository = DestinationRepository()
    val response = repository.addToCart(destination)
    if(response.success==true){
        withContext(Main){
            Toast.makeText(context, "One Destination Booked", Toast.LENGTH_SHORT).show()
        }
    }

}

            val fragment: Fragment = HomeFragment()
            val fragmentManager: FragmentManager =
                    (context as FragmentActivity).supportFragmentManager
            val fragmentTransaction: FragmentTransaction =
                    fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }



    }

    override fun getItemCount(): Int {
        return lstDestinations.size
    }
}