package com.example.anu.smartbudgettracker;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

public class UserMainActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);
        toolbar= (Toolbar) findViewById(R.id.tbToolbar);
        setSupportActionBar(toolbar);
        tabLayout=(TabLayout) findViewById(R.id.tbLayout);
        ViewPager viewPager= (ViewPager) findViewById(R.id.viewPager);
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new Dashboard(),"Dashboard");
        viewPagerAdapter.addFragments(new Categories(),"Categories");
        viewPagerAdapter.addFragments(new History(),"History");
        viewPagerAdapter.addFragments(new Goal(),"Goal");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        /*//final EditText edFname= (EditText)  findViewById(R.id.edFname);
        //final EditText edLname= (EditText)  findViewById(R.id.edLname);
        ////final EditText edEmail= (EditText)  findViewById(R.id.edEmailid);
        //final EditText edAge= (EditText)  findViewById(R.id.edAge);*/
        //final TextView welcomeMessage= (TextView) findViewById(R.id.ltWelcomeMsg);
        //Intent intent=getIntent();
        //String fname=intent.getStringExtra("fname");
        /*String lname=intent.getStringExtra("lname");
        String email=intent.getStringExtra("email");
        String age=intent.getStringExtra("age");*/

        //String msg= "Welcome " + fname ;
        //welcomeMessage.setText(msg);
        //edFname.setText(fname);
        ////edLname.setText(lname);
        ////edEmail.setText(email);
        //edAge.setText(age);
    }
}
