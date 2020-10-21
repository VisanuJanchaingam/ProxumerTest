package com.cp.overlayimageactionbar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proxumer.R
import kotlinx.android.synthetic.main.item_bottom_tab.view.*
import kotlinx.android.synthetic.main.item_home_goal.view.*
import kotlinx.android.synthetic.main.item_home_goal.view.item


/**
 * Created by Admin on 14/5/2560.
 */

class BottomTabAdapter(itemWidth : Int ,  listener: OnClickMenuListener) : RecyclerView.Adapter<BottomTabAdapter.BottomTabViewHolder>()
{
    companion object{
        var numberOfBadge = 0
    }
    var callback =  listener
    var width = itemWidth
    var selectedPost = 0

    interface OnClickMenuListener
    {
        fun onClick( position: Int )
    }

    fun selectTab(pos : Int)
    {
        selectedPost = pos
        notifyDataSetChanged()
    }
    fun updateBadge(num : Int)
    {
        numberOfBadge = num
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottomTabViewHolder
    {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_bottom_tab, parent, false)
        return BottomTabViewHolder( view)
    }

    override fun onBindViewHolder(holder: BottomTabViewHolder, position: Int)
    {

        holder.bind(width,callback,selectedPost)
    }

    override fun getItemCount(): Int
    {
        return 4
    }


    class BottomTabViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        fun bind(width : Int ,listener: OnClickMenuListener,selectedPost : Int )
        {
            itemView.apply {
                item.layoutParams.width = width
                item.setOnClickListener {
                    listener.onClick(adapterPosition)
                }



                if(adapterPosition==3){
                    badge.visibility = View.VISIBLE
                    tvNumberOfBadge.text = numberOfBadge.toString()
                }
                else
                    badge.visibility = View.GONE


                if(adapterPosition == selectedPost)
                    imgMenu.setColorFilter(context.getColor(R.color.color_orange))
                else
                    imgMenu.setColorFilter(context.getColor(R.color.color_grey))

            }

        }
    }





}
