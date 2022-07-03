package com.example.kisileruygulamasi.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasi.data.repo.KisilerDaoRepository

class KisiKayitFragmentViewModel : ViewModel() {
    val krepo = KisilerDaoRepository()

    fun Kayit(kisi_ad: String, kisi_tel: String) {
        krepo.kisiKayit(kisi_ad, kisi_tel)
    }
}