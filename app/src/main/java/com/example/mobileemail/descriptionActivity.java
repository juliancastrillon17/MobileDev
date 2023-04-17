package com.example.mobileemail;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class descriptionActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        ListElement element = (ListElement) getIntent().getSerializableExtra("List");
        TextView titleDescription = (TextView) findViewById(R.id.titleDescription);
        TextView cityDescription = (TextView) findViewById(R.id.cityDescription);
        TextView statusDescription = (TextView) findViewById(R.id.statusDescription);

        titleDescription.setText(element.getName());
        titleDescription.setTextColor(Color.parseColor(element.getColor()));

        cityDescription.setText(element.getCity());
        cityDescription.setTextColor(Color.RED);

        statusDescription.setText(element.getStatus());
        statusDescription.setTextColor(Color.RED);

    }
}