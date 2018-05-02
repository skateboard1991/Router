package com.skateboard.router

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.util.ArrayMap
import com.skateboard.routerannoation.Constants


class Router
{


    companion object
    {

        private val classMap = ArrayMap<String, Class<*>>()


        fun register(vararg moduleNames: String)
        {
            for (moduleName in moduleNames)
            {
                try
                {
                    val cla = Class.forName(Constants.PACKAGE_NAME + Constants.DOT + moduleName + "_" + Constants.ROUTER_TABLE_IMP)

                    val routerTable = cla.newInstance() as RouterTable

                    routerTable.putRouteClass(classMap)
                } catch (e: ClassNotFoundException)
                {
                    e.printStackTrace()
                } catch (e: Exception)
                {
                    e.printStackTrace()
                }
            }

        }


        fun go(context: Context, url: String, extras: Bundle? = null)
        {
            val intent = Intent(context, classMap[url])

            if (extras != null)
            {
                intent.putExtras(extras)
            }

            context.startActivity(intent)
        }

        fun goForResult(context: Context, url: String, requestCode: Int, extras: Bundle? = null)
        {
            val intent = Intent(context, classMap[url])

            if (extras != null)
            {
                intent.putExtras(extras)
            }

            if (context is Activity)
            {
                context.startActivityForResult(intent, requestCode)
            } else if (context is Fragment)
            {
                context.startActivityForResult(intent, requestCode)
            }
        }

        fun getFragment(url: String): Fragment?
        {
            try
            {
                val cla = classMap[url]

                if (cla != null)
                {
                    return cla.newInstance() as Fragment
                } else
                {

                }

            } catch (e: ClassNotFoundException)
            {
                e.printStackTrace()
            } catch (e: Exception)
            {
                e.printStackTrace()
            }
            return null
        }

    }
}