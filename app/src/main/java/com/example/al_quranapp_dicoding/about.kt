package com.example.al_quranapp_dicoding

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class about : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        val actionbar = supportActionBar
        actionbar!!.title = "Creator"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val imgMe: ImageView = findViewById(R.id.img_item_photo)
        val tImg = "https://scontent-sin2-2.xx.fbcdn.net/v/t1.0-1/p160x160/52354600_2263719893886833_7520461901067714560_n.jpg?_nc_cat=107&_nc_oc=AQnRoCVBqJj8bWvvXUp3oMNaID9h7mWIvDDMoz887DMx_Pxiz5odo1Q8HeebUwn_FGw&_nc_ht=scontent-sin2-2.xx&oh=20eb1487131ffc1f9e5f40c478e4e452&oe=5DDA6523"
        Glide.with(this)
            .load(tImg)
            .apply(RequestOptions())
            .into(imgMe)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}