package com.mokhtar.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.mokhtar.quiz.databinding.ActivityMainBinding;
import com.mokhtar.quiz.model.question;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private int index=0;
    private final question [] questionbank= new question[]
            {
                    new question(R.string.question_declaration, false),
                    new question(R.string.question_independence_rights , false),
                    new question(R.string.question_religion, false),
                    new question(R.string.question_amendments, false),
                    new question(R.string.question_constitution, false),
                    new question(R.string.question_government, false),

            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.questionVeiw.setText(questionbank[index].getQuestionid());
        binding.nextButton.setOnClickListener(view -> {
            index= (index+1)%questionbank.length;
            updateq(index);
        });
        binding.previousButton.setOnClickListener(view -> {
            if (index>0) {
            index= (index-1)%questionbank.length;}
            updateq(index);
        });
        binding.trueButton.setOnClickListener(view->checkanswer(true));
        binding.FalseButton.setOnClickListener(view->checkanswer(false));

    }

    private void updateq(int index)
        {
            binding.questionVeiw.setText(questionbank[index].getQuestionid());
            if(index==(questionbank.length-1))
                 {
                 Snackbar.make(binding.imageView, R.string.end, Snackbar.LENGTH_LONG).show();

                 }
            if(index==0)
                 {
               Snackbar.make(binding.imageView, R.string.start, Snackbar.LENGTH_LONG).show();

                 }
        }


    private void checkanswer(boolean useranswer)
    {

            boolean correctanswer= questionbank[index].isAnswertrue();
            int message;
            if (correctanswer==useranswer)
                {
                    message=R.string.correct_answer;
                }
            else
                { message=R.string.wrong_answer;
                }
        Snackbar.make(binding.imageView, message, Snackbar.LENGTH_LONG).show();


   }



    }
