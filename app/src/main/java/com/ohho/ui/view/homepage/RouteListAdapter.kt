package com.ohho.ui.view.homepage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.ohho.R
import com.ohho.data.network.api.response.HomePageResponse
import com.ohho.data.network.api.response.RouteResponse
import kotlinx.android.synthetic.main.layout_route_details.view.*
import kotlinx.android.synthetic.main.layout_user_item.view.*
import kotlin.to


typealias routeList = (RouteResponse.Re) -> Unit

class RouteListAdapter(val categorys: routeList) :
    RecyclerView.Adapter<RouteListAdapter.CategoryHolder>() {

    val RouteList = mutableListOf<RouteResponse.Re>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        return CategoryHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_route_details,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = RouteList.size

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.bindUi(position)
    }

    fun addCategoryList(_categoryList: List<RouteResponse.Re>) {
        println("Working_con"+ " "+ "2")

        RouteList.addAll(_categoryList)
        notifyDataSetChanged()
    }

    inner class CategoryHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bindUi(position: Int) {
            view.apply {
                RouteList[position].let { _category ->
                    if(position==0)
                    {
                        image_view.visibility = View.GONE
                    }
                    else{
                        image_view.visibility = View.VISIBLE
                    }
                    rounded_name.text = _category.location
                    setOnClickListener {    categorys.invoke(_category) }


                }
                }
            }
        }

    }
