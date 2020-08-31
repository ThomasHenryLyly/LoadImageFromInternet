package teo.android.loadimagefrominternet.extensions

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast

fun Context.showProgressDialog(process: ProgressDialog,title:String = "", msg: String = "", flag: Boolean = false){

    if (flag)
    {
        process.setTitle(title)
        process.setMessage(msg)
        process.show()
    }else{
        Toast.makeText(this, "End", Toast.LENGTH_SHORT).show()
        process.cancel()
    }
}