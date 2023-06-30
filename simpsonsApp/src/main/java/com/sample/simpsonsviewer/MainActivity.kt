package com.sample.simpsonsviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sample.simpsonsviewer.R
import com.sample.source_code_sdk.MainSdk
import com.sample.source_code_sdk.utils.AppType

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MainSdk.launchApplication(applicationContext, AppType.SIMPSONS)
    }
}