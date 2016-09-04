package ml.nihanth.teamnihanth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    private Button signOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.getCurrentUser();
        signOut = (Button)findViewById(R.id.signOutButton);
        signOut.setOnClickListener((View.OnClickListener) this);
    }
    private void signOut(){

    }

    @Override
    public void onClick(View view) {
        if(view == signOut){
            firebaseAuth.signOut();
            Intent i = new Intent(ChatActivity.this,SignIn.class);
            startActivity(i);
        }
    }
}
