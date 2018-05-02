package com.skateboard.libraryone

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.skateboard.router.Router
import com.skateboard.routerannoation.Route
import kotlinx.android.synthetic.main.activity_one.*

@Route("libraryone")
class ActivityOne : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)
//        startBtn.setOnClickListener {
//
//
//        }
        val fragment=Router.getFragment("librarytwofragment")
        supportFragmentManager.beginTransaction().replace(R.id.container,fragment).commit()
    }


}