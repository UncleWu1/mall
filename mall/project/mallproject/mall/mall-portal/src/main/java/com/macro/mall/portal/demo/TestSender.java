package com.macro.mall.portal.demo;

import com.macro.mall.portal.component.CancelOrderSender;
import com.macro.mall.portal.domain.QueueEnum;
import com.macro.mall.portal.util.SpringContextUtil;
import lombok.RequiredArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.jmx.support.ConnectorServerFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author: Wsq
 * @since: 2022-06-17 17:34
 **/

@Component
@RequiredArgsConstructor
public class TestSender {
    private static Logger LOGGER = LoggerFactory.getLogger(CancelOrderSender.class);
    public final  AmqpTemplate amqpTemplate;

    public  void sendMessage(Long orderId, final long delayTimes) {
//        AmqpTemplate amqpTemplate = SpringContextUtil.getBean(AmqpTemplate.class);
        //给延迟队列发送消息,
        //这里只需要指定交换机的名称和队列的routeKey就行了，这样就能找到对应的队列
        amqpTemplate.convertAndSend(QueueEnum.QUEUE_ORDER_CANCEL_TEST.getExchange(), QueueEnum.QUEUE_ORDER_CANCEL_TEST.getRouteKey(), "测试消息2,当前时间:"+System.currentTimeMillis() /*orderId, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                //给消息设置延迟毫秒值
                message.getMessageProperties().setExpiration(String.valueOf(delayTimes));
                return message;
            }
        }*/);
//        LOGGER.info("send orderId:{}", orderId);
//        System.out.println("消息发送者"+"send orderId:{}"+orderId);
    }


}
