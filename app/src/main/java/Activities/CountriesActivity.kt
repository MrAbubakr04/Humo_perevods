package Activities

import Adapters.CountryAdapter
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.SearchView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.my_project.R
import com.example.my_project.databinding.ChooseCountryActivityBinding
import data_classes.Countries

class CountriesActivity:AppCompatActivity() {
    lateinit var binding: ChooseCountryActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        binding = ChooseCountryActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        countries()
        val toolbar: Toolbar = findViewById(R.id.humo_perevod_toolbar1)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

    }

    private val сountryList = listOf<Countries>(
        Countries(R.drawable.flag_russia,"Россия"),
        Countries(R.drawable.flag_uzbekistan,"Узбекистан"),
        Countries(R.drawable.flag_tajikistan,"Таджикистан"),
        Countries(R.drawable.flag_kazakhstan,"Казахстан"),
        Countries(R.drawable.flag_uae,"ОАЭ"),
        Countries(R.drawable.flag_korea,"Корея")
    )
    private val AdapterCountries = CountryAdapter(сountryList)
    private  fun countries(){
        binding.apply{
            ReciclerViewCountries.layoutManager = LinearLayoutManager(this@CountriesActivity,
                LinearLayoutManager.VERTICAL, false)
            ReciclerViewCountries.adapter =AdapterCountries
        }
    }
}