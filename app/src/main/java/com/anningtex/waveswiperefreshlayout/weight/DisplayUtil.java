package com.anningtex.waveswiperefreshlayout.weight;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * @Author Song
 * @Desc:
 * @Date：2021-12-10
 */
public class DisplayUtil {
    private DisplayUtil() {
    }

    /**
     * 現在の向きが600dpを超えているかどうか
     *
     * @param context {@link Context}
     * @return 600dpを超えているかどうか
     */
    public static boolean isOver600dp(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return displayMetrics.widthPixels / displayMetrics.density >= 600;
    }
}