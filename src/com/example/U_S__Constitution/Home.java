package com.example.U_S__Constitution;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import id_tree.Node;

import java.lang.reflect.Field;

public class Home extends Activity {

    public static Node front;

    private double width = 0;
    private double height = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);


        Resources resources = getResources();
        Configuration config = resources.getConfiguration();
        DisplayMetrics dm = resources.getDisplayMetrics();
        width = (double)config.screenWidthDp * dm.density;
        height = width * dm.heightPixels / dm.widthPixels;

        TextView title1 = (TextView) findViewById(R.id.title);
        Typeface font = Typeface.createFromAsset(getAssets(), "USDeclaration.ttf");
        title1.setTypeface(font);

        title1.measure(0, 0);
        int tw = title1.getMeasuredWidth();
        int size = 0;
        while (tw < width && size < 50){
            size++;
            title1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, size);
            title1.measure(0, 0);
            tw = title1.getMeasuredWidth();
        }
        title1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, size - 1);




        TextView title2 = (TextView) findViewById(R.id.title2);
        title2.setTypeface(font);

        title2.measure(0, 0);
        tw = title2.getMeasuredWidth();
        size = 0;
        while (tw < width && size < 50){
            size++;
            title2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, size);
            title2.measure(0, 0);
            tw = title2.getMeasuredWidth();
        }
        title2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, size - 1);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, -3 * size, 0, 0);
        title2.setLayoutParams(params);

        LinearLayout  contents = (LinearLayout) findViewById(R.id.contents);
        contents.getLayoutParams().width = (int) (0.66 * width);

        createTree();
    }

    public void onClick(View v){
        int id = v.getId();
        switch (id) {
            case (R.id.a1): goToSections(1);
                break;
            case (R.id.a2): goToSections(2);
                break;
            case (R.id.a3): goToSections(3);
                break;
            case (R.id.a4): goToSections(4);
                break;
            case (R.id.a5): goToText(5);
                break;
            case (R.id.a6): goToText(6);
                break;
            case (R.id.a7): goToText(7);
                break;
            case (R.id.a8): goToSections(8);
                break;
        }
    }

    private void goToSections(int article){
        Intent intent = new Intent(this, Section.class);
        double[] info = {width, height};
        intent.putExtra("info", info);
        intent.putExtra("IDs", front.get(article - 1));
        startActivity(intent);
    }

    private void goToText(int article){
        Intent intent = new Intent(this, TextActivity.class);
        double[] info = {front.get(article - 1).getID(), width, height};
        intent.putExtra("info", info);
        startActivity(intent);
    }

    private static void createTree(){
        front = new Node(8);

        Node a1 = new Node(10);
        a1.add(new Node(0, R.string.a1_s1));
        a1.add(new Node(0, R.string.a1_s2));
        a1.add(new Node(0, R.string.a1_s3));
        a1.add(new Node(0, R.string.a1_s4));
        a1.add(new Node(0, R.string.a1_s5));
        a1.add(new Node(0, R.string.a1_s6));
        a1.add(new Node(0, R.string.a1_s7));
        a1.add(new Node(0, R.string.a1_s8));
        a1.add(new Node(0, R.string.a1_s9));
        a1.add(new Node(0, R.string.a1_s10));
        front.add(a1);

        Node a2 = new Node(4);
        a2.add(new Node(0, R.string.a2_s1));
        a2.add(new Node(0, R.string.a2_s2));
        a2.add(new Node(0, R.string.a2_s3));
        a2.add(new Node(0, R.string.a2_s4));
        front.add(a2);

        Node a3 = new Node(3);
        a3.add(new Node(0, R.string.a3_s1));
        a3.add(new Node(0, R.string.a3_s2));
        a3.add(new Node(0, R.string.a3_s3));
        front.add(a3);

        Node a4 = new Node(4);
        a4.add(new Node(0, R.string.a4_s1));
        a4.add(new Node(0, R.string.a4_s2));
        a4.add(new Node(0, R.string.a4_s3));
        a4.add(new Node(0, R.string.a4_s4));
        front.add(a4);

        Node a5 = new Node(0, R.string.a5);
        front.add(a5);

        Node a6 = new Node(0, R.string.a6);
        front.add(a6);

        Node a7 = new Node(0, R.string.a7);
        front.add(a7);

        Node a8 = new Node(27);
        a8.add(new Node(0, R.string.a8_s1));
        a8.add(new Node(0, R.string.a8_s2));
        a8.add(new Node(0, R.string.a8_s3));
        a8.add(new Node(0, R.string.a8_s4));
        a8.add(new Node(0, R.string.a8_s5));
        a8.add(new Node(0, R.string.a8_s6));
        a8.add(new Node(0, R.string.a8_s7));
        a8.add(new Node(0, R.string.a8_s8));
        a8.add(new Node(0, R.string.a8_s9));
        a8.add(new Node(0, R.string.a8_s10));
        a8.add(new Node(0, R.string.a8_s11));
        a8.add(new Node(0, R.string.a8_s12));
        a8.add(new Node(0, R.string.a8_s13));
        a8.add(new Node(0, R.string.a8_s14));
        a8.add(new Node(0, R.string.a8_s15));
        a8.add(new Node(0, R.string.a8_s16));
        a8.add(new Node(0, R.string.a8_s17));
        a8.add(new Node(0, R.string.a8_s18));
        a8.add(new Node(0, R.string.a8_s19));
        a8.add(new Node(0, R.string.a8_s20));
        a8.add(new Node(0, R.string.a8_s21));
        a8.add(new Node(0, R.string.a8_s22));
        a8.add(new Node(0, R.string.a8_s23));
        a8.add(new Node(0, R.string.a8_s24));
        a8.add(new Node(0, R.string.a8_s25));
        a8.add(new Node(0, R.string.a8_s26));
        a8.add(new Node(0, R.string.a8_s27));
        front.add(a8);
    }
}
