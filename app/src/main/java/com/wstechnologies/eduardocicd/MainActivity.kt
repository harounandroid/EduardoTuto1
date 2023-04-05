package com.wstechnologies.eduardocicd

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import com.microsoft.appcenter.utils.async.AppCenterConsumer


class MainActivity : AppCompatActivity() {
//    https://github.com/LaloCo/CICDDroid

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        AppCenter.start(
            application, "d6a3653c-8b08-40a4-b0cd-162df8aba7f3",
            Analytics::class.java, Crashes::class.java
        )

        val future=Crashes.hasCrashedInLastSession()
        future.thenAccept(AppCenterConsumer {
            if(it){
                Toast.makeText(this, "Oops! Sorry about that crash!", Toast.LENGTH_LONG).show()
            }
        })


        val edittext = findViewById<EditText>(R.id.edit_name)
        val edit_age = findViewById<EditText>(R.id.edit_age)

        val button = findViewById<Button>(R.id.button)
        val btnTrackEvent = findViewById<Button>(R.id.btnTrackEvent)

        val txt_name = findViewById<TextView>(R.id.txt_name)
        button.setOnClickListener {
            txt_name.text="hello "+edittext.text.toString()+" Hayet1"
            //hayet2
            //hayet3
            //hayet4
            //hayet5
            //hayet6
            //Log.e("this is exception", ""+1/0)
            //Crashes.generateTestCrash()
            //feature 1
            //feature 2.1
            //feature 3.1
            //feature 3.2
            //feature 4
            //new repo ne
            //new repo 1.1
             //new repo 1.2
            //new repo 1.3.1
        }
        btnTrackEvent.setOnClickListener {

            try {

                txt_name.text = ""+ edit_age.text.toString().toInt()

            }catch (e : java.lang.Exception){
                txt_name.text ="error"
                val hashMap:HashMap<String,String> = HashMap<String,String>() //define empty hashmap
                hashMap.put("age",edit_age.text.toString())
                hashMap.put("error_age","true")
                Analytics.trackEvent("error age",hashMap);
            }

        }


    }
}
