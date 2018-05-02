package com.skateboard.librarytwo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.skateboard.routerannoation.Route

@Route("librarytwofragment")
class LibraryTwoFragment:Fragment()
{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        return inflater.inflate(R.layout.fragment_layout,container,false)
    }
}