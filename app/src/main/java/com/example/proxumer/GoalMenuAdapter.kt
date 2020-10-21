package com.cp.overlayimageactionbar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proxumer.R
import kotlinx.android.synthetic.main.item_goal_menu.view.*


/**
 * Created by Admin on 14/5/2560.
 */

class GoalMenuAdapter : RecyclerView.Adapter<GoalMenuAdapter.GoalMenuViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoalMenuViewHolder
    {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_goal_menu, parent, false)
        return GoalMenuViewHolder( view)
    }

    override fun onBindViewHolder(holder: GoalMenuViewHolder, position: Int)
    {

        holder.bind()
    }

    override fun getItemCount(): Int
    {
        return 5
    }


    class  GoalMenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        private var menuName = arrayListOf("travel","education","invest","clothing","education")

        fun bind()
        {
            itemView.tvMenuName.text = menuName[adapterPosition]
        }
    }




}
