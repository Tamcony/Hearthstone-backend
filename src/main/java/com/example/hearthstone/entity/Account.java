package com.example.hearthstone.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * (Account)实体类
 *
 * @author makejava
 * @since 2024-01-04 17:00:08
 */
@Data
@Document(collection = "account")
public class Account{

    private String codeWebsite;

    private Integer dust;

    private String email;

    private Integer gold;

    @Id
    private String id;

    private String password;

    private Integer status;

    private String account;

    private String emailPassword;

    private String area;

}

