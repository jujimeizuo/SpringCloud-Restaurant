package com.zjgsu.entity;

public enum ResultCode {

    CODEWRONG(4001,"Invalid verification code"), //无效验证码
    ClockInTimeOut(4001,"The modified clock-in time is earlier than the end time of the last schedule"),//修改的打卡时间不能早于上次排班下班时间
    ClockOutTimeOut(4001,"The modified time to withdraw the card is later than the start time of the next schedule"),//修改的退卡时间不能晚于下次排班上班时间
    ClockInTimeWrong(4001,"The modified clock in time cannot be earlier than the last card return time or later than the next clock in time"),//打卡时间不能早于上次下班时间
    ClockOutTimeWrong(4001,"The modified time to withdraw the card cannot be later than the time of the next check-in"),//退卡时间不能晚于下次打卡时间
    FORMATWRONG(4001,"Format error"),//格式错误
    TimeWRONG(4001,"The detection time cannot be less than 20 minutes and more than 180 minutes"),//检测时间不能小于20分钟。
    RosterWrong(4001,"There is shift scheduling in this department during this time period"),//该部门该段时间存在排班
    StaffWRONG(4001,"Name and number do not match"),//员工格式姓名不匹配错误
    EMAILWRONG(4001,"Mailbox error"),//邮箱错误
    OSWRONG(4001,"The operating system is not supported"),//不支持该操作系统
    NoEmail(4004,"No such mailbox"),//无该邮箱
    NoDepartment(4004,"No such department"),//无该部门
    NoEveryDayClock(4004,"No such EverydayClock"),//无该打卡信息。
    HasNoDepartment(4004,"You don't belong to a department yet"),//您还没有归属部门
    FreeStaff(4001,"The employee is a free time employee,Position error"),//自由员工无法被定义为经理或总经理。
    NoWifi(4004,"No such wifi"),//无该wifi
    WIFIWRONG(4001,"WiFi matching failed"),//wifi匹配失败
    CLOCKINTimeOut(4001,"The shift scheduling time has passed, unable to punch in"),//排班结束，无法打卡
    NOtInRosterTime(4001,"The current shift is not within t" +
            "he valid shift scheduling time, unable to punch in"),//不在排班时间内无法打卡,针对非自由打卡员工。
    CLOCKINSTATUS(4002,"It is currently in the status of card to be returned"),//当前处于待退卡状态，
    CLOCKOUTSTATUS(4002,"It is currently in clock out status"),//当前处于待打卡状态，
    PasswordInconsistent(4005,"The two passwords are inconsistent"),//两次密码不一致
    Emailexists(4006,"Mailbox has been registered"),//邮箱已被注册
    Wifiexists(4006,"wifi exists"),//wifi存在
    NoStaff(4004,"No Such Staff"),//无该员工信息


    LOCKFAILD(4000,"Please ask later"),//为获取到锁
    SUCCESS(2000, "Processing succeeded"),//处理成功
    Falid(4000, "Don't ask frequently"),//处理成功
    FAILD(4000, "Processing failed"),//处理失败
    FAILD_LOGIN(4040, "Login failed"),//登录失败
    API_PARAMETER_ERROR(5000, "Parameter error"),//参数错误
    UNEXPECTED_ERROR(9999, "unknown error"),//未知错误
    REFULSE_REQUEST(7777, "access denied");//拒绝访问

    private int code;
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
