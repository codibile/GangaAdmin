package com.ohho.ui.view.homepage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.ohho.R
import com.ohho.data.network.api.response.HomePageResponse
import kotlinx.android.synthetic.main.layout_user_item.view.*
import kotlin.to


typealias category = (HomePageResponse.Re) -> Unit

class VehicleListAdapter(val category: category) :
    RecyclerView.Adapter<VehicleListAdapter.CategoryHolder>() {

    val categoryList = mutableListOf<HomePageResponse.Re>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        return CategoryHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_user_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = categoryList.size

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.bindUi(position)
    }

    fun addCategoryList(_categoryList: List<HomePageResponse.Re>) {
        categoryList.addAll(_categoryList)
        notifyDataSetChanged()
    }

    inner class CategoryHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bindUi(position: Int) {
            view.apply {
                categoryList[position].let { _category ->
                    from.text = _category.start_place
                    to.text = _category.end_place
                    type.text= _category.type
                    tvstaus.text = _category.status

                    if (_category.status.equals("in-trip"))
                    {

                        llstaus.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.ic_intripe) );
                    }
                    else{

                        llstaus.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.ic_cat_shape) );
                    }
                    setOnClickListener {    category.invoke(_category) }


                    }
                }
            }
        }


}