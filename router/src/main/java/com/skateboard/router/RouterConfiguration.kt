package com.skateboard.router

import android.support.v4.util.ArrayMap


class RouterConfiguration
{
    companion object
    {
        val classMap = ArrayMap<String, Class<*>>()
    }

    fun register(moduleName: String)
    {
//        val className = Constants.PACKAGE_NAME + Constants.DOT + Constants.ROUTE_TABLE
//
//        val cla = Class.forName(className)
//
//        val routerTable=cla.newInstance() as RouterTable
//
//        routerTable.putRouteClass(classMap)

    }


}