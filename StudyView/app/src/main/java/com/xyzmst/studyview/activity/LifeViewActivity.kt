package com.xyzmst.studyview.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xyzmst.studyview.view.life.AskAndAnswerView

class LifeViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_lifeview)


        setContentView( AskAndAnswerView.Builder(this).build())
    }

}