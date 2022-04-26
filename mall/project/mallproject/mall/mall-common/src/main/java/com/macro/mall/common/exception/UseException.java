package com.macro.mall.common.exception;

import com.macro.mall.common.enums.UserEnum;

/**
 * @author: Wsq
 * @since: 2022-04-26 15:09
 **/
public class UseException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private Integer code;

    public UseException() {
        super();
    }

    public UseException(UserEnum userEnum) {
        super(userEnum.getMessage());
        code = userEnum.getCode();
    }

    public UseException(String msg, Integer errorCode) {
        super(msg);
        code = errorCode;
    }

    public Integer getCode() {
        return code;
    }

}
