// Static stuff
// @author: msenol
package objectphotography2.com.object.photography.objectphotography_app;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;
public class StateStatic
{
    // This class holds global state variables. This class should be only used in static way
    // tells you whether you need to go to CeramicInput or CeramicInput2 & ObjectAcitivity or ObjectAcitivity2
    enum DataType
    {
        type1,
        type2
    }
    public static final String LOGTAG = "Ceramic App";
    public static final String LOGTAG_WIFIDIRECT = "WIFIDIRECT";
    public static final String LOGTAG_BLUETOOTH = "BLUETOOTH";
    public static final int ADDCOLORCODE = 201;
    public static final int CHANGECOLORCODE = 202;
    public static final int REQUESTIMAGECAPTURE = 301;
    public static final int MESSAGE_WEIGHT = 501;
    public static final int MESSAGE_STATUS_CHANGE = 502;
    public static final int REQUEST_ENABLE_BT = 301;
    public static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    public static final String DEFAULTWEBSERVERURL = "http://192.168.1.27";
    public static final String DEFAULT_CAMERA_MAC = "bc:f5:ac:dc:f3:7e";
    // 30 minutes
    public static final long DEFAULTCALIBRATIONINTERVAL = 1800000;
    // default url to connect to database to send photos back and forth
    public static final String DEFAULTPHOTOPATH = "ARCPHOTOS";
    public static final String DEFAULTPHOTOCACHEPATH = "ARCCACHE";
    public static final String THUMBNAIL_EXTENSION_STRING = "thumb.jpg";
    public static final int DEFAULT_VOLLEY_TIMEOUT = 7000;
    public static final String SYNCED = "S";
    public static final String MARKED_AS_REMOVED = "R";
    public static final String MARKED_AS_ADDED = "A";
    public static final String MARKED_AS_TO_DOWNLOAD = "D";
    // fields in the database
    public static final String READINGLOCATION = "reading_location";
    public static final String HUE = "hue";
    public static final String LIGHTNESS_VALUE = "lightness_value";
    public static final String CHROMA = "chroma";
    public static final String DESCRIPTION = "description";
    public static final String MUNSELLCOLOR = "munsell_color";
    public static final String INDEXBASE = "index_base";
    public static final String AREA_EASTING = "area_easting";
    public static final String AREA_NORTHING = "area_northing";
    public static final String CONTEXT_NUMBER = "context_number";
    public static final String SAMPLE_NUMBER = "sample_number";
    public static final String ALL_SAMPLE_NUMBER = "all_avaiable_sample_number";
    // offset values that help you to locate the correct fields in the datatables to store
    // information
    public static final int INDEXMULTIPIER = 100;
    public static final int READINGLOCATIONOFFSET = 1;
    public static final int COLOROFFSET = 2;
    public static final int DESCRIPTIONOFFSET = 3;
    // the global webserver is being set to a default value
    // need to make sure that app is able to find ip address on its own
    private static String globalWebServerURL = "http://165.123.220.106:8888";
    // DEFAULTWEBSERVERURL; connection to current mac camera address
    private static String globalCameraMAC = DEFAULT_CAMERA_MAC;
    // global current object most likely is used to track the current object from the database that
    // you are trying to view.
    private static String globalCurrentObject = "";
    private static String globalPhotoSavePath = DEFAULTPHOTOPATH;
    private static String globalPhotoCachePath = DEFAULTPHOTOCACHEPATH;
    private static long remoteCameraCalibrationInterval = DEFAULTCALIBRATIONINTERVAL;
    private static long tabletCameraCalibrationInterval = DEFAULTCALIBRATIONINTERVAL;
    private static DataType globalDataStructureType = DataType.type2;
    private static int scaleTare = 0;
    private static long tabletCameraCalibrationTime;
    private static long remoteCameraCalibrationTime;
    // variable to track connections
    private static boolean isRemoteCameraSelect = true;
    private static boolean isBluetoothEnabled = false;
    public static boolean connectedToRemoteCamera = false;
    public static String connectedMacAddress = "";
    static boolean isTakePhotoButtonClicked = false;
    /**
     * Get upload URL
     * @return Returns the upload URL of server
     */
    public static String getGlobalWebserverPhotoUploadURL()
    {
        return globalWebServerURL; //TODO
    }

