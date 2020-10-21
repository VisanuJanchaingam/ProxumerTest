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

open class SuggestionAdapter(itemWidth : Int) : RecyclerView.Adapter<SuggestionAdapter.SuggestionViewHolder>()
{
    var width = itemWidth

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuggestionViewHolder
    {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_best_offer, parent, false)
        return SuggestionViewHolder( view )
    }

    override fun onBindViewHolder(holder: SuggestionViewHolder, position: Int)
    {
        holder.bind(width)
    }

    override fun getItemCount(): Int
    {
        return 6
    }


    open class  SuggestionViewHolder(itemView: View ) : RecyclerView.ViewHolder(itemView)
    {
        fun bind(width : Int)
        {
            itemView.item.layoutParams.width = width
            Glide.with(itemView.context)
                .load("https://scontent.fbkk9-2.fna.fbcdn.net/v/t1.0-9/62455441_2412521245502640_4589181171480395776_o.jpg?_nc_cat=109&_nc_sid=730e14&_nc_eui2=AeFjkdzCV2Jeon" +
                        "9AJ8VORX5AJjTL3jDdT1wmNMveMN1PXBmN2emDEP21Cb9Jz9emlcI&_nc_ohc=Kh5ftDVgH58AX9VFxT6&_nc_ht=scontent.fbkk9-2.fna&oh=54d9713aaeb386d8f7842acb5dbbc14a&oe=5FB4C3C9")
                .fitCenter()
                .into(itemView.photo)
        }
    }




}
