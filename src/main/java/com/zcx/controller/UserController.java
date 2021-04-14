package com.zcx.controller;

import com.zcx.entity.User;
import com.zcx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    public String findAll(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "table";
    }

    /*登陆方法*/
    @RequestMapping("/login")
    public String login(String username, String password, Model model , HttpSession session) {
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        User login = userService.login(username, md5Password);
        if (login != null) {
            session.setAttribute("loginUser",username);
            return "redirect:/index";
        }
        model.addAttribute("errorMsg", "用户名或者密码错误");
        return "/login";
    }
    //注销登录
    @RequestMapping("/logout")
    public String logout(HttpSession session)
    {
        //session失效
        session.removeAttribute("loginUser");
        return "redirect:/";
    }
    @GetMapping("/delete")
    public String delete(String userID){
        userService.delete(userID);
        return "redirect:/findAll";
    }
    //register
    @PostMapping("/register")
    public String register(User user){
        userService.register(user);
        return "redirect:/login";//跳转登录
    }

    //id查询
    @GetMapping("/find")
    public  String find(String userID,Model model){
        User user = userService.find(userID);
        model.addAttribute("user",user);
        return "update";
    }
    //tosave
    @GetMapping("/tosave")
    public String tosave(){return "";}

    //更新
    @GetMapping("/update")
    public String update(User user){
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        userService.update(user);
        return "redirect:/findAll";
    }
}
