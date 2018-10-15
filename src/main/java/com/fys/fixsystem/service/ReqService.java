package com.fys.fixsystem.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ReqService {
    //用户提交信息处理
    void deal(HttpServletRequest req, HttpServletResponse resp);

    //管理员登陆处理
    void aDeal(HttpServletRequest req, HttpServletResponse resp);

    void adminManager(HttpServletRequest req, HttpServletResponse resp);

    int deleteById(String id);

    void sendEmail(String body, String receivedCount);
}
