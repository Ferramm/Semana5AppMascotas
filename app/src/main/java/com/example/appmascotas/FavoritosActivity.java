package com.example.appmascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.appmascotas.adapter.MascotaAdaptador;
import com.example.appmascotas.pojo.Mascota;

import java.util.ArrayList;

public class FavoritosActivity extends AppCompatActivity {

    private ArrayList<Mascota> mascotasFavoritas = new ArrayList<>();
    private RecyclerView rvMascotasFavoritas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_perfil);

       /* Toolbar miActionBar = findViewById(R.id.toolbar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

        mascotasFavoritas.add(new Mascota("Rinoceronte", 0, R.drawable.rino));
        mascotasFavoritas.add(new Mascota("Leon", 0, R.drawable.leon));
        mascotasFavoritas.add(new Mascota("Tigre", 0, R.drawable.tigre));
        mascotasFavoritas.add(new Mascota("Komodo", 0, R.drawable.komodo));
        mascotasFavoritas.add(new Mascota("Cocodrilo", 0, R.drawable.cocodrilo));

        rvMascotasFavoritas = findViewById(R.id.rvMacotasFavoritas);

        final LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotasFavoritas.setLayoutManager(llm);

        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador(mascotasFavoritas, this);
        rvMascotasFavoritas.setAdapter(mascotaAdaptador);
    }


}