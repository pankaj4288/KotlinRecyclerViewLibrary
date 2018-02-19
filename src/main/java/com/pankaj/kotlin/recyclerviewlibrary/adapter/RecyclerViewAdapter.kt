/**
 * Copyright 2018 Pankaj Kushwaha
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pankaj.kotlin.recyclerviewlibrary.adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.AppCompatButton
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pankaj.kotlin.recyclerviewlibrary.R
import com.pankaj.kotlin.recyclerviewlibrary.interfaces.RecylerViewCallbackInterface
import kotlinx.android.synthetic.main.item_layout.view.*

class RecyclerViewAdapter(var context: Context, var callback: RecylerViewCallbackInterface, var lists:
ArrayList<String>) : RecyclerView
.Adapter<RecyclerViewAdapter.ViewHolder>() {

    var cardBackgroundColor: Int = R.color.cardview_light_background
    var cardTextColor: Int = R.color.primary_material_dark
    var cornerRadius: Float = 0.0f
    var cardElevation: Float = 0.0f
    var margin: IntArray? = null
    var padding: IntArray? = null

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerViewAdapter.ViewHolder? {
        var v = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder!!.title.text = lists[position]
        holder!!.cardView.setOnClickListener { callback.itemClicked(position) }
        holder!!.cardView.setContentPadding(padding!![0], padding!![1], padding!![2], padding!![3])
        holder!!.cardView.setCardBackgroundColor(ContextCompat.getColor(context,cardBackgroundColor!!))
        holder!!.title.setTextColor(ContextCompat.getColor(context,cardTextColor!!))
        holder!!.cardView.radius = cornerRadius
        holder!!.cardView.elevation = cardElevation
        val layoutParams = holder!!.itemView.card_view.getLayoutParams() as ViewGroup.MarginLayoutParams
        layoutParams.setMargins(margin!![0], margin!![1], margin!![2], margin!![3])
        holder!!.cardView.requestLayout()
    }

    fun updatedList(lists: ArrayList<String>) {
        this.lists = lists
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.textView
        var cardView = view.card_view
    }

    fun setBackgroundColor(color: Int) {
        if (color == null) {
            cardBackgroundColor = R.color.cardview_light_background
        }
        cardBackgroundColor = color
    }

    fun setTextColor(color: Int) {
        if (color == null) {
            cardTextColor = R.color.primary_material_dark
        }
        cardTextColor = color
    }

    fun setCardCornerRadius(cornerRadius: Float) {
        this.cornerRadius = cornerRadius
    }

    fun setCardMargin(margin: IntArray) {
        this.margin = margin
    }

    fun setCardPadding(padding: IntArray) {
        this.padding = padding
    }

    fun setElevation(elevation: Float) {
        this.cardElevation = elevation
    }
}


