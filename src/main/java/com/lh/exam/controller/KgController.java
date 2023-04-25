package com.lh.exam.controller;

import com.lh.exam.api.CommonResult;
import com.lh.exam.entity.Kg;
import com.lh.exam.service.KgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KgController {
    @Autowired
    private KgService kgService;
    @ResponseBody
    @RequestMapping("/kglogin")
    public CommonResult kgLogin(@RequestBody Kg kg){
        System.out.println(kg.toString());
        Kg kg1 = kgService.selectKgForUsername(kg);
        if(kg1==null){
            return CommonResult.failed("登录账号不存在");
        }
        if(!kg1.getKgUsername().equals(kg.getKgUsername()) ||
                !kg.getKgPassword().equals(kg1.getKgPassword())){
            return CommonResult.failed("用户名或密码错误");
        }
        return CommonResult.success("登录成功");
    }
}
