package com.example.AplicatieCM;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.loginregister.R;

import java.util.ArrayList;


public class ListaProduseActivity extends AppCompatActivity implements View.OnClickListener {

    public Button btn_backProduct, btn_command;
    public ListView listProducts;

    public TextView sumaTot;
    int suma = 0;

    ArrayAdapter myAdapter;
    ArrayList<String> products = new ArrayList<>();
    String aux = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produse);

        btn_backProduct = findViewById(R.id.btn_inapoiProduse);
        btn_backProduct.setOnClickListener(this);

        btn_command = findViewById(R.id.btn_FinalComanda);
        btn_command.setOnClickListener(this);

        listProducts = findViewById(R.id.listaProduse);

        sumaTot = findViewById(R.id.sumTot);

        myAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, products);
        listProducts.setAdapter(myAdapter);


        for (int i = 0; i < ProduseActivity.listaProduse.size(); i++) {
            aux = ProduseActivity.listaProduse.get(i).getNume() + "            " +
                    ProduseActivity.listaProduse.get(i).getCantitate() + "            " +
                    ProduseActivity.listaProduse.get(i).getPret();
            suma = suma + (ProduseActivity.listaProduse.get(i).getCantitate() * ProduseActivity.listaProduse.get(i).getPret());
            products.add(aux);
            myAdapter.notifyDataSetChanged();
            aux = "";

        }

        sumaTot.setText("Total Price: " + suma + "$");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_inapoiProduse:
                Intent intent = new Intent(this, ProduseActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_FinalComanda: {

                Intent intentService = new Intent(getApplicationContext(), MyService.class);
                this.startService(intentService);

                String passStatus = "";

                new AlertDialog.Builder(this)
                        .setTitle(passStatus)
                        .setMessage("Congratulations" + "\n" + "The order has been completed successfully")
                        .setCancelable(true)
                        .show();

            }

        }
    }

}