package advertisingspaceforrent.demo.controller;

import advertisingspaceforrent.demo.service.UserService;
import advertisingspaceforrent.demo.vo.LoginForm;
import advertisingspaceforrent.demo.vo.ResponseVO;
import advertisingspaceforrent.demo.vo.SignUpForm;
import advertisingspaceforrent.demo.vo.UpdateMoneyForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/login")
    public ResponseVO login(@RequestBody LoginForm loginForm) {
        return userService.login(loginForm);
    }

    @RequestMapping("/user/signup")
    public ResponseVO signUp(@RequestBody SignUpForm signUpForm) {
        return userService.signUp(signUpForm);
    }

    @RequestMapping("/user/updatemoney")
    public ResponseVO addMoney(@RequestBody UpdateMoneyForm updateMoneyForm){
        return userService.updateMoney(updateMoneyForm);
    }

}