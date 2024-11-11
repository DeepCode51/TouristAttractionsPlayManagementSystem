package hue.edu.xiong.volunteer_travel.service;


import hue.edu.xiong.volunteer_travel.core.Result;
import hue.edu.xiong.volunteer_travel.core.ResultGenerator;
import hue.edu.xiong.volunteer_travel.core.ServiceException;
import hue.edu.xiong.volunteer_travel.model.User;
import hue.edu.xiong.volunteer_travel.repository.UserRepository;
import hue.edu.xiong.volunteer_travel.util.CookieUitl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Service
public class UserCenterService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoginService loginService;

    public User getUser(HttpServletRequest request) {
        Cookie cookie = CookieUitl.get(request, "username");
        User user = null;
        if (cookie != null) {
            user = userRepository.findUserByUsername(cookie.getValue());
        } else {
            throw new ServiceException("不存在该用户!");
        }
        return user;
    }

    public Result centerEdit(User user) {
        User oldUser = userRepository.findById(user.getId()).orElseThrow(() -> new ServiceException("用户ID错误!"));
        oldUser.setName(user.getName());
        userRepository.save(oldUser);
        return ResultGenerator.genSuccessResult();
    }

    public Result centerEditPW(HttpServletRequest request, HttpServletResponse response, String id, String oldPassword, String newPassword) {
        User oldUser = userRepository.findById(id).orElseThrow(() -> new ServiceException("用户ID错误!"));
        if (!oldUser.getPassword().equals(oldPassword)) {
            return ResultGenerator.genFailResult("原始密码错误!");
        }
        oldUser.setPassword(newPassword);
        userRepository.save(oldUser);
        //重新登录
        loginService.logout(request, response);
        return ResultGenerator.genSuccessResult();
    }
}
