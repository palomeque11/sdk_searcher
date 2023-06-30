package com.sample.source_code_sdk.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.VisibleForTesting
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.source_code_sdk.databinding.FragmentItemsBinding
import com.sample.source_code_sdk.utils.ResultState
import com.sample.source_code_sdk.views.viemwodel.MainBaseViewModel
import com.sample.source_code_sdk.views.adapter.AppAdapter

class ItemsFragment : Fragment() {

    private val binding by lazy {
        FragmentItemsBinding.inflate(layoutInflater)
    }

    private val viewModel:MainBaseViewModel by activityViewModels()

    @VisibleForTesting
    val appAdapter by lazy {
        AppAdapter {
            viewModel.setSelectedItem(it)
            binding.slidingPaneLayout.openPane()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding.mainFragment.searchChar.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.searchItems(newText)
                return false
            }

        })

        binding.mainFragment.charsRv.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = appAdapter
        }

        viewModel.characters.observe(viewLifecycleOwner) {
            when(it) {
                is ResultState.Loading -> {}
                is ResultState.Success -> {
                    appAdapter.updateItems(it.data)
                }
                is ResultState.Error -> {
                    Toast.makeText(requireContext(), "${it.error.message}", Toast.LENGTH_SHORT).show()
                }
                else -> {}
            }
        }

        return binding.root
    }
}