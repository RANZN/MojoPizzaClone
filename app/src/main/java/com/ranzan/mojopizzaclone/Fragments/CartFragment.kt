package com.ranzan.mojopizzaclone.Fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ranzan.mojopizzaclone.Adapter.All_Model
import com.ranzan.mojopizzaclone.Adapter.CartAdapter
import com.ranzan.mojopizzaclone.Adapter.CartModel
import com.ranzan.mojopizzaclone.R
import com.ranzan.mojopizzaclone.communication.ItemClickListener
import java.util.*

class CartFragment : Fragment(), ItemClickListener {
    private var recyclerView: RecyclerView? = null
    private var cartModelsList: ArrayList<CartModel>? = ArrayList()
    private var cartAdapter: CartAdapter? = null
    private var tvTotal: TextView? = null
    private var btn: Button? = null
    private var total = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    private fun loadData() {
        val sharedPreferences =
            requireContext().getSharedPreferences("shared preferences", Context.MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString("dataList", null)
        val type = object : TypeToken<ArrayList<CartModel?>?>() {}.type
        if (cartModelsList == null) {
            cartModelsList = ArrayList()
        } else if (gson.fromJson<Any?>(json, type) != null) cartModelsList!!.addAll(
            gson.fromJson(
                json,
                type
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        setCartAdapter()
        loadData()
        cartAdapter!!.updateUI(cartModelsList!!)
        setTotalAmount()
    }

    fun setTotalAmount() {
        for (i in cartModelsList!!) {
            val s = i.all_model.price
            val n = s.substring(1).toInt()
            total += n
        }
        tvTotal!!.text = "$ $total"
    }

    private fun setCartAdapter() {
        cartAdapter = CartAdapter(cartModelsList!!, this)
        val linearLayoutManager = LinearLayoutManager(context)
        recyclerView!!.layoutManager = linearLayoutManager
        recyclerView!!.adapter = cartAdapter
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.CartRecyclerView)
        tvTotal = view.findViewById(R.id.cartTotalPrice)
        tvTotal = view.findViewById(R.id.cartTotalPrice)
        btn = view.findViewById(R.id.cartOrderBtn)
    }

    override fun onItemClick(position: Int, all_model: All_Model?) {
        cartModelsList!!.removeAt(position)
        cartAdapter!!.updateUI(cartModelsList!!)
        setTotalAmount()
        addDataToPreference()
    }

    private fun addDataToPreference() {
        val sharedPreferences =
            requireContext()!!.getSharedPreferences("shared preferences", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val json = gson.toJson(cartModelsList)
        editor.putString("dataList", json)
        editor.apply()
    }
}