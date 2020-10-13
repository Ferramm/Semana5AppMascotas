package com.example.appmascotas.dp;

import android.content.ContentValues;
import android.content.Context;

import com.example.appmascotas.R;
import com.example.appmascotas.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;
    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        /*ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Leon",198, R.drawable.leon));
        mascotas.add(new Mascota("Cocodrilo",69,R.drawable.cocodrilo));
        mascotas.add(new Mascota("Komodo",104,R.drawable.komodo));
        mascotas.add(new Mascota("Rinoceronte",21,R.drawable.rino));
        mascotas.add(new Mascota("Tigre",177,R.drawable.tigre));
        return mascotas;*/

        BaseDatos db = new BaseDatos(context);
        insertarCincoMascotas(db);
        return  db.obtenerTodasLasMascotas();
    }

    public void insertarCincoMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Leon");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.leon);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Cocodrilo");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.cocodrilo);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Komodo");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.komodo);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Rinoceronte");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.rino);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Tigre");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.tigre);
        db.insertarMascota(contentValues);
    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_PET_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_PET_NUMERO_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }
}
