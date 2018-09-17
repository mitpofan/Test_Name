package mish.lisow.test_name;

import android.content.Context;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class Screen1 extends AppCompatActivity {
    public Offers[] offers;

    Context contex = this;
    String Company_Name, Short_des, btn1, logotip, full_des, btn2, url;
    boolean browser, enabled;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_1);
        new ParseTask().execute();

    }

    private class ParseTask extends AsyncTask<Void, Void, String> {

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String resultJson = "";

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL("http://sandytrast.info/ins/?id=1");

                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();

                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }

                resultJson = buffer.toString();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return resultJson;
        }

        @Override
        protected void onPostExecute(String strJson) {
            super.onPostExecute(strJson);
            JSONObject dataJsonObj = null;
            try {
                dataJsonObj = new JSONObject(strJson);
                JSONArray friends = dataJsonObj.getJSONArray("offers");
                offers = new Offers[friends.length()];
                for (int i = 0; i < friends.length(); i++) {
                    JSONObject secondFriend = friends.getJSONObject(i);
                        Company_Name = secondFriend.getString("name");
                        Short_des = secondFriend.getString("des");
                        btn1 = secondFriend.getString("btn");
                        logotip = secondFriend.getString("logo");
                        full_des = secondFriend.getString("desc_full");
                        btn2 = secondFriend.getString("btn2");
                        browser = secondFriend.getBoolean("browser");
                        enabled = secondFriend.getBoolean("enabled");
                        url = secondFriend.getString("url");
                        offers[i] = new Offers(Company_Name, Short_des, btn1, logotip, full_des, btn2, browser, enabled, url);
                    }

                List<Offers> list = Arrays.asList(offers);
               BoxAdapter boxAdapter = new BoxAdapter(contex, list);
                ListView lvMain = (ListView) findViewById(R.id.first_list);
                lvMain.setAdapter(boxAdapter);


            } catch (JSONException e) {
                e.printStackTrace();
            }
            }
        }
}








