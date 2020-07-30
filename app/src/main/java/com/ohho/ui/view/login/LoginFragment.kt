package com.ohho.ui.view.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LifecycleObserver
import androidx.navigation.fragment.findNavController
import com.mespace.data.preference.PreferenceManager

import com.ohho.R
import com.ohho.data.network.api.request.RequMobileNumberValidation
import com.ohho.data.network.viewmodel.MobileNumberValidationViewModel
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoginFragment : Fragment(),LifecycleObserver {

    private val mobileNumberValidationViewModel by viewModel<MobileNumberValidationViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
lifecycle.addObserver(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnContinue.setOnClickListener {
            if (!mobile_no.text.toString().trim().equals("")) {
                getmobileValidation()
            }
            else
            {
                Toast.makeText(requireContext(),"Enter the valid mobile no",Toast.LENGTH_LONG).show()

            }

        }
    }

    private fun getmobileValidation() {
        mobileNumberValidationViewModel.getHomePageList((
                RequMobileNumberValidation(
                    mobile_no.text.toString().trim())

                ),{
            Toast.makeText(requireContext(),it.msg,Toast.LENGTH_LONG).show()
            PreferenceManager(requireContext()).apply {
                setMobileNumber(mobile_no.text.toString().trim())

            }
            findNavController().navigate(R.id.verifyMobileNoFragment)

        },{

            Toast.makeText(requireContext(),it,Toast.LENGTH_LONG).show()

        })
    }

}
