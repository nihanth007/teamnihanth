package ml.nihanth.teamnihanth;

/**
 * Created by nihanth007 on 02-09-2016.
 */
import android.app.Application;
import android.os.Bundle;

import com.firebase.client.Firebase;

public class TeamNihanth extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }

}
