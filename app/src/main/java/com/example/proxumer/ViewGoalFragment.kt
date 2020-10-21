package com.example.newbaseandroid.proxumer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cp.overlayimageactionbar.GoalMenuAdapter
import com.example.proxumer.databinding.FragmentViewGoalBinding


class ViewGoalFragment : Fragment() {


    private val binding: FragmentViewGoalBinding by lazy { FragmentViewGoalBinding.inflate(layoutInflater) }

    fun newInstance():ViewGoalFragment {
        val args = Bundle()
        val fragment = ViewGoalFragment()
        fragment.arguments = args

        return fragment
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        initRecyclerView()
        return binding.root
    }

        private fun initRecyclerView()
    {
        binding.recyclerView.layoutManager = GridLayoutManager(activity,3 , RecyclerView.VERTICAL, false)
        binding.recyclerView.setHasFixedSize(true)
        var adapter = GoalMenuAdapter(  )
        binding.recyclerView.adapter = adapter
    }


    override fun onPause() {
        super.onPause()
    }


}