package com.example.piotr.projektinz;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.print.PrintAttributes;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class wybor_grupy extends AppCompatActivity {

/*dodawanie grup przez aplikacje
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mDatabaseReference;
    */
    Button dodaj_grupe_click;
    FirebaseDatabase mFirebaseDatabase;
    FirebaseDatabase database;
    DatabaseReference mDatabaseReference;
    DatabaseReference dbref;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wybor_grupy);
        addListenerButton();
        LinearLayout linearLayout1= findViewById(R.id.linearLayout1);
        linearLayout1.setVisibility(View.INVISIBLE);


        final Button Inf_1_rok= findViewById(R.id.Inf_1_rok);
        final Button Inf_2_rok= findViewById(R.id.Inf_2_rok);
        final Button Inf_3_rok= findViewById(R.id.Inf_3_rok);
        final Button Inf_4_rok= findViewById(R.id.Inf_4_rok);
        final Button Inf_5_rok= findViewById(R.id.Inf_5_rok);

        final Button AiR_1_rok= findViewById(R.id.AiR_1_rok);
        final Button AiR_2_rok= findViewById(R.id.AiR_2_rok);
        final Button AiR_3_rok= findViewById(R.id.AiR_3_rok);
        final Button AiR_4_rok= findViewById(R.id.AiR_4_rok);
        final Button AiR_5_rok= findViewById(R.id.AiR_5_rok);

        final Button Ele_1_rok= findViewById(R.id.Ele_1_rok);
        final Button Ele_2_rok= findViewById(R.id.Ele_2_rok);
        final Button Ele_3_rok= findViewById(R.id.Ele_3_rok);
        final Button Ele_4_rok= findViewById(R.id.Ele_4_rok);
        final Button Ele_5_rok= findViewById(R.id.Ele_5_rok);

        final Button EiT_1_rok= findViewById(R.id.EiT_1_rok);
        final Button EiT_2_rok= findViewById(R.id.EiT_2_rok);
        final Button EiT_3_rok= findViewById(R.id.EiT_3_rok);
        final Button EiT_4_rok= findViewById(R.id.EiT_4_rok);
        final Button EiT_5_rok= findViewById(R.id.EiT_5_rok);




        Inf_1_rok.setVisibility(View.INVISIBLE);
        Inf_2_rok.setVisibility(View.INVISIBLE);
        Inf_3_rok.setVisibility(View.INVISIBLE);
        Inf_4_rok.setVisibility(View.INVISIBLE);
        Inf_5_rok.setVisibility(View.INVISIBLE);

        AiR_1_rok.setVisibility(View.INVISIBLE);
        AiR_2_rok.setVisibility(View.INVISIBLE);
        AiR_3_rok.setVisibility(View.INVISIBLE);
        AiR_4_rok.setVisibility(View.INVISIBLE);
        AiR_5_rok.setVisibility(View.INVISIBLE);

        Ele_1_rok.setVisibility(View.INVISIBLE);
        Ele_2_rok.setVisibility(View.INVISIBLE);
        Ele_3_rok.setVisibility(View.INVISIBLE);
        Ele_4_rok.setVisibility(View.INVISIBLE);
        Ele_5_rok.setVisibility(View.INVISIBLE);

        EiT_1_rok.setVisibility(View.INVISIBLE);
        EiT_2_rok.setVisibility(View.INVISIBLE);
        EiT_3_rok.setVisibility(View.INVISIBLE);
        EiT_4_rok.setVisibility(View.INVISIBLE);
        EiT_5_rok.setVisibility(View.INVISIBLE);

        /*
        sprawdzanie czy w bazie danych jest taki child:
 */

        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild("Rok 1 Informatyka")) {
                    Inf_1_rok.setEnabled(true);
                }
                else {
                    Inf_1_rok.setEnabled(false);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Inf_1_rok.setEnabled(false);
            }
        });

        rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild("Rok 2 Informatyka")) {
                    Inf_2_rok.setEnabled(true);
                }
                else {
                    Inf_2_rok.setEnabled(false);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Inf_2_rok.setEnabled(false);
            }
        });


