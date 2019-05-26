package advertisingspaceforrent.demo.service;

import advertisingspaceforrent.demo.vo.AddMoneyForm;
import advertisingspaceforrent.demo.vo.LoginForm;
import advertisingspaceforrent.demo.vo.ResponseVO;
import advertisingspaceforrent.demo.vo.SignUpForm;

public interface UserService {

    /**
     * 登录
     * @param loginForm 登录表单
     * @return User
     */
    ResponseVO login(LoginForm loginForm);

    /**
     * 注册
     * @param signUpForm 注册表单
     * @return None
     */
    ResponseVO signUp(SignUpForm signUpForm);

    /**
     * 加钱
     * @param addMoneyForm 加钱表单
     * @return None
     */
    ResponseVO addMoney(AddMoneyForm addMoneyForm);
}