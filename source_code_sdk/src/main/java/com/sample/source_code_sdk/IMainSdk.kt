package com.sample.source_code_sdk

import android.content.Context
import android.content.Intent
import com.sample.source_code_sdk.utils.AppType
import com.sample.source_code_sdk.views.SourceActivity

interface IMainSdk {
    fun launchApplication(context: Context, appType: AppType)
}

object MainSdk : IMainSdk {

    override fun launchApplication(context: Context, appType: AppType) {
        Intent(context, SourceActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            putExtra("APP_TYPE", appType)
            context.startActivity(this)
        }
    }

}