package com.example.piotr.projektinz;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Menu_glowne extends AppCompatActivity{

    Button btn2,btn3,btn9;
    Switch demo_switch;
    TextView help_text;
    ImageView help_screen;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_glowne);
        addListeneronButton();

        help_text.setVisibility(View.INVISIBLE);
        help_screen.setVisibility(View.INVISIBLE);
    }



    private void addListeneronButton() {
        final Context context = this;
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn9 = findViewById(R.id.button9);
        demo_switch = findViewById(R.id.switch2);
        help_text = findViewById(R.id.textView2);
        help_screen = findViewById(R.id.imageView4);



        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, plan_zajec.class);
                startActivity(intent);
            }
        });
        /*btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
            }
        });*/
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, wybor_grupy.class);
                startActivity(intent);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,usosweb.class);
                startActivity(intent);
            }
        });

        demo_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(demo_switch.isChecked()) {
                    btn2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            help_text.setVisibility(View.VISIBLE);
                            help_text.setText("Przycisk umozliwijający przejście do menu wyboru dni tygodnia ukazujących plan dnia");
                            btn2.setBackgroundColor(Color.RED);
                            btn3.setBackgroundColor(0xFF1B50D7);
                            btn9.setBackgroundColor(0xFF1B50D7);
                            help_screen.setVisibility(View.VISIBLE);
                            help_screen.setImageResource(R.drawable.demo_screen_menu_glowne_1);
                        }
                    });
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            help_text.setVisibility(View.VISIBLE);
                            help_text.setText("Przycisk umożliwiający przejście do czatu grupowego");
                            btn2.setBackgroundColor(0xFF1B50D7);
                            btn3.setBackgroundColor(Color.RED);
                            btn9.setBackgroundColor(0xFF1B50D7);
                            help_screen.setVisibility(View.VISIBLE);
                            help_screen.setImageResource(R.drawable.demo_screen_menu_glowne_3);

                        }
                    });
                    btn9.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            help_text.setVisibility(View.VISIBLE);
                            help_text.setText("Przycisk umożliwiający przejście do strony z bezpośrednim dostępem do uczelnianego UsosWeb'u");
                            btn2.setBackgroundColor(0xFF1B50D7);
                            btn3.setBackgroundColor(0xFF1B50D7);
                            btn9.setBackgroundColor(Color.RED);
                            help_screen.setVisibility(View.VISIBLE);
                            help_screen.setImageResource(R.drawable.demo_screen_menu_glowne_2);

                        }
                    });
                }
                else {
                    help_text.setVisibility(View.INVISIBLE);
                    btn2.setBackgroundColor(0xFF1B50D7);
                    btn3.setBackgroundColor(0xFF1B50D7);
                    btn9.setBackgroundColor(0xFF1B50D7);
                    help_screen.setVisibility(View.INVISIBLE);
                    btn2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(context, plan_zajec.class);
                            startActivity(intent);
                        }
                    });
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(context, MainActivity.class);
                            startActivity(intent);
                        }
                    });
                    /*btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(context, wybor_grupy.class);
                            startActivity(intent);
                        }
                    });*/
                    btn9.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(context,usosweb.class);
                            startActivity(intent);
                        }
                    });
                }
            }
        });


    }
}
