package advertisingspaceforrent.demo.serviceImpl;

import advertisingspaceforrent.demo.data.DonelistMapper;
import advertisingspaceforrent.demo.service.DonelistService;
import advertisingspaceforrent.demo.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonelistServiceImpl implements DonelistService {

    @Autowired
    private DonelistMapper donelistMapper;

    public ResponseVO getDonelist(Integer userid){
        try {
            List<Integer> donelist = donelistMapper.selectDonelistByUserid(userid);
            if(null == donelist){
                return ResponseVO.buildFailure("无已做题!");
            }
            return ResponseVO.buildSuccess(donelist);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("获取已做题失败!");
        }
    }
}
