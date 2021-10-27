package com.example.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;


@TableName("item_and_group")
public class ItemAndGroup extends Model<ItemAndGroup> {
    /**
      * 主键
      */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
      * 组编号 
      */
    private Long groupId;

    /**
      * 项目编号 
      */
    private Long itemId;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
         this.groupId = groupId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
         this.itemId = itemId;
    }

}