package com.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:dispatcherServlet.xml","classpath:applicationContext.xml"})
public class TestCURD {

    @Test
    public void test(){
        System.out.println("hello test");
    }
}
