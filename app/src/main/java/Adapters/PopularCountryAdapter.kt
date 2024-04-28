package Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.my_project.R
import com.example.my_project.databinding.RecyclerViewFavoritesCountriesBinding
import data_classes.Countries

class PopularCountryAdapter: RecyclerView.Adapter<PopularCountryAdapter.textHolder> (){
    val countryList = ArrayList<Countries>()
    class textHolder(item:View):RecyclerView.ViewHolder (item){
        val binding = RecyclerViewFavoritesCountriesBinding.bind(item)
        fun bind(country:Countries) = with(binding){
            humoPerevodFavoriteCountryName.text = country.name
            humoPerevodFavoriteImageFlag.setImageResource(country.flag)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): textHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_favorites_countries,parent, false)
        return textHolder(view)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: textHolder, position: Int) {
        holder.bind(countryList[position])
    }

    fun adddata(dat:Countries){
        countryList.add(dat)
        notifyDataSetChanged()
    }
}