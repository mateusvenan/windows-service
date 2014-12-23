package com.ciandt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.tanukisoftware.wrapper.WrapperListener;
import org.tanukisoftware.wrapper.WrapperManager;

@Service
public class MainWrapper implements WrapperListener {

    @Autowired
    private SomeService service;

    public void controlEvent(int event) {
        if (!(event == WrapperManager.WRAPPER_CTRL_LOGOFF_EVENT) && (WrapperManager.isLaunchedAsService())) {
            WrapperManager.stop(0);
        }
    }

    public Integer start(String[] args) {
        System.out.println("Serviço Iniciado ");
        service.initService();
        return null;
    }

    public int stop(int exitCode) {
        System.out.println("Serviço Finalizado");
        return 0;
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        MainWrapper wrapper = context.getBean(MainWrapper.class);
        WrapperManager.start(wrapper, args);
    }
}
