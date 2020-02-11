package com.jesoft.colorpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.jesoft.colorpicker.R.layout.activity_main;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView mImageView;
    TextView mResultTv;
    View mColorView;

    Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

        ImageButton button1 = findViewById(R.id.imageButton1);
        button1.setOnClickListener(this);
       ImageButton button2 =  findViewById(R.id.imageButton2);
       button2.setOnClickListener(this);
        ImageButton button3 = findViewById(R.id.imageButton3);
        button3.setOnClickListener(this);
        ImageButton button4 =  findViewById(R.id.imageButton4);
        button4.setOnClickListener(this);
        ImageButton button5 =  findViewById(R.id.imageButton5);
        button5.setOnClickListener(this);

        mImageView = findViewById(R.id.imageView);
        mResultTv = findViewById(R.id.resultTv);
        mColorView = findViewById(R.id.colorView);

        mImageView.setDrawingCacheEnabled(true);
        mImageView.buildDrawingCache(true);

        mImageView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {

                    bitmap = mImageView.getDrawingCache();

                    int pixel = bitmap.getPixel((int) event.getX(), (int) event.getY());

                    int r = Color.red(pixel);
                    int g = Color.green(pixel);
                    int b = Color.blue(pixel);

                    String hex = "#" + Integer.toHexString(pixel);

                    mColorView.setBackgroundColor(Color.rgb(r, g, b));

                   mResultTv.setText("rgb " + r + ", " + g + ", " + b + "\nHex: " + hex);
                }
                return true;
            }
        });
    }


    public void onClick(View v) {
        switch (v.getId()){

            case R.id.imageButton1:
                Toast.makeText(this, "Button 1 Clicked", Toast.LENGTH_SHORT).show();

                break;
            case R.id.imageButton2:
                Toast.makeText(this, "Button 2 Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageButton3:
                Toast.makeText(this, "Button 3 Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageButton4:
                Toast.makeText(this, "Button 4 Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageButton5:
                Toast.makeText(this, "Button 5 Clicked", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
