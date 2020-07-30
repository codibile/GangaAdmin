package com.ohho.ui.view.verifymobile

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
import com.ohho.data.network.api.request.RequVerifyMobileNumber
import com.ohho.data.network.viewmodel.MobileNumberValidationViewModel
import com.ohho.data.network.viewmodel.OtpVerificationViewModel
import com.ohho.utility.applySpanPo
import kotlinx.android.synthetic.main.fragment_verify_mobile_no.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class VerifyMobileNoFragment : Fragment(),LifecycleObserver {
    private val otpVerificationViewModel by viewModel<OtpVerificationViewModel>()
var mobileNumber : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
lifecycle.addObserver(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_verify_mobile_no, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvResendOtp.applySpanPo(
            getString(R.string.label_didn_t_receive_sms),"?"+ " "+
            getString(R.string.label_resend_code),
            R.color.app_color
        )

        PreferenceManager(requireContext()).apply {

            mobileNumber = getMobileNumber()
        }
        btnVerify.setOnClickListener {
otpVerificationResult()

        }
    }

    private fun otpVerificationResult() {
        otpVerificationViewModel.getOtpResult(RequVerifyMobileNumber(mobileNumber,OptEts.text.toString()),{

            Toast.makeText(requireContext(),it.msg, Toast.LENGTH_LONG).show()
            if(it.userid.equals("0"))
            {
                findNavController().navigate(R.id.createUserFragment)

            }
            else
            {
                PreferenceManager(requireContext()).apply {
                    setUserId(it.userid)
                    findNavController().navigate(R.id.homePageFragment)
                }

            }

        },{

            Toast.makeText(requireContext(),it,Toast.LENGTH_LONG).show()
        })
    }


}
