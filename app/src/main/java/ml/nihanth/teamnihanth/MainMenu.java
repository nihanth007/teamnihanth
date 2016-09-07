package ml.nihanth.teamnihanth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainMenu extends AppCompatActivity implements View.OnClickListener  {

    private FirebaseAuth firebaseAuth;
    private Button signOut;
    private Button chatButton;
    private Button tasksButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.getCurrentUser();
        signOut = (Button)findViewById(R.id.signOutButton);
        chatButton = (Button)findViewById(R.id.chatButton);
        tasksButton = (Button)findViewById(R.id.tasksButton);
        signOut.setOnClickListener((View.OnClickListener) this);
        chatButton.setOnClickListener((View.OnClickListener) this);
        tasksButton.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View view) {
        if(view == signOut){
            firebaseAuth.signOut();
            Intent i = new Intent(MainMenu.this,SignIn.class);
            startActivity(i);
        }
        else if(view == chatButton){
            Intent i = new Intent(MainMenu.this,ChatActivity.class);
            startActivity(i);
        }
        else if(view == tasksButton){
            Intent i = new Intent(MainMenu.this,Tasks.class);
            startActivity(i);
        }

    }
}
