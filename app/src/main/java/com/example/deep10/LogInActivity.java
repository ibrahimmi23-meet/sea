package com.example.deep10;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogInActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;

    private FirebaseAuth database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        // Initialize Firebase
        database = FirebaseAuth.getInstance();

        // Find views
        emailEditText = findViewById(R.id.editTextEmailLogin);
        passwordEditText = findViewById(R.id.editTextPasswordLogin);
        loginButton = findViewById(R.id.buttonLogin);

        // Set up the click listener for the login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Validate the inputs (e.g., check for empty fields)
                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    // Handle validation errors
                    Toast.makeText(LogInActivity.this, "Email and password are required", Toast.LENGTH_SHORT).show();
                } else {
                    // Perform Firebase authentication and login here
                    database.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(LogInActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // User login successful
                                        FirebaseUser user = database.getCurrentUser();
                                        Toast.makeText(LogInActivity.this, "Logged in as " + user.getEmail(), Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(LogInActivity.this, DivingCentersActivity.class));
                                        finish(); // Close the LoginActivity
                                    } else {
                                        // User login failed
                                        Toast.makeText(LogInActivity.this, "Login failed: " + task.getException(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
    }
}
