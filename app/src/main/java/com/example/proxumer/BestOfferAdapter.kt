package com.cp.overlayimageactionbar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proxumer.R
import kotlinx.android.synthetic.main.item_best_offer.view.*
import kotlinx.android.synthetic.main.item_home_goal.view.*
import kotlinx.android.synthetic.main.item_home_goal.view.item


/**
 * Created by Admin on 14/5/2560.
 */

open class BestOfferAdapter(itemWidth : Int) : RecyclerView.Adapter<BestOfferAdapter.BestOfferViewHolder>()
{
    var width = itemWidth

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestOfferViewHolder
    {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_best_offer, parent, false)
        return BestOfferViewHolder( view )
    }

    override fun onBindViewHolder(holder: BestOfferViewHolder, position: Int)
    {
        holder.bind(width)
    }

    override fun getItemCount(): Int
    {
        return 6
    }


    open class  BestOfferViewHolder(itemView: View ) : RecyclerView.ViewHolder(itemView)
    {
        fun bind(width : Int)
        {
            itemView.item.layoutParams.width = width
            Glide.with(itemView.context)
                .load("https://scontent.fbkk12-4.fna.fbcdn.net/v/t1.0-9/107544156_3431621060259315_878990023008684388_o.jpg?_nc_cat=" +
                        "103&_nc_sid=730e14&_nc_eui2=AeHEwCIaGFJerPvE9WAS0NkE0CkhFaA9NcXQKSEVoD01xf0LNXbqHhPd_" +
                        "SKYdJuP_28&_nc_ohc=5VarxnvZxd4AX_0KuKl&_nc_ht=scontent.fbkk12-4.fna&oh=c1e16830568a87ed9e358273c861458e&oe=5FB61EF9")
                .into(itemView.photo)
        }
    }




}
