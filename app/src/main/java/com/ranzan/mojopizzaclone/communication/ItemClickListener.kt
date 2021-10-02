package com.ranzan.mojopizzaclone.communication

import com.ranzan.mojopizzaclone.Adapter.All_Model

interface ItemClickListener {
    fun onItemClick(position: Int, all_model: All_Model?)
}