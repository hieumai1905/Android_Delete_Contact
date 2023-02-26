package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Contact> listContact;
    private Adapter adapter;
    private ListView listViewContact;
    private Button delete;
    private Button addContact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listContact = new ArrayList<>();
        listViewContact = findViewById(R.id.listView);
        delete = findViewById(R.id.btnDel);
        addContact = findViewById(R.id.btnAdd);
        listContact.add(new Contact(1, "mai van hieu", "0123456789", "image"));
        listContact.add(new Contact(2, "mai van hieu", "0123456789", "image"));
        listContact.add(new Contact(3, "mai van hieu", "0123456789", "image"));
        listContact.add(new Contact(4, "mai van hieu", "0123456789", "image"));
        adapter = new Adapter(listContact, this);
        listViewContact.setAdapter(adapter);
        delete.setOnClickListener(view -> {
            for (int i = 0; i < listContact.size(); i++) {
                if (listContact.get(i).isChecked()) {
                    listContact.remove(i);
                    i--;
                }
            }
            adapter.notifyDataSetChanged();
        });

        addContact.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, NewContact.class);
            startActivityForResult(intent, 100);
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == 10) {
                Contact contact = new Contact();
                contact.setId(Integer.parseInt(data.getStringExtra("id")));
                contact.setName(data.getStringExtra("name"));
                contact.setPhone(data.getStringExtra("phone"));
                listContact.add(contact);
            }
            adapter.notifyDataSetChanged();
        }
    }
}