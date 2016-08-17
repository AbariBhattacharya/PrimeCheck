package com.example.dell.primecheck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class PrimeActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;

    private static final String TAG = "QuizActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime);

        mTrueButton = (Button) findViewById(R.id.TrueButton);
        mTrueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                TextView myText = (TextView)findViewById(R.id.textViewer);
                int num=Integer.parseInt(myText.getText().toString());
                boolean flag = checkPrime(num);
                if(flag==false)
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();


                Log.d(TAG, "Clicked True");

            }
        });

        mFalseButton = (Button) findViewById(R.id.FalseButton);
        mFalseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                TextView myText = (TextView)findViewById(R.id.textViewer);
                int num=Integer.parseInt(myText.getText().toString());
                boolean flag = checkPrime(num);
                Log.d(TAG, "after flag");
                if(flag==false)
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_LONG).show();


                Log.d(TAG, "Clicked False");

            }
        });
    }

    private boolean checkPrime(int num) {
        int f=0;
        int number=num;
        boolean a=true;
        for(int i=2;i<number;i++){
            if(number%i==0)
            {
                System.out.println(number+" is not a Prime Number");
                f = 1;
                a = false;
                System.out.println("a in not a prime: " +a);

                break;
            }
        }
        if(f==0) {
            System.out.println(number + " is a Prime Number");
            a = true;
            System.out.println("a in prime: " + a);
        }
return a;
    }

    public void generate(View view) {
        Random r = new Random();
        int number = r.nextInt(1000)+1;
        TextView myText = (TextView)findViewById(R.id.textViewer);
        String myString = String.valueOf(number);
        myText.setText(myString);

    }

    public void generateLand(View view) {
        Random r = new Random();
        int number = r.nextInt(1000)+1;
        TextView myText = (TextView)findViewById(R.id.textViewer);
        String myString = String.valueOf(number);
        myText.setText(myString);

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);

        Log.i(TAG, "Inside onSaveInstance");
    }

    @Override
    public void onStart()
    {
        super.onStart();
        Log.d(TAG, "Inside OnStart");
    }

    @Override
    public void onPause()
    {
        super.onPause();
        Log.d(TAG,"Inside OnPause");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"Inside OnREsume");

    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "Inside OnSTop");
    }

    @Override

    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Inside OnDestroy");
    }


}
