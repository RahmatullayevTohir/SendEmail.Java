package com.example.sendemailjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtreciver;
    EditText edtTopic;
    EditText edtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {

         edtreciver = findViewById(R.id.et_reciver);
         edtTopic = findViewById(R.id.et_topic);
         edtMessage = findViewById(R.id.et_message);
        Button button = findViewById(R.id.btn_sendMessage);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });

    }

    private void sendMessage(){

        String reciver =edtreciver.getText().toString();
        String topic  = edtTopic.getText().toString();
        String message = edtMessage.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {reciver});
        intent.putExtra(Intent.EXTRA_SUBJECT,topic);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        intent.setType("message/*");

        startActivity(Intent.createChooser(intent, "Choose an Email..."));

    }

}