package com.cp.overlayimageactionbar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proxumer.R
import kotlinx.android.synthetic.main.item_home_goal.view.*


/**
 * Created by Admin on 14/5/2560.
 */

open class AllGoalsAdapter(itemWidth : Int) : RecyclerView.Adapter<AllGoalsAdapter.AllGoalsViewHolder>()
{
    var width = itemWidth

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllGoalsViewHolder
    {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_home_goal, parent, false)
        return AllGoalsViewHolder( view )
    }

    override fun onBindViewHolder(holder: AllGoalsViewHolder, position: Int)
    {
        holder.bind(width)
    }

    override fun getItemCount(): Int
    {
        return 6
    }


    open class  AllGoalsViewHolder(itemView: View ) : RecyclerView.ViewHolder(itemView)
    {
        fun bind(width : Int)
        {
            itemView.apply {

                if(adapterPosition%2 == 0) {
                    background = context.getDrawable(R.drawable.green_round_cardview)
                    tvStatus.setTextColor(context.getColor(R.color.color_dark_green))
                }
                else{
                    background = context.getDrawable(R.drawable.red_round_cardview)
                    tvStatus.setTextColor(context.getColor(R.color.color_orange))
                }

                layoutParams.width = width
                barChart.percent = 50f
                barChart.radius = 30f
                barChart.startAnimation(1000)
            }


        }
    }




}
