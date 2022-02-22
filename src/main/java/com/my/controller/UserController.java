package com.my.controller;

import com.my.entity.User;
import com.my.service.UserService;
import com.my.utils.ValidateImageCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    /*
    生成验证码
     */
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public String register(User user){
        userService.register(user);
        return "redirect:/index";
    }

    @GetMapping("code")
    public void getImage(HttpSession session,HttpServletResponse response) throws IOException {
        //生成验证码
        String securityCode = ValidateImageCodeUtils.getSecurityCode();
        BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);
        session.setAttribute("code",securityCode);//存入session
        ServletOutputStream os = response.getOutputStream();
        ImageIO.write(image,"png",os);



    }
}
