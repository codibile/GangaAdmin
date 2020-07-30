package com.ohho.ui.view.createnewuser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import androidx.navigation.fragment.findNavController
import com.mespace.data.preference.PreferenceManager
import com.ohho.R
import com.ohho.data.network.api.request.RequCreateUser
import com.ohho.data.network.viewmodel.MobileNumberValidationViewModel
import com.ohho.data.network.viewmodel.RegisterUserViewModel
import kotlinx.android.synthetic.main.fragment_create_user.*
import kotlinx.android.synthetic.main.fragment_create_user.btnContinue
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
 * A simple [Fragment] subclass.
 */
class CreateUserFragment : Fragment(), LifecycleObserver {
    var selectedSuperStar: String? = null
    var mobileNumber : String = ""
    private val registerUserViewModel by viewModel<RegisterUserViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_user, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        PreferenceManager(requireContext()).apply {

            mobileNumber = getMobileNumber()
        }
        btnContinue.setOnClickListener {

            if (store.isChecked()) {
                selectedSuperStar = store.getText().toString();
            } else if (community.isChecked()) {
                selectedSuperStar = community.getText().toString();
            }

            callRegisterUserApi()
        }

    }

    private fun callRegisterUserApi() {
        registerUserViewModel.getRegisterResponse(RequCreateUser(
            name = etName.text.toString(),
            apartment_name = selectedSuperStar,
            block_no = etblock_no.text.toString(),
            floor_no = etFloor_no.text.toString(),
            flat_no = etFlat_no.text.toString(),
            street_name = et_Street_name.text.toString(),
            area = et_area_name.text.toString(),
            landmark = et_land_mark.text.toString(),
            pincode = et_pin_code.text.toString(),
            mobileno = mobileNumber
        ), {

            Toast.makeText(requireContext(),it.msg,Toast.LENGTH_LONG).show()
            PreferenceManager(requireContext()).apply {
                setUserId(it.userid)

            }
            findNavController().navigate(R.id.homePageFragment)


        }, {

            Toast.makeText(requireContext(),it,Toast.LENGTH_LONG).show()

        })

    }

}
