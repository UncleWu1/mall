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
@RunWith(SpringJUnit4ClassRunner.class)
@Component
@RequiredArgsConstructor
public class test {
    private static Logger LOGGER = LoggerFactory.getLogger(CancelOrderSender.class);
    public final  AmqpTemplate amqpTemplate;

    public  void sendMessage(Long orderId, final long delayTimes) {
//        AmqpTemplate amqpTemplate = SpringContextUtil.getBean(AmqpTemplate.class);
        //给延迟队列发送消息
        amqpTemplate.convertAndSend(QueueEnum.QUEUE_TTL_ORDER_CANCEL.getExchange(), QueueEnum.QUEUE_TTL_ORDER_CANCEL.getRouteKey(), orderId, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                //给消息设置延迟毫秒值
                message.getMessageProperties().setExpiration(String.valueOf(delayTimes));
                return message;
            }
        });
        LOGGER.info("send orderId:{}", orderId);
    }
    @Test
    public  void one() {
        sendMessage(1901l, 2131l);
    }
}
