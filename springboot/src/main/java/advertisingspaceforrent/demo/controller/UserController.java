package advertisingspaceforrent.demo.controller;

import advertisingspaceforrent.demo.service.UserService;
import advertisingspaceforrent.demo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/login")
    public ResponseVO login(@RequestParam String username, @RequestParam String password){
        return userService.login(username, password);
    }

    @RequestMapping("/user/signup")
    public ResponseVO signUp(@RequestParam String username, @RequestParam String password, @RequestParam String email) {
        return userService.signUp(username, password, email);
    }

    @RequestMapping("/user/updatemoney")
    public ResponseVO addMoney(@RequestParam Integer userid, @RequestParam Integer money){
        return userService.updateMoney(userid, money);
    }
}