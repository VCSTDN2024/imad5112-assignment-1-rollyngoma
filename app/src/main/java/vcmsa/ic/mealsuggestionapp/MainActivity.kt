package com.example.mealsuggestionapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import vcmsa.ic.mealsuggestionapp.R

class MainActivity : AppCompatActivity() {
    // Declare UI elements
    private lateinit var timeInput: EditText
    private lateinit var suggestButton: Button
    private lateinit var resetButton: Button
    private lateinit var mealSuggestionText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI elements
        timeInput = findViewById(R.id.timeInput)
        suggestButton = findViewById(R.id.suggestButton)
        resetButton = findViewById(R.id.resetButton)
        mealSuggestionText = findViewById(R.id.mealSuggestionText)

        // Set up button click listeners
        suggestButton.setOnClickListener {
            suggestMeal()
        }

        resetButton.setOnClickListener {
            resetForm()
        }
    }

    /**
     * Method to get and display meal suggestion based on time of day
     */
    private fun suggestMeal() {
        val timeOfDay = timeInput.text.toString().trim().lowercase()

        if (timeOfDay.isEmpty()) {
            showError("Please enter a time of day")
            return
        }

        // Meal suggestion logic using if statements
        val suggestion = when (timeOfDay) {
            "morning" -> "Eggs with toast and avocado"
            "mid-morning" -> "Fruit salad with yogurt"
            "afternoon" -> "Turkey sandwich with vegetables"
            "mid-afternoon" -> "Chocolate cake with coffee"
            "dinner" -> "Pasta with tomato sauce and parmesan"
            "after dinner" -> "Ice cream with berries"
            else -> {
                showError("Please enter Morning, Mid-morning, Afternoon, Mid-afternoon, Dinner, or After dinner")
                return
            }
        }

        // Display the suggestion
        mealSuggestionText.text = suggestion
    }

    /**
     * Method to reset form fields
     */
    private fun resetForm() {
        timeInput.text.clear()
        mealSuggestionText.text = ""
    }

    /**
     * Method to display error messages
     */
    private fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
