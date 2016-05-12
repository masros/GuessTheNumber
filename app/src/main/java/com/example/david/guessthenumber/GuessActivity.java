package com.example.david.guessthenumber;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Random;


public class GuessActivity extends AppCompatActivity {

    TextView textView, textViewinfo;
    CompoundButton mySwitch;
    Random RND;
    int myRND;
    int max, min;
    int chkCounter = 0;
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guess_layout);
        textView = (TextView) findViewById(R.id.textViewResult);
        textViewinfo = (TextView) findViewById(R.id.textViewInfo);

        newGame();

        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    mySwitch.setText("Hard 1 to 100 ");
                    newGame();
                } else {
                    mySwitch.setText("Easy 1 to 10 ");
                    newGame();
                }
            }
        });

    }

    public void newGame() {

        mySwitch = (CompoundButton) findViewById(R.id.switch1);

        if (mySwitch.isChecked()) {
            max = 100;
            min = 1;
            mySwitch.setText("Hard 1 to 100 ");
        } else {
            max = 11;
            min = 1;
            mySwitch.setText("Easy 1 to 10 ");
        }
        chkCounter = 1;
        textView.setText("");
        RND = new Random();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        myRND = RND.nextInt(max - min) + min;
        TextView textV = (TextView) findViewById(R.id.TextViewTitel);
        textV.setText("Guess the Number");
        textView.setTextSize(60);
        textViewinfo.setText("");

    }

    public boolean chk() {

        if ((mySwitch.isChecked() == true) && (chkCounter < 8))
            return true;
        else if ((mySwitch.isChecked() == false) && (chkCounter < 5))
            return true;
        else return false;
    }

    public void buttonOnClick(View v) {
        String btnLbl = "";
        Button button = (Button) v;
        btnLbl = "" + button.getText();
        switch (btnLbl) {
            case "0":
                textView.setText(textView.getText().toString() + button.getText());
                break;
            case "1":
                textView.setText(textView.getText().toString() + button.getText());
                break;
            case "2":
                textView.setText(textView.getText().toString() + button.getText());
                break;
            case "3":
                textView.setText(textView.getText().toString() + button.getText());
                break;
            case "4":
                textView.setText(textView.getText().toString() + button.getText());
                break;
            case "5":
                textView.setText(textView.getText().toString() + button.getText());
                break;
            case "6":
                textView.setText(textView.getText().toString() + button.getText());
                break;
            case "7":
                textView.setText(textView.getText().toString() + button.getText());
                break;
            case "8":
                textView.setText(textView.getText().toString() + button.getText());
                break;
            case "9":
                textView.setText(textView.getText().toString() + button.getText());
                break;
            case "CLEAR":
                textView.setText("");
                break;
            case "New Game":
                newGame();
                break;
            case "CHECK":
               if (textView.getText().toString().length()>0 )
                if (chk()) {
                    chkCounter++;
                    try {
                        if (myRND == Integer.valueOf(textView.getText().toString())) {
                            textView.setTextSize(30);
                            textView.setText("Hooray, you've opened the lock on tray "+chkCounter);
                        } else if (myRND < Integer.valueOf(textView.getText().toString())) {
                            textViewinfo.setText("Less then " + textView.getText());
                            textView.setText("");
                        } else {
                            textViewinfo.setText("Greater then " + textView.getText());
                            textView.setText("");
                        }


                    } catch (Exception e) {

                        textViewinfo.setText("Error !!! Plase press New Game ");
                    }

                } else {
        textView.setTextSize(55     );
                    textView.setText("You Lose\nAnswer is:" + myRND);

                }
                break;


        }


    }
}