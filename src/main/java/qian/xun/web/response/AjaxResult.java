package qian.xun.web.response;

import lombok.Data;


@Data
public class AjaxResult <T>{
    private int code;
    private T data;

    public static <T>AjaxResult success(T data){
         AjaxResult result = new AjaxResult();
         result.setCode(20000);
        result.setData(data);
         return result;
    }
}
