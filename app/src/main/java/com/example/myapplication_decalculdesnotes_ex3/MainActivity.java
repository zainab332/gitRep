package com.example.myapplication_decalculdesnotes_ex3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText note1;
    private EditText note2;
    private EditText note3;
    private EditText note4;
    private Button calculerButton;
    private TextView moyenneText;
    private TextView mentionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        note1 = findViewById(R.id.note1);
        note2 = findViewById(R.id.note2);
        note3 = findViewById(R.id.note3);
        note4 = findViewById(R.id.note4);
        calculerButton = findViewById(R.id.calculer_button);
        moyenneText = findViewById(R.id.moyenne_text);
        mentionText = findViewById(R.id.mention_text);

        calculerButton.setOnClickListener(v -> calculerMoyenne());
    }

    private void calculerMoyenne() {
        double n1 = Double.parseDouble(note1.getText().toString());
        double n2 = Double.parseDouble(note2.getText().toString());
        double n3 = Double.parseDouble(note3.getText().toString());
        double n4 = Double.parseDouble(note4.getText().toString());

        if (validerNotes(n1, n2, n3, n4)) {
            double moyenne = (n1 + n2 + n3 + n4) / 4;
            moyenneText.setText(String.format("Moyenne : %.2f", moyenne));

            String mention = obtenirMention(moyenne);
            mentionText.setText("Mention : " + mention);
        } else {
            Toast.makeText(this, "Les notes doivent être entre 0 et 20", Toast.LENGTH_LONG).show();
        }
    }

    private boolean validerNotes(double n1, double n2, double n3, double n4) {
        return (n1 >= 0 && n1 <= 20) && (n2 >= 0 && n2 <= 20) &&
                (n3 >= 0 && n3 <= 20) && (n4 >= 0 && n4 <= 20);
    }

    private String obtenirMention(double moyenne) {
        if (moyenne >= 16) {
            return "Excellent";
        } else if (moyenne >= 14) {
            return "Très bien";
        } else if (moyenne >= 12) {
            return "Bien";
        } else if (moyenne >= 10) {
            return "Assez bien";
        } else {
            return "Échec";
        }
    }
}
