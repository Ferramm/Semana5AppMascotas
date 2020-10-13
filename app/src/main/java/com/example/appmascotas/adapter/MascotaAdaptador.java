package com.example.appmascotas.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmascotas.FavoritosActivity;
import com.example.appmascotas.dp.ConstructorMascotas;
import com.example.appmascotas.pojo.Mascota;
import com.example.appmascotas.R;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview, parent, false);

        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgMascota.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombre.setText(mascota.getNombre());
        mascotaViewHolder.tvRatingMascota.setText(String.valueOf(mascota.getRaiting()) + " " + activity.getString(R.string.likes));

        mascotaViewHolder.imgMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, mascota.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, FavoritosActivity.class);
                intent.putExtra("nombre", mascota.getNombre());
                activity.startActivity(intent);

            }
        });
        mascotaViewHolder.ivRateMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + mascota.getNombre(),
                        Toast.LENGTH_SHORT).show();


                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);
                mascotaViewHolder.tvRatingMascota.setText(constructorMascotas.obtenerLikesMascota(mascota) + " " + activity.getString(R.string.likes));


            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgMascota;
        private TextView tvNombre;
        private ImageView ivRateMascota;
        private TextView tvRatingMascota;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            imgMascota     = (ImageView) itemView.findViewById(R.id.imgMascota);
            tvNombre    = (TextView) itemView.findViewById(R.id.tvNombre);
            ivRateMascota     = (ImageView) itemView.findViewById(R.id.ivRateMascota);
            tvRatingMascota     = (TextView) itemView.findViewById(R.id.tvRatingMascota);

        }
    }
}
