package com.example.coach.outils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySQLiteOpenHelper  extends SQLiteOpenHelper {

    //propriétés
    private String creation="create table profil ("
            + "datemesure TEXT PRIMARY KEY,"
            + "poids INTEGER NOT NULL,"
            + "taille INTEGER NOT NULL,"
            + "age INTEGER NOT NULL,"
            + "sexe INTEGER NOT NULL);";



    //constructeur
    public MySQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //si changement de base de données
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(creation);

    }

    //si changement de version
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
