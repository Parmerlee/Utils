package com.parmer.utils.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.parmer.utils.BuildConfig;

/**
 * *
 * 日志输出Utils
 */
public class LogUtils {

    private static boolean isNeedLog = BuildConfig.DEBUG;

    /**
     * 根据配置判断是否打印info信息
     *
     * @param tag
     * @param msg
     */
    public static void info(String tag, Object msg) {

        if (isNeedLog) {
            Log.i(tag, String.valueOf(msg));
        }

    }

    /**
     * 根据配置判断是否打印info信息
     *
     * @param tag
     * @param msg
     */
    public static void debug(String tag, Object msg) {

        if (isNeedLog) {
            Log.d(tag, String.valueOf(msg));
        }

    }

    /**
     * 根据配置判断是否打印info信息
     *
     * @param <T>
     * @param tag
     * @param msg
     */
    public static void debug(Class cla, Object msg) {

        if (isNeedLog) {
            Log.d(cla.getName(), String.valueOf(msg));
        }

    }

    /**
     * 根据配置判断是否打印info信息
     *
     * @param tag
     * @param msg
     */
    public static void error(String tag, Object msg) {

        if (isNeedLog) {
            Log.e(tag, String.valueOf(msg));
        }

    }

    /**
     * 根据配置判断是否打印info信息
     *
     * @param tag
     * @param msg
     */
    public static void toast(Context context, Object msg) {

        if (isNeedLog) {
            Toast.makeText(context, String.valueOf(msg), Toast.LENGTH_LONG).show();
        }

    }

    /**
     * 调用系统log
     *
     * @param str
     */
    public static void logBySys(String str) {
        if (isNeedLog) {
            System.out.println(str);
        }
    }
}
