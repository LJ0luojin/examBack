package com.lh.exam.controller;

import com.lh.exam.api.CommonResult;
import com.lh.exam.api.JWTutil;
import com.lh.exam.entity.ks;
import com.lh.exam.service.KsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KsController {
    @Autowired
    private KsService ksService;
    @RequestMapping("/login")
    @ResponseBody
    public CommonResult ksLogin(@RequestBody ks k){
        ks k2 = ksService.selectKsForNumber(k.getKsNumber());
        if(k2==null){
            return CommonResult.failed("用户不存在");
        }
        if(!k2.getKsPassword().equals(k.getKsPassword())){
            return CommonResult.failed("密码错误");
        }
        return CommonResult.success(JWTutil.generateToken(k2.getKsName()));
    }

    @ResponseBody
    @RequestMapping("/register")
    public CommonResult ksRegister(@RequestBody ks newKs){
        System.out.println(newKs.toString());
        ks ks = ksService.selectKsForNumber(newKs.getKsNumber());
        if (ks!=null){
            return CommonResult.failed("该考试已注册！");
        }
        int res = ksService.insertKs(newKs);
        if(res==0){
            return CommonResult.failed("注册失败");
        }else{
            return CommonResult.success("注册成功");
        }
    }
}
