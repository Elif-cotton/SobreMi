package com.example.sobremisprint;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

public class ContactInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);

        // Botón para abrir LinkedIn
        Button linkedinButton = findViewById(R.id.linkedin_button);
        linkedinButton.setOnClickListener(v -> openLinkedIn());

        // Botón para abrir WhatsApp
        Button whatsappButton = findViewById(R.id.whatsapp_button);
        whatsappButton.setOnClickListener(v -> openWhatsApp());

        // Botón para enviar email
        Button emailButton = findViewById(R.id.email_button);
        emailButton.setOnClickListener(v -> sendEmail());

        // Botón para salir de la aplicación
        Button exitButton = findViewById(R.id.exit_button);
        exitButton.setOnClickListener(v -> exitApp());

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Establecer el título de la actividad
        setTitle("Contacto.");

        // Habilitar la flecha de regreso
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

    }

    // Manejar el clic en la flecha de regreso
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            // Navegar de regreso a la MainActivity
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void openLinkedIn() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cl.linkedin.com/"));
        startActivity(intent);
    }

    private void openWhatsApp() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("whatsapp://send"));
        startActivity(intent);
    }

    private void sendEmail() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"developer@example.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Solicitud de servicios de desarrollo de aplicaciones");
        intent.putExtra(Intent.EXTRA_TEXT, "Estimado profesional,\n\nEstoy interesado en contratar sus servicios para el desarrollo de una aplicación. Por favor, háblenos de su experiencia y tarifas.\n\nGracias.\n\nSaludos cordiales.");

        try {
            startActivity(Intent.createChooser(intent, "Enviar email..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "No hay clientes de correo instalados.", Toast.LENGTH_SHORT).show();
        }
    }

    private void exitApp() {
        finishAffinity(); // Cerrar la aplicación
    }
}