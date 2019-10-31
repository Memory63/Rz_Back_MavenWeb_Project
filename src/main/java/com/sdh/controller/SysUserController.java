package com.sdh.controller;

import com.sdh.pojo.SysUser;
import com.sdh.service.SysUserService;
import com.sdh.utils.R;
import com.sdh.vo.UserLogin;
import com.sdh.vo.UserRole;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName SysUserController
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/29 11:37
 * @Version 1.0
 */
@Slf4j
@Controller
@RequestMapping("/sys")
@CrossOrigin("http://localhost:8080")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * todo: 用户登录
     * @param ul
     * @param session
     * @return
     */
    @RequestMapping("login")
    @ResponseBody
    public R login(@RequestBody UserLogin ul, HttpSession session){
        String captcha = (String) session.getAttribute("captcha");
        if(ul.getCaptcha()==null){
            return new R(1,"请输入验证码");
        }
        if(!captcha.equalsIgnoreCase(ul.getCaptcha())){
            return new R(1,"验证码错误!");
        }
        Subject subject = SecurityUtils.getSubject();
        System.out.println(ul);
        UsernamePasswordToken token = new UsernamePasswordToken(ul.getUsername(), ul.getPassword());
        if(ul.getRememberMe()!=null){
            token.setRememberMe(ul.getRememberMe());
        }
        subject.login(token);
        if(subject.isAuthenticated()){
            log.debug(this.getClass()+"用户登录成功");
            System.out.println("认证成功");
            return new R(0);
        }else {
            log.debug(this.getClass()+"用户登录失败");
            System.out.println("认证失败");
            return new R(1,"登录失败");
        }
    }

    /**
     * todo:登录成功之后，显示用户名
     * @return
     */
    @RequestMapping("/user/info")
    @ResponseBody
    public R showUsername(){
        log.debug(this.getClass()+"用户名显示");
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = sysUserService.querySysUserByUsername((String) subject.getPrincipal());
        return R.ok().put("user", sysUser);
    }

    /**
     * todo: 用户退出登录
     * @return
     */
    @RequestMapping("logout")
    @ResponseBody
    public R logout(){
        SecurityUtils.getSubject().logout();
        return new R(0);
    }

    /**
     * todo: 用户查询
     * @param order
     * @param limit
     * @param offset
     * @return
     */
    @RequestMapping("/user/list")
    @ResponseBody
    public R querySysUserList(String order,Integer limit,Integer offset){
        List<SysUser> sysUsers = sysUserService.querySysUserList(order, offset, limit);
        Integer total = sysUserService.getUserCount();
        return R.ok().put("total",total).put("rows", sysUsers);
    }

    /**
     * todo: 添加用户,并回填添加用户的id
     * @param userRole
     * @return
     */
    @RequestMapping("/user/save")
    @ResponseBody
    public R insertSysUser(@RequestBody UserRole userRole){
        Integer userId = sysUserService.insertSysUser(userRole);
        sysUserService.insertSysUserRole(userRole.getRoles(),userRole.getUserId());
        return new R(0);
    }

    /**
     * todo: 获取指定用户信息。
     * 作用: 修改用户信息是，需要先获取用户的的信息
     * @param userId
     * @return
     */
    @GetMapping("/user/info/{userId}")
    @ResponseBody
    public R querySysUserInfo(@PathVariable Integer userId){
        System.out.println(userId);
        UserRole userRole = sysUserService.querySysUserById(userId);
        System.out.println(userRole);
        return R.ok().put("user",userRole);
    }

    @RequestMapping("/user/update")
    @ResponseBody
    public R updateSysUserAndRole(@RequestBody UserRole userRole){
        System.out.println("update:"+userRole);
        sysUserService.updateSysUserById(userRole);
        return new R(0);
    }

    @RequestMapping("/user/del/{userId}")
    @ResponseBody
    public R deleteSysUserById(@PathVariable Integer userId){
        System.out.println(userId);
        sysUserService.deleteSysUserService(userId);
        return new R(0);
    }
}
