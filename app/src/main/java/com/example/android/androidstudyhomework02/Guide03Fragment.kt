package com.example.android.androidstudyhomework02

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.android.androidstudyhomework02.databinding.FragmentGuideItemBinding

class Guide03Fragment : Fragment() {

    private var _binding: FragmentGuideItemBinding? = null

    private val binding get() = _binding!!

    private lateinit var title: TextView
    private lateinit var description: TextView
    private lateinit var image: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGuideItemBinding.inflate(inflater, container, false)
        val root: View = binding.root

        title = binding.guideLayoutTitle
        description = binding.guideLayoutSubscription
        image = binding.guideLayoutImage

        title.setText(R.string.guide_03_title)
        description.setText(R.string.guide_03_description)
        image.setImageResource(R.drawable.guide_image03)

        return root
    }
}