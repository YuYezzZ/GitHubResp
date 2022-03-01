package com.yuye.ihrm.common.exception;

import com.yuye.ihrm.common.entity.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: yuye
 * @Date: 2022/3/1 - 03 - 01 - 19:07
 * @Description: com.yuye.ihrm.common.exception
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonException extends Exception{
    private ResultCode resultCode;

}
