package satria.xiirpl2.postest2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainUpdate extends AppCompatActivity implements View.OnClickListener {
    ActionBar actionBar;
    EditText edtJudul, edtDeskripsi;
    Button btnSubmit;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Update");

        edtJudul     = findViewById(R.id.judul);
        edtDeskripsi = findViewById(R.id.deskripsi);
        edtJudul.setText(getIntent().getStringExtra("judul"));
        edtDeskripsi.setText(getIntent().getStringExtra("deskripsi"));

        btnSubmit = findViewById(R.id.submit);
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
        startActivity(new Intent(MainUpdate.this, MainActivity.class));
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