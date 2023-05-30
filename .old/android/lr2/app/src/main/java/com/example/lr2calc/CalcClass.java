package com.example.lr2calc;

import android.renderscript.ScriptGroup;

import androidx.constraintlayout.solver.state.State;

public class CalcClass {

    private double firstArg;
    private double secondArg;

    private StringBuilder inputStr = new StringBuilder();

    private int actionSelected;

    private State state;

    private enum State {
        firstArgInput,
        secondArgInput,
        resultShow
    }

    public CalcClass() {
        state = State.firstArgInput;
    }

    public void onNumPressed (int NumberId) {

        if (state == State.resultShow) {
            state = State.firstArgInput;
            inputStr.setLength(0);
        }

        if (inputStr.length() < 9) {
            switch (NumberId) {
                case R.id.zero:
                    if (inputStr.length() != 0) {
                        inputStr.append("0");
                    }
                    break;

                case R.id.one:
                    inputStr.append("1");
                    break;
                case R.id.two:
                    inputStr.append("2");
                    break;
                case R.id.three:
                    inputStr.append("3");
                    break;
                case R.id.four:
                    inputStr.append("4");
                    break;
                case R.id.five:
                    inputStr.append("5");
                    break;
                case R.id.six:
                    inputStr.append("6");
                    break;
                case R.id.seven:
                    inputStr.append("7");
                    break;
                case R.id.eight:
                    inputStr.append("8");
                    break;
                case R.id.nine:
                    inputStr.append("9");
                    break;



            }
        }

    }

    public void onActionPressed (int ButtonId) {

        if (ButtonId == R.id.equality && state == State.secondArgInput) {
            secondArg = Integer.parseInt(inputStr.toString());
            state = State.resultShow;
            inputStr.setLength(0);
            switch (actionSelected) {
                case R.id.plus:
                    inputStr.append(firstArg + secondArg);
                    break;
                case R.id.minus:
                    inputStr.append(firstArg - secondArg);
                    break;
                case R.id.delit:
                    inputStr.append(firstArg / secondArg);
                    break;
                case R.id.multiply:
                    inputStr.append(firstArg * secondArg);
                    break;


            }

        } else if (inputStr.length() > 0 && state == State.firstArgInput) {
            firstArg = Integer.parseInt(inputStr.toString());
            state = State.secondArgInput;
            inputStr.setLength(0);

            switch (ButtonId) {
                case R.id.plus:
                    actionSelected = R.id.plus;
                    break;
                case R.id.minus:
                    actionSelected = R.id.minus;
                    break;
                case R.id.delit:
                    actionSelected = R.id.delit;
                    break;
                case R.id.multiply:
                    actionSelected = R.id.multiply;
                    break;

            }



        }

    }

    public String getText() {
        return inputStr.toString();

    }







}
