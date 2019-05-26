package advertisingspaceforrent.demo.controller;

import advertisingspaceforrent.demo.service.DonelistService;
import advertisingspaceforrent.demo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DonelistController {

    @Autowired
    private DonelistService donelistService;

    @RequestMapping("/donelist/get")
    public ResponseVO getDonelist(@RequestParam("userid") Integer userid){
        return donelistService.getDonelist(userid);
    }
}
