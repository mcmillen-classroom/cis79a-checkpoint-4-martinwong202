package MartinWong.quizapp;

import MartinWong.quizapp.Question;

public class TrueFalseQuestion extends Question {
    private boolean mAnswer;

    public TrueFalseQuestion(int textResId, int hintResId, boolean ans) {
        super(textResId, hintResId);
        mAnswer=ans;
    }

    @Override
    public boolean checkAnswer(boolean ans){
        return mAnswer==ans;
    }
}
