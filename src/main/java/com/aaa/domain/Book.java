package com.aaa.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @TableName book
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value ="book")
public class Book implements Serializable {
    /**
     * 图书编号
     */
    @TableId
    private Integer id;

    /**
     * 图书名称
     */
    private String bookName;

    /**
     * 图书价格
     */
    private String bookPrice;

    /**
     * 图书封面
     */
    private String bookCover;

    /**
     * 图书作者
     */
    private String bookAuthor;

    /**
     * 添加时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

    /**
     * 状态
     */
    private boolean status;

}