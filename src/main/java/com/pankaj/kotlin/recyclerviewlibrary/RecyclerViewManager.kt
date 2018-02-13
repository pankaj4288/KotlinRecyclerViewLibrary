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
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.pankaj.kotlin.recyclerviewlibrary.adapter.RecyclerViewAdapter
import com.pankaj.kotlin.recyclerviewlibrary.interfaces.RecylerViewCallbackInterface

class RecyclerViewManager() {

    var padding: IntArray = intArrayOf(5, 5, 5, 5)
    var margin: IntArray = intArrayOf(5, 5, 5, 5)
    var adap: RecyclerViewAdapter? = null

    fun setCardPadding(left: Int, top: Int, right: Int, botton: Int) {
        padding[0] = left
        padding[1] = top
        padding[2] = right
        padding[3] = botton
    }

    fun setCardMargin(left: Int, top: Int, right: Int, botton: Int) {
        margin[0] = left
        margin[1] = top
        margin[2] = right
        margin[3] = botton
    }

    fun showListView(context: Context, callback: RecylerViewCallbackInterface, list: RecyclerView?, lists:
    ArrayList<String>) {
        list!!.layoutManager = LinearLayoutManager(context)
        adap = RecyclerViewAdapter(context, callback, lists, margin, padding)
        list.adapter = adap
    }

    fun notifyDataSetChanged(lists:
                             ArrayList<String>) {
        adap!!.updatedList(lists)
    }
}