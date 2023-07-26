package com.crow.controller;

import com.crow.model.ResultResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:SystemController
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/7/20 10:34
 * @Role
 */
@RestController
@RequestMapping("/system")
public class SystemController {

    @PostMapping("/updateCarousel")
    public ResultResponse setFile(@RequestParam("file") MultipartFile[] file) throws IOException {
        for (int i = 0; i < file.length; i++) {
            if (file[i].isEmpty()){
                File img = new File("https://resources.hehuibin.cn/");
                String originalFilename = file[i].getOriginalFilename();
                File fileTo = new File(img, originalFilename);
                file[i].transferTo(fileTo);
            }
        }
        return new ResultResponse(true);
    }

}
