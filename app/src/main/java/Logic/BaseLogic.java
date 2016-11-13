package Logic;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.jar.Manifest;

/**
 * Created by Tsubasa on 2016/11/03.
 */
public class BaseLogic {

    /**
     * BitMapの保存
     *
     * @param bitmap Bitmap画像
     * @param context 呼び出し元 context
     *
     */
    public static String saveBitmap(Bitmap bitmap, Context context, Activity activity) throws IOException {

        View view;
        // file name for image
        Date mDate = new Date();
        SimpleDateFormat fileNameDate = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String fileName = fileNameDate.format(mDate) + ".jpg";

        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString();
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.mkdirs();
                Log.i("BaseLogic#mkdir", "directory has been created successfully");
            }

        } catch (SecurityException e) {
            e.printStackTrace();
            throw e;
        }

        if (!checkPermission(context, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

            ActivityCompat.requestPermissions(activity,
                    new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
        try {
            FileOutputStream out = new FileOutputStream(path + "/" + fileName);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            Log.i("BaseLogic, flash", "Bitmap has been flushed");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }

        return path + "/" + fileName;

        // save index
        /*
        ContentValues values = new ContentValues();
        ContentResolver contentResolver = getContentResolver();
        values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
        values.put(MediaStore.Images.Media.TITLE, fileName);
        values.put("_data", AttachName);
        contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        */
    }

    public static boolean checkPermission(Context context, String kind) {
        boolean permission = true;

        int permissionCheck = ContextCompat.checkSelfPermission(
                context, kind);
        if (PackageManager.PERMISSION_DENIED == permissionCheck) {
            permission = false;
        }

        return permission;
    }
}
