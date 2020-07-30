package com.ohho.ui.view.upcoming

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.ohho.R
import com.ohho.data.network.api.response.HomePageResponse
import com.ohho.data.network.api.response.UpcomingResponse
import kotlinx.android.synthetic.main.layout_upcoming_item.view.*
import kotlinx.android.synthetic.main.layout_user_item.view.*
import kotlinx.android.synthetic.main.layout_user_item.view.from
import kotlinx.android.synthetic.main.layout_user_item.view.to
import kotlinx.android.synthetic.main.layout_user_item.view.type
import kotlin.to


typealias upcoming = (UpcomingResponse.Re) -> Unit

class UpcomingListAdapter(val upcomingResponse: upcoming) :
    RecyclerView.Adapter<UpcomingListAdapter.CategoryHolder>() {

    val upComingList = mutableListOf<UpcomingResponse.Re>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        return CategoryHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_upcoming_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = upComingList.size

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.bindUi(position)
    }

    fun addUpcomingList(_categoryList: List<UpcomingResponse.Re>) {
        upComingList.addAll(_categoryList)
        notifyDataSetChanged()
    }

    inner class CategoryHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bindUi(position: Int) {
            view.apply {
                upComingList[position].let { _category ->
                    upfrom.text = _category.start_place
                    upto.text = _category.end_place
                    uptype.text= _category.type

                    upcomingUserName.text = _category.driver_name
                    upcomingMobileNumber.text = _category.driver_mobile.toString()


                    upstaus_txt.text = _category.status

                    if (_category.status.equals("in-trip"))
                    {

                        upstaus.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.ic_intripe) );
                    }
                    else{

                        upstaus.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.ic_cat_shape) );
                    }
                    setOnClickListener {    upcomingResponse.invoke(_category) }


                    }
                }
            }
        }


}