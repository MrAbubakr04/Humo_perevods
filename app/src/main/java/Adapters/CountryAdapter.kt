package Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.my_project.R
import com.example.my_project.databinding.RecyclerViewCountriesBinding
import data_classes.Countries

class CountryAdapter(private val countyList:List<Countries>):RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {
    class CountryViewHolder(item: View):RecyclerView.ViewHolder(item){
        val image:ImageView = item.findViewById(R.id.HumoPerevodImageFlag)
        val countryName : TextView = item.findViewById(R.id.humo_perevod_country_name)
        
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_countries,parent,false)
        return CountryViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return countyList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.image.setImageResource(countyList[position].flag)
        holder.countryName.text = countyList[position].name
    }


}