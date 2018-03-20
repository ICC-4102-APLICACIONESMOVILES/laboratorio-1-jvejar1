package com.example.e440.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.wifi.hotspot2.pps.Credential;
import android.preference.PreferenceManager;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this,Login.class);
        intent.putExtra(EXTRA_MESSAGE,"Este mensaje ha sido enviado desde MainActivity");

        startActivityForResult(intent,1);

    }

    public void sendMessage (View view){
        Context context = getApplicationContext();
        CharSequence text = "Hello toast";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context,text,duration);
        toast.show();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Context context = getApplicationContext();
        setContentView(R.layout.activity_main);

        if (requestCode == 1) {  //is from login
            if(resultCode == Activity.RESULT_OK){


                CredentialsManager credentials_manager = new CredentialsManager(context);
                String user_name = credentials_manager.getUserName();
                String user_password = credentials_manager.getUserPassword();
                displayGreeting(user_name,user_password);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }



    public void displayGreeting(String user_name, String user_password){



    }

    protected void getStringFromPreferences(SharedPreferences sharedPreferences){


    }

    public void closeSession(View view){



    }
}
