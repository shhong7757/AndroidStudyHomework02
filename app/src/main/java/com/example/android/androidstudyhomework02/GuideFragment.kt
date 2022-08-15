package com.example.android.androidstudyhomework02

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.android.androidstudyhomework02.adapters.GuidePagerAdapter
import com.example.android.androidstudyhomework02.databinding.FragmentGuideBinding
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class GuideFragment : Fragment() {

    private var _binding: FragmentGuideBinding? = null

    private val binding get() = _binding!!

    private lateinit var pager: ViewPager2
    private lateinit var pagerIndicator: DotsIndicator
    private lateinit var skipButton: Button
    private lateinit var signUpButton: Button
    private lateinit var logInButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGuideBinding.inflate(inflater, container, false)
        val root: View = binding.root

        pager = binding.guidePager
        pagerIndicator = binding.guidePagerIndicator
        skipButton = binding.guideLayoutSkipButton
        signUpButton = binding.guideLayoutSignUpButton
        logInButton = binding.guideLayoutLogInButton

        val pagerAdapter = GuidePagerAdapter(parentFragmentManager, lifecycle)
        pager.adapter = pagerAdapter

        pagerIndicator.attachTo(pager)

        pager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when(position){
                    2 -> {
                        logInButton.visibility = View.VISIBLE
                        skipButton.visibility = View.INVISIBLE
                        signUpButton.visibility = View.VISIBLE
                    }
                    else -> {
                        logInButton.visibility = View.INVISIBLE
                        skipButton.visibility = View.VISIBLE
                        signUpButton.visibility = View.INVISIBLE
                    }
                }
            }
        })

        skipButton.setOnClickListener {
            pager.currentItem = 2
        }

        signUpButton.setOnClickListener {
            findNavController().navigate(R.id.action_guideFragment_to_signUpFragment)
        }

        logInButton.setOnClickListener {
            findNavController().navigate(R.id.action_guideFragment_to_logInFragment)
        }

        return root
    }
}