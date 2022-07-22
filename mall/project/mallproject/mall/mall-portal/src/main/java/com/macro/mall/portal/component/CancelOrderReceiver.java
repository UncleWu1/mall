package com.macro.mall.portal.component;

import com.macro.mall.portal.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 取消订单消息的消费者
 * Created by macro on 2018/9/14.
 */
@Component
//@RabbitListener(queues = "mall.order.cancel")
//@RabbitListener(queues = "wsq_queue1")//名字不一致启动失败
//@RabbitListener//不加队列名字，不能接收消息
@RabbitListener(queues = "wsq_queue")//这里的队列的名字只要在rabbitMQ manager中能找到就行了，能不能在配置文件中找到无所谓的。，但是如果配置文件没有指定队列名字，这条消息可能会出现多次。
public class CancelOrderReceiver {
    private static Logger LOGGER = LoggerFactory.getLogger(CancelOrderReceiver.class);
    @Autowired
    private OmsPortalOrderService portalOrderService;

    @RabbitHandler
    public void handle(Long orderId) {
        portalOrderService.cancelOrder(orderId);
        LOGGER.info("process orderId:{}", orderId);
        System.out.println("消息接收者：" + orderId);
    }

    @RabbitHandler
    public void test(String message) {
        long l = System.currentTimeMillis();
        System.out.println("消息队列收到的消息:" + message + "接收的时间：" + l);
        String[] split = message.split(":");
        System.out.println("总共耗时：" + (l - Long.valueOf(split[1])));
    }
}
