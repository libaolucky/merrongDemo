package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

// 这个实体类是   用mybatis-plus 生成器 生成的
@TableName("t_permission")  // TableName 和数据库的表名 保持一致！！
public class Permission extends Model<Permission> {
    /**
     * 主键  在mybatis-plus 中的 TableId 就是主键的注解
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;

    private String path;

    private String description;

    private String flag;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
