package com.example.sebastian.powiadomienia;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    private static Button button_powrot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onButtonClickListener();

        Button btnCreateNotification = (Button) findViewById(R.id.btnCreateNotification);
        btnCreateNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               createNotification();
            }
        });
    }

    private void createNotification(){

        Intent intent = new Intent(this, MainActivity2Activity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);

        Notification noti = new NotificationCompat.Builder(this)
                .setContentTitle("Są internety?!?!")
                .setContentText("sprawdź połączenie z internetami!")
                .setTicker("Internety chcą się sprawdzić! ;)")
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setLargeIcon(icon)
                .setAutoCancel(true)
                .setContentIntent(pIntent)
                .build();

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        notificationManager.notify(0, noti);
    }

    public void onButtonClickListener(){
        button_powrot=(Button)findViewById(R.id.button3);
        button_powrot.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
                        a_builder.setMessage("Zamknąć apkę?")
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
                        alert.setTitle("Wyjście!!!");
                        alert.show();

                    }
                }
        );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
