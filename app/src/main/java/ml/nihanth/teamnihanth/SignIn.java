package ml.nihanth.teamnihanth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends BaseActivity {

    private FirebaseAuth fa;
    private EditText ET_email;
    private EditText ET_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        ET_email = (EditText)findViewById(R.id.email);
        ET_password = (EditText)findViewById(R.id.password);
        fa = FirebaseAuth.getInstance();
    }

    public void signin(View view) {
        String email = ET_email.getText().toString().trim();
        String password = ET_password.getText().toString().trim();

    }
}
