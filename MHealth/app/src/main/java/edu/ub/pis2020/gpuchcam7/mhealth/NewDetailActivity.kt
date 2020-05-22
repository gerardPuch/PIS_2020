package edu.ub.pis2020.gpuchcam7.mhealth

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_new_detail.*

class NewDetailActivity : AppCompatActivity() {

    lateinit var alertDialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_detail)

        alertDialog = SpotsDialog(this)
        alertDialog.show()

        //webView
        webView.settings.javaScriptEnabled = true
        webView.webChromeClient = WebChromeClient()
        webView.webViewClient = object : WebViewClient(){}

        if (intent != null){
            if (!intent.getStringExtra("webURL").isEmpty()){
                webView.loadUrl(intent.getStringExtra("webURL"))
            }
        }
    }
}
