package com.example.U_S__Constitution;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import id_tree.Node;

import java.util.HashMap;

public class Section extends Activity {

    private HashMap<Integer, Integer> sectionMap;
    private double dim[];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.section);

        sectionMap = new HashMap<>();
        dim = new double[2];

        Intent intent = getIntent();
        dim = intent.getDoubleArrayExtra("info");
        Node ids = (Node) intent.getSerializableExtra("IDs");
        int numSections = ids.length();
        int width = (int) dim[0];
        LinearLayout sections = (LinearLayout) findViewById(R.id.sections);
        for (int i = 0; i < numSections; i++){
            Button b  = new Button(this);
            b.setText("Section " + convertToRoman(i + 1));
            b.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 24);
            b.setWidth((int)(0.66 * width));
            sections.addView(b);
            int buttonID = View.generateViewId();
            b.setId(buttonID);

            sectionMap.put(buttonID, ids.get(i).getID());

            b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    buttonPress(v.getId());
                }
            });
        }
    }

    private String convertToRoman(int n){
        String s = "";
        while (n >= 10) {
            s += "X";
            n -= 10;
        }
        while (n >= 9) {
            s += "IX";
            n -= 9;
        }
        while (n >= 5) {
            s += "V";
            n -= 5;
        }
        while (n >= 4) {
            s += "IV";
            n -= 4;
        }
        while (n >= 1) {
            s += "I";
            n -= 1;
        }
        return s;
    }

    private void buttonPress(int id){
        Intent textIntent = new Intent(this, TextActivity.class);
        double[] info = {sectionMap.get(id), dim[0], dim[1]};
        textIntent.putExtra("info", info);
        startActivity(textIntent);
    }

}
