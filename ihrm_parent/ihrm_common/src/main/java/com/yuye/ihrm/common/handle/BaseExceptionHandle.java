package com.yuye.ihrm.common.handle;

import com.yuye.ihrm.common.entity.Result;
import com.yuye.ihrm.common.entity.ResultCode;
import com.yuye.ihrm.common.exception.CommonException;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: yuye
 * @Date: 2022/3/1 - 03 - 01 - 18:50
 * @Description: com.yuye.ihrm.common.handle
 * @version: 1.0
 */
//@ControllerAdvice
@ResponseBody
public class BaseExceptionHandle {
//    @ExceptionHandler(value = Exception.class)
    //捕获系统全部异常
    public Result error(HttpServletRequest request, HttpServletResponse response, Exception e){
        if(e.getClass()== CommonException.class){
            CommonException ce = (CommonException) e;
            return new Result(ce.getResultCode());
        }else{
            return new Result(ResultCode.SERVER_ERROR);
        }

    }
}
