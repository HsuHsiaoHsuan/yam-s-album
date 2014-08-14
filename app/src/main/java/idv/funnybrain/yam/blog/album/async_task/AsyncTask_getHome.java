package idv.funnybrain.yam.blog.album.async_task;

import android.content.AsyncTaskLoader;
import android.content.Context;
import de.greenrobot.event.EventBus;
import idv.funnybrain.yam.blog.album.event.Event_getHome;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by freeman on 2014/8/1.
 */
public class AsyncTask_getHome extends AsyncTaskLoader<Void> {

    // private Context mContext;

    public AsyncTask_getHome(Context context) {
        super(context);
        // mContext = context;
    }

    @Override
    public Void loadInBackground() {

        ArrayList<String> links = new ArrayList<String>();

        try {
            Document doc = Jsoup.connect("http://blog.yam.com/index.php?op=album").get();

            Elements items = doc.select(".main_bottoma .style_32 a[href]");
            Iterator<Element> iterator = items.iterator();

            while (iterator.hasNext()) {
                Element item = iterator.next();
                links.add(item.attr("href"));
                System.out.println("--------->" + item.attr("href"));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        EventBus.getDefault().post(new Event_getHome());

        return null;
    }
}