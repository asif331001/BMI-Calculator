package com.example.bmicalculatorefun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    EditText edWeight, edFeet, edInch, edAge;
    Button btnResult;
    TextView tvResult, maleTxt, femaleTxt;
    ImageView img, maleImg, femaleImg;

    CardView maleCard, femaleCard;

    LinearLayout maleLL, femaleLL;

    LottieAnimationView fat, normal, thin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fat = findViewById(R.id.cat_workout);
        thin = findViewById(R.id.eating_cat);
        normal = findViewById(R.id.party_cat);


        edWeight = findViewById(R.id.edWeight);
        edFeet = findViewById(R.id.edFeet);
        edInch = findViewById(R.id.edInch);
        edAge = findViewById(R.id.edAge);
        btnResult = findViewById(R.id.btnResult);
        tvResult = findViewById(R.id.tvResult);
        maleTxt = findViewById(R.id.maleTxt);
        femaleTxt = findViewById(R.id.femaleTxt);
        img = findViewById(R.id.img);
        maleImg = findViewById(R.id.maleImg);
        femaleImg = findViewById(R.id.femaleImg);
        maleCard = findViewById(R.id.maleCard);
        femaleCard = findViewById(R.id.femaleCard);
        maleLL = findViewById(R.id.maleLL);
        femaleLL = findViewById(R.id.femaleLL);



        maleCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maleLL.setBackgroundColor(getResources().getColor(R.color.metalBlue));
                femaleLL.setBackgroundColor(getResources().getColor(R.color.white));

            }
        });
 femaleCard.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                maleLL.setBackgroundColor(getResources().getColor(R.color.white));
                femaleLL.setBackgroundColor(getResources().getColor(R.color.metalBlue));
            }
        });

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sWeight = edWeight.getText().toString();
                String sFeet = edFeet.getText().toString();
                String sInch = edInch.getText().toString();
                String sAge = edAge.getText().toString();


                if (sWeight.isEmpty() || sFeet.isEmpty() || sInch.isEmpty() || sAge.isEmpty()) {
                    Toast.makeText(MainActivity.this, "সব গুলো খালি ঘর পূরণ করতে হবে", Toast.LENGTH_SHORT).show();
                } else {

                    float weight = Float.parseFloat(sWeight);

                    float feet = Float.parseFloat(sFeet);

                    float inch = Float.parseFloat(sInch);

                    float age = Float.parseFloat(sAge);


                    float height = (float) (feet * 0.3048 + inch * 0.0254);
                    float bmiIndex = weight / (height * height);

                    if (age >= 20) {
                        if (bmiIndex < 12) {
                            tvResult.setText("তোমার BMI Index: " + bmiIndex + "\n তুমি তো অনেক বেশিই শুকনা, বেশি বেশি পুষ্টিকর খাবার খাও, না হলে ফু দিলেই তো উরে যাবা");
                            tvResult.setTextColor(getResources().getColor(R.color.lg));
                            img.setVisibility(View.VISIBLE);

                            thin.setVisibility(View.VISIBLE);
                            normal.setVisibility(View.INVISIBLE);
                            fat.setVisibility(View.INVISIBLE);
                        } else if (bmiIndex > 12 && bmiIndex < 18.6) {
                            tvResult.setText("তোমার BMI Index: " + bmiIndex + "\n তুমি অনেক শুকনা, বেশি বেশি পুষ্টিকর খাবার খাও");
                            tvResult.setTextColor(getResources().getColor(R.color.lgreen));
                            img.setVisibility(View.VISIBLE);

                            thin.setVisibility(View.VISIBLE);
                            normal.setVisibility(View.INVISIBLE);
                            fat.setVisibility(View.INVISIBLE);
                        } else if (bmiIndex > 18.6 && bmiIndex < 25) {
                            tvResult.setText("তোমার BMI Index: " + bmiIndex + "\n খুব ভাল, তুমি পারফেক্ট");
                            tvResult.setTextColor(getResources().getColor(R.color.green));
                            img.setVisibility(View.VISIBLE);

                            normal.setVisibility(View.VISIBLE);
                            fat.setVisibility(View.INVISIBLE);
                            thin.setVisibility(View.INVISIBLE);
                        } else if (bmiIndex > 25 && bmiIndex < 30) {
                            tvResult.setText("তোমার BMI Index: " + bmiIndex + "\n তুমি মোটা ব্যায়াম কর, ওজন কমাও");
                            tvResult.setTextColor(getResources().getColor(R.color.ylw));
                            img.setVisibility(View.VISIBLE);

                            fat.setVisibility(View.VISIBLE);
                            thin.setVisibility(View.INVISIBLE);
                            normal.setVisibility(View.INVISIBLE);
                        } else if (bmiIndex > 30 && bmiIndex < 35) {
                            tvResult.setText("তোমার BMI Index: " + bmiIndex + "\n তুমি অনেক মোটা, কম কম খাও আর ব্যায়াম কর");
                            tvResult.setTextColor(getResources().getColor(R.color.orng));
                            img.setVisibility(View.VISIBLE);

                            fat.setVisibility(View.VISIBLE);
                            thin.setVisibility(View.INVISIBLE);
                            normal.setVisibility(View.INVISIBLE);
                        } else if (bmiIndex > 35 && bmiIndex < 40) {
                            tvResult.setText("তোমার BMI Index: " + bmiIndex + "\n তুমি অনেক বেশি মোটা, কম কম খাও আর বেশি বেশি ব্যায়াম কর");
                            tvResult.setTextColor(getResources().getColor(R.color.red));
                            img.setVisibility(View.VISIBLE);

                            fat.setVisibility(View.VISIBLE);
                            thin.setVisibility(View.INVISIBLE);
                            normal.setVisibility(View.INVISIBLE);
                        } else if (bmiIndex > 40) {
                            tvResult.setText("তোমার BMI Index: " + bmiIndex + "\n তুমি অনেক অনেক বেশি মোটা, কম কম খাও আর বেশি বেশি ব্যায়াম কর, please, ওজন কমাও ");
                            tvResult.setTextColor(getResources().getColor(R.color.vlt));
                            img.setVisibility(View.VISIBLE);

                            fat.setVisibility(View.VISIBLE);
                            thin.setVisibility(View.INVISIBLE);
                            normal.setVisibility(View.INVISIBLE);
                        }

                    } else {
                        Toast.makeText(MainActivity.this, "এটা বাচ্চাদের জন্য না, বয়স ১৯ এর বেশি দেও", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }
}