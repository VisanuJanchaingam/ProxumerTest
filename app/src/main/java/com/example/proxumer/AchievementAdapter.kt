package com.cp.overlayimageactionbar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proxumer.R


/**
 * Created by Admin on 14/5/2560.
 */

class AchievementAdapter : RecyclerView.Adapter<AchievementAdapter.AchievementViewHolder>()
{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AchievementViewHolder
    {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_medal, parent, false)
        return AchievementViewHolder( view)
    }

    override fun onBindViewHolder(holder: AchievementViewHolder, position: Int)
    {

        holder.bind()
    }

    override fun getItemCount(): Int
    {
        return 6
    }


    class  AchievementViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        fun bind()
        {

        }
    }




}
