package org.example.tliaswebmanagement.EntityClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 登录返回的响应数据
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginInfo {
    private Integer id;         // 用户数据id
    private String userName;    // 员工账号
    private String name;        // 用户名
    private String token;       // 令牌
}