    /**
     * return webserver url that is used to connect to the main database
     */
    public static String getGlobalWebServerURL()
    {
        return globalWebServerURL;
    }

    /**
     * Change server URL
     * @param globalWebServerURL - new server URL
     */
    public static void setGlobalWebServerURL(String globalWebServerURL)
    {
        Log.v(LOGTAG, "globalWebServerUrl changed into " + globalWebServerURL);
        StateStatic.globalWebServerURL = globalWebServerURL;
    }

    /**
     * Get Camera MAC address
     * @return Returns camera MAC address
     */
    public static String getGlobalCameraMAC()
    {
        return globalCameraMAC;
    }

    /**
     * Set MAC address
     * @param globalCameraMAC - new MAC address
     */
    public static void setGlobalCameraMAC(String globalCameraMAC)
    {
        Log.v(LOGTAG, "globalCameraMAC changed into " + globalCameraMAC);
        StateStatic.globalCameraMAC = globalCameraMAC;
    }

    /**
     * most likely the object that you are trying to refer to from the database
     * @return Returns current object
     */
    public static String getGlobalCurrentObject()
    {
        return globalCurrentObject;
    }

    /**
     * setting global current object
     * @param globalCurrentObject - new object
     */
    public static void setGlobalCurrentObject(String globalCurrentObject)
    {
        StateStatic.globalCurrentObject = globalCurrentObject;
    }

    /**
     * Get photo save location
     * @return Returns photo save location
     */
    public static String getGlobalPhotoSavePath()
    {
        return globalPhotoSavePath;
    }

    /**
     * Change photo save location
     * @param globalPhotoSavePath - new photo save location
     */
    public static void setGlobalPhotoSavePath(String globalPhotoSavePath)
    {
        StateStatic.globalPhotoSavePath = globalPhotoSavePath;
    }

    /**
     * Get photo cache location
     * @return - returns photo cache location
     */
    public static String getGlobalPhotoCachePath()
    {
        return globalPhotoCachePath;
    }

    /**
     * Change photo cache location
     * @param globalPhotoCachePath - new cache location
     */
    public static void setGlobalPhotoCachePath(String globalPhotoCachePath)
    {
        StateStatic.globalPhotoCachePath = globalPhotoCachePath;
    }

    /**
     * Get data structure type
     * @return Returns data structure type
     */
    public static DataType getGlobalDataStructureType()
    {
        return globalDataStructureType;
    }

    /**
     * Change data structure type
     * @param globalDataStructureType - new data structure type
     */
    public static void setGlobalDataStructureType(DataType globalDataStructureType)
    {
        StateStatic.globalDataStructureType = globalDataStructureType;
    }

    /**
     * Get tare
     * @return Returns tare
     */
    public static int getScaleTare()
    {
        return scaleTare;
    }

    /**
     * Set tare
     * @param scaleTare - new tare
     */
    public static void setScaleTare(int scaleTare)
    {
        StateStatic.scaleTare = scaleTare;
    }

    /**
     * Camera Methods
     * @return Returns camera calibration interval
     */
    public static long getRemoteCameraCalibrationInterval()
    {
        return remoteCameraCalibrationInterval;
    }

    /**
     * Change calibration frequency
     * @param remoteCameraCalibrationInterval - new frequency
     */
    public static void setRemoteCameraCalibrationInterval(long remoteCameraCalibrationInterval)
    {
        StateStatic.remoteCameraCalibrationInterval = remoteCameraCalibrationInterval;
    }

    /**
     * Get phone camera calibration frequency
     * @return - Returns phone camera calibration frequency
     */
    public static long getTabletCameraCalibrationInterval()
    {
        return tabletCameraCalibrationInterval;
    }

    /**
     * Change phone camera calibration frequency
     * @param tabletCameraCalibrationInterval - new phone camera calibration frequency
     */
    public static void setTabletCameraCalibrationInterval(long tabletCameraCalibrationInterval)
    {
        StateStatic.tabletCameraCalibrationInterval = tabletCameraCalibrationInterval;
    }

    /**
     * Set camera calibration time
     */
    public static void populateRemoteCameraCalibrationTime()
    {
        remoteCameraCalibrationTime = Calendar.getInstance().getTimeInMillis();
    }

