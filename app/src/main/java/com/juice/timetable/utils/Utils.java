package com.juice.timetable.utils;

import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * <pre>
 *     author : Aaron
 *     time   : 2020/04/29
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Utils {

    /**
     * 解决一些布局问题
     *
     * @param context
     * @param dpValue
     * @return
     */
    public static int dip2px(Context context, float dpValue) {
        return (int) (0.5f + dpValue * context.getResources().getDisplayMetrics().density);
    }

    /**
     * 生成UUID
     */
    public static String createUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 返回一个随机颜色
     *
     * @param num
     * @return
     */
    public static int getColor(int num) {
        int[] colorArr = {0xFFEB9D6C, 0xFFF4B997, 0xFFD0DDE3, 0xFFB4DDCF, 0xFFEDB6D5, 0xFFE9D2E2, 0xFFFCE2C1, 0xFFE35B45, 0xFFFD8256, 0xFFF9C272, 0xFF8BD5C8, 0xFFACC864, 0xFFAED5D4, 0xFFF9CE89, 0xFFFFB296, 0xFFFD485B, 0xFF75CAE9, 0xFFA7DDE9, 0xFFF7DB70, 0xFFEF727A, 0xFFFFA3A8, 0xFFFFA791, 0xFF7186A3, 0xFF7CCDEA, 0xFFCBE7F5, 0xFFBEF4E6, 0xFF65EEDE, 0xFF91C7ED, 0xFFF9D1AD, 0xFFDCE1E4, 0xFFF9C0B9, 0xFFFDE9AC, 0xFFAFE9DB};
        return colorArr[num % (colorArr.length - 1)];
    }

    /**
     * 判断当前是否为签到时间（注意！时间左右都不包括）
     *
     * @return
     */
    public static boolean isCheckInTime() {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        Date now = null;
        Date beginTime = null;
        Date endTime = null;
        try {
            now = df.parse(df.format(new Date()));
            // 注意！时间左右都不包括 实际是21:40~22:40
            beginTime = df.parse("21:39");
            endTime = df.parse("22:41");
//            LogUtils.getInstance().d(new Date()+"  "+beginTime+"  "+endTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now.after(beginTime) && now.before(endTime);
    }


}
