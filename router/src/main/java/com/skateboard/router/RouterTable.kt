package com.skateboard.router

import android.support.v4.util.ArrayMap


interface RouterTable
{
    fun putRouteClass(routableMap: ArrayMap<String, Class<*>>)
}