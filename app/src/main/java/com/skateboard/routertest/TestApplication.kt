package com.skateboard.routertest

import android.app.Application
import com.skateboard.router.Router

class TestApplication:Application()
{
    override fun onCreate()
    {
        super.onCreate()
        Router.register("app","libraryone","librarytwo")
    }
}