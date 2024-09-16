package com.example.sobremisprint;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.Intent;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainContentFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_content, container, false);

        // Botón para abrir la actividad de información de contacto
        Button openContactInfoButton = view.findViewById(R.id.contact_info_button);
        openContactInfoButton.setOnClickListener(v -> openContactInfoActivity());

        return view;
    }

    // Método para abrir la nueva actividad
    private void openContactInfoActivity() {
        Intent intent = new Intent(getActivity(), ContactInfoActivity.class);
        startActivity(intent);
    }
}