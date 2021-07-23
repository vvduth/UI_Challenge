package org.mycode.ui_challenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Main activity" ;

    private EditText edtTxtName,  edtTxtEmail, edtTextPassword, edtTextPasswordConfirm ;
    private Button buttonPickImage, btnRegister;
    private TextView txtWrongName, txtWrongEmail, txtWrongPassword, txtPassNotMatch;
    private RadioGroup rgGender ;
    private CheckBox agreementCheck ;
    private ConstraintLayout parent ;
    private Spinner spinnerCountries ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        buttonPickImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Yet to talk about", Toast.LENGTH_SHORT).show();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initRegister() ;
            }
        });
    }

    private void initRegister(){ //check if the user fill all the informations in the form
        Log.d(TAG, "initRegister: Started");
        if(validateData()){
            if(agreementCheck.isChecked()){
                showSnackBar();
            } else {
                Toast.makeText(this,"Please agree to the licence agreement",Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void showSnackBar(){
        Log.d(TAG, "showSNACKBAR: Started");
        txtWrongName.setVisibility(View.GONE);
        txtWrongEmail.setVisibility(View.GONE);
        txtWrongPassword.setVisibility(View.GONE);
        txtPassNotMatch.setVisibility(View.GONE);

        Snackbar.make(parent, "User Registered", Snackbar.LENGTH_INDEFINITE)
                .setAction("Dismiss", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();
    }

    private boolean validateData(){
        Log.d(TAG, "ValidateData: Started") ;
        if(edtTxtName.getText().toString().equals("")){
            txtWrongName.setVisibility(View.VISIBLE);
            txtWrongName.setText("Invalid name, please enter again");
            return false;
        }

        if(edtTxtEmail.getText().toString().equals("")){
            txtWrongEmail.setVisibility(View.VISIBLE);
            txtWrongEmail.setText("Invalid email, please enter again");
            return false;
        }

        if(edtTextPassword.getText().toString().equals("")){
            txtWrongPassword.setVisibility(View.VISIBLE);
            txtWrongPassword.setText("Invalid password, please enter again");
            return false;
        }

        if(edtTextPasswordConfirm.getText().toString().equals("")){
            txtPassNotMatch.setVisibility(View.VISIBLE);
            txtPassNotMatch.setText("Password does not match, please enter again");
            return false;
        }
        return true ;
    }

    private void initViews() {
        Log.d(TAG, "initView: Started");
        edtTxtName = findViewById(R.id.edtTxtName);
        edtTxtEmail = findViewById(R.id.edtTxtEmail);
        edtTextPassword = findViewById(R.id.edtTextPassword);
        edtTextPasswordConfirm = findViewById(R.id.edtTextPasswordConfirm);


        buttonPickImage = findViewById(R.id.buttonPickImage);
        btnRegister = findViewById(R.id.btnRegister);

        txtWrongName = findViewById(R.id.txtWrongName);
        txtWrongEmail = findViewById(R.id.txtWrongEmail);
        txtWrongPassword = findViewById(R.id.txtWrongPassword);
        txtPassNotMatch = findViewById(R.id.txtPassNotMatch);

        spinnerCountries = findViewById(R.id.spinnerCountry);
        rgGender = findViewById(R.id.rgGender);
        agreementCheck = findViewById(R.id.agreementCheck);
        parent = findViewById(R.id.parent);


    }
}