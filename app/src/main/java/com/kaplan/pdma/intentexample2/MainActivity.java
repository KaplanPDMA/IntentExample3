package com.kaplan.pdma.intentexample2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int request_code = 123;
    private Context context = this;
    private EditText editTextQuestion;
    private TextView textViewReply;
    private Button buttonAsk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextQuestion = (EditText) findViewById(R.id.editTextQuestion);
        textViewReply = (TextView) findViewById(R.id.textViewReply);
        buttonAsk = (Button) findViewById(R.id.buttonAsk);

        buttonAsk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String question = editTextQuestion.getText().toString();

                Intent intentAsk = new Intent(context, Activity2.class);
                intentAsk.putExtra("question", question);
                startActivityForResult(intentAsk, request_code);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == request_code && resultCode == RESULT_OK) {
            String reply = data.getExtras().getString("reply");
            textViewReply.setText(reply);
        }
    }
}
