package com.example.newbaseandroid.proxumer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cp.overlayimageactionbar.AchievementAdapter
import com.example.proxumer.databinding.FragmentAchievementBinding

class AchievementFragment : Fragment()
{
    private val binding: FragmentAchievementBinding by lazy { FragmentAchievementBinding.inflate(layoutInflater) }

    fun newInstance():AchievementFragment {
        val args = Bundle()
        val fragment = AchievementFragment()
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
        //recyclerView
        binding.recyclerView.layoutManager = GridLayoutManager(activity,3 , RecyclerView.VERTICAL, false)
        binding.recyclerView.setHasFixedSize(true)
        var adapter = AchievementAdapter(  )
        binding.recyclerView.adapter = adapter
    }


}