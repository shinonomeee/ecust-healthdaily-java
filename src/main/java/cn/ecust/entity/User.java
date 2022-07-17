package cn.ecust.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description
 * @Author chris
 * @Date 2022/7/18, 00:47
 */
@Data
@AllArgsConstructor
public class User {

    private String account;

    private String password;

    private String location;

}
