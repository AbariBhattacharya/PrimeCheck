package com.example.dell.primecheck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private static final String TAG = "HintActivity";
    private Button mShowCheatButton;

    int flag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        //final TextView primeNum = (TextView) findViewById(R.id.textViewCheat);
        //primeNum.setText(getIntent().getExtras().getString("prime"));

        mShowCheatButton = (Button) findViewById(R.id.showcheatbutton);
        mShowCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag=3;
                TextView myText = (TextView) findViewById(R.id.cheattext);
                String myString = "You have cheated";
                //String myString = String.valueOf(number);
               // textString = myString;
               //myText.setText(myString);
                myText.setText(myString);
                Intent intentc = new Intent();
                intentc.putExtra("anycheat",flag);
                setResult(RESULT_OK,intentc);

                //finish();

            }
        });
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

       // savedInstanceState.putInt(NUM_GEN, number);
        //savedInstanceState.putBoolean(CHECK_ANS,flag);
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "Inside onSaveInstance");
    }

}