package com.kaplan.pdma.intentexample2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    private static final int request_code = 123;
    private Context context = this;
    private EditText editTextReply;
    private TextView textViewQuestion;
    private Button buttonReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        textViewQuestion = (TextView) findViewById(R.id.textViewQuestion);
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            String question = extras.getString("question");
            textViewQuestion.setText(question);
        }

        editTextReply = (EditText) findViewById(R.id.editTextReply);
        buttonReply = (Button) findViewById(R.id.buttonReply);

        buttonReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String reply = editTextReply.getText().toString();

                Intent intentReply = new Intent();
                intentReply.putExtra("reply", reply);
                setResult(RESULT_OK, intentReply);

                finish();
            }
        });

    }

}
