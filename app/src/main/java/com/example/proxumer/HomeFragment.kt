package com.example.newbaseandroid.proxumer

import android.os.Bundle
import android.util.DisplayMetrics
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.cp.overlayimageactionbar.AllGoalsAdapter
import com.cp.overlayimageactionbar.BestOfferAdapter
import com.cp.overlayimageactionbar.SuggestionAdapter
import com.example.proxumer.R
import com.example.proxumer.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private val binding: FragmentHomeBinding by lazy { FragmentHomeBinding.inflate(layoutInflater) }

    fun newInstance():HomeFragment {
        val args = Bundle()
        val fragment = HomeFragment()
        fragment.arguments = args
        return fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        initRecyclerViewSuggestion()
        initRecyclerViewBestOffer()
        initRecyclerView()
        goToViewGoal()
        return binding.root
    }


    private fun goToViewGoal()
    {
        binding.btnNewGoal.setOnClickListener {
            (activity as SaleHereActivity).replaceFragmentWithBackStack(R.id.contentContainer,ViewGoalFragment().newInstance(),"","")
        }
    }

    private fun initRecyclerView()
    {
        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerviewGoals.layoutManager = layoutManager
        binding.recyclerviewGoals.setHasFixedSize(true)
        var adapter = AllGoalsAdapter( (activity as SaleHereActivity).getWidthDevice(2.5f)  )
        binding.recyclerviewGoals.adapter = adapter
    }

    private fun initRecyclerViewBestOffer()
    {
        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerviewBestOffer.layoutManager = layoutManager
        binding.recyclerviewBestOffer.setHasFixedSize(true)
        var adapter = BestOfferAdapter( (activity as SaleHereActivity).getWidthDevice(2.5f)  )
        binding.recyclerviewBestOffer.adapter = adapter

    }

    private fun initRecyclerViewSuggestion()
    {
        //recyclerView
        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerviewSuggestion.layoutManager = layoutManager
        binding.recyclerviewSuggestion.setHasFixedSize(true)
        var adapter = SuggestionAdapter( (activity as SaleHereActivity).getWidthDevice(2.5f)  )
        binding.recyclerviewSuggestion.adapter = adapter

    }


}