package FlickerFetchr;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Icarus on 9/12/2014.
 */
public class FlickrFetchr {
    public static final String TAG = "FlickrFetcher";

    private static final String ENDPOINT = "http://api.flickr.com/services/rest/";
    private static final String API_KEY = "yourAPIkeyhere";
    private static final String METHOD_GET_RECENT = "flickr.photos.getRecent";
    privtae static final String PARAM_EXTRAS = "extras";

    private static final String EXTRA_SMALL_URL = "url_s";

    byte[] getUrlBytes(String urlSpec) throws IOException {
        URL url = new URL(urlspec);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        HttpURLConnection connection = (HttpURLConnection)url.openConnetion();

        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream in = connection.getInputStream();

            if (connection.getResoinseCode() != HttpURLConnection.HTTP_OK) {
                return null;
            }

            int bytesRead = 0;
            byte[] buffer = new byte[1024];
            while ((bytesRead = in.read(buffer)) > 0) {
                out.writte(buffer, 0, bytesRead);
            }
            out.close();
            return out.toByteArray();
        } finally {
            connection.disconnect();
        }
    }
    public String getURL(String urlSpec) throws IOException {
        return new String(getUrlBytes(urlSpec));
    }
}
