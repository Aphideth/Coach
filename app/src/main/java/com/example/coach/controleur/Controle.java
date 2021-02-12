package com.example.coach.controleur;

import android.content.Context;

import com.example.coach.modele.AccesLocal;
import com.example.coach.modele.Profil;
import com.example.coach.outils.Serializer;

import java.io.Serializable;
import java.util.Date;

public final class Controle {

    private static Controle instance = null;
    private static Profil profil;
    private static String nomFic = "saveprofil";
    private static AccesLocal accesLocal;

    //constructeur private
    private Controle () {
        super();
    }

    //création de l'instance
    public static final Controle getInstance(Context contexte) {
    if (Controle.instance == null) {
        Controle.instance = new Controle();
        accesLocal = new AccesLocal(contexte);
        profil = accesLocal.recupDernier();
//        recupSerialize(contexte);
    }
    return Controle.instance;
    }

    //création profil
    public void creerProfil(Integer poids, Integer taille, Integer age, Integer sexe, Context contexte) {
        profil = new Profil (new Date(), poids, taille, age, sexe);
        accesLocal.ajout(profil);
//        Serializer.serialize(nomFic, profil, contexte);
    }

    //récupération img de profil
    public float getImg() {
        return profil.getImg();
    }

    //récupération message de profil
    public String getMessage() {
        return profil.getMessage();
    }

    //récupération de l'objet sérialisé (profil)
    private static void recupSerialize(Context contexte){
        profil = (Profil) Serializer.deSerialize(nomFic, contexte);
    }

    public Integer getPoids() {
        if (profil == null) {
            return null;
        }else{
            return profil.getPoids();
        }
    }

    public Integer getTaille() {
        if (profil == null) {
            return null;
        }else{
            return profil.getTaille();
        }

    }public Integer getAge() {
        if (profil == null) {
            return null;
        }else{
            return profil.getAge();
        }

    }public Integer getSexe() {
        if (profil == null) {
            return null;
        }else{
            return profil.getSexe();
        }
    }




}
