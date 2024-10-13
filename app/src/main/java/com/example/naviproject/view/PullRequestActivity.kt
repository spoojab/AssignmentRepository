package com.example.naviproject.view

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.entity.PullRequestEntity
import com.example.naviproject.R
import com.example.naviproject.adapter.PullRequestAdapter
import com.example.naviproject.databinding.PullRequestRecyclerBinding
import com.example.naviproject.viewmodel.Viewmodel
import com.example.util.ViewStateValue
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class PullRequestActivity : AppCompatActivity() {
    private val viewModel: Viewmodel by viewModels()
    private lateinit var binding: PullRequestRecyclerBinding
    private var adapter: PullRequestAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PullRequestRecyclerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        observeViewModel()
    }

    private fun setUpRecyclerView(list: List<PullRequestEntity>) {
        adapter = PullRequestAdapter()
        binding.recyclerView.let {
            it.adapter = adapter
            it.layoutManager = LinearLayoutManager(this)
        }
        adapter?.setData(list)
    }

    private fun observeViewModel() {
        viewModel.pullRequestFlow.onEach {
           
if(it == ViewStateValue.Failure ) {
Toast.makeText(this, "Unable to load data", Toast.LENGTH_SHORT).show()
} else if(it == ViewStateValue.Idle) {
Toast.makeText(this, "Data will be loaded soon ...", Toast.LENGTH_SHORT).show()
} else if(it ==  ViewStateValue.Loading ) {
Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show()
} else {
setUpRecyclerView(it.value)
}
        }.launchIn(lifecycleScope)
        viewModel.getPullRequestResponse()
    }
}
