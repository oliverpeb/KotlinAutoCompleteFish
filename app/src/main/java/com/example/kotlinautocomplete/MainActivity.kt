package com.example.kotlinautocomplete

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import com.example.kotlinautocomplete.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val fishNames = arrayOf(
        "bream", "carp", "grayling", "perch", "pike", "pike-perch", "roach",
        "tench", "eel", "sturgeon", "salmon", "trout", "smelt", "rainbow trout", "whitefish",
        "picked dogfish", "shark", "skate", "smooth hound", "anchovy", "herring", "pilchard",
        "sardine", "sardinella", "sprat", "blue ling", "blue whitling", "cod", "greater forkbeard",
        "haddock", "hake", "ling", "pollack", "poor cod",
        "pout", "saithe", "tush", "whiting", "atherine", "bogue", "mullet", "picaral", "scad",
        "sea bream", "surmullet", "chub mackerel", "garfish",
        "mackerel", "swordfish", "albacore tuna", "bonito tuna", "skipjack tuna", "tuna"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        fishNames.sort()
        val adapter = ArrayAdapter(this, R.layout.simple_dropdown_item_1line, fishNames)

        binding.autoCompleteTextViewFish.setAdapter(adapter)

        binding.buttonShow.setOnClickListener {
            val fish = binding.autoCompleteTextViewFish.text.trim()
            if (fish.isEmpty()) {
                binding.autoCompleteTextViewFish.error = "No fish!"
                return@setOnClickListener
            }
            binding.textviewMessage.text = "You caught a $fish"
        }
    }


}