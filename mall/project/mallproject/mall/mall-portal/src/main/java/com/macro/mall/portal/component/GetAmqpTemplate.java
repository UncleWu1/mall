package com.macro.mall.portal.component;

import lombok.Data;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: Wsq
 * @since: 2022-06-23 18:08
 **/
@Component
@Data
public class GetAmqpTemplate {

    public GetAmqpTemplate getAmqpTemplate;
    @Autowired
    public AmqpTemplate amqpTemplate1;

    @Autowired
    public AmqpTemplate GetAmqpTemplate(GetAmqpTemplate getAmqpTemplate){
        this.getAmqpTemplate=getAmqpTemplate;
        amqpTemplate1= getAmqpTemplate.getAmqpTemplate1();
        return null;
    }

}
