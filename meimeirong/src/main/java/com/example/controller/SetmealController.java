package com.example.controller;

import cn.hutool.core.io.FileUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.Result;
import com.example.entity.Setmeal;
import com.example.service.SetmealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/setmeal")
@Slf4j
public class SetmealController {
    @Resource
     private SetmealService setmealService;

    @PostMapping
    public Result<?> save(@RequestBody Setmeal setmeal) {
        return Result.success(setmealService.save(setmeal));
    }

    @PutMapping
    public Result<?> update(@RequestBody Setmeal setmeal) {
        return Result.success(setmealService.updateById(setmeal));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        setmealService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Setmeal> findById(@PathVariable Long id) {
        return Result.success(setmealService.getById(id));
    }

    @GetMapping
    public Result<List<Setmeal>> findAll() {
        return Result.success(setmealService.list());
    }

    @GetMapping("/page")
    public Result<IPage<Setmeal>> findPage(@RequestParam(required = false, defaultValue = "") String name,
                                           @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(setmealService.page(new Page<>(pageNum, pageSize), Wrappers.<Setmeal>lambdaQuery().like(Setmeal::getName, name)));
    }

    // 套餐图片的上传  注意： 此图片上传到了 静态资源文件夹中了，即 项目的路径下，  不太好
    /**
     * 单文件上传
     *
     * @param file
     * @return
     */
    // 第一种
    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) {   //MultipartFile  指的是前端文件
        // 文件的路径
        String filePath = System.getProperty("user.dir") + "/src/main/resources/static/file/";
        log.info("filePath"+filePath);
        // 以 当前时间的long值 创建一个新的 名称
        String flag = System.currentTimeMillis()+ ""+ UUID.randomUUID();
        log.info("图片的新名称"+flag);
        String fileName = file.getOriginalFilename();  // 后缀名
        log.info("fileName"+fileName);
        try {
            FileUtil.writeBytes(file.getBytes(), filePath + flag + "-" + fileName);
            System.out.println(fileName + "--上传成功");
            Thread.sleep(1L);
        } catch (Exception e) {
            System.err.println(fileName + "--文件上传失败");
        }
        return Result.success(flag);
    }

    // 使用虚拟路径  配置图片 地址 第二种
    @PostMapping("/upload1")
    public Result<String> upload1(MultipartFile file) {   //MultipartFile  指的是前端文件
        // 文件的路径
        //String filePath = System.getProperty("user.dir") + "/src/main/resources/static/file/";
        String filePath ="D:/xunipic/";
        log.info("filePath"+filePath);
        // 以 当前时间的long值 创建一个新的 名称
        String flag = System.currentTimeMillis() + ""+ UUID.randomUUID();
        log.info("图片的新名称"+flag);
        String fileName = file.getOriginalFilename();  // 后缀名
        log.info("fileName"+fileName);
        try {
            FileUtil.writeBytes(file.getBytes(), filePath + flag + "-" + fileName);
            System.out.println(fileName + "--上传成功");
            Thread.sleep(1L);
        } catch (Exception e) {
            System.err.println(fileName + "--文件上传失败");
        }
        return Result.success(flag);
    }


}