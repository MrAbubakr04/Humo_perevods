package com.example.my_project

import Adapters.FirstAdapter
import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.my_project.databinding.ActivityMainBinding
import data_classes.Countries

class MainActivity : AppCompatActivity() {
    private  val varadapter1 = FirstAdapter()
    private val varadapter2 = FirstAdapter()
    lateinit var binding: ActivityMainBinding
    private val countryList = listOf(
        "Таджикистан",
        "Россия",
        "Узбекистан"
    )
    private val flagList = listOf (
        R.drawable.flag_tajikistan,
        R.drawable.flag_russia,
        R.drawable.flag_uzbekistan
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.materialCardExit.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Выйти из аккаунта?")
                .setMessage("Если вы уверены, что хотите выйти и удалить все ВАШИ данные, нажмите ПРОДОЛЖИТЬ")
                .setNegativeButton("ОТМЕНИТЬ") { dialog, which ->
                }
                    .setPositiveButton("ПРОДОЛЖИТЬ") { dialog, which ->
                        //sharedPreferencesNumber?.edit()?.remove("abonent_number")?.apply()
                        finishAffinity()
                    }
                    .show()
        }

        init1()
    }
    @SuppressLint("ResourceType")
    private  fun init1(){
        binding.apply{
            ReciclerView1.layoutManager = LinearLayoutManager(this@MainActivity,
                LinearLayoutManager.HORIZONTAL, false)
            ReciclerView1.adapter = varadapter1
            for (i in 0 until flagList.size){
                val datass = Countries(flagList[i],countryList[i])
                varadapter1.adddata(datass)
            }
        }
    }
}
