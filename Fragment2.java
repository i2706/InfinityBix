package com.example.infinity;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.infinity.Database.database;


public class Fragment2 extends Fragment {
    database db1;
    int i=0;
    int p;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_2, container, false);
        db1=new database(getContext(),"LoginData",null,1);
        Cursor data= db1.AllDetails();
        LinearLayout Parentlayout=view.findViewById(R.id.r2);

        if(data.moveToFirst()){
            do{
                ++i;
                final String email=data.getString(data.getColumnIndex("email"));
                String pass =data.getString(data.getColumnIndex("pass"));

                LinearLayout layout=new LinearLayout(getContext());
                layout.setOrientation(LinearLayout.HORIZONTAL);
                layout.setWeightSum(2);
                LinearLayout.LayoutParams layoutParamTV=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,1);
                LinearLayout.LayoutParams layoutParamParent=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,3);


                p=i+100;
                TextView text2=new TextView(getContext());
                text2.setText(email);
                text2.setTextSize(10);
                text2.setId(p);
                text2.setTextColor(getResources().getColor(R.color.black));
                text2.setPadding(35,35,35,35);
                text2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

                TextView text3=new TextView(getContext());
                text3.setText(pass);
                text3.setTextSize(10);
                text3.setId(i);
                text3.setTextColor(getResources().getColor(R.color.black));
                text3.setPadding(35,35,35,35);
                text3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);


                layout.addView(text2,layoutParamTV);
                layout.addView(text3,layoutParamTV);

                Parentlayout.addView(layout,layoutParamParent);



                int id = getResources().getIdentifier(String.valueOf(p), "id", "com.my.package");
                TextView input3=view.findViewById(id);
                input3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        clearimage1();
                        ImageView i3 = getActivity().findViewById(R.id.m4);
                        i3.setBackgroundResource(R.drawable.newwhome);
                        TextView tt=view.findViewById(id);
                        SharedPreferences sharedPreferences = getContext().getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("newemail",tt.getText().toString());
                        editor.commit();

                        FragmentTransaction f1=getFragmentManager().beginTransaction();
                        f1.replace(R.id.fragments,new Fragment3());
                        f1.commit();
                    }

                    private void clearimage1() {
                        ImageView i3 = getActivity().findViewById(R.id.m3);
                        i3.setBackgroundResource(R.drawable.homebw);
                        ImageView i4 = getActivity().findViewById(R.id.m4);
                        i4.setBackgroundResource(R.drawable.homebw);

                    }
                });

            }while(data.moveToNext());

        }
        data.close();


        return view;


    }

}