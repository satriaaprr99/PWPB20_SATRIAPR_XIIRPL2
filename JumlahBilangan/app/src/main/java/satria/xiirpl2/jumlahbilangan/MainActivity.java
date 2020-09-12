package satria.xiirpl2.jumlahbilangan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edit1, edit2, hitung;
    private Button btnhitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        initEvent();
    }

    private void initUI(){
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        hitung = findViewById(R.id.hasil);
        btnhitung = findViewById(R.id.btnhitung);
    }
    private void initEvent(){
        btnhitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hitungjumlah();
            }
        });
    }
    private void hitungjumlah(){
        int angka1 = Integer.parseInt(edit1.getText().toString());
        int angka2 = Integer.parseInt(edit2.getText().toString());
        int total = angka1 + angka2;
        hitung.setText(total + "");
    }
}