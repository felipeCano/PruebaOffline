package com.example.felipecano.pruebaoffline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText meditName;
    private EditText meditLastName;
    private EditText meditAddress;
    public Button mbuttonSaveOffline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DataOffline dataOffline = new DataOffline(getApplicationContext());

        meditName = findViewById(R.id.editName);
        meditLastName = findViewById(R.id.editLastName);
        meditAddress = findViewById(R.id.editAddess);
        mbuttonSaveOffline = findViewById(R.id.buttonSaveOffline);

        mbuttonSaveOffline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = meditName.getText().toString();
                dataOffline.AddPerson(meditName.getText().toString(), meditLastName.getText().toString(),
                        meditAddress.getText().toString());
                meditName.setText("");
                meditLastName.setText("");
                meditAddress.setText("");
                Toast.makeText(MainActivity.this, "Registro Exito De " + name,
                              Toast.LENGTH_LONG).show();
            }

        });

    }
}
