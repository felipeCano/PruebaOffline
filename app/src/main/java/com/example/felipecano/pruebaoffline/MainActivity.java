package com.example.felipecano.pruebaoffline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText meditName;
    private EditText meditLastName;
    private EditText meditAddress;
    public Button mbuttonSaveOffline;
    private static DataOffline dataOffline;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataOffline = new DataOffline(getApplicationContext());

        meditName = findViewById(R.id.editName);
        meditLastName = findViewById(R.id.editLastName);
        meditAddress = findViewById(R.id.editAddess);
        mbuttonSaveOffline = findViewById(R.id.buttonSaveOffline);


    }
    public void SavePerson (View v){

        String name = meditName.getText().toString();
        dataOffline.AddPerson(meditName.getText().toString(), meditLastName.getText().toString(),
                meditAddress.getText().toString());
        meditName.setText("");
        meditLastName.setText("");
        meditAddress.setText("");
        Toast.makeText(MainActivity.this, "Registro Exito De " + name,
                Toast.LENGTH_LONG).show();
    }
    public  void loadPerson (View v){
       List<String> seachList =  dataOffline.Search();

       for (String temp : seachList){
           Log.d("person" , temp);
       }

    }

}
