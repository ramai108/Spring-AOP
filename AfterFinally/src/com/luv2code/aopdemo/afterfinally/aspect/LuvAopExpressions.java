package com.luv2code.aopdemo.afterfinally.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {

    @Pointcut("execution(* com.luv2code.aopdemo.afterfinally.dao.*.*(..))")
    public void forDaoPackage() {}

    //create pointcut for getter methods
    @Pointcut("execution(* com.luv2code.aopdemo.afterfinally.dao.*.get*(..))")
    public void getter() {}

    //create pointcut for setter methods
    @Pointcut("execution(* com.luv2code.aopdemo.afterfinally.dao.*.set*(..))")
    public void setter() {}

    //create pointcut: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}
}