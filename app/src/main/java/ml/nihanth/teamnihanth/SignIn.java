package ml.nihanth.teamnihanth;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class SignIn extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth fa;
    private EditText ET_email;
    private EditText ET_password;
    private Button signinButton;
    private TextView textViewRegister;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        progressDialog = new ProgressDialog(this);
        ET_email = (EditText)findViewById(R.id.email);
        ET_password = (EditText)findViewById(R.id.password);
        fa = FirebaseAuth.getInstance();
        signinButton = (Button) findViewById(R.id.signinButton);
        textViewRegister = (TextView) findViewById(R.id.textViewRegister);
        signinButton.setOnClickListener(this);
        textViewRegister.setOnClickListener(this);
    }

    public void signInUser() {
        String email = ET_email.getText().toString().trim();
        String password = ET_password.getText().toString().trim();

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
        progressDialog.setMessage(" Signing In ");
        progressDialog.show();
        fa.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    //User is Successfully Registered
                    progressDialog.dismiss();
                    Toast.makeText(SignIn.this, " You are Successfully Signed In ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignIn.this,MainMenu.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(SignIn.this, " Please Try Again ", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onClick(View view) {

        if(view == signinButton){
            signInUser();
        }
        if(view == textViewRegister){
            // Login Activity
            Intent intent = new Intent(SignIn.this,MainActivity.class);
            startActivity(intent);
        }
    }
}
