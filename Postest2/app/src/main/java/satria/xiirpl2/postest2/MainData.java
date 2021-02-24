package satria.xiirpl2.postest2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainData extends AppCompatActivity implements View.OnClickListener {
    ActionBar actionBar;
    EditText edtJudul, edtDeskripsi;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Tambah Data");

        edtJudul     = findViewById(R.id.judul);
        edtDeskripsi = findViewById(R.id.deskripsi);
        btnSubmit    = findViewById(R.id.submit);
        btnSubmit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.submit){
            DatabaseHelper db = new DatabaseHelper(this);
            PersonBean currentPerson = new PersonBean();
            currentPerson.setJudul(edtJudul.getText().toString());
            currentPerson.setDeskripsi(edtDeskripsi.getText().toString());
            db.insert(currentPerson);
            edtJudul.setText("");
            edtDeskripsi.setText("");
            edtJudul.setFocusable(true);
            startActivity(new Intent(MainData.this, MainActivity.class));
            Toast.makeText(this, "Data Berhasil Ditambah!", Toast.LENGTH_SHORT).show();
        }
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
