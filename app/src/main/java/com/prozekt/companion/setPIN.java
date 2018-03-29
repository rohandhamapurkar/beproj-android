package com.prozekt.companion;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class setPIN extends AppCompatActivity {

    private EditText pinOne;
    private EditText pinTwo;
    private PrefManager prefManager;
    private Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_pin);
        prefManager = new PrefManager(this);
        pinOne = findViewById(R.id.setPin);
        pinTwo = findViewById(R.id.confirmPin);
        Button button = findViewById(R.id.savePin);
        ctx = this;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });
    }

    void validate() {
        View focusView = null;
        boolean cancel = false;
        final String pinone = pinOne.getText().toString();
        final String pintwo = pinTwo.getText().toString();
        pinOne.setError(null);
        pinTwo.setError(null);

        if (pinone.length() != 4 && pintwo.length()!=4) {
            cancel = true;
            pinOne.setError("PIN should be 4 digit only");
            focusView = pinOne;
        } else if (!pinone.equals(pintwo)) {
            cancel = true;
            pinOne.setError("The PIN do not match");
            focusView = pinTwo;
        } else {
            prefManager.setPinValue(Integer.parseInt(pinone));
            prefManager.setFirstTimeLaunch(Boolean.FALSE);
            Intent intent = new Intent(ctx, MainActivity.class);
            ctx.startActivity(intent);
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(false);
        finishAndRemoveTask ();
    }
}
