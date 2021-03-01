package narsis.xiirpl2.postestsql;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private int waktu = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent intent = new Intent(MainActivity.this, MainHome.class);
               startActivity(intent);
               finish();
           }
       },waktu);






    }
}