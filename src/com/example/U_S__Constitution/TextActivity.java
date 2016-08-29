package com.example.U_S__Constitution;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.TextView;
import id_tree.Node;

public class TextActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text);

        Intent intent = getIntent();
        double[] info = intent.getDoubleArrayExtra("info");
        TextView txt = (TextView) findViewById(R.id.text);
        txt.setWidth((int) (0.90 * info[1]));
        txt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        txt.setText((int) info[0]);
    }
}
