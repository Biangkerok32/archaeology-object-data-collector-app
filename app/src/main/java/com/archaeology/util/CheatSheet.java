// CheatSheet contains commons methods that are used throughout the other classes
// @author: msenol
package com.archaeology.util;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.archaeology.ui.SettingsActivity;
import static com.archaeology.util.StateStatic.THUMBNAIL_EXTENSION_STRING;
import static com.archaeology.util.StateStatic.getGlobalPhotoSavePath;
public class CheatSheet
{
    /**
     * Returns all the items in the spinner
     * @param aSpinner - spinner to read
     */
    public static List<String> getSpinnerItems(Spinner aSpinner)
    {
        int itemCount = aSpinner.getCount();
        List<String> items = new ArrayList<>(itemCount);
        for (int i = 0; i < itemCount; i++)
        {
            items.add(aSpinner.getItemAtPosition(i).toString());
        }
        return items;
    }

    /**
     * Set items to spinner
     * @param aContext - calling context
     * @param aSpinner - spinner to set
     * @param items - items for spinner
     */
    public static void setSpinnerItems(Context aContext, Spinner aSpinner, List<String> items)
    {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(aContext,
                android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        aSpinner.setAdapter(adapter);
    }

    /**
     * Read IP and MAC addresses from ARP file
     * @return Returns a list of devices
     */
    public static String findIPFromMAC(String MACAddress)
    {
        BufferedReader bufferedReader = null;
        String IP = null;
        Log.v("ARP FILE", "Looking for MAC " + MACAddress);
        try
        {
            bufferedReader = new BufferedReader(new FileReader("/proc/net/arp"));
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                Log.v("ARP FILE", "Read line " + line);
                String[] splitted = line.split(" +");
                if (splitted != null && splitted.length >= 4)
                {
                    String MAC = splitted[3];
                    Log.v("ARP FILE", "Found MAC " + MAC);
                    if (MAC.matches("..:..:..:..:..:..") && MAC.equals(MACAddress))
                    {
                        IP = splitted[0];
                        Log.v("ARP FILE", IP);
                    }
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                bufferedReader.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return IP;
    }

    /**
     * Set items to spinner
     * @param aContext - calling context
     * @param aSpinner - spinner to fill
     * @param items - spinner items
     * @param selectedItem - default item
     * @param spinnerItemLayout - ordering to items
     */
    public static void setSpinnerItems(Context aContext, Spinner aSpinner, List<String> items,
                                       String selectedItem, int spinnerItemLayout)
    {
        int selectedItemIndex = 0;
        for (int i = 0; i < items.size(); i++)
        {
            if (items.get(i).equals(selectedItem))
            {
                selectedItemIndex = i;
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(aContext, spinnerItemLayout, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        aSpinner.setAdapter(adapter);
        aSpinner.setSelection(selectedItemIndex);
    }

    /**
     * Creating a thumbnail for requested image
     * @param inputFileName - image file
     * @return Returns image URI
     */
    public static Uri getThumbnail(String inputFileName)
    {
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), getGlobalPhotoSavePath());
        String originalFilePath = mediaStorageDir.getPath() + File.separator + inputFileName;
        String thumbPath = mediaStorageDir.getPath() + File.separator + THUMBNAIL_EXTENSION_STRING;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        // Returns null, sizes are in the options variable
        BitmapFactory.decodeFile(originalFilePath, options);
        int width = options.outWidth;
        int height = options.outHeight;
        File thumbFile = new File(thumbPath);
        // creating a thumbnail image and setting the bounds of the thumbnail
        Bitmap thumbImage = ThumbnailUtils.extractThumbnail(BitmapFactory
                        .decodeFile(originalFilePath), Math.round(width / 4.1f),
                Math.round(height / 4.1f));
        try
        {
            FileOutputStream fos = new FileOutputStream(thumbFile);
            thumbImage.compress(Bitmap.CompressFormat.JPEG, 90, fos);
            fos.close();
        }
        catch (Exception ex)
        {
            // e.getMessage is returning a null value
            ex.printStackTrace();
        }
        return Uri.fromFile(thumbFile);
    }

    /**
     * Returns the URI of the original image
     * @param thumbnailURI - thumbnail location
     * @return Returns the original's location
     */
    public static Uri getOriginalImageURI(Uri thumbnailURI)
    {
        String thumbnailURIString = thumbnailURI.toString();
        String x = thumbnailURIString.substring(0, thumbnailURIString.length()
                - THUMBNAIL_EXTENSION_STRING.length());
        return Uri.parse(x);
    }

    /**
     * Count number of links in the string
     * @param body - string to search
     * @return Returns the number of links in the string
     */
    private static int countLinks(String body)
    {
        int count = 0;
        while (body.indexOf("a href") > 0)
        {
            // Skipping past "a href = '"
            body = body.substring(body.indexOf("a href") + 10);
            count++;
        }
        return count;
    }

    /**
     * Takes incoming link list and converts to an ArrayList
     * @param response - response HTML to convert
     * @return Returns an ArrayList of the link list
     */
    public static ArrayList<String> convertLinkListToArray(String response)
    {
        int links = countLinks(response);
        ArrayList<String> tmpArray = new ArrayList<>(links);
        for (int i = 0; i < links; i++)
        {
            response = response.substring(response.indexOf("?") + 1);
            String URL = response.substring(0, response.indexOf("\'"));
            tmpArray.add(URL.substring(URL.lastIndexOf("=") + 1));
        }
        return tmpArray;
    }

    /**
     * Takes incoming image link list and converts to an ArrayList
     * @param response - response HTML to convert
     * @return Returns an ArrayList of the link list
     */
    public static ArrayList<String> convertImageLinkListToArray(String response)
    {
        int links = countLinks(response);
        ArrayList<String> tmpArray = new ArrayList<>(links);
        for (int i = 0; i < links; i++)
        {
            response = response.substring(response.indexOf("a href") + 10);
            String URL = response.substring(0, response.indexOf("\'"));
            tmpArray.add(URL.substring(URL.lastIndexOf("=") + 1));
        }
        return tmpArray;
    }

    /**
     * Create a file URI for saving an image
     * @param fileName - image location
     * @return Returns the image URI
     */
    public static Uri getOutputMediaFileURI(String fileName)
    {
        return Uri.fromFile(getOutputMediaFile(fileName));
    }

    /**
     * Create a File for saving an image
     * @param fileName - name of file
     * @return Returns the file
     */
    public static File getOutputMediaFile(String fileName)
    {
        // To be safe, you should check that the SDCard is mounted using
        // Environment.getExternalStorageState() before doing this.
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), getGlobalPhotoSavePath());
        // This location works best if you want the created images to be shared between
        // applications and persist after your app has been uninstalled. Create the storage
        // directory if it does not exist
        if (!mediaStorageDir.isDirectory())
        {
            if (!mediaStorageDir.mkdirs())
            {
                return null;
            }
        }
        // Create a media file name
        String path = mediaStorageDir.getPath() + File.separator + fileName +".jpg";
        return new File(path);
    }

    /**
     * Deletes photos from external storage public directory
     */
    public static void clearThePhotosDirectory()
    {
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), getGlobalPhotoSavePath());
        if (mediaStorageDir.isDirectory())
        {
            for (File file: mediaStorageDir.listFiles())
            {
                file.delete();
            }
        }
    }

    /**
     * Uses thumbnail to get original file and deletes both
     * @param thumbnailURI - thumbnail location
     */
    public static void deleteOriginalAndThumbnailPhoto(Uri thumbnailURI)
    {
        Uri originalImageURI = getOriginalImageURI(thumbnailURI);
        File thumbnailFile = new File(thumbnailURI.getPath());
        File originalFile = new File(originalImageURI.getPath());
        thumbnailFile.delete();
        originalFile.delete();
    }

    /**
     * Open SettingsActivity
     * @param anActivity - anActivity - calling activity
     */
    public static void goToSettings(Activity anActivity)
    {
        Intent myIntent = new Intent(anActivity, SettingsActivity.class);
        anActivity.startActivity(myIntent);
    }
}