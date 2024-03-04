    package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

    public class MainActivity extends AppCompatActivity {

        private EditText editTextWeight, editTextHeight;
        private TextView textViewResult;
        private Button btncalc;
        private ImageView imageViewResult;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            editTextWeight = findViewById(R.id.editTextWeight);
            editTextHeight = findViewById(R.id.editTextHeight);
            textViewResult = findViewById(R.id.textViewResult);
            imageViewResult = findViewById(R.id.ImageView);
            btncalc = findViewById(R.id.btncalc);

            btncalc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calculateBMI();
                }
            });
        }

        private void calculateBMI() {
            String weightStr = editTextWeight.getText().toString();
            String heightStr = editTextHeight.getText().toString();

            if (weightStr.isEmpty() || heightStr.isEmpty()) {
                Toast.makeText(this, "Veuillez entrer votre poids et votre taille.", Toast.LENGTH_SHORT).show();
                return;
            }

            float weight = Float.parseFloat(weightStr);
            float height = Float.parseFloat(heightStr) ; // Convertir la taille en mètres

            float imc= weight / (height * height);

            String interpretation;

            if (imc >= 40) {
                interpretation = "Obésité morbide ou ma";
            } else if (imc >= 35) {
                interpretation = "Obésité sévère";
            } else if (imc >= 30) {
                interpretation = "Obésité modérée";
            } else if (imc >= 25) {
                interpretation = "Surpoids";
            } else if (imc >= 18.5) {
                interpretation = "Corpulence normale";
            } else if (imc >= 16.5) {
                interpretation = "Maigreur";
            } else {
                interpretation = "Famine";
            }

            String result = "IMC: " + imc + "\nInterprétation: " + interpretation;
            textViewResult.setText(result);


            int imageResource;
            switch (interpretation) {
                case "Obésité morbide ou ma":
                    imageResource = R.drawable.img1;
                    break;
                case "Obésité sévère":
                    imageResource = R.drawable.img2;
                    break;
                case "Obésité modérée":
                    imageResource = R.drawable.img3;
                    break;
                case "Surpoids":
                    imageResource = R.drawable.img4;
                    break;
                case "Corpulence normale":
                    imageResource = R.drawable.img1;
                    break;
                case "Maigreur":
                    imageResource = R.drawable.img2;
                    break;
                case "Famine":
                    imageResource = R.drawable.img3;
                    break;
                default:
                    // Default image if interpretation is unknown
                    imageResource = R.drawable.img4;
                    break;
            }

            imageViewResult.setImageResource(imageResource);
        }

    }
