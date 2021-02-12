package com.example.coach.modele;

import java.io.Serializable;
import java.util.Date;

public class Profil implements Serializable {

    //constantes
    private static final Integer minFemme = 15; //maigre si en dessous
    private static final Integer maxFemme = 30; //gros si au dessus
    private static final Integer minHomme = 10; //maigre si en dessous
    private static final Integer maxHomme = 25; // gros si au dessus

    //propriétés
    private Date dateMesure;
    private Integer poids;
    private Integer taille;
    private Integer age;
    private Integer sexe;
    private float img;
    private String message;


    //constructeurs
    public Profil(Date dateMesure, Integer poids, Integer taille, Integer age, Integer sexe) {
        this.dateMesure = dateMesure;
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.sexe = sexe;
        this.calculIMG();
        this.resultIMG();
    }

        //getter
        public Integer getPoids () {
            return poids;
        }

        public Integer getTaille () {
            return taille;
        }

        public Integer getAge () {
            return age;
        }

        public Integer getSexe () {
            return sexe;
        }

        public float getImg () {
            return img;
        }

        public String getMessage () {
            return message;
        }

        public Date getDateMesure() { return dateMesure; }

    //formule de calcul IMG
        private void calculIMG () {
            float tailleM = ((float) taille) / 100;
            this.img = (float) ((1.2 * poids / (tailleM * tailleM)) + (0.23 * age) - (10.83 * sexe) - 5.4);
        }

        //définition homme-femme
        private void resultIMG () {
            Integer min;
            Integer max;
            if (sexe == 0) { //femme
                min = minFemme;
                max = maxFemme;
            } else { //homme
                min = minHomme;
                max = maxHomme;
            }
            //message
            message = "normal";
            if (img < min) {
                message = "trop faible";
            } else {
                if (img > max)
                    message = "trop élevé";
            }
        }

    }



