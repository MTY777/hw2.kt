package com.example.hw2kt

import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.example.hw2kt.databinding.ActivityMainBinding
import kotlin.random.Random


class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private lateinit var binding: ActivityMainBinding
    private val url_image = arrayListOf<String>()
    private val mimeTypeImageList = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addImageList()
        addImageListIncludingMimeType()
        setupListeners()
    }

    private fun setupListeners() {
        binding.btnSumbit.setOnClickListener {
            submitImage()
        }
        binding.btnRandom.setOnClickListener {
            randomImage()
        }
    }

    private fun addImageListIncludingMimeType() {
        mimeTypeImageList.apply {
            add(getString(R.string.mimepng))
            add(getString(R.string.mimesvg))
            add(getString(R.string.mimejpg))
            add(getString(R.string.mimejpeg))
            add(getString(R.string.mimeapng))
            add(getString(R.string.mimeavif))
            add(getString(R.string.mimegif))
            add(getString(R.string.mimeavp))
            add(getString(R.string.mimewebp))
            add(getString(R.string.mimebmp))
            add(getString(R.string.mimeiso))
            add(getString(R.string.mimetiff))
        }
    }

    private fun addImageList() {
        url_image.apply {
            add(getString(R.string.image_one))
            add(getString(R.string.image_two))
            add(getString(R.string.image_three))
            add(getString(R.string.image_fouth))
            add(getString(R.string.image_five))
            add(getString(R.string.image_six))
            add(getString(R.string.image_seven))
            add(getString(R.string.image_eight))
            add(getString(R.string.image_nine))
            add(getString(R.string.image_ten))
        }
    }

    private fun randomImage() {
        val randomButton = Random.nextInt(url_image.size)
        binding.ivRandom.setImage(url_image[randomButton])
    }

    private fun submitImage() {
        val imageLink = binding.etImage.text
        val link = submitImage(Uri.parse(imageLink.toString()))
        if (mimeTypeImageList.contains(link)) {
            binding.ivRandom.setImage(imageLink.toString())
            url_image.add(imageLink.toString())
        } else {
            Toast.makeText(this, getString(R.string.soso), Toast.LENGTH_SHORT).show()
        }
    }

}
