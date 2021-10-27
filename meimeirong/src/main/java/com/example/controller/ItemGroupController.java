package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.Result;
import com.example.entity.ItemGroup;
import com.example.service.ItemGroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/itemGroup")
@Slf4j   //lombok  的注解 用log4j的
public class ItemGroupController {
    @Resource
     private ItemGroupService itemGroupService;

    @PostMapping
    public Result<?> save(@RequestBody ItemGroup itemGroup) {
        return Result.success(itemGroupService.save(itemGroup));
    }

    @PutMapping
    public Result<?> update(@RequestBody ItemGroup itemGroup) {
        return Result.success(itemGroupService.updateById(itemGroup));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        itemGroupService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<ItemGroup> findById(@PathVariable Long id) {
        return Result.success(itemGroupService.getById(id));
    }

    @GetMapping
    public Result<List<ItemGroup>> findAll() {
        return Result.success(itemGroupService.list());
    }

    @GetMapping("/page")
    public Result<IPage<ItemGroup>> findPage(@RequestParam(required = false, defaultValue = "") String name,
                                           @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(itemGroupService.page(new Page<>(pageNum, pageSize), Wrappers.<ItemGroup>lambdaQuery().like(ItemGroup::getName, name)));
    }

    // 项目组的增加： （1）项目组的添加， （2）将得到的 数组，添加到 中间表
    @PostMapping("/additemAndGroup")    // 注意：两个参数， 第一个参数是itemGroup 的实体类，第二个参数是  item全查后 选中的数组！！
    public Result additemAndGroup(String itemIds,@RequestBody ItemGroup itemGroup){
        log.info(itemIds); // itemIds=28,29,31  如何把 A,B,C,D 格式， 分割成数组？
        log.info(itemGroup.toString());  // 这个是itemGroup 对象
        String[] newids = itemIds.split(",");
        for (String newid : newids) {
            System.out.println("newid = " + newid);
        }
        System.out.println(itemGroup.getName());
        // 步骤： 执行  增加了。。。  ItemGroup,  itemAndGroup
        Boolean b = itemGroupService.adItemGroupAndTable(itemGroup, newids);
        if(b){
            return Result.success();
        }else {
            return Result.error("50004","添加失败，请重新添加！！！");
        }
    }


}