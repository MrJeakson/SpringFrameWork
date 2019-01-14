package com.jt.controller;

import com.jt.common.vo.JsonResult;
import com.jt.pojo.User;
import com.jt.pojo.UserInfo;
import com.jt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/query/{pageCurrent}/{pageSize}")
    @ResponseBody
    public JsonResult userQuery(@PathVariable("pageCurrent") Integer pageCurrent,
                                @PathVariable("pageSize") Integer pageSize) {

        List<User> userList = userService.findPageObject(pageCurrent, pageSize);

        //System.out.println(userList);

        return new JsonResult(userList);
    }

    @RequestMapping("/show")
    public ModelAndView showPageView() {

        ModelAndView mv = new ModelAndView("page");

        mv.addObject("hello", "hoew are you ?");

        return mv;
    }

    @RequestMapping(value = "/withoutRequest")
    @ResponseBody
    public String withoutStringParameter(@RequestParam(value ="foo",required = false) String foo){

        return "obtain the name is:"+foo;

    }

    @RequestMapping("/withoutDate")
    @ResponseBody
    public String withoutDate(Date birthday ){



        return "his birthday:  "+birthday;
    }

    @RequestMapping("/withoutVarParam")
    @ResponseBody
    public String withoutVarParam(Integer ...ids ){



        return "Obtained ids parameter value '" + ids + "'";
    }

    @RequestMapping("/entity/data")
    @ResponseBody
    public String withoutVarEntity(User user ){

        return "Obtained ids parameter value '" + user + "'";
    }

    @RequestMapping("/obtainHeaderParam")
    @ResponseBody
    public String obtainHeaderParam(@RequestHeader String accept){

        return  "obtain header parameter:  "+accept;
    }

    @RequestMapping(value="/entity", method=RequestMethod.GET)
    @ResponseBody
    public String withEntity(
            HttpEntity<String> entity) {
        return "Posted request body " + entity.getBody() +
                "headers = " + entity.getHeaders();
    }

/*    @RequestMapping("doResponse")
    public String doRresponse(HttpSession session){

        session.setAttribute("date","The part of my life,It's call stupid ！");

        return "response";
    }*/
    @RequestMapping("/doResponse")
    public String doRresponse(Integer pageCurrent, Integer pageSize, HttpServletRequest request){

        List<User> userList = userService.findPageObject(pageCurrent, pageSize);

        request.setAttribute("userList",userList);
        return "response";
    }

    @RequestMapping("/queryUserInfo")
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonResult queryUserInfo(String name,String password){

       UserInfo userInfo = userService.findUserInfo(name, password);
       System.out.println(userInfo);
        return new JsonResult(userInfo) ;

    }
}
