package com.example.dell.primecheck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HintActivity extends AppCompatActivity {

    private static final String TAG = "HintActivity";
    private static final String HINT= "hint";
    private Button mShowHintButton;
    private String hint;
    int flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);

        TextView primeNum = (TextView)findViewById(R.id.textViewCheat);
        primeNum.setText(getIntent().getExtras().getString("prime"));

        if (savedInstanceState != null) {
            TextView myText = (TextView) findViewById(R.id.hinttext);
          hint= savedInstanceState.getString(HINT);
          myText.setText(hint);
        }

        mShowHintButton = (Button) findViewById(R.id.showhintbutton);
        mShowHintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //flag=2;
                TextView myText = (TextView) findViewById(R.id.hinttext);
                String myString = "A prime number (or a prime) is a natural number greater than 1 that has no positive divisors other than 1 and itself.";
                myText.setText(myString);
               Intent intent = new Intent();
                intent.putExtra("anything",2);
                setResult(RESULT_OK,intent);
                //finish();

            }
        });




    }
    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "Inside OnStart");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "Inside OnPause");
    }

    /*@Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "Inside OnREsume");

    }*/

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "Inside OnSTop");
    }

    @Override

    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Inside OnDestroy");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        //savedInstanceState.putInt(NUM_GEN, number);
        //savedInstanceState.putBoolean(CHECK_ANS,flag);
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "Inside onSaveInstance");
    }






}
