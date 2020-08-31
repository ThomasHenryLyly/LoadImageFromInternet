package teo.android.loadimagefrominternet

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import teo.android.loadimagefrominternet.asynctask.LoadImageFromInternet

//https://stackoverflow.com/questions/55570990/kotlin-call-a-function-every-second/55571042

class MainActivity : AppCompatActivity() {

    companion object{
        val TAG: String = MainActivity::class.java.simpleName
    }

    lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listImage = listOf<String>(
                "https://johncodeos.com/wp-content/uploads/2019/08/customprogressdialogandroidtutorial.png",
                "https://i.ytimg.com/vi/1P-JiNtobOc/maxresdefault.jpg",
                "https://miro.medium.com/max/359/1*iwXb0ccWhxQWf8BdZ-Jp2w.jpeg",
                "https://static.toiimg.com/thumb/msid-67586673,width-800,height-600,resizemode-75,imgsize-3918697,pt-32,y_pad-40/67586673.jpg"

        )




        handler = Handler()

        val runnable = object : Runnable {
            override fun run() {
                val random: String = listImage.random()
                Log.d(TAG, random)
                val task = LoadImageFromInternet(this@MainActivity, imgHinh)
                task.execute(random)
                handler.postDelayed(this, 5000)
            }

        }

        handler.post(runnable)
    }



}
