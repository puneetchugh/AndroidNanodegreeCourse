package com.example.puneet.fragmentsandloaders;

import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by puneet on 2/14/16.
 */
public class FragmentOne extends Fragment{

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    //private RelativeLayout relativeLayout;
    private RecyclerView.Adapter adapter;
    private Context mcontext;
    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstance){

        posterPath = new ArrayList<>();
        overview = new ArrayList<>();
        originalTitle = new ArrayList<>();
        userRating = new ArrayList<>();
        releaseDate = new ArrayList<>();
        makeSearch();

        return layoutInflater.inflate(R.layout.fragment_one, container, false);
    }

    HttpURLConnection urlConnection = null;
    ArrayList<String> posterPath;
    ArrayList<String> overview;
    ArrayList<String> originalTitle;
    ArrayList<String> userRating;
    ArrayList<String> releaseDate;


    public void makeSearch() {

        String urlstring = "http://api.themoviedb.org/3/discover/movie?api_key=83e1104fe785f2505827544e570b1755&sort_by=popularity.desc";
        new CallAPI().execute(urlstring);
    }

    private void response(String responseData){
        //TextView productInfo = (TextView) findViewById(R.id.textView);
        ArrayList<String> moviesList = new ArrayList();

        try {
            getDataFromJson(responseData);// List of pairs containing productid and name
            //String simple = moviesList.get(1);  // get the first pair in the array
            //productInfo.setText(simple);// Display the name of first item in the pair
        }
        catch (JSONException e) {
            //productInfo.setText(e.getMessage());// set productInfo toast or message
        }

    }

    public void getDataFromJson(String jString) throws JSONException {


        JSONObject myjson = new JSONObject(jString);
        JSONArray myJsonArray = myjson.getJSONArray("results");


        for(int i = 0; i < myJsonArray.length(); i++) {
            JSONObject tempJSONobj = myJsonArray.getJSONObject(i);

            posterPath.add(tempJSONobj.get("poster_path").toString());
            overview.add( tempJSONobj.get("overview").toString());
            originalTitle.add(tempJSONobj.get("original_title").toString());
            userRating.add(tempJSONobj.get("vote_average").toString());
            releaseDate.add(tempJSONobj.get("release_date").toString());


        }

    }

    private class CallAPI extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {

            InputStream in = null;
            int resCode = -1;
            try {
                URL url = new URL(params[0]);
                URLConnection urlConn = url.openConnection();

                if (!(urlConn instanceof HttpURLConnection)) {
                    throw new IOException("URL is not an Http URL");
                }
                HttpURLConnection httpConn = (HttpURLConnection) urlConn;
                httpConn.setAllowUserInteraction(true);
                httpConn.setInstanceFollowRedirects(true);
                httpConn.setRequestMethod("GET");
                httpConn.connect();
                resCode = httpConn.getResponseCode();

                if (resCode == HttpURLConnection.HTTP_OK) {
                    in = httpConn.getInputStream();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String json = convertStreamToString(in);
            return json;

        }


        public String convertStreamToString(InputStream is){
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String line = null;

            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }
            } catch (IOException e) {
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                }
            }

            return sb.toString();
        }
        protected void onPostExecute(String stream_url) {
            super.onPostExecute(stream_url);
            response(stream_url);
            //relativeLayout = (RelativeLayout) getView().findViewById(R.id.rl);
            recyclerView = (RecyclerView) getView().findViewById(R.id.recycler_view);

            ArrayList<String> stringList = new ArrayList<>();
            stringList.add("Puneet");
            stringList.add("DEvesh");
            stringList.add("Om");
            stringList.add("Jyoti");
            stringList.add("Aarti");
            stringList.add("Saroj");

            mcontext = getActivity();
            layoutManager = new GridLayoutManager(mcontext,2, LinearLayoutManager.VERTICAL, false);
            adapter = new MyAdapter(stringList);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }
    }
}
