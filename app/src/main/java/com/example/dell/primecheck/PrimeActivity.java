package com.example.dell.primecheck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
//import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class PrimeActivity extends AppCompatActivity {
    static final String NUM_GEN = "numberGen";
    //static final String CHECK_ANS="ansPrime";
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mText;
    private Button mHintButton;
    private Button mCheatButton;
    private String textString;
    public int number;
    public boolean flag;
    public int check;

    private static final String TAG = "PrimeActivity";
    private static final int REQUEST_CODE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_prime);
        Log.d(TAG, "in OnCreate function");
        mText = (TextView) findViewById(R.id.textViewer);
        if (savedInstanceState != null) {
            System.out.println("saved instance is not null");
            number = savedInstanceState.getInt(NUM_GEN);
            System.out.println("number is: " + number);
            String myString = String.valueOf(number);
            textString = myString;
            mText.setText(myString);
            //flag= savedInstanceState.getBoolean(CHECK_ANS);
        }

        // mText = (TextView)findViewById(R.id.textViewer);
        mText.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {
                                         Random r = new Random();
                                         number = r.nextInt(1000) + 1;
                                         //TextView myText = (TextView)findViewById(R.id.textViewer);
                                         String myString = String.valueOf(number);
                                         textString = myString;
                                         mText.setText(myString);
                                         System.out.println(number);
                                     }
                                 }
        );

        mHintButton = (Button) findViewById(R.id.hintbutton);
        mHintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.dell.primecheck.HintActivity");
                intent.putExtra("prime", mText.getText().toString());

                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        mCheatButton = (Button) findViewById(R.id.cheatbutton);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.dell.primecheck.CheatActivity");
                intent.putExtra("prime number", number);
                startActivityForResult(intent, REQUEST_CODE);

            }
        });


        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r = new Random();
                number = r.nextInt(1000) + 1;
                TextView myText = (TextView) findViewById(R.id.textViewer);
                String myString = String.valueOf(number);
                myText.setText(myString);
                System.out.println(number);
            }
        });


        mTrueButton = (Button) findViewById(R.id.TrueButton);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView myText = (TextView) findViewById(R.id.textViewer);
                int num = Integer.parseInt(myText.getText().toString());
                flag = checkPrime(num);
                if (flag == false)
                    Toast.makeText(getApplicationContext(), "Sorry, Incorrect!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Well Done!", Toast.LENGTH_SHORT).show();


                Log.d(TAG, "Clicked True");

            }
        });

        mFalseButton = (Button) findViewById(R.id.FalseButton);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView myText = (TextView) findViewById(R.id.textViewer);
                int num = Integer.parseInt(myText.getText().toString());
                flag = checkPrime(num);
                Log.d(TAG, "after flag");
                if (flag == false)
                    Toast.makeText(getApplicationContext(), "Well Done!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Sorry, Incorrect!", Toast.LENGTH_SHORT).show();


                Log.d(TAG, "Clicked False");

            }
        });
    }

    private boolean checkPrime(int num) {
        int f = 0;
        int n = num;
        boolean a = true;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                System.out.println(n + " is not a Prime Number");
                f = 1;
                a = false;
                System.out.println("a in not a prime: " + a);

                break;
            }
        }
        if (f == 0) {
            System.out.println(n + " is a Prime Number");
            a = true;
            System.out.println("a in prime: " + a);
        }
        return a;
    }

  /* public void generate(View view) {
        Random r = new Random();
        number = r.nextInt(1000)+1;
        TextView myText = (TextView)findViewById(R.id.textViewer);
        String myString = String.valueOf(number);
        myText.setText(myString);

    }

    public void generateLand(View view) {
        Random r = new Random();
        number = r.nextInt(1000)+1;
        TextView myText = (TextView)findViewById(R.id.textViewer);
        String myString = String.valueOf(number);
        myText.setText(myString);

    }*/

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putInt(NUM_GEN, number);
        //savedInstanceState.putBoolean(CHECK_ANS,flag);
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "Inside onSaveInstance");
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

    @Override
    public void onResume() {
        super.onResume();
        //int mainFlag=getIntent().getIntExtra()
        if (check == 1) {
            Toast.makeText(getApplicationContext(), "Hey you got a hint! Now try yourself", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "Inside OnREsume:for hint");

        }
        if (check == 2) {
            Toast.makeText(getApplicationContext(), "You have cheated..Very Bad!", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "Inside OnREsume:for cheat");
        }
    }


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
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE)
            if (resultCode == RESULT_OK) {
                check = 1;
            }
        if (resultCode == RESULT_FIRST_USER) {

            check = 2;
        }


    }
}