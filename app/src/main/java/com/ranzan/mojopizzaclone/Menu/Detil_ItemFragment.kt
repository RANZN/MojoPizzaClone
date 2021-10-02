package com.ranzan.mojopizzaclone.Menu

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.ranzan.mojopizzaclone.Adapter.All_Model
import com.ranzan.mojopizzaclone.Adapter.CartModel
import com.ranzan.mojopizzaclone.R
import java.util.*

class Detil_ItemFragment : Fragment() {
    private var mTv_Show_Image_Poster: ImageView? = null
    private lateinit var closeBtn: ImageView
    private var mTv_Show_Name: TextView? = null
    private var mTv_Show_Detail: TextView? = null
    private var mTv_Show_Price: TextView? = null
    private var mBtnAddToCart: Button? = null
    private var mBtnMoreInfo: TextView? = null
    private var all_model: All_Model? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
        if (arguments != null) {
            all_model = requireArguments()!!.getSerializable("data") as All_Model?

        }
        if (all_model != null) {
            mTv_Show_Image_Poster!!.setImageResource(all_model!!.posterImage)
            mTv_Show_Name!!.text = all_model!!.nameOfItem
            mTv_Show_Price!!.text = all_model!!.price
            mTv_Show_Detail!!.text = all_model!!.detailOfItem
        }


//        mBtnMoreInfo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getContext(), Item_Detail_Activity.class);
//                startActivity(intent);
//            }
//        });
        mBtnAddToCart!!.setOnClickListener {
            cartList.add(CartModel(all_model!!, 1))
            addDataToPreference()
            Toast.makeText(context, "Added to Cart", Toast.LENGTH_SHORT).show()
        }
    }

    private fun addDataToPreference() {
        val sharedPreferences =
            requireContext()!!.getSharedPreferences("shared preferences", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val json = gson.toJson(cartList)
        editor.putString("dataList", json)
        editor.apply()
    }

    private fun initView(view: View) {
        mTv_Show_Name = view.findViewById(R.id.Trans_Tv_Show_Name)
        mTv_Show_Image_Poster = view.findViewById(R.id.Trans_Poster_Image)
        mTv_Show_Detail = view.findViewById(R.id.Trans_Tv_Show_Detail)
        mTv_Show_Price = view.findViewById(R.id.Trans_Tv_Show_Prize)
        mBtnAddToCart = view.findViewById(R.id.Trans_Btn_addToCart)
        mBtnMoreInfo = view.findViewById(R.id.Btnmoreinfo)
        closeBtn = view.findViewById(R.id.closeBtn)
        closeBtn.setOnClickListener(View.OnClickListener { requireActivity()!!.fragmentManager.popBackStack() })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detil__item, container, false)
    }

    companion object {
        private val cartList = ArrayList<CartModel>()
    }
}