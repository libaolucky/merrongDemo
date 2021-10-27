package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.ToString;

@ToString
@TableName("item_group")
public class ItemGroup extends Model<ItemGroup> {
    /**
      * 主键
      */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
      * 注意事项 
      */
    private String attention;

    /**
      * 组代码 
      */
    private String code;

    /**
      * 组名称 
      */
    private String name;

    /**
      * 说明 
      */
    private String remark;

    /**
      * 性别 
      */
    private String sex;

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
         this.attention = attention;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
         this.code = code;
    }

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
         this.remark = remark;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
         this.sex = sex;
    }

}