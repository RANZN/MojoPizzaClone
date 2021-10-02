package com.ranzan.mojopizzaclone.Menu

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ranzan.mojopizzaclone.Adapter.All_Model
import com.ranzan.mojopizzaclone.Adapter.MenuAdapter
import com.ranzan.mojopizzaclone.R
import com.ranzan.mojopizzaclone.communication.FragmentListener
import com.ranzan.mojopizzaclone.communication.ItemClickListener
import java.util.*

class All_in_oneFragment : Fragment(), ItemClickListener {
    private var btnBack: ImageView? = null
    private var TvFavorite: ImageView? = null
    private var mTvPredict: TextView? = null
    private var mTvHalfAndHalf: TextView? = null
    private var mTvPartyCombo: TextView? = null
    private var mTvBig_10: TextView? = null
    private var mTvStarters: TextView? = null
    private var mTvGarlicBread: TextView? = null
    private var mTvDesserts: TextView? = null
    private var recyclerView: RecyclerView? = null
    private var searchView: SearchView? = null
    private var all_modelsList = ArrayList<All_Model>()
    private var fragmentListener: FragmentListener? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentListener = context as FragmentListener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_in_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        buildRecyclerViewData()
        setRecyclerviewAdapter()
        scrollTo()
        autoScrollTo()
    }

    private fun autoScrollTo() {
        val bundle = arguments
        if (bundle != null) {
            scrollNum = bundle.getInt("pos")
        }
        when (scrollNum) {
            1 -> recyclerView!!.scrollToPosition(8)
            2 -> recyclerView!!.scrollToPosition(15)
            3 -> recyclerView!!.scrollToPosition(22)
            4 -> recyclerView!!.scrollToPosition(29)
            5 -> recyclerView!!.scrollToPosition(35)
            else -> recyclerView!!.scrollToPosition(0)
        }
    }

    private fun scrollTo() {
        mTvHalfAndHalf!!.setOnClickListener { recyclerView!!.smoothScrollToPosition(0) }
        mTvPartyCombo!!.setOnClickListener { recyclerView!!.smoothScrollToPosition(8) }
        mTvBig_10!!.setOnClickListener { recyclerView!!.smoothScrollToPosition(15) }
        mTvStarters!!.setOnClickListener { recyclerView!!.smoothScrollToPosition(22) }
        mTvGarlicBread!!.setOnClickListener { recyclerView!!.smoothScrollToPosition(29) }
        mTvDesserts!!.setOnClickListener { recyclerView!!.smoothScrollToPosition(35) }
    }

    private fun setRecyclerviewAdapter() {
        val menuAdapter = MenuAdapter(all_modelsList, this)
        val linearLayoutManager = LinearLayoutManager(context)
        recyclerView!!.layoutManager = linearLayoutManager
        recyclerView!!.adapter = menuAdapter
    }

    private fun buildRecyclerViewData() {
        all_modelsList = ArrayList()
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.half_1,
                "$410"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.half_2,
                "$300"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.half_3,
                "$200"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.half_4,
                "$260"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.half_5,
                "$390"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.half_6,
                "$400"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.half_7,
                "$540"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.combo_1,
                "$410"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.combo_2,
                "$300"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.combo_3,
                "$200"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.combo_4,
                "$260"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.combo_5,
                "$390"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.combo_6,
                "$400"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.combo_7,
                "$540"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.big_1,
                "$410"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.big_2,
                "$300"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.big_3,
                "$200"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.big_4,
                "$260"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.big_5,
                "$390"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.big_6,
                "$400"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.big_7,
                "$540"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.starters_1,
                "$410"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.starters_2,
                "$300"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.starters_3,
                "$200"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.starters_4,
                "$260"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.starters_5,
                "$390"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.starters_6,
                "$400"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.starters_7,
                "$540"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.garlic_1,
                "$410"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.garlic_2,
                "$300"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.garlic_3,
                "$200"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.garlic_4,
                "$260"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.garlic_5,
                "$390"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.garlic_6,
                "$400"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.desserts_1,
                "$410"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.desserts_2,
                "$300"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.desserts_3,
                "$200"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.desserts_4,
                "$260"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.desserts_5,
                "$390"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.desserts_6,
                "$400"
            )
        )
        all_modelsList.add(
            All_Model(
                "Half & Half Pizzas",
                "Veg - Non-Veg Half Half",
                "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza",
                "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ",
                R.drawable.desserts_7,
                "$540"
            )
        )
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.all_menu_recyclerView)
        searchView = view.findViewById(R.id.searchBar)
        btnBack = view.findViewById(R.id.btnback)
        TvFavorite = view.findViewById(R.id.btnfavorite)
        mTvPredict = view.findViewById(R.id.predict)
        mTvHalfAndHalf = view.findViewById(R.id.HalfAndHalf)
        mTvPartyCombo = view.findViewById(R.id.partycombo)
        mTvBig_10 = view.findViewById(R.id.Big_10)
        mTvStarters = view.findViewById(R.id.Starters)
        mTvGarlicBread = view.findViewById(R.id.GarlicBread)
        mTvDesserts = view.findViewById(R.id.Desserts)

//        navController = Navigation.findNavController(view);
    }

    fun setFragmentListener(fragmentListener: FragmentListener?) {
        this.fragmentListener = fragmentListener
    }

    override fun onItemClick(position: Int, all_model: All_Model?) {
        val bundle = Bundle()
        bundle.putSerializable("data", all_model)
        fragmentListener!!.fragmentListener(bundle)
        //        PreferenceHelper.writeIntToPreference(getContext(), "ImagePoster", all_model.getPosterImage());
//        PreferenceHelper.writeStringToPreference(getContext(), "ItemName", all_model.getNameOfItem());
//        PreferenceHelper.writeStringToPreference(getContext(), "ItemDetail", all_model.getDetailOfItem_1());
//        PreferenceHelper.writeStringToPreference(getContext(), "ItemDetail_1", all_model.getDetailOfItem());
//        PreferenceHelper.writeStringToPreference(getContext(), "Prize", all_model.getPrize());
//        navController.navigate(R.id.action_all_in_oneFragment_to_detil_ItemFragment, bundle);
//        Detil_ItemFragment fragment = new Detil_ItemFragment();
//        fragment.setArguments(bundle);
//        getFragmentManager().beginTransaction().add(R.id.contaner, fragment).addToBackStack("").commit();
    }

    companion object {
        private var scrollNum = 0
    }
}