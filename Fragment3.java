package com.example.infinity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.infinity.Database.database;


public class Fragment3 extends Fragment {
    database db1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_3, container, false);
        db1=new database(getContext(),"LoginData",null,1);
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
        String s=sharedPreferences.getString("newemail",null);
        Log.d("a", ""+s);
        Cursor cursor= db1.Details(s);
        Log.d("data is", String.valueOf(cursor.getCount()));

        if (cursor.moveToFirst()){
            do{

                String n1 =cursor.getString(cursor.getColumnIndex("user"));
                String n2=cursor.getString(cursor.getColumnIndex("email"));
                String n3 =cursor.getString(cursor.getColumnIndex("pass"));
                TextView textView=view.findViewById(R.id.name);
                TextView textView1=view.findViewById(R.id.mail2);
                TextView textView2=view.findViewById(R.id.passw);
                textView.setText(n1);
                textView1.setText(n2);
                textView2.setText(n3);
            }while(cursor.moveToNext());
        }
        cursor.close();

        return view;
    }
}