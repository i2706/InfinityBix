package com.example.infinity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.infinity.Database.database;


public class Fragment1 extends Fragment {
    Button SignIn;
    EditText mail;
    EditText password;
    EditText password2;
    EditText User;
    Button SignUp;
    EditText mail2;
    TextView NoAcc;
    Button Submit1;
    EditText mail1;
    database db1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        db1=new database(getContext(),"LoginData",null,1);

        View view = inflater.inflate(R.layout.fragment_1, container, false);

        TextView Acc=view.findViewById(R.id.account);

        Acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText user=view.findViewById(R.id.user);
                EditText mail3=view.findViewById(R.id.email1);
                EditText pass=view.findViewById(R.id.pass1);
                RelativeLayout relativeLayout=view.findViewById(R.id.rl7);
                RelativeLayout relativeLayout1=view.findViewById(R.id.rl4);
                relativeLayout.setVisibility(View.GONE);
                relativeLayout1.setVisibility(View.VISIBLE);
                user.getText().clear();
                mail3.getText().clear();
                pass.getText().clear();
            }

        });
        NoAcc=view.findViewById(R.id.signin);

        NoAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText Email=view.findViewById(R.id.email);
                EditText Password=view.findViewById(R.id.pass);
                RelativeLayout relativeLayout=view.findViewById(R.id.rl4);
                RelativeLayout relativeLayout1=view.findViewById(R.id.rl7);
                relativeLayout.setVisibility(View.GONE);
                relativeLayout1.setVisibility(View.VISIBLE);
                Email.getText().clear();
                Password.getText().clear();
            }
        });

        ImageView left =view.findViewById(R.id.left1);

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelativeLayout relativeLayout=view.findViewById(R.id.rl7);
                RelativeLayout relativeLayout1=view.findViewById(R.id.rl4);
                relativeLayout.setVisibility(View.GONE);
                relativeLayout1.setVisibility(View.VISIBLE);

            }
        });
        mail=view.findViewById(R.id.email);
        password=view.findViewById(R.id.pass);
        SignIn=view.findViewById(R.id.signin2);
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mail.getText().toString().isEmpty() && password.getText().toString().isEmpty()) {


                    Toast.makeText(getContext(), "Please Enter Mailid", Toast.LENGTH_SHORT).show();
                    return;
                }
                int c = db1.GetRow(mail.getText().toString(), password.getText().toString());
                if (c > 0)
                {
                    String U1=db1.getValue(mail.getText().toString(),"1");
                    String Password1=db1.getValue(mail.getText().toString(),"2");
                    SharedPreferences sharedPreferences= getContext().getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("user",U1);
                    editor.putString("email",mail.getText().toString());
                    editor.putString("pass",Password1);
                    editor.apply();

                    Toast.makeText(getContext(), "Successfully Login", Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(getContext(), "Check Your Entries", Toast.LENGTH_SHORT).show();
                }

            }

        });


        User=view.findViewById(R.id.user);
        mail2=view.findViewById(R.id.email1);
        password2=view.findViewById(R.id.pass1);
        SignUp=view.findViewById(R.id.signup);
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (User.getText().toString().isEmpty() && mail2.getText().toString().isEmpty() && password2.getText().toString().isEmpty()) {

                    Toast.makeText(getContext(), "Please Enter Username", Toast.LENGTH_SHORT).show();
                    return;

                }
                int c = db1.SubmitData(User.getText().toString(),mail2.getText().toString(),password2.getText().toString());

                if(c==0)
                {

                    Toast.makeText(getContext(),"Successfully Submit! Now Login",Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getContext(), "Email is already used", Toast.LENGTH_SHORT).show();

                }
            }

        });


        return view;
    }
}