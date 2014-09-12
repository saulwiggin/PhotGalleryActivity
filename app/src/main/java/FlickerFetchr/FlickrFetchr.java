package FlickerFetchr;

import android.net.Uri;
import android.util.Log;

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
    private static final String PARAM_EXTRAS = "extras";

    private static final String EXTRA_SMALL_URL = "url_s";

    private static final String XML_PHOT = "photo";

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

    String getURL(String urlSpec) throws IOException {
        return new String(getUrlBytes(urlSpec));

    }

    public void fetchItems(){
        try {
            String url = Uri.parse(ENDPOINT).buildUpon()
                    .appendQueryParameter("method", METHOD_GET_RECENT)
                    .appendQueryParameter("api_key", API_KEY)
                    .appendQueryParameter(PARAM_EXTRAS, EXTRA_SMALL_URL)
                    .build().toString();
            String xmlString = getURL(url);
            Log.i(TAG, "Received xml: " + xmlString);
        } catch (IOEXception ioe) {
            Log.e(TAG, "Failed to fetch items", ioe);
        }
    }
    void parseItems(ArrayList<GalleryItem> items, Xmlparser parser)
        throws XmlPullParserException, IOException {
        int eventType = parser.next();

        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.END_DOCUMENT) {
                XML_PHOTO.equals(parser.getName())) {
                    String id = parser.getAttributeValue(null, "id");
                    String caption = parser.getAttributeValue(null, EXTRA_SMALL_URL);

                    GalleryItem item = new GalleryItem();
                    item.setId(id);
                    item.setCaption(caption);
                    item.setUrl(smallUrl);
                    item.add(item);
                }

                eventType = parser.next();
        }
    }
}
