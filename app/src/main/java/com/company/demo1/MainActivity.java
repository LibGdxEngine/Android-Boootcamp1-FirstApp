package com.company.demo1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Declare one image_view & two buttons for our app
    ImageView image;
    Button nextBtn , backBtn;
    //make an array for holding images
    int [] images = {R.drawable._image1
            , R.drawable._image2
            , R.drawable._image3 ,
            R.drawable._image4 ,
            R.drawable._image5};
    //counter to specify our position
    int position = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize our image & button
        image = findViewById(R.id.image);
        nextBtn = findViewById(R.id.nextBtn);
        backBtn = findViewById(R.id.backBtn);
        //make a default image in the beginning
        image.setImageResource(images[position]);
        //when press on nextBtn move forward to the next image
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = (position + 1 ) % 5;
                image.setImageResource(images[position]);
            }
        });
        //when press on nextBtn move backward to the next image
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = (position - 1 ) % 5;
                //if position is less than zero we need to make it a positive value to avoid app crash
                if(position < 0){
                    position = 4;
                }
                image.setImageResource(images[position]);
            }
        });
    }
}
