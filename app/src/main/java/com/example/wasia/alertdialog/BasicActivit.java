package com.example.wasia.alertdialog;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BasicActivit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fabBasic = (FloatingActionButton) findViewById(R.id.fabBasic);
        fabBasic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder diagBasic = new AlertDialog.Builder(BasicActivit.this);
                diagBasic
                        .setTitle("Basic AlertDialog")
                        .setMessage("This is basic AlertDialog")
                        .setPositiveButton("OK", null)
                        .show();
            }
        });

        FloatingActionButton fabFood = (FloatingActionButton) findViewById(R.id.fabFood);
        fabFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] food = {"腿庫", "雞蛋糕", "沙威瑪", "澳美客", "麵線", "麵疙瘩"};
                AlertDialog.Builder diagFood = new AlertDialog.Builder(BasicActivit.this);
                diagFood
                        .setTitle("Please choose your favoriate food")
                        .setItems(food, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast
                                        .makeText(BasicActivit.this, "You choosed " + food[which], Toast.LENGTH_SHORT)
                                        .show();
                            }
                        })
                        .show();
            }
        });

        FloatingActionButton fabEmail = (FloatingActionButton) findViewById(R.id.fabEamil);
        fabEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "AlertDialog includes Layout", Snackbar.LENGTH_LONG)
                        .setActionTextColor(Color.YELLOW)
                        .setAction("Chick Here", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                AlertDialog.Builder diagEmail = new AlertDialog.Builder(BasicActivit.this);
                                // AlertDialog including a layout resource file
                                LayoutInflater inflater = LayoutInflater.from(BasicActivit.this);
                                final View vEmail = inflater.inflate(R.layout.alertdialog_use, null);
                                diagEmail
                                        .setTitle("Information")
                                        .setView(vEmail)
                                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                EditText etEmail = (EditText) (vEmail.findViewById(R.id.etEmail));
                                                Toast
                                                        .makeText(getApplicationContext(), "Your email is " + etEmail.getText().toString(), Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .show();
                            }
                        })
                        .show();
            }
        });
    }
}