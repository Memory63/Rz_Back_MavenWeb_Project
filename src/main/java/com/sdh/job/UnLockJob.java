package com.sdh.job;

import com.sdh.pojo.SysUser;
import com.sdh.service.SysUserService;
import com.sdh.utils.ApplicationContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Slf4j
public class UnLockJob implements Job{
    //private Logger log = LoggerFactory.getLogger(UnLockJob.class);
    //private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UnLockJob.class);
    /**
     * 检查用户是否需要解锁
     * @param context
     * @throws JobExecutionException
     */
    public void execute(JobExecutionContext context) throws JobExecutionException {
        SysUserService userService = (SysUserService) ApplicationContextUtil.getBean("sysUserServiceImpl");
        List<SysUser> users = userService.querySysUsers();
        for (SysUser user : users) {
            log.debug("用户状态:"+user.getStatus());
            if(user.getStatus()==0){
                log.debug("用户:"+user.getUsername()+" 被发现了是锁定状态");
                // 获取当天 日期
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date());
                int i = calendar.get(Calendar.DAY_OF_MONTH);
                // 获取锁定 日期
                Calendar calendar2 = Calendar.getInstance();
                calendar2.setTime(user.getLockDate());
                int j = calendar2.get(Calendar.DAY_OF_MONTH);
                if(i>j){//锁定期到，解锁
                    log.debug("用户:"+user.getUsername()+" 锁定到期");
                    userService.unlockUser(user.getUserId());
                }
            }
        }
    }
}
