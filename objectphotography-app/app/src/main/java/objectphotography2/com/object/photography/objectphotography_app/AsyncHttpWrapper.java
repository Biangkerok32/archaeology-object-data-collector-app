// HTTP Wrapper
// @author: msenol
package objectphotography2.com.object.photography.objectphotography_app;
import android.app.Activity;
import android.net.Uri;
import android.util.Log;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;
import java.io.File;
import java.io.FileNotFoundException;
import static objectphotography2.com.object.photography.objectphotography_app.StateStatic.LOGTAG;
import static objectphotography2.com.object.photography.objectphotography_app.StateStatic.showToastError;
public class AsyncHttpWrapper
{
    /**
     * upload image
     * @param url - destination URL
     * @param imageUri - image location
     * @param anActivity - calling activity
     * @param callbackWrapper - callback function
     */
    public static void makeImageUpload(String url, Uri imageUri, Activity anActivity,
                                       final AsyncHttpCallbackWrapper callbackWrapper)
    {
        // setting up variables to establish connection with server
        AsyncHttpClient client = new AsyncHttpClient();
        File myFile = new File(imageUri.getPath());
        RequestParams params = new RequestParams();
        try
        {
            Log.v(LOGTAG,"upload_picture=" + myFile.getPath());
            params.put("upload_picture", myFile);
        }
        catch(FileNotFoundException e)
        {
            showToastError(e, anActivity);
        }
        // send to database
        client.post(url, params, new TextHttpResponseHandler() {
            /**
             * methods implemented from AsyncHttpWrapper.java
             * @param statusCode - HTTP status
             * @param headers - HTTP headers
             * @param responseString - HTTP response
             * @param throwable - error
             */
            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers,
                                  String responseString, Throwable throwable)
            {
                Log.v(LOGTAG, "File upload failed");
                callbackWrapper.onFailureCallback(responseString);
                Log.v(LOGTAG, "responseString from file upload request: " + responseString);
            }

            /**
             * HTTP success
             * @param statusCode - HTTP status
             * @param headers - response headers
             * @param responseString - response body
             */
            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers,
                                  String responseString)
            {
                Log.v(LOGTAG, "File upload succeed");
                Log.v(LOGTAG, "responseString from file upload request: " + responseString);
                callbackWrapper.onSuccessCallback(responseString);
            }

            /**
             * Response started
             */
            @Override
            public void onStart()
            {
                super.onStart();
                Log.v(LOGTAG, "File upload started");
                callbackWrapper.onStartCallback();
            }

            /**
             * Retry request
             * @param retryNo - attempt number
             */
            @Override
            public void onRetry(int retryNo)
            {
                super.onRetry(retryNo);
                Log.v(LOGTAG, "Retrying File Upload retry number: " + retryNo);
                callbackWrapper.onRetryCallback(retryNo);
            }
        });
    }
}