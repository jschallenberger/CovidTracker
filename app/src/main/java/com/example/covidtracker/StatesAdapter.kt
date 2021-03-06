package com.example.covidtracker

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerstatecard.view.*
import java.text.NumberFormat
import java.util.*

class StatesAdapter(val dataCovid: DataCovid): RecyclerView.Adapter<CustomViewHolder>() {

    override fun getItemCount(): Int {
        return dataCovid.data.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.recyclerstatecard, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val state = dataCovid.data[position]
        holder?.view?.nomeEstado2?.text=dataCovid.data[position].state
        holder?.view?.UF3?.text = dataCovid.data[position].uf
       // holder?.view?.txtDeaths?.text = NumberFormat.getIntegerInstance(Locale.GERMAN).format(dataCovid.data[position].deaths)
       // holder?.view?.txtCases?.text =  NumberFormat.getIntegerInstance(Locale.GERMAN).format(dataCovid.data[position].cases)
       // holder?.view?.txtRefuses?.text =  NumberFormat.getIntegerInstance(Locale.GERMAN).format(dataCovid.data[position].refuses)
       // holder?.view?.txtSuspects?.text = NumberFormat.getIntegerInstance(Locale.GERMAN).format(dataCovid.data[position].suspects)
    }

}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view){
    init {
        view.setOnClickListener {
            val intent = Intent(view.context, DetailState::class.java)
            intent.putExtra("UF",it.UF3.text)
            view.context.startActivity(intent)
        }
    }
}