package com.josh.freetriviaapp.data;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.josh.freetriviaapp.controller.AppController;
import com.josh.freetriviaapp.model.Question;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import static com.josh.freetriviaapp.controller.AppController.TAG;

//invoke to get questions
public class QuestionBank {
    //instantiating empty array list for question types
    ArrayList<Question> questionArrayList = new ArrayList<>();
    private String url = "https://raw.githubusercontent" +
            ".com/curiousily/simple-quiz/master/script/statements-data.json";

    public List<Question> getQuestions() {

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                (JSONArray) null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
//                        Log.d("JSON Stuff","onResponse: " + response); //testing JSON


                       for (int i =0; i < response.length(); i++) { //loop for 0 index JSON
                           try {
                               Log.d("JSON1","onResponse: " + response.getJSONArray(i).get(0));
                               Log.d("JSON2", "onResponse: " + response.getJSONArray(i).getBoolean(1));

                           } catch (JSONException e) {
                               e.printStackTrace();
                           }
                       }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        AppController.getInstance().addToRequestQueue(jsonArrayRequest);


        return null; //placeholder

    }


}
