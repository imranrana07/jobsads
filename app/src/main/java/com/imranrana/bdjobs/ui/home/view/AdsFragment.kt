package com.imranrana.bdjobs.ui.home.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.eduworld.bdjobs.R
import com.eduworld.bdjobs.databinding.FragmentAdsBinding
import com.imranrana.bdjobs.data.repository.AdsRepository
import com.imranrana.bdjobs.ui.home.adapter.AdsAdapter
import com.imranrana.bdjobs.ui.home.viewmodel.AdsViewModel
import com.imranrana.bdjobs.ui.home.viewmodel.AdsViewModelFactory
import com.imranrana.bdjobs.utils.VISIBILITY_GONE
import com.imranrana.bdjobs.utils.VISIBILITY_VISIBLE
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class AdsFragment : Fragment() {
    private lateinit var binding: FragmentAdsBinding
    private lateinit var adsViewModel: AdsViewModel
    private lateinit var adsRepository: AdsRepository

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentAdsBinding.inflate(LayoutInflater.from(requireContext()),container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adsRepository = AdsRepository()
        adsViewModel = ViewModelProvider(this,AdsViewModelFactory(
            adsRepository
        )).get(AdsViewModel::class.java)
        initData()
    }

    private fun initData() {
        val adapter = AdsAdapter()
        val layoutManager= LinearLayoutManager(requireContext())
        binding.rvAds.layoutManager = layoutManager
        binding.rvAds.adapter = adapter

        adapter.addLoadStateListener {
            when(it.refresh){
                is LoadState.Loading -> {
                    binding.progressBar.visibility = VISIBILITY_VISIBLE
                }
                else -> {
                    binding.progressBar.visibility = VISIBILITY_GONE
                }
            }
        }

        lifecycleScope.launch {
            adsViewModel.getAds().collectLatest {
                adapter.submitData(it)
            }
        }
    }
}