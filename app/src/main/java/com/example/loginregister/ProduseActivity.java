package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ProduseActivity extends AppCompatActivity implements View.OnClickListener {
    //butoanele de adaugare
    public Button addP1, addP2, addP3, addP4, addP5;
    //butoanele de stergere
    public Button removeP1, removeP2, removeP3, removeP4, removeP5;

    //cosul de cumparaturi
    public Button btn_cosCumparaturi;

    //cantitatea de produse selectate
    public TextView cantitateP1, cantitateP2, cantitateP3, cantitateP4, cantitateP5;

    //numarul final de produse
    public static int amountP1 = 0, amountP2 = 0, amountP3 = 0, amountP4 = 0, amountP5 = 0;


    int sumaFinala = 0;

//    HashMap<String, Integer> lista = new HashMap<String, Integer>();
    public static ArrayList<ProdusClass> listaProduse = new ArrayList<>();


    int index = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produse);

        //datele pentru produsul 1
        addP1 = findViewById(R.id.addP1);
        addP1.setOnClickListener(this);
        removeP1 = findViewById(R.id.removeP1);
        removeP1.setOnClickListener(this);
        cantitateP1 = findViewById(R.id.cantitateP1);

        //datele pentru produsul 2
        addP2 = findViewById(R.id.addP2);
        addP2.setOnClickListener(this);
        removeP2 = findViewById(R.id.removeP2);
        removeP2.setOnClickListener(this);
        cantitateP2 = findViewById(R.id.cantitateP2);


        //datele pentru produsul 3
        addP3 = findViewById(R.id.addP3);
        addP3.setOnClickListener(this);
        removeP3 = findViewById(R.id.removeP3);
        removeP3.setOnClickListener(this);
        cantitateP3 = findViewById(R.id.cantitateP3);

        //datele pentru produsul 4
        addP4 = findViewById(R.id.addP4);
        addP4.setOnClickListener(this);
        removeP4 = findViewById(R.id.removeP4);
        removeP4.setOnClickListener(this);
        cantitateP4 = findViewById(R.id.cantitateP4);

        //datele pentru produsul 5
        addP5 = findViewById(R.id.addP5);
        addP5.setOnClickListener(this);
        removeP5 = findViewById(R.id.removeP5);
        removeP5.setOnClickListener(this);
        cantitateP5 = findViewById(R.id.cantitateP5);

        //cosul de cumparaturi
        btn_cosCumparaturi = findViewById(R.id.cosCumparaturi);
        btn_cosCumparaturi.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        //in functie de id-ul butonului selectat
        //apelem functia necesara
        switch (v.getId()) {
            case R.id.addP1:
                adaugareProdus(getString(R.string.nameProdus1), R.string.priceProdus1);
                break;

            case R.id.removeP1:
                stergereProdus(getString(R.string.nameProdus1), R.string.priceProdus1, amountP1);
                break;

            case R.id.addP2:
                adaugareProdus(getString(R.string.nameProdus2),R.string.priceProdus2 );
                break;
            case R.id.removeP2:
                stergereProdus(getString(R.string.nameProdus2), R.string.priceProdus2, amountP2);
                break;

            case R.id.addP3:
                adaugareProdus(getString(R.string.nameProdus3),R.string.priceProdus3);
                break;
            case R.id.removeP3:
                stergereProdus(getString(R.string.nameProdus3), R.string.priceProdus3, amountP3);
                break;

            case R.id.addP4:
                adaugareProdus(getString(R.string.nameProdus4), R.string.priceProdus4);
                break;
            case R.id.removeP4:
                stergereProdus(getString(R.string.nameProdus4), R.string.priceProdus4, amountP4);
                break;

            case R.id.addP5:
                adaugareProdus(getString(R.string.nameProdus5), R.string.priceProdus5);
                break;
            case R.id.removeP5:
                stergereProdus(getString(R.string.nameProdus5), R.string.priceProdus5, amountP5);
                break;

            case R.id.cosCumparaturi:
                Intent intent = new Intent(ProduseActivity.this, ListaProduseActivity.class);
//                intent.putExtra("key", ListaProduse);
                startActivity(intent);
                break;

        }
    }

    private int adaugareProdus(String nume, int pret) {

        int ok = 0;
        ProdusClass produsClass = new ProdusClass(nume , 3, amountP1);
        for (int i = 0; i < listaProduse.size(); i++){
            if (listaProduse.get(i).getNume().equals(nume)){
                listaProduse.get(i).setCantitate(listaProduse.get(i).getCantitate() + 1);
                ok++;
                cantitateP1.setText(getString(R.string.cantitate) + Integer.toString(listaProduse.get(i).getCantitate()));
                return listaProduse.get(i).getCantitate();
            }
        }
        if (ok == 0) {
            listaProduse.add(produsClass);
        }
        cantitateP1.setText(getString(R.string.cantitate) + Integer.toString(1));
        return 1;

    }

    private void stergereProdus(String nume, int pret, int amount) {
        amount = amount - 1;
        cantitateP1.setText(getString(R.string.cantitate) + Integer.toString(amount));
        sumaFinala = sumaFinala - pret;
//        lista.put(nume, amount);
//        System.out.println(lista);
        System.out.println(sumaFinala);

    }
}