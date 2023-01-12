package com.example.loginregister;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListaProduseActivity extends AppCompatActivity implements View.OnClickListener {

    public Button btn_inapoiProduse, btn_finalComanda;
    public ListView listaProduse;

    ArrayAdapter myAdapter;
    ArrayList<String> produse = new ArrayList<>();
    String aux = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produse);

        btn_inapoiProduse = findViewById(R.id.btn_inapoiProduse);
        btn_inapoiProduse.setOnClickListener(this);

        btn_finalComanda = findViewById(R.id.btn_FinalComanda);
        btn_finalComanda.setOnClickListener(this);

        listaProduse = findViewById(R.id.listaProduse);

        myAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, produse);
        listaProduse.setAdapter(myAdapter);

        for (int i = 0; i < ProduseActivity.listaProduse.size(); i++) {
            aux = ProduseActivity.listaProduse.get(i).getNume() + "               " +
                    ProduseActivity.listaProduse.get(i).getCantitate() + "                " +
                    ProduseActivity.listaProduse.get(i).getPret();
            produse.add(aux);
            myAdapter.notifyDataSetChanged();
            aux = "";

        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_inapoiProduse:
                Intent intent = new Intent(this, ProduseActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_FinalComanda: {
                String passStatus = "";

                new AlertDialog.Builder(this)
                        .setTitle(passStatus)
                        .setMessage("Congratulations" + "\n" + "The order has been completed successfully")
                        .setCancelable(false)
                        .show();
                
                break;
            }

        }
    }


}