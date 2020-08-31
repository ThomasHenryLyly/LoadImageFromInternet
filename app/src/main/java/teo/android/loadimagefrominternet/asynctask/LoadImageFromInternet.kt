package teo.android.loadimagefrominternet.asynctask

import android.app.ProgressDialog
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.widget.ImageView
import teo.android.loadimagefrominternet.MainActivity
import teo.android.loadimagefrominternet.extensions.showProgressDialog
import java.net.URL

open class LoadImageFromInternet(
    val context: Context,
    val imageView: ImageView
) : AsyncTask<String, Void, Bitmap>() {
    val process = ProgressDialog(context)
    override fun onPreExecute() {
        super.onPreExecute()
        context.showProgressDialog(process,"Waitting", "Loading Image", true)
    }

    override fun doInBackground(vararg params: String?): Bitmap? {
        val url = URL(params[0])
        val inputStream = url.openConnection().getInputStream()
        val bitmap = BitmapFactory.decodeStream(inputStream)

        return bitmap
    }

    override fun onPostExecute(result: Bitmap?) {
        super.onPostExecute(result)
        imageView.setImageBitmap(result)
        context.showProgressDialog(process,"","", false)
    }
}