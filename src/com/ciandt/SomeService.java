package com.ciandt;

import org.springframework.stereotype.Service;

@Service
public class SomeService {

    public void initService() {
        System.out.println(System.currentTimeMillis());
    }

}