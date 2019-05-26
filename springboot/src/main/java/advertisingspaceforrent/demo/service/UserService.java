package advertisingspaceforrent.demo.service;

import advertisingspaceforrent.demo.vo.LoginForm;
import advertisingspaceforrent.demo.vo.ResponseVO;

public interface UserService {

    /**
     * 登录
     * @param loginForm
     * @return
     */
    public ResponseVO login(LoginForm loginForm);

}
