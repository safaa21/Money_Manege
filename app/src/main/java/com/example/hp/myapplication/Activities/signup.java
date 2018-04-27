package com.example.hp.myapplication.Activities;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.example.hp.myapplication.DB.DatabaseHelper;
import com.example.hp.myapplication.DB.InputValidation;
import com.example.hp.myapplication.DB.User;
import com.example.hp.myapplication.R;

public class signup extends AppCompatActivity  implements View.OnClickListener{

        public final AppCompatActivity activity = signup.this;

        public NestedScrollView nestedScrollView;

    public TextInputLayout textInputLayoutName;
    public TextInputLayout textInputLayoutPassword;
    public TextInputLayout textInputLayoutConfirmPassword;

    public TextInputEditText textInputEditTextName;
    public TextInputEditText textInputEditTextPassword;
    public TextInputEditText textInputEditTextConfirmPassword;

    public AppCompatButton appCompatButtonRegister;
    public AppCompatTextView appCompatTextViewLoginLink;

    public InputValidation inputValidation;
    public DatabaseHelper databaseHelper;
    public User user;

        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_signup);

            initViews();
            initListeners();
            initObjects();
        }

        private void initViews(){
            nestedScrollView = findViewById(R.id.nestedScrollView);

            textInputLayoutName =  findViewById(R.id.textInputLayoutName);
            textInputLayoutPassword = findViewById(R.id.textInputLayoutPassword);
            textInputLayoutConfirmPassword = findViewById(R.id.textInputLayoutConfirmPassword);

            textInputEditTextName =  findViewById(R.id.name);
            textInputEditTextPassword =  findViewById(R.id.pass1);
            textInputEditTextConfirmPassword =  findViewById(R.id.pass2);

            appCompatButtonRegister =  findViewById(R.id.BTN_SIGNUP);


            appCompatTextViewLoginLink = findViewById(R.id.appCompatTextViewLoginLink);
        }

        private void initListeners(){
            appCompatButtonRegister.setOnClickListener(this);
            appCompatTextViewLoginLink.setOnClickListener(this);
        }

        private void initObjects(){
            inputValidation = new InputValidation(activity);
            databaseHelper = new DatabaseHelper(activity);
            user = new User();
        }

        @Override
        public void onClick(View v){
            switch (v.getId()){
                case R.id.BTN_SIGNUP:
                    postDataToSQLite();
                    break;
                case R.id.appCompatTextViewLoginLink:
                    finish();
                    break;
            }
        }

        private void postDataToSQLite() {
            if (!inputValidation.isInputEditTextFilled(textInputEditTextName, textInputLayoutName, getString(R.string.error_message_name))) {
                return;
            }

            if (!inputValidation.isInputEditTextFilled(textInputEditTextPassword, textInputLayoutPassword, getString(R.string.error_message_password))) {
                return;
            }
            if (!inputValidation.isInputEditTextMatches(textInputEditTextPassword, textInputEditTextConfirmPassword,
                    textInputLayoutConfirmPassword, getString(R.string.error_password_match))) {
                return;
            }

            if (!databaseHelper.checkUser(textInputEditTextName.getText().toString().trim())) {

                user.setName(textInputEditTextName.getText().toString().trim());
                user.setPassword(textInputEditTextPassword.getText().toString().trim());
                databaseHelper.addUser(user);
       //         String id = databaseHelper.getID();
         //       SharedPreferences prefs = getSharedPreferences(id, MODE_PRIVATE);
           //     int I_D = prefs.getInt("id", 0); //0 is the default value.


                Snackbar.make(nestedScrollView, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
                emptyInputEditText();

            } else
                Snackbar.make(nestedScrollView, getString(R.string.error_email_exists), Snackbar.LENGTH_LONG).show();
        }


        private void emptyInputEditText(){
            textInputEditTextName.setText(null);
            textInputEditTextPassword.setText(null);
            textInputEditTextConfirmPassword.setText(null);
        }}