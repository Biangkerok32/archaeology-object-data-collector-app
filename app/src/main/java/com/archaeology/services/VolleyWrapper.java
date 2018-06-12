// URL communication wrapper
// @author: Christopher Besser and msenol
package com.archaeology.services;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.archaeology.models.ImageResponseWrapper;
import com.archaeology.models.JSONObjectResponseWrapper;
import static com.android.volley.Request.Method;
import static com.archaeology.util.StateStatic.DEFAULT_VOLLEY_TIMEOUT;
public class VolleyWrapper
{
    /**
     * Get list of API methods
     * @param URL - camera URL
     * @param queue - request queue
     * @param ID - request id
     * @param LAMBDA_WRAPPER - request wrapper
     * @throws JSONException if the JSON is malformed
     */
    public static void getAPIList(final String URL, RequestQueue queue, final int ID,
                                  final JSONObjectResponseWrapper LAMBDA_WRAPPER) throws JSONException
    {
        final String POST_BODY = new JSONObject().put("method", "getAvailableApiList")
                .put("params", new JSONArray()).put("id", ID).put("version", "1.0").toString();
        JSONObject JSONPOSTBody = new JSONObject(POST_BODY);
        JsonObjectRequest myRequest = new JsonObjectRequest(Method.POST, URL, JSONPOSTBody,
                new Response.Listener<JSONObject>() {
            /**
             * Response received
             * @param response - database response
             */
            @Override
            public void onResponse(JSONObject response)
            {
                LAMBDA_WRAPPER.responseMethod(response);
            }
        }, new Response.ErrorListener() {
            /**
             * Connection error
             * @param error - failure
             */
            @Override
            public void onErrorResponse(VolleyError error)
            {
                LAMBDA_WRAPPER.errorMethod(error);
            }
        });
        myRequest.setRetryPolicy(new DefaultRetryPolicy(20000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(myRequest);
    }

    /**
     * Get supported live view sizes
     * @param URL - camera URL
     * @param queue - request queue
     * @param ID - request id
     * @param LAMBDA_WRAPPER - request wrapper
     * @throws JSONException if the JSON is malformed
     */
    public static void getSupportedLiveViewSize(final String URL, RequestQueue queue, final int ID,
                                                final JSONObjectResponseWrapper LAMBDA_WRAPPER) throws JSONException
    {
        final String POST_BODY = new JSONObject().put("method", "getSupportedLiveviewSize")
                .put("params", new JSONArray()).put("id", ID).put("version", "1.0").toString();
        JSONObject JSONPOSTBody = new JSONObject(POST_BODY);
        JsonObjectRequest myRequest = new JsonObjectRequest(Method.POST, URL, JSONPOSTBody,
                new Response.Listener<JSONObject>() {
            /**
             * Response received
             * @param response - database response
             */
            @Override
            public void onResponse(JSONObject response)
            {
                LAMBDA_WRAPPER.responseMethod(response);
            }
        }, new Response.ErrorListener() {
            /**
             * Connection error
             * @param error - failure
             */
            @Override
            public void onErrorResponse(VolleyError error)
            {
                LAMBDA_WRAPPER.errorMethod(error);
            }
        });
        myRequest.setRetryPolicy(new DefaultRetryPolicy(20000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(myRequest);
    }

    /**
     * Get available live view sizes
     * @param URL - camera URL
     * @param queue - request queue
     * @param ID - request id
     * @param LAMBDA_WRAPPER - request wrapper
     * @throws JSONException if the JSON is malformed
     */
    public static void getAvailableLiveViewSize(final String URL, RequestQueue queue, final int ID,
                                                final JSONObjectResponseWrapper LAMBDA_WRAPPER) throws JSONException
    {
        final String POST_BODY = new JSONObject().put("method", "getAvailableLiveviewSize")
                .put("params", new JSONArray()).put("id", ID).put("version", "1.0").toString();
        JSONObject JSONPOSTBody = new JSONObject(POST_BODY);
        JsonObjectRequest myRequest = new JsonObjectRequest(Method.POST, URL, JSONPOSTBody,
                new Response.Listener<JSONObject>() {
            /**
             * Response received
             * @param response - database response
             */
            @Override
            public void onResponse(JSONObject response)
            {
                LAMBDA_WRAPPER.responseMethod(response);
            }
        }, new Response.ErrorListener() {
            /**
             * Connection error
             * @param error - failure
             */
            @Override
            public void onErrorResponse(VolleyError error)
            {
                LAMBDA_WRAPPER.errorMethod(error);
            }
        });
        myRequest.setRetryPolicy(new DefaultRetryPolicy(20000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(myRequest);
    }

    /**
     * Set the camera function
     * @param URL - camera URL
     * @param queue - request queue
     * @param ID - request id
     * @param function - function to enable
     * @param LAMBDA_WRAPPER - request wrapper
     * @throws JSONException if the JSON is malformed
     */
    public static void setCameraFunction(final String URL, RequestQueue queue, final int ID, String function,
                                         final JSONObjectResponseWrapper LAMBDA_WRAPPER) throws JSONException
    {
        final String POST_BODY = new JSONObject().put("method", "setCameraFunction")
                .put("params", new JSONArray().put(function)).put("id", ID)
                .put("version", "1.0").toString();
        JSONObject JSONPOSTBody = new JSONObject(POST_BODY);
        JsonObjectRequest myRequest = new JsonObjectRequest(Method.POST, URL, JSONPOSTBody,
                new Response.Listener<JSONObject>() {
            /**
             * Response received
             * @param response - database response
             */
            @Override
            public void onResponse(JSONObject response)
            {
                LAMBDA_WRAPPER.responseMethod(response);
            }
        }, new Response.ErrorListener() {
            /**
             * Connection error
             * @param error - failure
             */
            @Override
            public void onErrorResponse(VolleyError error)
            {
                LAMBDA_WRAPPER.errorMethod(error);
            }
        });
        myRequest.setRetryPolicy(new DefaultRetryPolicy(20000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(myRequest);
    }

    /**
     * Set the camera function
     * @param URL - camera URL
     * @param queue - request queue
     * @param ID - request id
     * @param LAMBDA_WRAPPER - request wrapper
     * @throws JSONException if the JSON is malformed
     */
    public static void getCameraFunction(final String URL, RequestQueue queue, final int ID,
                                         final JSONObjectResponseWrapper LAMBDA_WRAPPER) throws JSONException
    {
        final String POST_BODY = new JSONObject().put("method", "getCameraFunction")
                .put("params", new JSONArray()).put("id", ID).put("version", "1.0").toString();
        JSONObject JSONPOSTBody = new JSONObject(POST_BODY);
        JsonObjectRequest myRequest = new JsonObjectRequest(Method.POST, URL, JSONPOSTBody,
                new Response.Listener<JSONObject>() {
            /**
             * Response received
             * @param response - database response
             */
            @Override
            public void onResponse(JSONObject response)
            {
                LAMBDA_WRAPPER.responseMethod(response);
            }
        }, new Response.ErrorListener() {
            /**
             * Connection error
             * @param error - failure
             */
            @Override
            public void onErrorResponse(VolleyError error)
            {
                LAMBDA_WRAPPER.errorMethod(error);
            }
        });
        myRequest.setRetryPolicy(new DefaultRetryPolicy(20000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(myRequest);
    }

    /**
     * Get list of API methods
     * @param URL - camera URL
     * @param queue - request queue
     * @param ID - request id
     * @param LAMBDA_WRAPPER - request wrapper
     * @throws JSONException if the JSON is malformed
     */
    public static void startRecMode(final String URL, RequestQueue queue, final int ID,
                                    final JSONObjectResponseWrapper LAMBDA_WRAPPER) throws JSONException
    {
        final String POST_BODY = new JSONObject().put("method", "startRecMode")
                .put("params", new JSONArray()).put("id", ID).put("version", "1.0").toString();
        JSONObject JSONPOSTBody = new JSONObject(POST_BODY);
        JsonObjectRequest myRequest = new JsonObjectRequest(Method.POST, URL, JSONPOSTBody,
                new Response.Listener<JSONObject>() {
            /**
             * Response received
             * @param response - database response
             */
            @Override
            public void onResponse(JSONObject response)
            {
                LAMBDA_WRAPPER.responseMethod(response);
            }
        }, new Response.ErrorListener() {

            /**
             * Connection error
             * @param error - failure
             */
            @Override
            public void onErrorResponse(VolleyError error)
            {
                LAMBDA_WRAPPER.errorMethod(error);
            }
        });
        myRequest.setRetryPolicy(new DefaultRetryPolicy(20000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(myRequest);
    }

    /**
     * Get list of API methods
     * @param URL - camera URL
     * @param queue - request queue
     * @param ID - request id
     * @param LAMBDA_WRAPPER - request wrapper
     * @throws JSONException if the JSON is malformed
     */
    public static void stopRecMode(final String URL, RequestQueue queue, final int ID,
                                    final JSONObjectResponseWrapper LAMBDA_WRAPPER) throws JSONException
    {
        final String POST_BODY = new JSONObject().put("method", "stopRecMode")
                .put("params", new JSONArray()).put("id", ID).put("version", "1.0").toString();
        JSONObject JSONPOSTBody = new JSONObject(POST_BODY);
        JsonObjectRequest myRequest = new JsonObjectRequest(Method.POST, URL, JSONPOSTBody,
                new Response.Listener<JSONObject>() {
            /**
             * Response received
             * @param response - database response
             */
            @Override
            public void onResponse(JSONObject response)
            {
                LAMBDA_WRAPPER.responseMethod(response);
            }
        }, new Response.ErrorListener() {

            /**
             * Connection error
             * @param error - failure
             */
            @Override
            public void onErrorResponse(VolleyError error)
            {
                LAMBDA_WRAPPER.errorMethod(error);
            }
        });
        myRequest.setRetryPolicy(new DefaultRetryPolicy(20000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(myRequest);
    }

    /**
     * Send photo request
     * @param URL - camera URL
     * @param queue - request queue
     * @param ID - request id
     * @param LAMBDA_WRAPPER - request wrapper
     * @throws JSONException if the JSON is malformed
     */
    public static void makeVolleySonyAPITakePhotoRequest(final String URL, RequestQueue queue, final int ID,
                                                         final JSONObjectResponseWrapper LAMBDA_WRAPPER)
            throws JSONException
    {
        final String POST_BODY = new JSONObject().put("method", "actTakePicture")
                .put("params", new JSONArray()).put("id", ID).put("version", "1.0").toString();
        JSONObject JSONPOSTBody = new JSONObject(POST_BODY);
        JsonObjectRequest myRequest = new JsonObjectRequest(Method.POST, URL, JSONPOSTBody,
                new Response.Listener<JSONObject>() {
            /**
             * Response received
             * @param response - database response
             */
            @Override
            public void onResponse(JSONObject response)
            {
                LAMBDA_WRAPPER.responseMethod(response);
            }
        }, new Response.ErrorListener() {
            /**
             * Connection error
             * @param error - failure
             */
            @Override
            public void onErrorResponse(VolleyError error)
            {
                LAMBDA_WRAPPER.errorMethod(error);
            }
        });
        myRequest.setRetryPolicy(new DefaultRetryPolicy(20000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(myRequest);
    }

    /**
     * Request camera feed
     * @param URL - camera URL
     * @param queue - request queue
     * @param ID - request id
     * @param LAMBDA_WRAPPER - request wrapper
     * @throws JSONException if the JSON is malformed
     */
    public static void makeVolleySonyAPIStartLiveViewRequest(final String URL, RequestQueue queue, final int ID,
                                                             final JSONObjectResponseWrapper LAMBDA_WRAPPER)
            throws JSONException
    {
        // setting up with params for JSON object
        final String POST_BODY = new JSONObject().put("method", "startLiveview")
                .put("params", new JSONArray()).put("id", ID).put("version","1.0").toString();
        JSONObject JSONPOSTBody = new JSONObject(POST_BODY);
        // making request
        JsonObjectRequest myRequest = new JsonObjectRequest(Method.POST, URL, JSONPOSTBody,
                new Response.Listener<JSONObject>() {
            /**
             * Response received
             * @param response - camera response
             */
            @Override
            public void onResponse(JSONObject response)
            {
                LAMBDA_WRAPPER.responseMethod(response);
            }
        }, new Response.ErrorListener() {
            /**
             * Connection failed
             * @param error - failure
             */
            @Override
            public void onErrorResponse(VolleyError error)
            {
                LAMBDA_WRAPPER.errorMethod(error);
            }
        });
        // setting up retry policy in case of failure
        myRequest.setRetryPolicy(new DefaultRetryPolicy(20000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(myRequest);
    }

    /**
     * Stopping live view usually in case of error or when image has been captured
     * @param URL - camera URL
     * @param queue - request queue
     * @param ID - request id
     * @param LAMBDA_WRAPPER - request wrapper
     */
    public static void makeVolleySonyAPIStopLiveViewRequest(final String URL, RequestQueue queue, final int ID,
                                                            final JSONObjectResponseWrapper LAMBDA_WRAPPER)
            throws JSONException
    {
        // adding params for JSON object
        final String POST_BODY = new JSONObject().put("method", "stopLiveview")
                .put("params", new JSONArray()).put("id", ID).put("version", "1.0").toString();
        JSONObject JSONPOSTBody = new JSONObject(POST_BODY);
        // making request
        JsonObjectRequest myRequest = new JsonObjectRequest(Method.POST, URL, JSONPOSTBody,
                new Response.Listener<JSONObject>() {
            /**
             * Response received
             * @param response - camera response
             */
            @Override
            public void onResponse(JSONObject response)
            {
                LAMBDA_WRAPPER.responseMethod(response);
            }
        }, new Response.ErrorListener() {
            /**
             * Connection failed
             * @param error - failure
             */
            @Override
            public void onErrorResponse(VolleyError error)
            {
                LAMBDA_WRAPPER.errorMethod(error);
            }
        });
        myRequest.setRetryPolicy(new DefaultRetryPolicy(5000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(myRequest);
    }

    /**
     * Calls actZoom API to the target server. Request JSON data is such like as below.
     * @param direction - direction of zoom ("in" or "out")
     * @param queue - request queue
     * @param URL - camera URL
     * @param ID - request id
     * @param LAMBDA_WRAPPER - request wrapper
     * @throws JSONException if the JSON is malformed
     */
    public static void makeVolleySonyAPIActZoomRequest(String direction, RequestQueue queue,
                                                       final String URL, final int ID,
                                                       final JSONObjectResponseWrapper LAMBDA_WRAPPER)
            throws JSONException
    {
        final String POST_BODY = new JSONObject().put("method", "actZoom")
                .put("params", new JSONArray().put(direction).put("1shot"))
                .put("id", ID).put("version", "1.0").toString();
        JSONObject JSONPOSTBody = new JSONObject(POST_BODY);
        JsonObjectRequest myRequest = new JsonObjectRequest(Method.POST, URL, JSONPOSTBody,
                new Response.Listener<JSONObject>() {
            /**
             * Response received
             * @param response - camera response
             */
            @Override
            public void onResponse(JSONObject response)
            {
                LAMBDA_WRAPPER.responseMethod(response);
            }
        }, new Response.ErrorListener() {
            /**
             * Connection failed
             * @param error - failure
             */
            @Override
            public void onErrorResponse(VolleyError error)
            {
                LAMBDA_WRAPPER.errorMethod(error);
            }
        });
        myRequest.setRetryPolicy(new DefaultRetryPolicy(5000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(myRequest);
    }

    /**
     * Download an image
     * @param timeout - maximum time
     * @param URL - image URL
     * @param queue - request queue
     * @param LAMBDA_WRAPPER - callback
     */
    public static void makeVolleyImageRequest(int timeout, final String URL, RequestQueue queue,
                                              final ImageResponseWrapper LAMBDA_WRAPPER)
    {
        Log.v("Volley", "volley url:" + URL);
        ImageRequest request = new ImageRequest(URL, new Response.Listener<Bitmap>() {
            /**
             * Camera response
             * @param bitmap - image bitmap
             */
            @Override
            public void onResponse(Bitmap bitmap)
            {
//                        mImageView.setImageBitmap(bitmap);
                LAMBDA_WRAPPER.responseMethod(bitmap);
            }
        }, 0, 0, ImageView.ScaleType.CENTER, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
            /**
             * Request failed
             * @param error - failure
             */
            public void onErrorResponse(VolleyError error)
            {
//                        mImageView.setImageResource(R.drawable.image_load_error);
                LAMBDA_WRAPPER.errorMethod(error);
            }
        });
        request.setRetryPolicy(new DefaultRetryPolicy(timeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        // Add the request to the RequestQueue.
        request.setRetryPolicy(new DefaultRetryPolicy(DEFAULT_VOLLEY_TIMEOUT, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(request);
    }

    /**
     * Cancel camera requests
     * @param aQueue - request queue
     */
    public static void cancelAllVolleyRequests(RequestQueue aQueue)
    {
        aQueue.cancelAll(new RequestQueue.RequestFilter() {
            /**
             * Cancel the request
             * @param request - request to cancel
             * @return Returns true
             */
            @Override
            public boolean apply(Request<?> request)
            {
                return true;
            }
        });
    }
}