package com.skateboard.router

class Router
{


    companion object
    {

        fun register(moduleName: String): RouterConfiguration
        {
            val routerConfiguration = RouterConfiguration()
            routerConfiguration.register(moduleName)
            return routerConfiguration
        }

    }
}