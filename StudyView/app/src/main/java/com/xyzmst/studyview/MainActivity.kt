package com.xyzmst.studyview

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.xyzmst.studyview.activity.DashBoradActivity
import com.xyzmst.studyview.activity.LifeViewActivity
import com.xyzmst.studyview.activity.PieActivity
import com.xyzmst.studyview.activity.XfermodeActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View) {
        when (view.id) {
            //仪表盘
            R.id.dashborad -> {
                startActivity(Intent(this, DashBoradActivity::class.java))
            }
            //饼图
            R.id.pie -> {
                startActivity(Intent(this, PieActivity::class.java))
            }
            R.id.xfermode -> {
                startActivity(Intent(this, XfermodeActivity::class.java))
            }
            R.id.lifeView -> {
                startActivity(Intent(this, LifeViewActivity::class.java))
            }

        }
    }
}