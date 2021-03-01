package com.example.sqllite;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormUpdate extends AppCompatActivity implements View.OnClickListener {
    ActionBar actionBar;
    EditText edtJudul, edtDeskripsi;
    Button btnSubmit;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_update);

        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Ubah");

        edtJudul = findViewById(R.id.inpjudul);
        edtDeskripsi = findViewById(R.id.inpdeskripsi);
        edtJudul.setText(getIntent().getStringExtra("judul"));
        edtDeskripsi.setText(getIntent().getStringExtra("deskripsi"));
        btnSubmit = findViewById(R.id.btnsubmit);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        DatabaseHelper db = new DatabaseHelper(context);
        PersonBean currentPerson = new PersonBean();
        edtJudul.setText(currentPerson.getJudul());
        edtJudul.setFocusable(false);
        edtDeskripsi.setText(currentPerson.getDeskripsi());
        currentPerson.setJudul(edtJudul.getText().toString());
        currentPerson.setDeskripsi(edtDeskripsi.getText().toString());
        db.update(currentPerson);
        startActivity(new Intent(FormUpdate.this, MainActivity.class));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}