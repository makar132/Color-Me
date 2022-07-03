package com.example.colorme

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.colorme.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var boxes: List<View>
    lateinit var colors: List<Int>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {

            boxes = listOf(boxOne, boxTwo, boxThree, boxFour, boxFive)
        }
        colors = listOf(
            Color.GRAY,
            Color.BLUE,
            Color.MAGENTA,
            Color.GREEN,
            Color.RED,
            Color.YELLOW,
            Color.CYAN,
            Color.BLACK,
            Color.DKGRAY,
            Color.parseColor("#FF00FF"),
            Color.parseColor("#FFBB86FC"),
            Color.parseColor("#FF6200EE"),
            Color.parseColor("#FF3700B3"),
            Color.parseColor("#008577"),
            Color.parseColor("#00574B"),
            Color.parseColor("#003342"),
            Color.parseColor("#D81B60")
        )

        setListeners()

    }

    private fun setListeners() {
        binding.apply {
            val clickableViews: List<View> =
                listOf(
                    layout,
                    boxOne,
                    boxTwo,
                    boxThree,
                    boxFour,
                    boxFive,
                    redButton,
                    yellowButton,
                    greenButton
                )

            for (item in clickableViews) {
                item.setOnClickListener { makeColored(it) }
            }
        }

    }

    private fun makeColored(it: View) {
        binding.apply {
            when (it) {

                // Boxes using Color class colors for background

                boxOne -> it.setBackgroundColor(colors[Random.nextInt(colors.size)])
                boxTwo -> it.setBackgroundColor(colors[(colors.indices).random()])

                // Boxes using Android color resources for background
                boxThree -> it.setBackgroundResource(android.R.color.holo_green_light)
                boxFour -> it.setBackgroundResource(android.R.color.holo_green_dark)
                boxFive -> it.setBackgroundResource(android.R.color.holo_green_light)

                // Boxes using custom colors for background
                redButton -> for (box in boxes) {
                    box.setBackgroundResource(R.color.my_red)
                }

                yellowButton -> for (box in boxes) {
                    box.setBackgroundResource(R.color.my_yellow)
                }
                greenButton -> for (box in boxes) {
                    box.setBackgroundResource(R.color.my_green)
                }

                else -> it.setBackgroundColor(Color.LTGRAY)
            }
        }

    }
}