package MartinWong.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mTextView;
    private EditText mEditText;

    private LinearLayout mTrueFalseContainer;
    private LinearLayout mFillTheBlankContainer;
    private LinearLayout mMultipleChoiceContainer;
//    private LinearLayout m



    TextView score_view;
    int score = 0;
//    private ScoreView mScoreView;
//    private Text mScoreview1;
//    private Text mText;
    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mNextButton;
    private ImageButton mBackButton;
    private Button mHintButton;
    private Button mCheckButton;
    private Button mAbutton;
    private Button mBbutton;
    private Button mCbutton;
    private Button mDbutton;

    private MartinWong.quizapp.Question[] mQuestions;
    private int mIndex;
    private int mScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mNextButton = (ImageButton) findViewById(R.id.next_button);
        mBackButton = (ImageButton) findViewById(R.id.BackButton);
        mHintButton = (Button) findViewById(R.id.HintButton);
        mCheckButton= (Button) findViewById(R.id.check_button);
        mAbutton= (Button) findViewById(R.id.a_button);
        mBbutton= (Button) findViewById(R.id.b_button);
        mCbutton= (Button) findViewById(R.id.c_button);
        mDbutton= (Button) findViewById(R.id.d_button);

        mTrueFalseContainer=(LinearLayout)findViewById(R.id.true_false_container);
        mFillTheBlankContainer=(LinearLayout)findViewById(R.id.fill_the_blank_container);
        mMultipleChoiceContainer=(LinearLayout)findViewById(R.id.multiple_choice_container);

        mEditText=(EditText)findViewById(R.id.edit_text);

        score_view = (TextView) findViewById(R.id.score_view);
        score_view.setText("Score: " + score);

        mTrueButton.setOnClickListener(this);
        mFalseButton.setOnClickListener(this);
        mNextButton.setOnClickListener(this);
        mBackButton.setOnClickListener(this);
        mHintButton.setOnClickListener(this);
        mCheckButton.setOnClickListener(this);
        mAbutton.setOnClickListener(this);
        mBbutton.setOnClickListener(this);
        mCbutton.setOnClickListener(this);
        mDbutton.setOnClickListener(this);


        mQuestions= new MartinWong.quizapp.Question[7];
        mIndex=0;
        mScore=0;

        mTextView=(TextView) findViewById(R.id.text_view);
        mQuestions[0]= new TrueFalseQuestion(R.string.question1,R.string.question_1_hint, true);
        mQuestions[1]= new TrueFalseQuestion(R.string.question2, R.string.question_2_hint,true);
        mQuestions[2]= new TrueFalseQuestion(R.string.question3, R.string.question_3_hint,true);
        mQuestions[3]= new TrueFalseQuestion(R.string.question4, R.string.question_4_hint,false);
        mQuestions[4]= new TrueFalseQuestion(R.string.question5, R.string.question_5_hint,true);
        String[] q6Answers = getResources().getStringArray(R.array.question6answers);
        mQuestions[5]= new FillTheBlank(R.string.question6, R .string.questuion_6_hint, q6Answers);
        mQuestions[6]=new MultipleChoiceQuestion(R.string.question7,R.string.question_7_hint,R.array.question7answers, 0);
        //Set up the first question
        setupQuestion();
    }

    @Override
    public void onClick(View view) {
        if(view.getId()== R.id.true_button ) {
            checkAnswer(true);

            score_view.setText("Score: " + score);
        }else if(view.getId()== R.id.false_button ) {
            checkAnswer(false);

            score_view.setText("Score: " + score);

        }
        else if(view.getId()==R.id.check_button)
        {
            checkAnswer(mEditText.getText().toString());
            score_view.setText("Score: " + score);
        }
        else if (view.getId()==R.id.a_button)
        {
            checkAnswer(0);
            score_view.setText("Score: " + score);
            mAbutton.setBackgroundColor(Color.GREEN);
        }
        else if (view.getId()==R.id.b_button)
        {
            checkAnswer(1);
            score_view.setText("Score: " + score);
            mBbutton.setBackgroundColor(Color.RED);
        }
        else if (view.getId()==R.id.c_button)
        {
            checkAnswer(2);
            score_view.setText("Score: " + score);
            mCbutton.setBackgroundColor(Color.RED);
        }
        else if (view.getId()==R.id.d_button)
        {
            checkAnswer(3);
            score_view.setText("Score: " + score);
            mDbutton.setBackgroundColor(Color.RED);
        }
        else if(view.getId()== R.id.next_button)
        {
            if(mIndex == 6)
            {
                Toast myToast = Toast.makeText(this, "You are done!", Toast.LENGTH_SHORT);
                myToast.show();
            }
            else
            {
                mIndex++;
                //Do if statement here:
              setupQuestion();
            }
        }
        else if(view.getId()== R.id.BackButton)
        {
            if(mIndex==0)
            {
                Toast myToast = Toast.makeText(this, "You can not go back!", Toast.LENGTH_SHORT);
                myToast.show();
            }
            else {
                mIndex--;
                //Do if statement here:
               setupQuestion();
            }
        }
        if(view.getId()== R.id.HintButton )
        {
            Toast myToast = Toast.makeText(this,mQuestions[mIndex].getmHintTextResId(), Toast.LENGTH_LONG);
            myToast.setGravity(Gravity.TOP| Gravity.CENTER_HORIZONTAL, 0, 0);
            myToast.show();
//            if(mIndex==0)
//            {
//                Toast myToast = Toast.makeText(this, R.string.question_1_hint, Toast.LENGTH_LONG);
//               
//                myToast.show();
//            }
//            else if(mIndex==1)
//            {
//                Toast myToast = Toast.makeText(this, R.string.question_2_hint, Toast.LENGTH_LONG);
//                myToast.setGravity(Gravity.TOP| Gravity.CENTER_HORIZONTAL, 0, 0);
//                myToast.show();
//            }
//            else if(mIndex==2)
//            {
//                Toast myToast = Toast.makeText(this, R.string.question_3_hint, Toast.LENGTH_LONG);
//                myToast.setGravity(Gravity.TOP| Gravity.CENTER_HORIZONTAL, 0, 0);
//                myToast.show();
//            }
//            else if(mIndex==3)
//            {
//                Toast myToast = Toast.makeText(this, R.string.question_4_hint, Toast.LENGTH_LONG);
//                myToast.setGravity(Gravity.TOP| Gravity.CENTER_HORIZONTAL, 0, 0);
//                myToast.show();
//            }
//            else if(mIndex==4)
//            {
//                Toast myToast = Toast.makeText(this, R.string.question_5_hint, Toast.LENGTH_LONG);
//                myToast.setGravity(Gravity.TOP| Gravity.CENTER_HORIZONTAL, 0, 0);
//                myToast.show();
//            }
        }
    }

    public void setupQuestion(){
        mTextView.setText(mQuestions[mIndex].getTextResId());
        if(mQuestions[mIndex].isTrueFalseQuestion())
        {
                mTrueFalseContainer.setVisibility(View.VISIBLE);
                mFillTheBlankContainer.setVisibility(View.GONE);
                mMultipleChoiceContainer.setVisibility(View.GONE);
        }
        else if(mQuestions[mIndex].isFillTheBlankQuestion())
        {
            mTrueFalseContainer.setVisibility(View.GONE);
            mFillTheBlankContainer.setVisibility(View.VISIBLE);
            mMultipleChoiceContainer.setVisibility(View.GONE);
        }
        else if (mQuestions[mIndex].isMultipleChoiceQuestion())
        {
            mTrueFalseContainer.setVisibility(View.GONE);
            mFillTheBlankContainer.setVisibility(View.GONE);
            mMultipleChoiceContainer.setVisibility(View.VISIBLE);
            int optionsResId =((MultipleChoiceQuestion)mQuestions[mIndex]).getmOptionsResIds();
            String[] options=getResources().getStringArray(optionsResId);
            mAbutton.setText(options[0]);
            mBbutton.setText(options[1]);
            mCbutton.setText(options[2]);
            mDbutton.setText(options[3]);
        }
    }

    public boolean checkAnswer(boolean userInput)
    {
        if(mQuestions[mIndex].checkAnswer(userInput))
        {
            score++;
            Toast myToast = Toast.makeText(this, "You are correct", Toast.LENGTH_LONG);
            myToast.show();

//            mTextView=(TextView) findViewById(R.id.score_view);
//            mTextView.setText(mScore);

//            mScore=mScore+9;
//            myToast = Toast.makeText(this, "Score:"+mScore, Toast.LENGTH_SHORT);
//            myToast.setGravity(Gravity.TOP| Gravity.CENTER_HORIZONTAL, 0, 0);
//            myToast.show();
            return true;
        }
        else
        {
            score--;
            Toast myToast = Toast.makeText(this, "You are incorrect", Toast.LENGTH_SHORT);
            myToast.show();
            return false;
        }
    }

    public boolean checkAnswer(String userInput)
    {
        if(mQuestions[mIndex].checkAnswer(userInput))
        {
            score++;
            mCheckButton.setBackgroundColor(Color.GREEN);
            Toast myToast = Toast.makeText(this, "You are correct", Toast.LENGTH_LONG);
            myToast.show();
            return true;
        }
        else
        {
            score--;
            mCheckButton.setBackgroundColor(Color.RED);
            Toast myToast = Toast.makeText(this, "You are incorrect", Toast.LENGTH_SHORT);
            myToast.show();
            return false;
        }
    }
    public boolean checkAnswer(int userInput)
    {
        if(mQuestions[mIndex].checkAnswer(userInput))
        {
            score++;
            Toast myToast = Toast.makeText(this, "You are correct", Toast.LENGTH_LONG);
            myToast.show();
            return true;
        }
        else
        {
            score--;
            Toast myToast = Toast.makeText(this, "You are incorrect", Toast.LENGTH_SHORT);
            myToast.show();
            return false;
        }
    }
}