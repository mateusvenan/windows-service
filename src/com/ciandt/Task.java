package com.ciandt;

import java.util.TimerTask;

public class Task extends TimerTask {

    @Override
    public void run() {
        System.out.println("Do something");
    }
}