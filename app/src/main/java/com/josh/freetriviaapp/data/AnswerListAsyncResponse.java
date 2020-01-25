package com.josh.freetriviaapp.data;

import com.josh.freetriviaapp.model.Question;

import java.util.ArrayList;

public interface AnswerListAsyncResponse {
    void processFinished(ArrayList<Question> questionArrayList);

}
