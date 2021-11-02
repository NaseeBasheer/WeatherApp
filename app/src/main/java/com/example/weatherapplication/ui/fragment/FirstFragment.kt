package com.example.weatherapplication.ui.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.weatherapplication.R
import com.example.weatherapplication.databinding.FirstFragmentBinding

class FirstFragment : Fragment() {

    private var _binding: FirstFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Toast.makeText(activity, "in onAttach", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(activity, "in onCreate", Toast.LENGTH_SHORT).show()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View{
        Toast.makeText(activity, "in onCreateView", Toast.LENGTH_SHORT).show()

        _binding = FirstFragmentBinding.inflate(inflater, container, false)

        binding.button5.setOnClickListener {
            val frag = SecondFragment()
            val fragManager = requireActivity().supportFragmentManager
            val fragTransaction = fragManager.beginTransaction()
            fragTransaction.replace(R.id.frame_holder, frag,"main_fragment")
            fragTransaction.addToBackStack(null)
            fragTransaction.commit()
        }

        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(activity, "in onViewCreated", Toast.LENGTH_SHORT).show()

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Toast.makeText(activity, "in onActivityCreated", Toast.LENGTH_SHORT).show()

    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(activity, "in onStart", Toast.LENGTH_SHORT).show()

    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(activity, "in onResume", Toast.LENGTH_SHORT).show()

    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(activity, "in onPause", Toast.LENGTH_SHORT).show()

    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(activity, "in onstop", Toast.LENGTH_SHORT).show()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        Toast.makeText(activity, "in onDestroyView", Toast.LENGTH_SHORT).show()

    }
    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(activity, "in onDestroy", Toast.LENGTH_SHORT).show()

    }

    override fun onDetach() {
        super.onDetach()
        Toast.makeText(activity, "in onDetach", Toast.LENGTH_SHORT).show()

    }




}