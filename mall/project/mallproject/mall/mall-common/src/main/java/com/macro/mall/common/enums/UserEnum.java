package com.macro.mall.common.enums;

/**
 * @author: Wsq
 * @since: 2022-04-26 15:13
 **/
/**
 * 用户错误枚举类
 */
public enum UserEnum {
    PARIMART_KEY_NOT_NULL(500, "主键id不能为null"),
    PARIMART_KEY_NULL(500, "新增不能有主键id"),
    NO_USER(404, "用户不存在"),
    NO_LOGIN(401, "未登录"),
    NO_CODE(501, "请先发送验证码"),
    REPETITION(501, "请勿在1分钟内重复发送短信"),
    LOGIN_EXPIRED(501, ""),
    PASSWORD_ERROR(501, "账号或密码错误"),
    CODE_AND_ERROR(501, "账号信息错误"),
    REPEAT_LOGIN(501, "您的账号已在其他地方登录"),
    SUCCESS(200, "成功"),
    CODE_ERROR(501, "验证码错误"),

    NO_ORG(501, "未绑定机构"),
    ORG_ERROR(501, "当前登录账号的机构错误"),
    ACCOUNT_REPETITION(501, "账号重复，登录失败"),
    PERSON_INFO_ERROR(501, "人员信息错误"),
    PERSON_NOT_EXIST(501, "请选择上报人员"),
    MEASURE_TEMPLATE(501,"请选择管控措施"),
    ERROR_IDCARD(501, "错误的身份证号"),
    ERROR_ORGAN(501, "错误的上传机构"),
    TIME_NOT_NULL(501, "检测时间不能为空"),
    TEMPERATURE_NOT_NULL(501, "体温不能为空"),
    HEALTH_DESCRIPTION_NOT_NULL(501, "健康描述不能为空"),
    MEASURE_NOT_EXIST(501, "措施不存在"),
    WORK_RECIVED(501, "工单已接收或不存在"),
    WORK_ORDER_EXIST_OR_END(501, "该工单已完成或无法被移交"),
    ERROR_ORGAN_EXIST(501, "机构不存在"),
    ERROR_WORK_FROM(501, "错误的工单"),
    FILL_CONTENT(501, "请填写内容"),
    WORK_APPLYING(501, "工单已申请解除隔离"),
    MEASURE_DETAIL_EXIST(501, "当前机构无法执行该项管控措施"),
    NO_AUTH(501, "无权访问"),
    PHONE_EXIT(501, "该用户已经存在"),
    ORANGNAME_EXIT(501, "该机构名称已经存在"),
    INSERT_FAIL(501, "新增失败"),
    UPDATE_FAIL(501, "修改失败"),
    ERROR_TYPE(501, "错误的类型"),
    UPLOAD_ERROR(501, "上传文件失败"),
    UPDATE_SHOWSWITCH_FAIL(501, "设置隐藏/显示失败"),
    DELETE_FAIL(501, "删除失败"),
    SMSTEMPLATE_IS_NULL(501, "短信模板不存在"),
    SMSTEMPLATE_IS_EXIST(501, "短信模板名称已经存在"),
    EPIDEMICPOLICYANNOUNCEMENT_IS_NULL(501, "文件不存在"),
    EMERGENCY_PHONE_IS_EXIST(501, "紧急联系人已经存在"),
    EMERGENCY_PHONE_IS_NOT_EXIST(501, "紧急联系人已经存在"),
    GREENCODE_ERROR(10001, "绿码通访问无权限"),
    MEASURE_NOT_START(501, "措施尚未开始"),
    WORKFORM_INTERFACE_ERROR(501, "工单统计接口访问类型错误"),
    ONE_COMMUNITY_CODE_JUST_HAVA_ONE_COMMUNITY(501, "同一社区区划码下只能有一个社区"),
    MEASURE_IS_EXIST(501, "措施已经存在"),
    USER_COMUNITY_ISNOT(501, "用户所属社区不存在"),
    USER_IDCARD_ISEXIST(501, "用户身份证号码对应申请已经存在"),
    CLEARING_POINT_ID_IS_NULL(501, "清运点id为空"),
    UPDATE_CLEARING_POINT_IS_FAIL(501, "修改清运点状态失败"),
    USER_NAME_IS_EXIST(501, "用户名已经存在"),
    USER_EMAIL_IS_EXIST(501, "邮箱已经存在"),
    INSERT_ADMIN_FAIL(501, "新增用户失败");


    private int code;
    private String message;


    // 构造方法
    UserEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
