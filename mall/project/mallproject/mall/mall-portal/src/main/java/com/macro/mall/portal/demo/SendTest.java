package com.macro.mall.portal.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: Wsq
 * @since: 2022-07-19 16:18
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class SendTest {
    @Autowired
    TestSender testSender;


    @Test
    public void one() {
        testSender.sendMessage(1901l, 2131l);

    }
}
