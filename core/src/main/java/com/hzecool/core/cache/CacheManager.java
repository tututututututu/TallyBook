package com.hzecool.core.cache;

import android.support.annotation.IntDef;

import com.hzecool.common.utils.Utils;
import com.hzecool.db.utils.utils;

import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.hzecool.common.utils.FileUtils.deleteDir;

/**
 * Discribe:app缓存管理类
 * Created by tutu on 2017/3/17.
 */

public class CacheManager {
    /**
     * 分享缓存
     */
    public static final int SHARE_CACHE_PATH = 1;

    /**
     * 一般通用缓存
     */
    public static final int COMMON_CACHE_PATH = 2;

    /**
     * 日志缓存
     */
    public static final int LOG_CACHE_PATH = 3;

    /**
     * 数据库缓存
     */
    public static final int DB_CACHE_PATH = 4;


    @IntDef({SHARE_CACHE_PATH, COMMON_CACHE_PATH, LOG_CACHE_PATH, DB_CACHE_PATH})
    @Retention(RetentionPolicy.SOURCE)
    public @interface CacheType {
    }

    /**
     * 获取app缓存目录
     *
     * @return
     */
    public static String getAppCachePath() {
        return utils.getCacheDirectory(Utils.getContext(), true).getAbsolutePath();
    }


    /**
     * 获取不同类型缓存的目录
     *
     * @param cacheType
     * @return
     */
    public static String getTyleCachePath(@CacheType int cacheType) {
        switch (cacheType) {
            case COMMON_CACHE_PATH:
                return getAppCachePath() + File.separator + "commonCache";

            case SHARE_CACHE_PATH:
                return getAppCachePath() + File.separator + "shareCache";

            case LOG_CACHE_PATH:
                return getAppCachePath() + File.separator + "logCache";

            case DB_CACHE_PATH:
                return getAppCachePath() + File.separator + "dbCache";
        }
        return null;
    }


    /**
     * 清除一般缓存目录
     * 包括通用缓存,分享下载的图片缓存
     */
    public static void clearCommonCache() {
        deleteDir(getTyleCachePath(COMMON_CACHE_PATH));
        deleteDir(getTyleCachePath(SHARE_CACHE_PATH));
        // com.lzy.okgo.cache.CacheManager.INSTANCE.clear();
    }

    /**
     * 清除日志缓存
     */
    public static void clearLogCache() {
        deleteDir(getTyleCachePath(LOG_CACHE_PATH));
    }
}
