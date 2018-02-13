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
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pankaj.kotlin.recyclerviewlibrary.R
import com.pankaj.kotlin.recyclerviewlibrary.interfaces.RecylerViewCallbackInterface
import kotlinx.android.synthetic.main.item_layout.view.*

class RecyclerViewAdapter(var context: Context, var callback: RecylerViewCallbackInterface, var lists:
ArrayList<String>, var margin: IntArray, var padding: IntArray) : RecyclerView
.Adapter<RecyclerViewAdapter.ViewHolder>() {

    var color = 0

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
        holder!!.cardView.setContentPadding(padding[0], padding[1], padding[2], padding[3])
        val layoutParams = holder!!.itemView.card_view.getLayoutParams() as ViewGroup.MarginLayoutParams
        layoutParams.setMargins(margin[0], margin[1], margin[2], margin[3])
        holder!!.cardView.requestLayout()
    }

    fun updatedList(lists: ArrayList<String>) {
        this.lists = lists
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.textView
        var cardView = view.card_view
    }
}


