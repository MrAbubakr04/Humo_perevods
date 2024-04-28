package Activities

import Adapters.CountryAdapter
import Adapters.PopularCountryAdapter
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.my_project.R
import com.example.my_project.databinding.ActivityMainBinding
import data_classes.Countries

class MainActivity : AppCompatActivity() {
    private  val AdapterPopularCountries = PopularCountryAdapter()
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


    //private val myAdapter=PopularCountryAdapter1(listOfCountry)

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
                    val sharedPreferences = getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE)
                    sharedPreferences.edit().clear().apply()
                    finish()
                }
                .show()
        }

        FavoriteCountries()
        binding.imageHumoPerevodiMaterialButton.setOnClickListener{

        }

        val button:com.google.android.material.button.MaterialButton = findViewById(R.id.material_button)
        button.setOnClickListener {
            val intent = Intent(this,CountriesActivity::class.java)
            startActivity(intent)
        }

    }
    @SuppressLint("ResourceType")
    private  fun FavoriteCountries(){
        binding.apply{
            ReciclerViewFavoriteCountri.layoutManager = LinearLayoutManager(this@MainActivity,
                LinearLayoutManager.HORIZONTAL, false)
            //ReciclerView1.adapter = myAdapter
            ReciclerViewFavoriteCountri.adapter =AdapterPopularCountries
            for (i in 0 until flagList.size){
                val datass = Countries(flagList[i],countryList[i])
                AdapterPopularCountries.adddata(datass)
            }

        }
    }


}
