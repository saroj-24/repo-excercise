package com.example.contactsave;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    Button savebutton;
    EditText nametext,numbertext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        savebutton = findViewById(R.id.savebtn);
        nametext = findViewById(R.id.nametxt);
        numbertext = findViewById(R.id.numbertxt);

        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_CONTACTS )!= PackageManager.PERMISSION_GRANTED)
                {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_CONTACTS},0);
                }
                else
                {
                    String name = nametext.getText().toString();
                    String number = numbertext.getText().toString();
                    Intent intent = new Intent(Intent.ACTION_INSERT);
                    intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
                    intent.putExtra(ContactsContract.Intents.Insert.NAME,name);
                    intent.putExtra(ContactsContract.Intents.Insert.PHONE,number);
                    startActivity(intent);
                }
            }
        });
    }
    private void savecontact()
    {
        Toast.makeText(this, "contact save", Toast.LENGTH_SHORT).show();
    }
    private  void deletecontact()
    {
        Toast.makeText(this, "contact delete", Toast.LENGTH_SHORT).show();
    }


}