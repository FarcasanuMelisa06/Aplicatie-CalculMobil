package com.example.AplicatieCM;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.loginregister.R;

import java.util.ArrayList;

public class ProduseActivity extends AppCompatActivity implements View.OnClickListener {

    //butoanele de adaugare
    public Button addP1, addP2, addP3, addP4, addP5;

    //butoanele de stergere
    public Button removeP1, removeP2, removeP3, removeP4, removeP5;

    //cosul de cumparaturi
    public Button btn_cosCumparaturi;

    //cantitatea de produse selectate
    public TextView amountP1, amountP2, amountP3, amountP4, amountP5;

    //numarul final de produse
    public static int amount = 0;


    public static ArrayList<ProdusClass> listaProduse = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produse);

        //datele pentru produsul 1
        addP1 = findViewById(R.id.addP1);
        addP1.setOnClickListener(this);
        removeP1 = findViewById(R.id.removeP1);
        removeP1.setOnClickListener(this);
        amountP1 = findViewById(R.id.cantitateP1);


        //datele pentru produsul 2
        addP2 = findViewById(R.id.addP2);
        addP2.setOnClickListener(this);
        removeP2 = findViewById(R.id.removeP2);
        removeP2.setOnClickListener(this);
        amountP2 = findViewById(R.id.cantitateP2);


        //datele pentru produsul 3
        addP3 = findViewById(R.id.addP3);
        addP3.setOnClickListener(this);
        removeP3 = findViewById(R.id.removeP3);
        removeP3.setOnClickListener(this);
        amountP3 = findViewById(R.id.cantitateP3);

        //datele pentru produsul 4
        addP4 = findViewById(R.id.addP4);
        addP4.setOnClickListener(this);
        removeP4 = findViewById(R.id.removeP4);
        removeP4.setOnClickListener(this);
        amountP4 = findViewById(R.id.cantitateP4);

        //datele pentru produsul 5
        addP5 = findViewById(R.id.addP5);
        addP5.setOnClickListener(this);
        removeP5 = findViewById(R.id.removeP5);
        removeP5.setOnClickListener(this);
        amountP5 = findViewById(R.id.cantitateP5);

        //cosul de cumparaturi
        btn_cosCumparaturi = findViewById(R.id.cosCumparaturi);
        btn_cosCumparaturi.setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {

        //in functie de id-ul butonului selectat
        //apelem functia necesara
        switch (v.getId()) {
            case R.id.addP1:
                addProduct(getString(R.string.nameProdus1),
                        this.getResources().getInteger(R.integer.priceProdus1));
                break;

            case R.id.removeP1:
                removeProduct(getString(R.string.nameProdus1),
                        this.getResources().getInteger(R.integer.priceProdus1));
                break;

            case R.id.addP2:
                addProduct(getString(R.string.nameProdus2),
                        this.getResources().getInteger(R.integer.priceProdus2));
                break;
            case R.id.removeP2:
                removeProduct(getString(R.string.nameProdus2),
                        this.getResources().getInteger(R.integer.priceProdus2));
                break;

            case R.id.addP3:
                addProduct(getString(R.string.nameProdus3),
                        this.getResources().getInteger(R.integer.priceProdus3));
                break;
            case R.id.removeP3:
                removeProduct(getString(R.string.nameProdus3),
                        this.getResources().getInteger(R.integer.priceProdus3));
                break;

            case R.id.addP4:
                addProduct(getString(R.string.nameProdus4),
                        this.getResources().getInteger(R.integer.priceProdus4));
                break;
            case R.id.removeP4:
                removeProduct(getString(R.string.nameProdus4),
                        this.getResources().getInteger(R.integer.priceProdus4));
                break;

            case R.id.addP5:
                addProduct(getString(R.string.nameProdus5),
                        this.getResources().getInteger(R.integer.priceProdus5));
                break;
            case R.id.removeP5:
                removeProduct(getString(R.string.nameProdus5),
                        this.getResources().getInteger(R.integer.priceProdus5));
                break;

            case R.id.cosCumparaturi:
                Intent intent = new Intent(ProduseActivity.this, ListaProduseActivity.class);
                startActivity(intent);
                break;

        }

    }

    //functia de adaugare produs
    private void addProduct(String nume, int pret) {

        ProdusClass produsClass = new ProdusClass(nume, pret, amount);
        manager(nume, pret, produsClass, 1);

    }

    //functia de stergere produs
    public void removeProduct(String name, int pret) {
        manager(name, pret, null, 0);

    }

    public void manager(String nume, int pret, ProdusClass produsClass, int quantity) {
        //il folosim ca sa ne asiguram ca produsele nu se repeta in lista
        int duplicate = 0;

        for (int i = 0; i < listaProduse.size(); i++) {

            if (listaProduse.get(i).getNume().equals(nume)) {

                if (quantity == 1) {
                    listaProduse.get(i).setCantitate(listaProduse.get(i).getCantitate() + 1);

                } else if (quantity == 0) {

                    listaProduse.get(i).setCantitate(listaProduse.get(i).getCantitate() - 1);
                }

                duplicate++;

                switch (i) {
                    case 0:
                        amountP1.setText(getString(R.string.cantitate) + Integer.toString(listaProduse.get(i).getCantitate()));
                        break;
                    case 1:
                        amountP2.setText(getString(R.string.cantitate) + Integer.toString(listaProduse.get(i).getCantitate()));
                        break;
                    case 2:
                        amountP3.setText(getString(R.string.cantitate) + Integer.toString(listaProduse.get(i).getCantitate()));
                        break;
                    case 3:
                        amountP4.setText(getString(R.string.cantitate) + Integer.toString(listaProduse.get(i).getCantitate()));
                        break;
                    case 4:
                        amountP5.setText(getString(R.string.cantitate) + Integer.toString(listaProduse.get(i).getCantitate()));
                        break;

                }

//                listaProduse.get(i).getCantitate();
            }
        }
        if (duplicate == 0) {
            listaProduse.add(produsClass);
        }
    }

}