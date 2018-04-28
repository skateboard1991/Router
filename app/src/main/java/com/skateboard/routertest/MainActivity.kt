package com.skateboard.routertest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.skateboard.routerannoation.Route

@Route("app","test")
class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
