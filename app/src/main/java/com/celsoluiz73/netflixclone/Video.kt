package com.celsoluiz73.netflixclone

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.celsoluiz73.netflixclone.databinding.ActivityVideoBinding

class Video : AppCompatActivity() {

    private lateinit var binding: ActivityVideoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        val videoUrl = Uri.parse("https://firebasestorage.googleapis.com/v0/b/netflix-clone-fcf03.appspot.com/o/THE%20WITCHER%20_%20TRAILER%20FINAL%20_%20NETFLIX.mp4?alt=media&token=ff6991ae-eca0-405e-9877-de33cafa6800")

        val video = binding.video
        video.setMediaController(MediaController(this))
        video.setVideoURI(videoUrl)
        video.requestFocus()
        video.start()

    }
}