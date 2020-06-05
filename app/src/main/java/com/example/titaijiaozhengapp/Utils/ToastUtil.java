package com.example.titaijiaozhengapp.Utils;

import android.widget.Toast;

import com.example.titaijiaozhengapp.MyApplication;

public class ToastUtil {

    private static Toast sToast;

    public static void showToast(String tips) {
        if(sToast == null) {
            sToast = Toast.makeText(MyApplication.getAppContext(),tips,Toast.LENGTH_SHORT);
        } else {
            sToast.setText(tips);
        }
        sToast.show();
    }
}
