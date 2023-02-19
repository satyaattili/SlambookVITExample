package com.vit.hellovit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView

class FriendsAdapter(private val items: ArrayList<Friend>, private val context: Context) :
    RecyclerView.Adapter<FriendsAdapter.FriendsViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_friend, parent, false)
        return FriendsViewHolder(view)
    }

    override fun onBindViewHolder(holder: FriendsViewHolder, position: Int) {
        with(holder) {
            with(items[position]) {
                holder.nameTextView.text = items[position].name
                holder.itemView.setOnClickListener {
                    Toast.makeText(
                        holder.itemView.context, "$phone\n$dob\n$hobby",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }


    inner class FriendsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView = itemView.findViewById<AppCompatTextView>(R.id.friendName)
    }

}