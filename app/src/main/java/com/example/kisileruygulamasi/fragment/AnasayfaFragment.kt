package com.example.kisileruygulamasi.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.example.kisileruygulamasi.entity.Kisiler
import com.google.android.material.snackbar.Snackbar


class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        binding.toolbarAnasayfa.title = "Kişiler"
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarAnasayfa)


        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.anasayfaToKisiKayit)
        }

        binding.buttonDetay.setOnClickListener {
            val kisi = Kisiler(1, "Ahmet", "111111")
            val gecis = AnasayfaFragmentDirections.anasayfaToKisiDetay(kisi = kisi)
            Navigation.findNavController(it).navigate(gecis)
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_ara -> {
                Log.e("Kişi Menü", "Ara tıklandı.")
                return true
            }
            R.id.action_cikis -> {
                Log.e("Kişi Menü", "Çıkış tıklandı.")
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }

    }
}