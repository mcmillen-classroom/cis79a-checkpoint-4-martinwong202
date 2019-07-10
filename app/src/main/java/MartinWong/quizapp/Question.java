package MartinWong.quizapp;

public class Question {
    private int mTextResId;
    private int mHintTextResId;


    public Question(int textResId, int hintResId) {
        mTextResId = textResId;
        mHintTextResId=hintResId;

    }

    public int getmHintTextResId() {
        return mHintTextResId;
    }

    public void setmHintTextResId(int mHintTextResId) {
        this.mHintTextResId = mHintTextResId;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }



    // stub method - intentionally does nothing
    // only applies to true false question
    public boolean checkAnswer(boolean boolResponse)
    {
        return false;
    }

    // stub method
    // only applies to fill the blank question
    public boolean checkAnswer(String userAnswer)
    {
        return false;
    }

    public boolean checkAnswer(int answer)
    {
        return false;
    }
    //stub
    public boolean isTrueFalseQuestion(){return false;}
    //stub
    public boolean isFillTheBlankQuestion(){return false;}
    //stub
    public boolean isMultipleChoiceQuestion(){return false;}
    //stub
    public boolean isMultipleImageChoiceQuestion(){
        return false;
    }
}