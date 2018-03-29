package com.prozekt.companion;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;


public class loginApiRequest extends AsyncTask<Void, Void, String> {
    AsyncResponse delegate = null;
    private final String username;
    private final String password;
    private final String host = "https://beproject.tk";
    loginApiRequest(String Username, String Password,AsyncResponse delegate)
    {
        username = Username;
        password = Password;
        this.delegate = delegate;
    }


    @Override
    protected String doInBackground(Void... params) {
        String url  = host+"/auth/v0.1/user/login";
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);
            JSONObject user = new JSONObject();
            JSONObject data = new JSONObject();
            data.put("id",username);
            data.put("password",password);
            user.put("user",data);
            httpPost.setEntity(new StringEntity(user.toString(),"UTF8"));
            httpPost.setHeader("Content-type","application/json");
            HttpResponse response = httpClient.execute(httpPost);
            return EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    protected void onPostExecute(final String success)
    {
        Log.d("TEST",success);
        delegate.processFinish(success);
    }
}
