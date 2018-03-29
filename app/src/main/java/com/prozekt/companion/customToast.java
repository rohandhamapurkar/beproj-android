package com.prozekt.companion;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Prithvi Chavhan on 01-02-2018.
 */

public class customToast {
    private String text;
    private Context ctx;
    public customToast(String text,Context ctx){
        this.text = text;
        this.ctx = ctx;
    }

    public void show(){
        LayoutInflater inflater = ((Activity)ctx).getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) ((Activity)ctx).findViewById(R.id.custom_toast_container));

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText(this.text);
        Toast toast = new Toast(ctx);
        toast.setGravity(Gravity.BOTTOM, 0, 50);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}
