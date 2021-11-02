package com.example.weatherapplication.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.calculatorapp.ui.DataModel
import com.example.calculatorapp.ui.RecyclerViewAdapter
import com.example.calculatorapp.ui.viewmodel.FragmentBViewModel
import com.example.weatherapplication.R

class SecondFragment : Fragment(), RecyclerViewAdapter.ClickListener {
    private lateinit var adapter: RecyclerViewAdapter
    val listData:ArrayList<DataModel> = ArrayList()



    private lateinit var viewModel: FragmentBViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.second_fragment, container, false)
        buildDisplayedData()
        initRecyclerView(view)
        return view


        /*val recyclerView = view as RecyclerView
        recyclerView.findViewById<View>(R.id.recyclerView)
        val llm = LinearLayoutManager(activity)
        recyclerView.setLayoutManager(llm)*/
    }
    private fun initRecyclerView(view: View){
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        adapter = RecyclerViewAdapter(listData, this)
        recyclerView.adapter = adapter
    }
    private fun buildDisplayedData(){
        listData.add(DataModel("London, UK"))
        listData.add(DataModel("New York, US"))
        listData.add(DataModel("Chicago, US"))
        listData.add(DataModel("Paris, FR"))
        listData.add(DataModel("New Delhi, IN"))
        listData.add(DataModel("Los Angeles, US"))
        listData.add(DataModel("Milan, IT"))
        listData.add(DataModel("Tokyo, JP"))
        listData.add(DataModel("Beijing, CN"))
        listData.add(DataModel("Mumbai, IN"))
        listData.add(DataModel("Manila, PH"))
        listData.add(DataModel("Barcelona, ES"))
        listData.add(DataModel("Zurich, CH"))
        listData.add(DataModel("Thrissur, IN"))
        listData.add(DataModel("Kochi, IN"))
        listData.add(DataModel("Aluva, IN"))





    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FragmentBViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onItemClick(dataModel: DataModel) {

        val fragment:Fragment = DetailFragment.newInstance(dataModel.title!!)
        val transaction = activity?.supportFragmentManager!!.beginTransaction()
        transaction.hide(activity?.supportFragmentManager!!.findFragmentByTag("main_fragment")!!)
        transaction.add(R.id.frame_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    companion object {

        fun newInstance() =
            SecondFragment().apply {

            }
    }


}