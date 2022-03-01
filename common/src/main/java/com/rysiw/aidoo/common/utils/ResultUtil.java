package com.rysiw.aidoo.common.utils;

import com.rysiw.aidoo.common.constant.RespCode;
import com.rysiw.aidoo.common.vo.ResultVO;

/**
 * 返回结果工具类
 * @author Rysiw
 * @date 2022/2/25 13:34
 */
public class ResultUtil {

    /**
     * 返回成功
     * @return ResultVO
     */
    public static ResultVO success(){
        return ResultVO.builder()
                .code(RespCode.SUCCESS.getCode())
                .msg(RespCode.SUCCESS.getMsg())
                .build();
    }

    /**
     * 返回成功(无msg)
     * @return ResultVO
     */
    public static ResultVO successWithNoMsg(){
        return ResultVO.builder()
                .code(RespCode.SUCCESS.getCode())
                .build();
    }

    /**
     * 返回成功带data
     * @return ResultVo
     */
    public static ResultVO success(Object data){
        return ResultVO.builder()
                .code(RespCode.SUCCESS.getCode())
                .msg(RespCode.SUCCESS.getMsg())
                .data(data)
                .build();
    }

    /**
     * 返回失败
     */
    public static ResultVO error(){
        return ResultVO.builder()
                .code(RespCode.ERROR.getCode())
                .msg(RespCode.ERROR.getMsg())
                .build();
    }

    /**
     * 自定义返回
     * @param e RespCode
     * @return ResultVo
     */
    public static ResultVO custom(RespCode e){
        return ResultVO.builder()
                .code(e.getCode())
                .msg(e.getMsg())
                .build();
    }

    /**
     * 自定义返回
     * @param code
     * @param msg
     * @return ResultVo
     */
    public static ResultVO custom(String code, String msg){
        return ResultVO.builder()
                .code(code)
                .msg(msg)
                .build();
    }

    /**
     * 自定义返回
     * @param code
     * @param msg
     * @param data
     * @return ResultVo
     */
    public static ResultVO custom(String code, String msg, Object data){
        return ResultVO.builder()
                .code(code)
                .msg(msg)
                .data(data)
                .build();
    }
}
