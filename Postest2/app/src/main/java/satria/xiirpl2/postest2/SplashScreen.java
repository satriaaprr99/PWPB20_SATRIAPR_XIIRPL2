package satria.xiirpl2.postest2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        Thread splash = new Thread(){
            public void run(){
                try {
                    sleep(2000);
                }
                catch (InterruptedException a){
                    a.printStackTrace();
                }
                finally {
                    startActivity(new Intent(SplashScreen.this,MainActivity.class));
                    finish();
                }
            }
        };
        splash.start();

    }
}
