package com.sample.source_code_sdk.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.sample.source_code_sdk.databinding.FragmentDetailsBinding
import com.sample.source_code_sdk.views.viemwodel.MainBaseViewModel

class DetailsFragment : Fragment() {

    private val binding by lazy {
        FragmentDetailsBinding.inflate(layoutInflater)
    }

    private val viewModel:MainBaseViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        viewModel.selectedItem.observe(viewLifecycleOwner) {
            binding.tvTitle.text = it.name
            binding.tvDscr.text = it.description
            Glide.with(this).load(it.imageUrl).into(binding.ivLogo)
        }

        return binding.root
    }
}