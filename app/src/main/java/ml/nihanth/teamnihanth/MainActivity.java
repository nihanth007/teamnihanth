package ml.nihanth.teamnihanth;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button registerButton;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignin;
    private FirebaseAuth fa;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fa = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        registerButton = (Button) findViewById(R.id.registerButton);

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        textViewSignin = (TextView) findViewById(R.id.textViewSignin);

        registerButton.setOnClickListener(this);
        textViewSignin.setOnClickListener(this);

    }

    private void registerUser(){
        String email = editTextEmail.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            //Email is Empty
            Toast.makeText(this , " Please Enter Email",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            //Password is Empty
            Toast.makeText(this , " Please Enter Password",Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage(" Registering ");
        progressDialog.show();
        fa.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    //User is Successfully Registered
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this, " User Successfully Registered ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,SignIn.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(MainActivity.this, " Please Try Again ", Toast.LENGTH_SHORT).show();
            }
        });
        progressDialog.dismiss();
    }

    @Override
    public void onClick(View view) {

        if(view == registerButton){
            registerUser();
        }
        if(view == textViewSignin){
            // Login Activity
            Intent intent = new Intent(MainActivity.this,SignIn.class);
            startActivity(intent);
        }
    }
}
