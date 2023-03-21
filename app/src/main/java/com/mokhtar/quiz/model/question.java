package com.mokhtar.quiz.model;

public class question {
    private int questionid;
    private boolean answertrue;

    public question(int questionid, boolean answertrue) {
        this.questionid = questionid;
        this.answertrue = answertrue;
    }

    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }

    public boolean isAnswertrue() {
        return answertrue;
    }

    public void setAnswertrue(boolean answertrue) {
        this.answertrue = answertrue;
    }
}
