package com.skateboard.routertest

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.skateboard.router.Router
import com.skateboard.routerannoation.Route
import kotlinx.android.synthetic.main.activity_main.*

@Route("test")
class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startBtn.setOnClickListener {
            Router.goForResult(this@MainActivity,"libraryone",1001)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode== Activity.RESULT_OK)
        {
            Toast.makeText(this,"hehe",Toast.LENGTH_SHORT).show()
        }
    }
}
