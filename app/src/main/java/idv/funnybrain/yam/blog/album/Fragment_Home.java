package idv.funnybrain.yam.blog.album;

import android.app.Fragment;
import android.os.Bundle;
import de.greenrobot.event.EventBus;
import idv.funnybrain.yam.blog.album.async_task.AsyncTask_getHome;
import idv.funnybrain.yam.blog.album.event.Event_getHome;

/**
 * Created by freeman on 2014/7/31.
 */
public class Fragment_Home extends Fragment {

    private static final boolean D = true;
    private static final String TAG = "Fragment_Home";

    private volatile static Fragment_Home self;

    public Fragment_Home() {}

    public static Fragment_Home newInstance() {
        if (self == null) {
            synchronized (Fragment_Login.class) {
                if (self == null) {
                    self = new Fragment_Home();
                }
            }
        }
        return self;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);

        new AsyncTask_getHome(getActivity()).forceLoad();
    }

    @Override
    public void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    public void onEventMainThread(Event_getHome event) {

    }
}
