//Aplikacja w pełni działajaąca na stan 17:41 dnia 22 września 2018 roku.




package com.example.piotr.projektinz;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

import java.util.HashMap;
import java.util.Map;


public class logo_powitanie extends AppCompatActivity implements ForceUpdateChecker.OnUpdateNeededListener{


    private static final String TAG = logo_powitanie.class.getSimpleName();


    Button btn;
    TextView help_text;
    Switch demo_switch;
    ImageView help_screen;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo_powitanie);
        addListenerButton();

        help_text.setVisibility(View.INVISIBLE);
        help_screen.setVisibility(View.INVISIBLE);
        final FirebaseRemoteConfig firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        ForceUpdateChecker.with(this).onUpdateNeeded(this).check();

        // set in-app defaults

        Map<String, Object> remoteConfigDefaults = new HashMap();
        remoteConfigDefaults.put(ForceUpdateChecker.KEY_UPDATE_REQUIRED, false);
        remoteConfigDefaults.put(ForceUpdateChecker.KEY_CURRENT_VERSION, "1.0.0");
        remoteConfigDefaults.put(ForceUpdateChecker.KEY_UPDATE_URL, "https://firebasestorage.googleapis.com/v0/b/projektinz-47fa0.appspot.com/o/app-debug.apk?alt=media&token=8bcc4cd4-dfd2-434c-b628-1e6d7c4dd2b7");

        firebaseRemoteConfig.setDefaults(remoteConfigDefaults);
        firebaseRemoteConfig.fetch(60) // fetch every minutes
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "remote config is fetched.");
                            firebaseRemoteConfig.activateFetched();
                        }
                    }
                });

    }

    private void addListenerButton() {
        final Context context = this;
        btn = findViewById(R.id.button);
        help_text = findViewById(R.id.textView);
        demo_switch = findViewById(R.id.switch1);
        help_screen = findViewById(R.id.imageView3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Menu_glowne.class);
                startActivity(intent);
            }
        });

        demo_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(demo_switch.isChecked()) {
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            help_text.setVisibility(View.VISIBLE);
                            btn.setBackgroundColor(Color.RED);
                            help_screen.setVisibility(View.VISIBLE);
                        }
                    });
                }
                else {
                    help_text.setVisibility(View.INVISIBLE);
                    btn.setBackgroundColor(0xFF1B50D7);
                    help_screen.setVisibility(View.INVISIBLE);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(context, Menu_glowne.class);
                            startActivity(intent);
                        }
                    });
                }
            }
        });


    }

    @Override
    public void onUpdateNeeded(final String updateUrl) {
        AlertDialog dialog = new AlertDialog.Builder(this).setTitle("Nowa wersja dostępna")
                .setMessage("Prosze zaktualizowac aplikacje by móc z niej korzystac.")
                .setPositiveButton  ("Aktualizuj", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                redirectStore(updateUrl);
                            }
                        }).setNegativeButton("Nie, dziekuje", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        }).create();
        dialog.show();

        //Button bq = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
        //bq.setBackgroundColor(Color.GREEN);
        //Button bq1 = dialog.getButton(DialogInterface.BUTTON_NEGATIVE);
        //bq1.setBackgroundColor(Color.RED);
    }

    private void redirectStore(String updateUrl) {
        final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(updateUrl));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }


}
