package com.example.controller;

import com.example.common.Result;
import com.example.entity.Item;
import com.example.service.ItemService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {
    @Resource
    private ItemService itemService;

    @PostMapping
    public Result<?> save(@RequestBody Item item) {
        return Result.success(itemService.save(item));
    }

    @PutMapping
    public Result<?> update(@RequestBody Item item) {
        return Result.success(itemService.updateById(item));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        itemService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Item> findById(@PathVariable Long id) {
        return Result.success(itemService.getById(id));
    }

    @GetMapping
    public Result<List<Item>> findAll() {
        return Result.success(itemService.list());
    }

    @GetMapping("/page")
    public Result<IPage<Item>> findPage(@RequestParam(required = false, defaultValue = "") String name,
                                        @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                        @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(itemService.page(new Page<>(pageNum, pageSize), Wrappers.<Item>lambdaQuery().like(Item::getName, name)));
    }

}