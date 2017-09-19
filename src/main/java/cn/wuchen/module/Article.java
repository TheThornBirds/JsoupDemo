package cn.wuchen.module;

import lombok.Data;

import java.util.Date;
@Data
public class Article {

    private String id;

    private String title;

    private String content;

    private Date date;

    private String type;
}
