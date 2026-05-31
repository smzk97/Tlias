package org.example.tliaswebmanagement.EntityClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回字段信息实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer id; // 编码，成功：1，失败：0
    private String msg; // 错误/失败信息
    private Object data; // 数据

    // 200且返回数据为空
    public static Result Success(){
        return new Result(1,"成功",null);
    }

    // 200且返回数据不为空
    public static Result Success(Object data){
        return new Result(1,"成功",data);
    }

    // 4xx
    public static Result Defeat(String msg){
        return new Result(0,msg,null);
    }
}
