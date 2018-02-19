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
package com.pankaj.kotlin.recyclerviewlibrary

import android.content.Context
import android.os.Build
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.pankaj.kotlin.recyclerviewlibrary.adapter.RecyclerViewAdapter
import com.pankaj.kotlin.recyclerviewlibrary.interfaces.RecylerViewCallbackInterface

class RecyclerViewManager() {

    private var padding: IntArray = intArrayOf(5, 5, 5, 5)
    private var margin: IntArray = intArrayOf(5, 5, 5, 5)
    private var adap: RecyclerViewAdapter? = null

    fun init(context: Context, callback: RecylerViewCallbackInterface,
             lists:
             ArrayList<String>) {
        adap = RecyclerViewAdapter(context, callback, lists)
    }

    fun setCardPadding(left: Int, top: Int, right: Int, botton: Int) {
        padding[0] = left
        padding[1] = top
        padding[2] = right
        padding[3] = botton
        adap!!.setCardPadding(padding)
    }

    fun setCardMargin(left: Int, top: Int, right: Int, botton: Int) {
        margin[0] = left
        margin[1] = top
        margin[2] = right
        margin[3] = botton
        adap!!.setCardMargin(margin)
    }

    fun setTextColor(color: Int) {
        adap!!.setTextColor(color!!)
    }

    fun setCardBackgroundColor(color: Int) {
        adap!!.setBackgroundColor(color!!)
    }

    fun setCardCornerRadius(cornerRadius: Float) {
        adap!!.setCardCornerRadius(cornerRadius)
    }

    fun setElevation(elevation: Float) {
        adap!!.setElevation(elevation)
    }

    fun showListView(context: Context, list: RecyclerView?) {
        list!!.layoutManager = LinearLayoutManager(context) as RecyclerView.LayoutManager?
        list.adapter = adap
        adap!!.notifyDataSetChanged()
    }

    fun showListView(context: Context, list: RecyclerView?, columns: Int) {
        list!!.layoutManager = GridLayoutManager(context, columns) as RecyclerView.LayoutManager?
        list.adapter = adap
        adap!!.notifyDataSetChanged()
    }

    fun notifyUpdates() {
        adap!!.notifyDataSetChanged()
    }

    fun updateList(lists:
                   ArrayList<String>) {
        adap!!.updatedList(lists)
    }
}