//dodawanie przycisku przez wejscie na karte
/*
        ConstraintLayout layout = findViewById(R.id.wyborgrupy);
        ConstraintSet set = new ConstraintSet();
        set.clone(layout);
        Button button = new Button(this);
        button.setText("1");
        button.setId(100);
        layout.addView(button);
        set.connect(button.getId(), ConstraintSet.TOP, EiT_1_rok.getId(), ConstraintSet.BOTTOM, 8);
        set.connect(button.getId(), ConstraintSet.RIGHT, EiT_1_rok.getId(), ConstraintSet.RIGHT, 0);
        set.connect(button.getId(),ConstraintSet.LEFT,EiT_1_rok.getId(),ConstraintSet.LEFT,0);
        set.constrainHeight(button.getId(), 170);
        set.applyTo(layout);
*/

        // fabMenu1 = findViewById(R.id.floatingActionMenu);
       // rok1Inf = findViewById(R.id.floatingActionItem1);

        /*dodawanie grup rpzez aplikacje
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference("Rok 1 Elektronika i Telekomunikacja/qwer123");
        Map<String,String> map = new HashMap<>();
        map.put("name","test");
        map.put("text","test");
        mDatabaseReference.setValue(map);
        */

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_group_menu, menu);
        return true;
    }

    private void addListenerButton() {
        final Context context = this;

        final EditText nazwagrupy = findViewById(R.id.nazwagrupy);

        final Button wstecz = findViewById(R.id.button11);
        final Button dodajgrupe = findViewById(R.id.button10);

        final Button Inf_Menu =  findViewById(R.id.Inf_menu);
        final Button Inf_1_rok= findViewById(R.id.Inf_1_rok);
        final Button Inf_2_rok= findViewById(R.id.Inf_2_rok);
        final Button Inf_3_rok= findViewById(R.id.Inf_3_rok);
        final Button Inf_4_rok= findViewById(R.id.Inf_4_rok);
        final Button Inf_5_rok= findViewById(R.id.Inf_5_rok);

        final Button AiR_Menu = findViewById(R.id.AiR_menu);
        final Button Air_1_rok= findViewById(R.id.AiR_1_rok);
        final Button Air_2_rok= findViewById(R.id.AiR_2_rok);
        final Button Air_3_rok= findViewById(R.id.AiR_3_rok);
        final Button Air_4_rok= findViewById(R.id.AiR_4_rok);
        final Button Air_5_rok= findViewById(R.id.AiR_5_rok);

        final Button Ele_Menu = findViewById(R.id.Ele_menu);
        final Button Ele_1_rok= findViewById(R.id.Ele_1_rok);
        final Button Ele_2_rok= findViewById(R.id.Ele_2_rok);
        final Button Ele_3_rok= findViewById(R.id.Ele_3_rok);
        final Button Ele_4_rok= findViewById(R.id.Ele_4_rok);
        final Button Ele_5_rok= findViewById(R.id.Ele_5_rok);

        final Button EiT_Menu = findViewById(R.id.EiT_menu);
        final Button EiT_1_rok= findViewById(R.id.EiT_1_rok);
        final Button EiT_2_rok= findViewById(R.id.EiT_2_rok);
        final Button EiT_3_rok= findViewById(R.id.EiT_3_rok);
        final Button EiT_4_rok= findViewById(R.id.EiT_4_rok);
        final Button EiT_5_rok= findViewById(R.id.EiT_5_rok);

        Inf_Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Inf_1_rok.isShown()) {
                    dodaj_grupe();
                    Inf_1_rok.setVisibility(View.INVISIBLE);
                    Inf_2_rok.setVisibility(View.INVISIBLE);
                    Inf_3_rok.setVisibility(View.INVISIBLE);
                    Inf_4_rok.setVisibility(View.INVISIBLE);
                    Inf_5_rok.setVisibility(View.INVISIBLE);
                }
                else {
                    Inf_1_rok.setVisibility(View.VISIBLE);
                    Inf_2_rok.setVisibility(View.VISIBLE);
                    Inf_3_rok.setVisibility(View.VISIBLE);
                    Inf_4_rok.setVisibility(View.VISIBLE);
                    Inf_5_rok.setVisibility(View.VISIBLE);
                }
            }
        });
        Inf_1_rok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                globalne_dane.MESSAGES_CHILD="Rok 1 Informatyka";
                startActivity(intent);
            }
        });
        Inf_2_rok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                globalne_dane.MESSAGES_CHILD="Rok 2 Informatyka";
                startActivity(intent);
            }
        });
        Inf_3_rok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                globalne_dane.MESSAGES_CHILD="Rok 3 Informatyka";
                startActivity(intent);
            }
        });
        Inf_4_rok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                globalne_dane.MESSAGES_CHILD="Rok 4 Informatyka";
                startActivity(intent);
            }
        });
        Inf_5_rok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                globalne_dane.MESSAGES_CHILD="Rok 5 Informatyka";
                startActivity(intent);
            }
        });

        AiR_Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Air_1_rok.isShown()) {
                    Air_1_rok.setVisibility(View.INVISIBLE);
                    Air_2_rok.setVisibility(View.INVISIBLE);
                    Air_3_rok.setVisibility(View.INVISIBLE);
                    Air_4_rok.setVisibility(View.INVISIBLE);
                    Air_5_rok.setVisibility(View.INVISIBLE);
                }
                else {
                    Air_1_rok.setVisibility(View.VISIBLE);
                    Air_2_rok.setVisibility(View.VISIBLE);
                    Air_3_rok.setVisibility(View.VISIBLE);
                    Air_4_rok.setVisibility(View.VISIBLE);
                    Air_5_rok.setVisibility(View.VISIBLE);
                }
            }
        });
        Air_1_rok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                globalne_dane.MESSAGES_CHILD="Rok 1 Automatyka i Robotyka";
                startActivity(intent);
            }
        });
        Air_2_rok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                globalne_dane.MESSAGES_CHILD="Rok 2 Automatyka i Robotyka";
                startActivity(intent);
            }
        });
        Air_3_rok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                globalne_dane.MESSAGES_CHILD="Rok 3 Automatyka i Robotyka";
                startActivity(intent);
            }
        });
        Air_4_rok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                globalne_dane.MESSAGES_CHILD="Rok 4 Automatyka i Robotyka";
                startActivity(intent);
            }
        });
        Air_5_rok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                globalne_dane.MESSAGES_CHILD="Rok 5 Automatyka i Robotyka";
                startActivity(intent);
            }
        });

        Ele_Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Ele_1_rok.isShown()) {
                    Ele_1_rok.setVisibility(View.INVISIBLE);
                    Ele_2_rok.setVisibility(View.INVISIBLE);
                    Ele_3_rok.setVisibility(View.INVISIBLE);
                    Ele_4_rok.setVisibility(View.INVISIBLE);
                    Ele_5_rok.setVisibility(View.INVISIBLE);
                }
                else {
                    Ele_1_rok.setVisibility(View.VISIBLE);
                    Ele_2_rok.setVisibility(View.VISIBLE);
                    Ele_3_rok.setVisibility(View.VISIBLE);
                    Ele_4_rok.setVisibility(View.VISIBLE);
                    Ele_5_rok.setVisibility(View.VISIBLE);
                }
            }
        });
        Ele_1_rok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                globalne_dane.MESSAGES_CHILD="Rok 1 Elektrotechnika";
                startActivity(intent);
            }
        });
        Ele_2_rok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                globalne_dane.MESSAGES_CHILD="Rok 2 Elektrotechnika";
                startActivity(intent);
            }
        });
        Ele_3_rok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                globalne_dane.MESSAGES_CHILD="Rok 3 Elektrotechnika";
                startActivity(intent);
            }
        });
        Ele_4_rok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                globalne_dane.MESSAGES_CHILD="Rok 4 Elektrotechnika";
                startActivity(intent);
            }
        });
        Ele_5_rok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                globalne_dane.MESSAGES_CHILD="Rok 5 Elektrotechnika";
                startActivity(intent);
            }
        });

        EiT_Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (EiT_1_rok.isShown()) {
                    EiT_1_rok.setVisibility(View.INVISIBLE);
                    EiT_2_rok.setVisibility(View.INVISIBLE);
                    EiT_3_rok.setVisibility(View.INVISIBLE);
                    EiT_4_rok.setVisibility(View.INVISIBLE);
                    EiT_5_rok.setVisibility(View.INVISIBLE);
                }
                else {
                    EiT_1_rok.setVisibility(View.VISIBLE);
                    EiT_2_rok.setVisibility(View.VISIBLE);
                    EiT_3_rok.setVisibility(View.VISIBLE);
                    EiT_4_rok.setVisibility(View.VISIBLE);
                    EiT_5_rok.setVisibility(View.VISIBLE);
                }
            }
        });
        EiT_1_rok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                globalne_dane.MESSAGES_CHILD="Rok 1 Elektronika i Telekomunikacja";
                startActivity(intent);
            }
        });
        EiT_2_rok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                globalne_dane.MESSAGES_CHILD="Rok 2 Elektronika i Telekomunikacja";
                startActivity(intent);
            }
        });
        EiT_3_rok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                globalne_dane.MESSAGES_CHILD="Rok 3 Elektronika i Telekomunikacja";
                startActivity(intent);
            }
        });
        EiT_4_rok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                globalne_dane.MESSAGES_CHILD="Rok 4 Elektronika i Telekomunikacja";
                startActivity(intent);
            }
        });
        EiT_5_rok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                globalne_dane.MESSAGES_CHILD="Rok 5 Elektronika i Telekomunikacja";
                startActivity(intent);
            }
        });
        wstecz.setOnClickListener(new View.OnClickListener() {
            LinearLayout linearLayout1= findViewById(R.id.linearLayout1);
            @Override
            public void onClick(View v) {
                linearLayout1.setVisibility(View.INVISIBLE);
            }
        });
        dodajgrupe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout linearLayout1= findViewById(R.id.linearLayout1);
                dodaj_grupe();
                EditText nazwagrupy = findViewById(R.id.nazwagrupy);

                nazwagrupy.getText().toString();
                //dodawanie grupy do bazy
                mFirebaseDatabase = FirebaseDatabase.getInstance();
                mDatabaseReference = mFirebaseDatabase.getReference("asd");
                Map<String,String> map = new HashMap<>();
                map.put("name","Administrator");
                map.put("text","Nowa grupa została utworzona");
                mDatabaseReference.setValue(map);
                linearLayout1.setVisibility(View.INVISIBLE);
                Toast.makeText(wybor_grupy.this,"Grupa została utworzona",10);
            }
        });

    }
    public void dodaj_grupe() {
        final Button button = new Button(this);
        final Button EiT_1_rok = findViewById(R.id.EiT_1_rok);
        ConstraintLayout layout = findViewById(R.id.constraintlayout);
        ConstraintSet set = new ConstraintSet();
        set.clone(layout);
        button.setText("1");
        button.setId(110);
        layout.addView(button);
        set.connect(button.getId(), ConstraintSet.TOP, EiT_1_rok.getId(), ConstraintSet.BOTTOM, 25);
        set.connect(button.getId(), ConstraintSet.RIGHT, EiT_1_rok.getId(), ConstraintSet.RIGHT, 0);
        set.connect(button.getId(),ConstraintSet.LEFT,EiT_1_rok.getId(),ConstraintSet.LEFT,0);
        set.constrainHeight(button.getId(), 170);
        set.applyTo(layout);
        button.setVisibility(View.VISIBLE);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        LinearLayout linearLayout1= findViewById(R.id.linearLayout1);
        switch (item.getItemId()) {
            case R.id.add_group:
                linearLayout1.setVisibility(View.VISIBLE);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
