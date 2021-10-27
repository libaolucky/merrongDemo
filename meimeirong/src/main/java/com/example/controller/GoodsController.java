package com.example.controller;

import com.example.common.Result;
import com.example.entity.Goods;
import com.example.service.GoodsService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/goods")
public class GoodsController {
    @Resource
    private GoodsService goodsService;

    @PostMapping
    public Result<?> save(@RequestBody Goods goods) {
        return Result.success(goodsService.save(goods));
    }

    @PutMapping
    public Result<?> update(@RequestBody Goods goods) {
        return Result.success(goodsService.updateById(goods));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        goodsService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Goods> findById(@PathVariable Long id) {
        return Result.success(goodsService.getById(id));
    }

    @GetMapping
    public Result<List<Goods>> findAll() {
        return Result.success(goodsService.list());
    }

    @GetMapping("/page")
    public Result<IPage<Goods>> findPage(@RequestParam(required = false, defaultValue = "") String name,
                                         @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                         @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(goodsService.page(new Page<>(pageNum, pageSize), Wrappers.<Goods>lambdaQuery().like(Goods::getName, name)));
    }

}