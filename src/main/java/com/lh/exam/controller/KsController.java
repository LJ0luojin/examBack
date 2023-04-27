package com.lh.exam.controller;

import com.lh.exam.api.CommonResult;
import com.lh.exam.api.JWTutil;
import com.lh.exam.entity.Ks;
import com.lh.exam.service.KsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KsController {
    @Autowired
    private KsService ksService;
    @RequestMapping("/login")
    @ResponseBody
    public CommonResult ksLogin(@RequestBody Ks k){
        Ks k2 = ksService.selectKsForNumber(k.getKsNumber());
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
    public CommonResult ksRegister(@RequestBody Ks newKs){
        System.out.println(newKs.toString());
        Ks ks = ksService.selectKsForNumber(newKs.getKsNumber());
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

    @RequestMapping(value = "/selectks",method = RequestMethod.GET)
    public CommonResult selectKs(String selectks){
        List<Ks> ks = ksService.selectKs(selectks);
        for (Ks k : ks) {
            System.out.println(k);
        }
        return CommonResult.success(ks,"成功");
    }
    @ResponseBody
    @RequestMapping("/selectallks")
    public CommonResult selectAllKs(){
        List<Ks> allKs = ksService.selectAllKs();
        return CommonResult.success(allKs,"成功");

    }
}
