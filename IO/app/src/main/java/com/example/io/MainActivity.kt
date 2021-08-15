package com.example.io

import android.app.Activity
import android.os.Bundle
import android.os.FileUtils
import java.io.File

class MainActivity : Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val file = File("")
        file.copyTo()
        FileUtils.copy()
    }
}