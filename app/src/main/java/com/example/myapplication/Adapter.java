package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {
    private ArrayList<Contact> listContact;
    private ArrayList<Contact> listContactBackup;
    private Activity context;
    private LayoutInflater inflater;

    public Adapter() {
    }

    public Adapter(ArrayList<Contact> data, Activity activity) {
        this.listContact = data;
        this.context = activity;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listContact.size();
    }

    @Override
    public Object getItem(int i) {
        return listContact.get(i);
    }

    @Override
    public long getItemId(int i) {
        return listContact.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewContact = view;
        if (view == null) {
            viewContact = inflater.inflate(R.layout.contact_item, null);
        }
        ((TextView) viewContact.findViewById(R.id.txtName)).setText(listContact.get(i).getName());
        ((TextView) viewContact.findViewById(R.id.txtPhone)).setText(listContact.get(i).getPhone());
        ((CheckBox) viewContact.findViewById(R.id.select)).setChecked(listContact.get(i).isChecked());

        ((CheckBox) viewContact.findViewById(R.id.select)).setOnClickListener(view1 -> {
            listContact.get(i).setChecked(((CheckBox) view1).isChecked());
        });

        viewContact.findViewById(R.id.btnCall).setOnClickListener(view1 -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + listContact.get(i).getPhone()));
            context.startActivity(intent);
        });

        viewContact.findViewById(R.id.btnSendMessage).setOnClickListener(view1 -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:" + listContact.get(i).getPhone()));
            context.startActivity(intent);
        });

        return viewContact;
    }

//    @Override
//    public Filter getFilter() {
//        return new Filter() {
//            @Override
//            protected FilterResults performFiltering(CharSequence charSequence) {
//                FilterResults filterResults = new FilterResults();
//                if (listContactBackup == null) {
//                    listContactBackup = new ArrayList<>(listContact);
//                }
//                if (charSequence == null || charSequence.length() == 0) {
//                    filterResults.values = listContactBackup;
//                    filterResults.count = listContactBackup.size();
//                } else {
//                    ArrayList<Contact> listContactFilter = new ArrayList<>();
//                    for (Contact contact : listContactBackup) {
//                        if (contact.getName().toLowerCase().contains(charSequence.toString().toLowerCase())) {
//                            listContactFilter.add(contact);
//                        }
//                    }
//                    filterResults.values = listContactFilter;
//                    filterResults.count = listContactFilter.size();
//                }
//                return filterResults;
//            }
//
//            @Override
//            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
//                listContact = (ArrayList<Contact>) filterResults.values;
//                notifyDataSetChanged();
//            }
//        };
//    }
}
