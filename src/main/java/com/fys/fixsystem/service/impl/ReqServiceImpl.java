package com.fys.fixsystem.service.impl;

import com.fys.fixsystem.dao.ReqDao;
import com.fys.fixsystem.pojo.UInfo;
import com.fys.fixsystem.service.ReqService;
import com.fys.fixsystem.util.CheckInfo;
import com.fys.fixsystem.util.MailUtil;
import com.fys.fixsystem.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class ReqServiceImpl implements ReqService {
    @Autowired
    private ReqDao reqDao;

    @Override
    public void deal(HttpServletRequest req, HttpServletResponse resp) {
        resp.setHeader("content-type","text/html;charset=UTF-8");

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String floor = req.getParameter("floor");
        String room = req.getParameter("room");
        String phone = req.getParameter("phone");
        String info = req.getParameter("info");
        //获得当前的时间戳并转化为字符串
        String createDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
        String[] infos = {id, name, floor, room, phone, info};
        if (!CheckInfo.isNull(infos)) {
            boolean isPhone = CheckInfo.checkPhone(phone);
            //判断手机格式是否正确
            if (!isPhone) {
                try {
                    resp.getWriter().write("请按照要求扫描二维码,并且不要随意修改数据!");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return;
            }

                if (1 == reqDao.addInfo(new UInfo(name, floor, room, phone, info, createDate))) {
                    try {
                        resp.getWriter().write("提交成功!请等待维修部门与您取得联系!");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    MailUtil.sendTo("有一个新用户提交了故障信息，请尽快查看处理.<a href='http://localhost:8080/admin/Manager'>去查看</a>", "fuyuanshun521@gmail.com");
                    return;
                }
                try {
                    resp.getWriter().write("服务器内部好像出了点小问题~请稍后提交试试哦亲~");
                } catch (IOException e) {
                    e.printStackTrace();
                }
        } else {
            try {
                resp.getWriter().write("请填写故障信息!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void aDeal(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        if (null == reqDao.isExist(name, password)) {
            try {
                resp.getWriter().write("error");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }

        req.getSession().setAttribute("adminName", name);
        try {
            resp.getWriter().write("success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void adminManager(HttpServletRequest req, HttpServletResponse resp) {
        int currentPage = 1;
        //获得用户传进来的当前页参数，如果该参数为空，则使用默认的值1
        String strCurrentPage = req.getParameter("currentPage");
        if (null == strCurrentPage || "".equals(strCurrentPage)) {
            currentPage = 1;
            //使用正则表达式确保接收的参数为1个到多个数字
        } else {
            if (Pattern.matches("^\\d+$", strCurrentPage)) {
                currentPage = Integer.parseInt(strCurrentPage);
            }
        }

            int totalCount =reqDao.selectCount();

            //初始化每页显示的条目数
            int pageSize = 10;

            Page page = new Page();
            page.init(totalCount, pageSize);

            //当前页不能大于总页数，如果当前页大于总页数的话，将总页数的值赋给当前页
            if (currentPage > page.getTotalPage()) {
                currentPage = page.getTotalPage();
            }

            if (currentPage <= 0) {
                currentPage = 1;
            }

            //初始化一个List集合，存放用户反馈的信息
            List<UInfo> infos = reqDao.getInfos(((currentPage - 1) * pageSize), pageSize);
            if (infos == null) {
            }
            req.getSession().setAttribute("infos", infos);
            req.getSession().setAttribute("page", page);
            req.getSession().setAttribute("currentPage", page.getCurrentPage());
        }

    /**
     * 删除已经处理好的报修信息
     * @param id
     */
    @Override
    public int deleteById(String id) {
        return reqDao.deleteById(id);
    }

    /**
     * 发送邮件
     */
    @Override
    public void sendEmail(String body, String receivedCount) {
        MailUtil.sendTo(body, receivedCount);
    }
}