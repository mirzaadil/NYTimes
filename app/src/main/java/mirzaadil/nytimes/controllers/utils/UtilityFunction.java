package mirzaadil.nytimes.controllers.utils;

import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;

import mirzaadil.nytimes.R;


/**
 * Created by Mirza Adil on 7/09/2018.
 * <p>
 * This class provides utility functions.
 * </p>
 */


public class UtilityFunction extends Application {

    private static boolean Logs = true;
    private static String TAG;

    private static Context mContext = null;


    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        TAG = getAppContext().getResources().getString(R.string.app_name);
        Fresco.initialize(this);
    }

    public static Context getAppContext() {
        return mContext;
    }

    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
     * Show Logs Messages
     * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

    public static void showLogs(String msg) {
        if (Logs) {
            Log.d(UtilityFunction.TAG, msg);
        }
    }

    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
     * Show Toast Message
     * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

    public static void showToast(String msg) {
        if (!stringEmpty(msg))
            Toast.makeText(getAppContext(), msg, Toast.LENGTH_SHORT).show();
    }

    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
     * Check String Empty
     * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

    public static boolean stringEmpty(String str) {
        if (str != null && !str.isEmpty() && str.length() > 0)
            return false;
        return true;
    }

    public static boolean isUrlValid(String url) {
        return Patterns.WEB_URL.matcher(url).matches();
    }

    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
     * Get Progress Dialog with out Text Message
     * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

    public static ProgressDialog getProgressDialog(Context mContext) {
        if (mContext != null) {
            ProgressDialog progressDialog = new ProgressDialog(mContext, android.R.style.Theme_Holo_Light_Dialog);
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            progressDialog.setMessage("Loading please wait...");
            progressDialog.setIndeterminate(true);
            progressDialog.setCancelable(false);
            return progressDialog;
        } else {
            return null;
        }
    }

    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
     * Get Progress Dialog with Text Message
     * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

    public static ProgressDialog getProgressDialog(Context mContext, String txtMsg) {
        ProgressDialog progressDialog = new ProgressDialog(mContext, android.R.style.Theme_Holo_Light_Dialog);
        progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        progressDialog.setMessage(txtMsg);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        return progressDialog;
    }

    public static void showProgressDialog(ProgressDialog pd) {
        if (pd != null && !pd.isShowing())
            pd.show();
    }

    public static void dismissProgressDialog(ProgressDialog pd) {
        if (pd != null && pd.isShowing())
            pd.dismiss();
    }


    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
     * is network connected
     * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

    /**
     * Get whether or not any network connection is present (eg. wifi, 3G, etc.).
     */
    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null) return false;
        NetworkInfo[] info = connectivityManager.getAllNetworkInfo();
        if (info == null) return false;
        for (int i = 0; i < info.length; i++)
            if (info[i].getState() == NetworkInfo.State.CONNECTED) return true;
        return false;
    }

    public static boolean isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager) getAppContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }


    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
     * Hides the soft keyboard
     * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
    public static void hideSoftKeyboard(FragmentActivity activity) {
        if (activity.getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getAppContext().getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }
    }


    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
     * Shows the soft keyboard
     * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

    public static void showSoftKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getAppContext().getSystemService(INPUT_METHOD_SERVICE);
        view.requestFocus();
        inputMethodManager.showSoftInput(view, 0);
    }

}
