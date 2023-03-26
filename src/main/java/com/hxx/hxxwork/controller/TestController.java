package com.hxx.hxxwork.controller;

import com.alibaba.fastjson.JSONObject;
import com.hxx.hxxwork.pojo.User;
import com.hxx.hxxwork.service.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class TestController {
    @Autowired
    UserMapper mapper;

    @RequestMapping("query")
    public List<User> queryList() {
        List<User> list = mapper.queryStuList();
        return list;
    }

    @RequestMapping("add")
    public Map<String, Object> add(@RequestBody User user){

        JSONObject object = new JSONObject();
        System.out.println(user);
        mapper.add(user);
        mapper.batchAdd(user);
        object.put("code","1");
        object.put("message", "success");
        return object;
    }

    @RequestMapping("del")
    public String del(Integer id){
        mapper.deleteStu(id);
        mapper.deleteCours(id);
        return "1";
    }

    @RequestMapping("stu/{kind}")
    public String stu(@PathVariable("kind")Integer kind){
        JSONObject object = new JSONObject();
        //对应的班级
        List<Map> bj = mapper.queryBj(kind);
        //所有的课程
        List<Map> kc =mapper.queryKc();
        object.put("gender",bj);
        object.put("skills",kc);
        return object.toJSONString();
    }
    @PostMapping("uploadFile")
    public String uploadFile(MultipartFile fileUpload) {
        String filename = fileUpload.getOriginalFilename();
        filename = UUID.randomUUID() + "_" + filename;
        String dirPath = "/Users/quchaodev/Documents/file/";
        File file = new File(dirPath);
        System.out.println(file.toString());
        if (!file.exists()) {
            file.mkdir();
        }
        try {
            fileUpload.transferTo(new File(dirPath + filename));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("上传失败");
        }
        return "success";
    }
}
