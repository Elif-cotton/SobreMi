package com.example.sobremisprint;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Cargar el MainContentFragment si es la primera vez que se crea la actividad
        if (savedInstanceState == null) {
            // Crear una instancia del fragmento
            MainContentFragment mainContentFragment = new MainContentFragment();

            // Obtener el FragmentManager y comenzar una transacción
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            // Reemplazar el contenedor en el layout con el fragmento
            fragmentTransaction.replace(R.id.fragment_container, mainContentFragment);
            fragmentTransaction.commit();  // Confirmar la transacción
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Establecer el título de la actividad
        setTitle("Sobre mí.");

    }

}