package id.handi.raisoresto.SplashScreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import javax.inject.Inject;

import id.handi.raisoresto.MainActivity;
import id.handi.raisoresto.R;

public class SplashScreenActivity extends Activity {

    @Inject
    SplashScreenPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_splash_screen);

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(SplashScreenActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
        //initPresenter();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    //private void initPresenter() {}
}
