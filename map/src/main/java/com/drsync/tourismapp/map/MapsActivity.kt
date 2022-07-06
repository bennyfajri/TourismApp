package com.drsync.tourismapp.map

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.drsync.tourismapp.core.data.Resource
import com.drsync.tourismapp.map.databinding.ActivityMapsBinding
import org.koin.core.context.loadKoinModules
import org.koin.android.viewmodel.ext.android.viewModel

class MapsActivity : AppCompatActivity() {

    private val viewModel: MapsViewModel by viewModel()
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadKoinModules(mapsModule)

        supportActionBar?.title = "Tourism Map"

        getTourismData()
    }

    private fun getTourismData() {
        viewModel.tourism.observe(this){ tourism ->
            if(tourism != null){
                when(tourism){
                    is Resource.Loading -> binding.progressBar.isVisible = true
                    is Resource.Success -> {
                        binding.progressBar.isVisible = false
                        binding.tvMaps.text = "This is map of ${tourism.data?.get(0)?.name}"
                    }
                    is Resource.Error -> {
                        binding.progressBar.isVisible = false
                        binding.tvError.isVisible = true
                        binding.tvError.text = tourism.message
                    }
                }
            }
        }
    }
}