package com.parmer.utils.utils;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;

/**
 * package 工具类 提供方法：
 * 1，判断某个包名的应用是否安装；
 * 2，获取版本号及版本名称
 */
public class PackageUtil {
    public static boolean isPackageInstalled(Context context, String packageName) {
        try {
            context.getPackageManager().getPackageInfo(packageName, 0);

            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static int getVersionCode(Context context, String packageName) {
        try {
            LogUtils.debug("AAAAA", "version:" + context.getPackageManager().getPackageInfo(packageName, 0).packageName);
            return context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
        } catch (NameNotFoundException e) {
            return 0;
        }
    }

    public static int getVersionCode(Context context) {
        LogUtils.logBySys("name:" + context.getPackageName());
        return getVersionCode(context, context.getPackageName());
    }

    public static String getVersionName(Context context) {
        LogUtils.logBySys("name:" + context.getPackageName());
        String versionName = null;
        try {
            versionName = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }

}
