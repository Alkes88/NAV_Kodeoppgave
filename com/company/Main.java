package com.company;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner innLonn = new Scanner(System.in);

        System.out.println("Skriv inn inntekt for 2021: ");
        double inntekt2021 = innLonn.nextDouble();
        Objects.requireNonNull(inntekt2021, "Må skrive inn en inntekt. Skriv 0 om du ikke har hatt inntekt for dette året.");

        System.out.println("Skriv inn inntekt for 2020: ");
        double inntekt2020 = innLonn.nextDouble();
        Objects.requireNonNull(inntekt2020, "Må skrive inn en inntekt. Skriv 0 om du ikke har hatt inntekt for dette året.");

        System.out.println("Skriv inn inntekt for 2019: ");
        double inntekt2019 = innLonn.nextDouble();
        Objects.requireNonNull(inntekt2019, "Må skrive inn en inntekt. Skriv 0 om du ikke har hatt inntekt for dette året.");


////////////////////// OPPNÅELSE AV DAGPENGER ///////////////////////////////////////////////////////////
        double arbeidsinntekt_3aar = inntekt2019 + inntekt2020 + inntekt2021;
        boolean oppnaaddDagpenger;
        int G = 111477;

        if (inntekt2021 <= 0) {
            oppnaaddDagpenger = false;
            System.out.println("Du har ikke hatt arbeidsinntekt i forrige år og kvalifiserer dessverre ikke for dagpenger.");
        }

        else if (inntekt2021 > (1.5 * G)) {
            oppnaaddDagpenger = true;
        }

        else if (arbeidsinntekt_3aar >= (3 * G)) {
            oppnaaddDagpenger = true;
        }

        else {
            oppnaaddDagpenger = false;
            System.out.println("Basert på din arbeidsinntekt for de siste 3 år kvalifiserer du dessverre ikke for dagpenger.");
        }

////////////////////// UTREGNING AV DAGPENGER ///////////////////////////////////////////////////////////
        if (oppnaaddDagpenger) {
            double dagpengegrunnlag;
            double gjennomsnittsinntekt = arbeidsinntekt_3aar / 3;

            if (inntekt2021 > gjennomsnittsinntekt) {
                dagpengegrunnlag = inntekt2021;
            }
            else {
                dagpengegrunnlag = gjennomsnittsinntekt;
            }

            if (dagpengegrunnlag > (6 * G)) {
                dagpengegrunnlag = 6 * G;
            }

            int dagsats = (int) Math.ceil((double)dagpengegrunnlag / 260);

            System.out.println("Du har kvalifisert til å motta dagpenger. Du vil få en dagsats på kr "+dagsats);
        }
    }
}