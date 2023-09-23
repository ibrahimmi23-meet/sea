package com.example.deep10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        CardView merchandiseCardView = findViewById(R.id.merchandiseCardView);
        CardView mapCardView = findViewById(R.id.mapCardView);
        CardView chatCardView = findViewById(R.id.chatCardView);
        CardView tripsCardView = findViewById(R.id.tripsCardView);

        merchandiseCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the MerchandiseActivity
                Intent intent = new Intent(HomePage.this, MerchandiseActivity.class);
                startActivity(intent);
            }
        });

        mapCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the MapActivity
                Intent intent = new Intent(HomePage.this, MapActivity.class);
                startActivity(intent);
            }
        });

        chatCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the ChatActivity
                Intent intent = new Intent(HomePage.this, ChatActivity.class);
                startActivity(intent);
            }
        });

        tripsCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the TripsActivity
                Intent intent = new Intent(HomePage.this, TripsActivity.class);
                startActivity(intent);
            }
        });
    }
}