    /**
     * Set phone camera calibration time
     */
    public static void populateTabletCameraCalibrationTime()
    {
        tabletCameraCalibrationTime = Calendar.getInstance().getTimeInMillis();
    }

    /**
     * Was camera calibrated recently?
     * @return Returns whether camera needs calibrated
     */
    public static boolean isRemoteCameraRecentlyCalibrated()
    {
        long currentTime  = Calendar.getInstance().getTimeInMillis();
        return (currentTime - remoteCameraCalibrationTime <= remoteCameraCalibrationInterval);
    }

    /**
     * Does phone camera need calibrated?
     * @return Returns whether phone camera needs calibrated
     */
    public static boolean isTabletCameraRecentlyCalibrated()
    {
        long currentTime = Calendar.getInstance().getTimeInMillis();
        return (currentTime - tabletCameraCalibrationTime <= tabletCameraCalibrationInterval);
    }

    /**
     * Are we using Sony camera?
     * @return Returns whether Sony camera is used
     */
    public static boolean isIsRemoteCameraSelect()
    {
        return isRemoteCameraSelect;
    }

    /**
     * Change active camera
     * @param isRemoteCameraSelect - true if Sony is used
     */
    public static void setIsRemoteCameraSelect(boolean isRemoteCameraSelect)
    {
        StateStatic.isRemoteCameraSelect = isRemoteCameraSelect;
    }

    /**
     * Is Bluetooth on?
     * @return Returns if Bluetooth is on
     */
    public static boolean isBluetoothEnabled()
    {
        return isBluetoothEnabled;
    }

    /**
     * Toggle Bluetooth
     * @param isBluetoothEnabled - enable or diable Bluetooth
     */
    public static void setIsBluetoothEnabled(boolean isBluetoothEnabled)
    {
        StateStatic.isBluetoothEnabled = isBluetoothEnabled;
    }

    /**
     * Get image color
     * @param hue - image hue
     * @param lightness_value - image lightness
     * @param chroma - image chroma
     * @return - returns image color
     */
    public static String getMunsellColor(String hue, String lightness_value, String chroma)
    {
        return hue + " " + lightness_value + "/" + chroma;
    }

    /**
     * splits string containing munsell colors adds them to a hashmap so they can be returned
     * @param munsellColor - color
     * @return Returns map of colors
     */
    public static HashMap<String, String> parseMunsellColor(String munsellColor)
    {
        munsellColor = munsellColor.replace('/', ' ');
        String[] tmpArray = munsellColor.split(" ");
        HashMap<String, String> colorDict = new HashMap<>(3);
        colorDict.put(HUE, tmpArray[0]);
        colorDict.put(LIGHTNESS_VALUE, tmpArray[1]);
        colorDict.put(CHROMA, tmpArray[2]);
        return colorDict;
    }

    /**
     * the following methods convert pixels to different formats
     * @param px - pixel
     * @return Returns dp of px
     */
    public static float convertPixelsToDp(float px)
    {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        return px / (metrics.densityDpi / 160f);
    }

    /**
     * Convert dp to px
     * @param dp - pixel
     * @return - return px of dp
     */
    public static float convertDpToPixel(float dp)
    {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        return dp * (metrics.densityDpi / 160f);
    }

    /**
     * Convert dp to px
     * @param dp - pixel
     * @return Returns px of dp
     */
    public static int convertDpToPixel(int dp)
    {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        return dp * (metrics.densityDpi / 160);
    }

    /**
     * Convert px to dp
     * @param px - pixel
     * @return - Returns dp of px
     */
    public static int convertPixelsToDp(int px)
    {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        return px / (metrics.densityDpi / 160);
    }

    /**
     * Get current date
     * @return Returns timestamp
     */
    public static String getTimeStamp()
    {
        return new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    }

    /**
     * Display error
     * @param error - error to display
     * @param cont - calling context
     */
    public static void showToastError(Exception error, Context cont)
    {
        Toast.makeText(cont, error.toString(), Toast.LENGTH_SHORT).show();
    }

    /**
     * no current usages
     * @param fileUri - image location
     * @return Returns if image is remote
     */
    public static boolean isRemote(Uri fileUri)
    {
        String temp = fileUri.toString();
        boolean x = temp.matches("^http.*");
        Log.v(LOGTAG, "isRemote: fileUri :" + fileUri.toString() + " boolean: " + x);
        return x;
    }
}