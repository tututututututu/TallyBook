package com.hzecool.db.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.util.Log;

import com.hzecool.common.utils.Utils;

import java.io.File;
import java.io.IOException;

import static android.os.Environment.MEDIA_MOUNTED;


/**
 * Created by 47066 on 2017/3/30.
 */

public class utils {

    /**
     * 判断目录是否存在，不存在则判断是否创建成功
     * 如果存在，是目录则返回true，是文件则返回false，不存在则返回是否创建成功
     *
     * @param name 文件名
     * @return {@code true}: 存在或创建成功<br>{@code false}: 不存在或创建失败
     */

    public static String getDbPath(String name) {
        String dbpath = getAppCacheDir() + File.separator + name;
        Log.e("db", dbpath);

        return dbpath;
    }

    /**
     * 获取app缓存目录
     *
     * @return
     */
    public static String getAppCacheDir() {
        StringBuilder builder = new StringBuilder();

        builder.append(getCacheDirectory(Utils.getContext(), true).getAbsolutePath());

        builder.append(File.separator);

        builder.append("dbCache");


        return builder.toString();
    }


    /**
     * Returns application cache directory. Cache directory will be created on SD card
     * <i>("/Android/data/[app_package_name]/cache")</i> (if card is mounted and app has appropriate permission) or
     * on device's file system depending incoming parameters.
     *
     * @param context        Application context
     * @param preferExternal Whether prefer external location for cache
     * @return Cache {@link File directory}.<br />
     * <b>NOTE:</b> Can be null in some unpredictable cases (if SD card is unmounted and
     * {@link Context#getCacheDir() Context.getCacheDir()} returns null).
     */
    public static File getCacheDirectory(Context context, boolean preferExternal) {
        File appCacheDir = null;
        String externalStorageState;
        try {
            externalStorageState = Environment.getExternalStorageState();
        } catch (NullPointerException e) { // (sh)it happens (Issue #660)
            externalStorageState = "";
        } catch (IncompatibleClassChangeError e) { // (sh)it happens too (Issue #989)
            externalStorageState = "";
        }
        if (preferExternal && MEDIA_MOUNTED.equals(externalStorageState) && hasExternalStoragePermission(context)) {
            appCacheDir = getExternalCacheDir(context);
        }
        if (appCacheDir == null) {
            appCacheDir = context.getCacheDir();
        }
        if (appCacheDir == null) {
            String cacheDirPath = "/data/data/" + context.getPackageName() + "/cache/";
            appCacheDir = new File(cacheDirPath);
        }
        return appCacheDir;
    }

    private static final String EXTERNAL_STORAGE_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";

    private static boolean hasExternalStoragePermission(Context context) {
        int perm = context.checkCallingOrSelfPermission(EXTERNAL_STORAGE_PERMISSION);
        return perm == PackageManager.PERMISSION_GRANTED;
    }

    private static File getExternalCacheDir(Context context) {
        File dataDir = new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data");
        File appCacheDir = new File(new File(dataDir, context.getPackageName()), "cache");
        if (!appCacheDir.exists()) {
            if (!appCacheDir.mkdirs()) {
                return null;
            }
            try {
                new File(appCacheDir, ".nomedia").createNewFile();
            } catch (IOException e) {
            }
        }
        return appCacheDir;
    }
}
