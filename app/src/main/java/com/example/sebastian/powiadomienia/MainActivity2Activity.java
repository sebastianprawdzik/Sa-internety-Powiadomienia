package com.example.sebastian.powiadomienia;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity2Activity extends ActionBarActivity {

    private static Button button_sbm;


    public void polaczenie(View view){
        TextView tv = (TextView)findViewById(R.id.textView);

        ConnectivityManager conMgr = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();
        if(netInfo!=null && netInfo.isConnected()){
            tv.setText("Są internety ! ! !");

        }
        else {
            tv.setText("Brak internetów! ; (");
        }


    }

    public void onButtonClickListener(){
        button_sbm=(Button)findViewById(R.id.button2);
        button_sbm.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity2Activity.this);
                        a_builder.setMessage("powrócić do poprzedniego ekranu?")
                        .setCancelable(false)
                        .setPositiveButton("Tak",new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int which){
                                finish();
                            }
                        })
                        .setNegativeButton("Nie", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int which){
                                dialog.cancel();
                            }
                        });
                        AlertDialog alert = a_builder.create();
                        alert.setTitle("Powrót");
                        alert.show();

                    }
                }
        );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        onButtonClickListener();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
