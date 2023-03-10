package com.luv2code.aopdemo.pointcut;

import com.luv2code.aopdemo.pointcut.dao.AccountDAO;
import com.luv2code.aopdemo.pointcut.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        // get the bean from spring container
        AccountDAO theAccoundDAO = context.getBean("accountDAO",AccountDAO.class);

        // get membership bean from spring container
        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        // call business method
        Account myAccount = new Account();
        theAccoundDAO.addAccount(myAccount,true);
        theAccoundDAO.doWork();
        // call the membership business method
        theMembershipDAO.addSillyMember();
        theMembershipDAO.goToSleep();

        // close the context
        context.close();
    }
}
