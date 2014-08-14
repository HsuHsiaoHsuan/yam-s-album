package idv.funnybrain.yam.blog.album;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by freeman on 2014/7/31.
 */
public class Fragment_Login extends Fragment {

    private static final boolean D = false;
    private static final String TAG = "Fragment_Login";

    private volatile static Fragment_Login self;

    public Fragment_Login() {}

    public static Fragment_Login newInstance() {
        if (self == null) {
            synchronized (Fragment_Login.class) {
                if (self == null) {
                    self = new Fragment_Login();
                }
            }
        }
        return self;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, null);

        return view;
    }
}
