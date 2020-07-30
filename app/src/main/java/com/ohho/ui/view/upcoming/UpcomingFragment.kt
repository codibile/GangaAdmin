package com.ohho.ui.view.upcoming

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleObserver
import com.mespace.data.preference.PreferenceManager

import com.ohho.R
import com.ohho.data.network.api.request.RequUpComing
import com.ohho.data.network.viewmodel.UpcomingListViewModel
import com.ohho.ui.view.homepage.VehicleListAdapter
import kotlinx.android.synthetic.main.fragment_home_page.*
import kotlinx.android.synthetic.main.fragment_upcoming.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class UpcomingFragment : Fragment(),LifecycleObserver {
private val upcomingListViewModel by viewModel<UpcomingListViewModel> ()
var userid :String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_upcoming, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        PreferenceManager(requireContext()).apply {

            userid = getUserId()
        }
        upcoming_list.adapter = UpcomingListAdapter { _category ->

        }
        getUpcomingList()
    }

    private fun getUpcomingList() {
        upcomingListViewModel.getUpcomingList(
            RequUpComing(userid = userid),{
                println("Upcoming_list"+" "+ it.res)
                (upcoming_list.adapter as UpcomingListAdapter).addUpcomingList(it.res)

            },{
                println("Upcoming_list"+" "+ it)
            }

        )
    }

}
