package com.yatoooon.screenadaptation;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by yatoooon on 2018/2/6.
 */

public class ScreenAdapterTools {

    private static LoadViewHelper loadViewHelper;

    public static LoadViewHelper getInstance() {
        return loadViewHelper;
    }

    private static boolean isInitialised = false;

    public static void init(Context context) {
        if (isInitialised){
            loadViewHelper.reset();
        }else {
            ApplicationInfo applicationInfo = null;
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(context
                        .getPackageName(), PackageManager.GET_META_DATA);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            int designwidth = applicationInfo.metaData.getInt("designwidth");
            int designdpi = applicationInfo.metaData.getInt("designdpi");
            float fontsize = applicationInfo.metaData.getFloat("fontsize");
            String unit = applicationInfo.metaData.getString("unit");
            loadViewHelper = new LoadViewHelper(context, designwidth, designdpi, fontsize, unit);
            isInitialised = true;
        }

    }


}
