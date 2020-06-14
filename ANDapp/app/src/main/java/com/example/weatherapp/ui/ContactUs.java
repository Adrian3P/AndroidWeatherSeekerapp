package com.example.weatherapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.weatherapp.R;

public class ContactUs extends Fragment {
    private EditText email;
    private EditText subject;
    private EditText body;
    private Button send;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View routeView = inflater.inflate(R.layout.contactus_fragment, container, false);
        email = routeView.findViewById(R.id.fieldEmail);
        subject = routeView.findViewById(R.id.subjectEmail);
        body = routeView.findViewById(R.id.bodyMessage);
        send = routeView.findViewById(R.id.Send);
        send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email.getText().toString()});
                intent.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, body.getText().toString());
                startActivity(intent);
            }
        });
        return routeView;
    }
}