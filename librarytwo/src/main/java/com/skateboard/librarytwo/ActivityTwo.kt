package com.skateboard.librarytwo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.skateboard.routerannoation.Route

@Route("librarytwo")
class ActivityTwo:AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

    }
}