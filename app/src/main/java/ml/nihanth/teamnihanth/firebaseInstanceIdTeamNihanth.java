package ml.nihanth.teamnihanth;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by nihanth007 on 04-09-2016.
 */
public class firebaseInstanceIdTeamNihanth extends FirebaseInstanceIdService {

    private static final String REG_TOKEN = "REG_TOKEN";

    @Override
    public void onTokenRefresh() {

        String recent_Token = FirebaseInstanceId.getInstance().getToken();
        Log.d(REG_TOKEN,recent_Token);
    }
}
