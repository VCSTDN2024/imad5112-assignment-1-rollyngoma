package vcmsa.ic.mealsuggestionapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import vcmsa.ic.mealsuggestionapp.R;

public class MainActivity extends AppCompatActivity {
    // Declare UI elements
    private EditText timeInput;
    private Button suggestButton;
    private Button resetButton;
    private TextView mealSuggestionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        timeInput = findViewById(R.id.timeInput);
        suggestButton = findViewById(R.id.suggestButton);
        resetButton = findViewById(R.id.resetButton);
        mealSuggestionText = findViewById(R.id.mealSuggestionText);

        // Set up button click listeners
        suggestButton.setOnClickListener(view -> suggestMeal());

        resetButton.setOnClickListener(view -> resetForm());
    }


    private void suggestMeal() {
        String timeOfDay = timeInput.getText().toString().trim().toLowerCase();

        if (timeOfDay.isEmpty()) {
            showError("Please enter a time of day");
            return;
        }

        // Meal suggestion logic using if-else statements
        String suggestion;

        if ("morning".equals(timeOfDay)) {
            suggestion = "Eggs with toast and avocado";
        } else if ("mid-morning".equals(timeOfDay)) {
            suggestion = "Fruit salad with yogurt";
        } else if ("afternoon".equals(timeOfDay)) {
            suggestion = "Turkey sandwich with vegetables";
        } else if ("mid-afternoon".equals(timeOfDay)) {
            suggestion = "Chocolate cake with coffee";
        } else if ("dinner".equals(timeOfDay)) {
            suggestion = "Pasta with tomato sauce and parmesan";
        } else if ("after dinner".equals(timeOfDay)) {
            suggestion = "Ice cream with berries";
        } else {
            showError("Please enter Morning, Mid-morning, Afternoon, Mid-afternoon, Dinner, or After dinner");
            return;
        }

        // Display the suggestion
        mealSuggestionText.setText(suggestion);
    }


    private void resetForm() {
        timeInput.setText("");
        mealSuggestionText.setText("");
    }


    private void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}


