package com.example.weatherapplication.ui.fragment

import android.annotation.SuppressLint
import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import com.example.weatherapplication.R
import org.json.JSONObject
import java.lang.Exception
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {


    val CITY: String = "dhaka, bd"
    val API: String = "28d9ddb0e847b8ceb7d5bd2cd4b94b15"


    // TODO: Rename and change types of parameters
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.CUPCAKE) {
            weatherTask().execute()
        }
    }

    @SuppressLint("NewApi")
    inner class weatherTask(): AsyncTask<String, Void, String>(){
        override fun onPreExecute() {
            super.onPreExecute()
            val bar = view?.findViewById<ProgressBar>(R.id.loader)
            bar?.visibility = View.VISIBLE


        }

        @SuppressLint("ResourceType")
        override fun doInBackground(vararg params: String?): String? {
            var response: String?
            try {
                val title=  view?.findViewById<TextView>(R.id.titleTV)
                title?.text = param1
                response = URL("https://api.openweathermap.org/data/2.5/weather?q=$param1&units=metric&appid=$API").readText(
                    Charsets.UTF_8)
            }
            catch (e: Exception){
                response = null
            }
            return response
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            try {
                val jsonObj = JSONObject(result)
                val main = jsonObj.getJSONObject("main")
                val sys = jsonObj.getJSONObject("sys")
                val wind = jsonObj.getJSONObject("wind")
                val weather = jsonObj.getJSONArray("weather").getJSONObject(0)
                val updatedAt:Long = jsonObj.getLong("dt")
                val updatedAtText = "Updated at:"+ SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).format(
                    Date(updatedAt*1000)
                )
                val temp = main.getString("temp")+"°C"
                val tempMin = "Min Temp:"+main.getString("temp_min")+"°C"
                val tempMax = "Max Temp:"+main.getString("temp_max")+"°C"
                val pressure = "Pressure: "+main.getString("pressure")
                val humidity = main.getString("humidity")
                val sunrise:Long = sys.getLong("sunrise")
                val sunset:Long = sys.getLong("sunset")
                val weatherDescription = "Weather Description: "+weather.getString("description")
                val address = jsonObj.getString("name")+", "+sys.getString("country")


                val maxTemp = view?.findViewById<TextView>(R.id.maxTemp)
                maxTemp?.text = tempMax

                val minTemp = view?.findViewById<TextView>(R.id.minTemp)
                minTemp?.text = tempMin

                val weaDescription = view?.findViewById<TextView>(R.id.description)
                weaDescription?.text = weatherDescription



                val pres = view?.findViewById<TextView>(R.id.pressure)
                pres?.text = pressure



                val bar = view?.findViewById<ProgressBar>(R.id.loader)
                bar?.visibility = View.GONE


            }
            catch (e: Exception){
                val bar = view?.findViewById<ProgressBar>(R.id.loader)
                bar?.visibility = View.VISIBLE
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=  inflater.inflate(R.layout.fragment_detail, container, false)
        val title=  view.findViewById<TextView>(R.id.titleTV)
        title.text = param1
        return view
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *

         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String ) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}