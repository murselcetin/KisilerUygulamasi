package com.example.kisileruygulamasi.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.data.repo.KisilerDaoRepository

class AnasayfaFragmentViewModel: ViewModel() {
    val krepo = KisilerDaoRepository()
    var kisilerListesi = MutableLiveData<List<Kisiler>>()

    init {
        kisilerYukle()
        kisilerListesi = krepo.kisileriGetir()
    }

    fun ara(aramaKelimesi: String) {
        krepo.kisiAra(aramaKelimesi)
    }

    fun sil(kisi_id: Int) {
        krepo.kisiSil(kisi_id)
    }

    fun kisilerYukle() {
        krepo.tumKisileriAl()
    }
}