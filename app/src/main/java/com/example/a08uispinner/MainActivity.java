package com.example.a08uispinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spDiasSemana = null;
    private TextView tvSeleccion = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spDiasSemana = findViewById(R.id.spDiasSemana);
        tvSeleccion = findViewById(R.id.tvSeleccion);

        ArrayList<String> diasSemana = creaDiasSemana();


        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(getApplicationContext(),
                                                    R.layout.support_simple_spinner_dropdown_item,
                                                    diasSemana);

        spDiasSemana.setAdapter(adapter);

        spDiasSemana.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if (position != 0)
                    tvSeleccion.setText("Selección: " + adapterView.getItemAtPosition(position));
                else
                    tvSeleccion.setText("Selección: ");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

    }

    private ArrayList<String> creaDiasSemana() {
        ArrayList<String> diasSemana = new ArrayList<>();

        diasSemana.add("Seleccione ...");
        diasSemana.add("Lunes");
        diasSemana.add("Martes");
        diasSemana.add("Miércoles");
        diasSemana.add("Jueves");
        diasSemana.add("Viernes");
        diasSemana.add("Sabado");
        diasSemana.add("Domingo");

        return diasSemana;
    }
}
