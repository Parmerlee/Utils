package com.parmer.utils.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * *
 * collect all sharepreferences stored in the phone
 */
public class SharedPreferencesCollector {
    private List<String> mSharePrefIds;
    private Context mContext;

    /**
     *
     * @param mContext
     * @param mSharePrefIds a arraylist of all sp names 默认包含default sp
     */
    public SharedPreferencesCollector(Context mContext, List<String> mSharePrefIds) {
        this.mSharePrefIds = mSharePrefIds;
        this.mContext = mContext;
    }

    public String collect() {
        final StringBuffer stringBuffer = new StringBuffer();
        final Map<String, SharedPreferences> sharedPreferencesMap = new TreeMap<>();
        sharedPreferencesMap.put("default", PreferenceManager.getDefaultSharedPreferences(mContext));
        if (mSharePrefIds != null) {
            for (final String name : mSharePrefIds) {
                sharedPreferencesMap.put(name, mContext.getSharedPreferences(name, Context.MODE_PRIVATE));
            }
        }

        for (Map.Entry<String, SharedPreferences> entry : sharedPreferencesMap.entrySet()) {
            final String sharePrefId = entry.getKey();
            final SharedPreferences prefs = entry.getValue();
            final Map<String, ?> prefEntries = prefs.getAll();
            if (prefEntries.isEmpty()) {
                stringBuffer.append(sharePrefId).append("=").append("empty\n");
                continue;
            }
            for (final Map.Entry<String, ?> prefEntry : prefEntries.entrySet()) {
                final Object prefValue = (Object) prefEntry.getValue();
                stringBuffer.append(sharePrefId).append(".").append(prefEntry.getKey()).append("=");
                stringBuffer.append(prefValue == null ? "null" : prefValue.toString());
                stringBuffer.append("\n");
            }
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }
}