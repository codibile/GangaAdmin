package com.ohho.ui.view.homepage

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleObserver
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.mespace.data.preference.PreferenceManager

import com.ohho.R
import com.ohho.data.network.api.request.BookingRequest
import com.ohho.data.network.api.request.RequBook
import com.ohho.data.network.api.request.RequRouteDetails
import com.ohho.data.network.api.response.HomePageResponse
import com.ohho.data.network.api.response.RouteResponse
import com.ohho.data.network.viewmodel.HomePageViewModel
import kotlinx.android.synthetic.main.fragment_home_page.*
import kotlinx.android.synthetic.main.fragment_route_details_list_dialog.*
import kotlinx.android.synthetic.main.fragment_route_details_list_dialog.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomePageFragment() : Fragment(), LifecycleObserver {
    private val homePageViewModel by viewModel<HomePageViewModel>()

var userid :String = ""
    var vehlicleid :String = ""
    var routeid :String = ""

    var stopId :String = ""
    var amount :String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        PreferenceManager(requireContext()).apply {

            userid = getUserId()
        }
        user_list.adapter = VehicleListAdapter { _category ->
            _category.carid
            vehlicleid = _category.carid.toString()
            getRouteDetails(_category.carid,_category)

        }
        hmenu.setOnClickListener {

            findNavController().navigate(R.id.upcomingFragment)
        }
        getVehileDetails()


    }

    private fun getRouteDetails(
        carid: Int,
        _category: HomePageResponse.Re
    ) {
      homePageViewModel.getRouteDetails(RequRouteDetails(carid = carid.toString()),{
          println("List_of_Vehicle" + " " + it)

         routeid = it.trip_route.toString()
          showBottomSheetDialog(requireContext(),it,_category.status,_category.type)
      },{
          println("List_of_Vehicle" + " " + it)

      })
    }

    private fun getVehileDetails() {
        homePageViewModel.getAvailableVehicle({


            println("List_of_Vehicle" + " " + it.res)

            (user_list.adapter as VehicleListAdapter).addCategoryList(it.res)

        }, {

            println("List_of_Vehicle" + " " + it)
        })

    }


    private fun showBottomSheetDialog(context: Context,
        category: RouteResponse,
        status: String,
        type: String
    ) {
        val view = layoutInflater.inflate(R.layout.fragment_route_details_list_dialog, null)
        val dialog = BottomSheetDialog(context)
        dialog.setContentView(view)
        view.rdtype.text= type
        view.rdtvstaus.text = status
        if (status.equals("in-trip"))
        {

            view.rdstaus.setBackgroundDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_intripe) );
        }
        else{

            view.rdstaus.setBackgroundDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_cat_shape) );
        }

        view.no_of_seats.text = category.seat_available.toString()
        view.rvroutelist.adapter =  RouteListAdapter { _category ->

            view.bottom_txt.visibility = View.VISIBLE
            view.rdprice.text = "₹"+" "+ _category.amount.toString()
           stopId =  _category.id.toString()
            amount =_category.amount.toString()
        }

        (view.rvroutelist.adapter as RouteListAdapter).addCategoryList(category.res)
        view.rdbook.setOnClickListener {
            bookingaCar()
        }
        dialog.show()
    }

    private fun bookingaCar() {
        homePageViewModel.BookaNewTrip(

            BookingRequest(
                userid = userid,
                vehicleid =vehlicleid,
                routeid = routeid,
                route_stop = stopId,
                amount = amount

            ),{

                Toast.makeText(requireContext(),it.msg, Toast.LENGTH_LONG).show()

            },{

                Toast.makeText(requireContext(),it, Toast.LENGTH_LONG).show()

            })
    }

    private fun showDialog() {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.menu_home)
        val body = dialog.findViewById(R.id.upcoming) as TextView

        body.setOnClickListener {

            findNavController().navigate(R.id.upcomingFragment)

            dialog.dismiss()
        }
        dialog.show()

    }


}
