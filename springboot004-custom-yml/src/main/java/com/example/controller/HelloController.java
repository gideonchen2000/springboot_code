package com.example.controller;

import com.example.vo.SchoolInfo;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Value("${school.name}")
    private String name;

    @Value("${school.website}")
    private String website;

    @Value("${site}")
    private String site;

    @Resource
    private SchoolInfo info;
    @RequestMapping("/data")
    @ResponseBody
    public String queryData() {
        return name+", website="+website+", 访问地址="+site;
    }

    @RequestMapping("/info")
    @ResponseBody
    public String queryInfo() {
        return "SchoolInfo对象=="+info.toString();
    }
}
