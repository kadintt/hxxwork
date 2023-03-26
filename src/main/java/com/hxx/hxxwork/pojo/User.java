package com.hxx.hxxwork.pojo;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String opinion;
    private String gender;
    private Integer[] skills;
    private String cnames;
}
