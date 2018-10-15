package com.fys.fixsystem.controller;

import com.fys.fixsystem.service.ReqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class FixSystemController {
    boolean b =  true;

    //注入
    @Autowired
    private ReqService reqService;

    /**
     * 提交信息页面
    */
    @RequestMapping("/reqInfo")
    public String reqInfo(HttpServletRequest req, HttpServletResponse resp) {
        String addr = req.getRemoteAddr();
        if (b) {
            if (!(addr.equals("127.0.0.1")) && !(addr.equals("117.159.12.38"))) {
                reqService.sendEmail("有人访问你的的网站了~~ IP是： " + addr, "849485789@qq.com");
                b = false;
            }
        }

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String floor = req.getParameter("floor");
        String room = req.getParameter("room");
        String phone = req.getParameter("phone");


        if (null != id && !id.equals("")) {
            req.getSession().setAttribute("id", id);
            req.getSession().setAttribute("name", name);
            req.getSession().setAttribute("floor", floor);
            req.getSession().setAttribute("room", room);
            req.getSession().setAttribute("phone", phone);
            return "infoForm";
        } else {
            try {
                resp.getWriter().write("id必须为数字!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "infoForm";
    }

    /**
     * 提交信息的处理
     */
    @RequestMapping("/deal")
    public void deal(HttpServletRequest req, HttpServletResponse resp) {
        reqService.deal(req, resp);
    }

    /**
     * 管理员登陆页面
     * @return
     */
    @RequestMapping("/adminLogin")
    public String adminLogin(HttpServletRequest req, HttpServletResponse resp) {
        String addr = req.getRemoteAddr();
        if (b) {
            if (!(addr.equals("127.0.0.1")) && !(addr.equals("117.159.12.38"))) {
                reqService.sendEmail("有人访问你的的网站了~~ IP是： " + addr, "849485789@qq.com");
                b = false;
            }
        }

        return "admin/admin";
    }

    /**
     * 管理后台页面
     */
    @RequestMapping("/admin/Manager")
    public String adminManager(HttpServletRequest req, HttpServletResponse resp) {
        reqService.adminManager(req, resp);
        return "admin/manager";
    }

    /**
     * 管理员登陆处理
     */
    @RequestMapping("/adeal")
    public void aDeal(HttpServletRequest req, HttpServletResponse resp) {
        reqService.aDeal(req, resp);
    }

    /**
     * 管理员退出登陆
     */
    @RequestMapping("/admin/logout")
    public String logout(HttpServletRequest req, HttpServletResponse resp) {
        if (null != req.getSession().getAttribute("name")) {
            req.getSession().removeAttribute("name");
        }
        return "admin/admin";
    }

    /**
     * 处理完成的报修信息，删除
     */
    @RequestMapping("/delete")
    public void delete(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        reqService.deleteById(id);
        try {
            resp.sendRedirect("admin/Manager");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}