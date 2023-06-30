package com.sample.source_code_sdk.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.gson.Gson
import com.sample.source_code_sdk.R
import com.sample.source_code_sdk.di.DaggerWrapper
import com.sample.source_code_sdk.di.GenericViewModelFactory
import com.sample.source_code_sdk.utils.AppType
import com.sample.source_code_sdk.views.viemwodel.MainBaseViewModel
import javax.inject.Inject

//@AndroidEntryPoint
class SourceActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: GenericViewModelFactory

    private val viewModel: MainBaseViewModel by lazy{
    ViewModelProvider(this,viewModelFactory)[MainBaseViewModel::class.java]
 }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerWrapper.getComponent()!!.inject(this)
        setContentView(R.layout.activity_source)

        viewModel.appType = intent.getSerializableExtra("APP_TYPE") as AppType

        val host = supportFragmentManager.findFragmentById(R.id.frag_container) as NavHostFragment

        setupActionBarWithNavController(host.navController)
    }
}