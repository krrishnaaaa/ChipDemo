package com.pcsalt.example.chipdemo

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.pcsalt.example.chipdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val planetList = listOf(
        "Mercury",
        "Venus",
        "Earth",
        "Mars",
        "Jupiter",
        "Saturn",
        "Uranus",
        "Neptune",
        "Pluto"
    )

    private val selectedPlanets = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter(this@MainActivity, R.layout.item_drop_down, planetList)
        binding.tietTags.setAdapter(adapter)

        binding.tietTags.setOnItemClickListener { parent, _, position, _ ->
            val selectedPlanet = parent.getItemAtPosition(position) as String
            if (selectedPlanets.contains(selectedPlanet)) {
                Toast.makeText(
                    this@MainActivity,
                    "You have already selected $selectedPlanet",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                addPlanetChip(selectedPlanet)
            }
        }
    }

    private fun addPlanetChip(planetName: String) {
        selectedPlanets.add(planetName)
        binding.cgTags.addView(getChip(planetName))
    }

    private fun getChip(name: String): Chip {
        return Chip(this@MainActivity).apply {
            text = name
            isCloseIconVisible = true
            setOnCloseIconClickListener {
                selectedPlanets.remove((it as Chip).text)
                (it.parent as ChipGroup).removeView(it)
            }
        }
    }
}