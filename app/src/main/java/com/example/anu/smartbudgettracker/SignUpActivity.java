package com.example.anu.smartbudgettracker;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        final EditText edFName= (EditText)  findViewById(R.id.edFName);
        final EditText edLName= (EditText)  findViewById(R.id.edLName);
        final EditText edEmail= (EditText)  findViewById(R.id.edLname);
        final EditText edAge= (EditText)  findViewById(R.id.edAge);
        final EditText edUsername= (EditText)  findViewById(R.id.edUsername);
        final EditText edPassword= (EditText)  findViewById(R.id.edPassword);
        final Button bSignUp= (Button) findViewById(R.id.bSignUp);
        if (bSignUp != null) {
            bSignUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    final String fName= edFName.getText().toString();
                    final String lName= edLName.getText().toString();
                    final String email= edEmail.getText().toString();
                    final int age= Integer.parseInt(edAge.getText().toString());
                    final String username= edUsername.getText().toString();
                    final String password= edPassword.getText().toString();
                    Response.Listener<String> responseListener= new Response.Listener<String>(){
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject= new JSONObject(response);
                                boolean success= jsonObject.getBoolean("success");
                                Log.i("signupactivity", "request string on server =" + jsonObject.getString("request"));
                                if (success) {
                                    String fname= jsonObject.getString("fname");
                                    String lname= jsonObject.getString("lname");
                                    String email= jsonObject.getString("email");
                                    int  age= jsonObject.getInt("age");
                                    //Log.i("SignupActivity", "in success");
                                    Intent intent = new Intent(SignUpActivity.this, UserMainActivity.class);
                                    SignUpActivity.this.startActivity(intent);
                                }else {
                                    Log.e("SignupActivity", "in fail");
                                    AlertDialog.Builder builder=new AlertDialog.Builder(SignUpActivity.this);
                                    builder.setMessage("Signup unsucessfull!!") .setNegativeButton("retry",null) .create() .show();
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    };
                    Log.d("Signupactivity", fName);
                    Log.d("Signupactivity", lName);
                    Log.d("Signupactivity", email);

                    SignUpRequest signUpRequest=new SignUpRequest(fName,lName,email,age,username,password,responseListener);
                    RequestQueue requestQueue= Volley.newRequestQueue(SignUpActivity.this);
                    requestQueue.add(signUpRequest);

                }
            });
        }else{
            Log.e("SignupActivity", "Button bsignup is null");
        }
    }
}
