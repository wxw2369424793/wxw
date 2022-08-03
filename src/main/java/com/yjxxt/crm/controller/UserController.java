package com.yjxxt.crm.controller;

import com.yjxxt.crm.base.BaseController;
import com.yjxxt.crm.base.ResultInfo;
import com.yjxxt.crm.exceptions.ParamsException;

import com.yjxxt.crm.query.UserModel;
import com.yjxxt.crm.query.UserQuery;
import com.yjxxt.crm.service.UserService;
import com.yjxxt.crm.utils.AssertUtil;
import com.yjxxt.crm.utils.LoginUserUtil;
import com.yjxxt.crm.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController extends BaseController {
    @Resource
    private UserService userService;


    /**
     *  用户登录
     * @param userName
     * @param userPwd
     */
    @PostMapping("login")
    @ResponseBody
    public ResultInfo login(String userName,String userPwd){
        return userService.loginCheck(userName, userPwd);
    }

    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> queryUserByParams(UserQuery query){
        return userService.queryUserBYParams(query);
    }


    /**
     *  修改密码

     */
    @PostMapping("update")
    @ResponseBody
    public ResultInfo update(HttpServletRequest request, String oldPassword, String newPassword, String confirmPassword){
        //获取登录用户的id
        int id = LoginUserUtil.releaseUserIdFromCookie(request);
        userService.userUpdate(id,oldPassword,newPassword,confirmPassword);
        return success();
    }

    /**
     *  跳转用户模块首页
     */
    @RequestMapping("index")
    public String index(){
        return "user/user";
    }

    //打开修改密码页面
    @RequestMapping("toPasswordPage")
    public String toPasswordPage(){
        return "user/password";
    }

    /**
     * 用户添加
     * @param user
     * @return
     */

    @PostMapping("save")
    @ResponseBody
    public ResultInfo saveUser(User user){
        userService.saveUser(user);
        return success("用户添加成功");
    }


    /**
     * 用户修改
     * @param user
     * @return
     */
    @PostMapping("updateUser")
    @ResponseBody
    public ResultInfo updateUser(User user){
        userService.updateUser(user);
        return success("用户修改成功");
    }


    //打开添加/修改页面
    @RequestMapping("toUpdateAddPage")
    public String toUpdateAddPage(Integer id,HttpServletRequest request){
        //如果是修改操作，那么需要将数据显示在页面中
        if(id != null){
            User user = userService.selectByPrimaryKey(id);
            AssertUtil.isTrue(user == null,"数据异常请重试");
            request.setAttribute("user",user);
        }
        return "user/add_update";
    }


    //批量删除
    @PostMapping("deleteBatch")
    @ResponseBody
    public ResultInfo deleteUsers(Integer[] ids){
        userService.deleteUsers(ids);
        return success();
    }


}
