# Router
使用方法:
导入module ':router', ':processor', ':routerannoation'
在需要使用的项目gradle文件里，添加
    apply plugin: 'kotlin-kapt'
    
    
     defaultConfig {
        minSdkVersion 15
        targetSdkVersion 27
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
        kapt {
            arguments {
                //module name，会传入注解解释器
                arg("moduleName", project.name)
            }
        }
         kapt project(':processor')
        api project(':router')
        
      
在application里

    //注册module name
    Router.register("app","libraryone","librarytwo")
    
在Activity或者fragment里添加注解

     @Route("url")
    class MainActivity : AppCompatActivity()
    {
    
    }
    
Router提供的方法

    fun go(fragment: Fragment,url: String, extras: Bundle? = null) //类似startActivity
    fun goForResult(context: Context, url: String, requestCode: Int, extras: Bundle? = null)  //类似startActivityForResult
    fun getFragment(url: String): Fragment?  //得到fragment
    
    
        
