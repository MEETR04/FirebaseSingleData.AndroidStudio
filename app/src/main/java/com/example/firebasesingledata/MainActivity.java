package com.example.firebasesingledata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        editText = findViewById(R.id.editTextTextPersonName);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText.getText().toString();

                FirebaseDatabase db = FirebaseDatabase.getInstance();
                DatabaseReference ref = db.getReference();

                ref.setValue(name);

                editText.setText("");
                Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_SHORT).show();

            }
        });

    }
}