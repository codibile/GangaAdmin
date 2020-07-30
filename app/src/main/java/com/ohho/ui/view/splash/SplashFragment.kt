package com.ohho.ui.view.splash

import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.mespace.data.preference.PreferenceManager

import com.ohho.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 */
class SplashFragment : Fragment(),LifecycleObserver {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (Build.VERSION.SDK_INT >= 21) {
            val window: Window = requireActivity().getWindow()
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = resources.getColor(R.color.app_color)
        }


        lifecycleScope.launch {
            delay(2000)
            PreferenceManager(requireContext()).apply {
                val mobileNumber = getUserId()
                if(mobileNumber .equals(""))
                {
                    findNavController().navigate(R.id.loginFragment)

                }
                else
                {

                    findNavController().navigate(R.id.homePageFragment)

                }

            }
        }

    }
}
