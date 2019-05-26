package advertisingspaceforrent.demo.controller;

import advertisingspaceforrent.demo.service.UserService;
import advertisingspaceforrent.demo.vo.LoginForm;
import advertisingspaceforrent.demo.vo.ResponseVO;
import advertisingspaceforrent.demo.vo.SignUpForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/user/login")
    public ResponseVO login(@RequestBody LoginForm loginForm) {
        return userService.login(loginForm);
    }

    @RequestMapping("/user/signup")
    public ResponseVO signup(@RequestBody SignUpForm signUpForm) {
        return userService.signup(signUpForm);
    }
}
