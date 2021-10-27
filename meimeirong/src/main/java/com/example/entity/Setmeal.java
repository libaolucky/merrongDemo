package com.example.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;


@TableName("setmeal")
public class Setmeal extends Model<Setmeal> {
    /**
      * 主键
      */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
      * 套餐名称 
      */
    private String name;

    /**
      * 是否上架 
      */
    private Integer status;

    /**
      * 适用性别 
      */
    private String sex;

    /**
      * 套餐价格 
      */
    private Double price;

    /**
      * 套餐说明 
      */
    private String remark;

    /**
      * 注意事项 
      */
    private String attention;

    /**
      * 套餐图片 
      */
    private String img;

    /**
      * 套餐数量 
      */
    private Integer count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
         this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
         this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
         this.status = status;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
         this.sex = sex;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
         this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
         this.remark = remark;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
         this.attention = attention;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
         this.img = img;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
         this.count = count;
    }

}