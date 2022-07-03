package com.example.kisileruygulamasi.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.databinding.CardTasarimBinding
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.ui.fragment.AnasayfaFragmentDirections
import com.example.kisileruygulamasi.ui.viewmodel.AnasayfaFragmentViewModel
import com.example.kisileruygulamasi.util.gecisYap
import com.google.android.material.snackbar.Snackbar

class KisilerAdapter(
    var mContext: Context,
    var kisilerListesi: List<Kisiler>,
    var viewModel: AnasayfaFragmentViewModel
) :
    RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(tasarim: CardTasarimBinding) :
        RecyclerView.ViewHolder(tasarim.root) {
        var tasarim: CardTasarimBinding

        init {
            this.tasarim = tasarim//Shadowing
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding: CardTasarimBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.card_tasarim, parent, false)
        return CardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val kisi = kisilerListesi[position]
        val t = holder.tasarim
        t.kisiNesnesi = kisi

        t.imageViewSilResim.setOnClickListener {
            Snackbar.make(it, "${kisi.kisi_ad} silinsin mi?", Snackbar.LENGTH_LONG)
                .setAction("EVET") {
                    viewModel.sil(kisi.kisi_id)
                }.show()
        }
        t.satirCard.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.anasayfaToKisiDetay(kisi = kisi)
            Navigation.gecisYap(it,gecis)
        }
    }

    override fun getItemCount(): Int {
        return kisilerListesi.size
    }
}