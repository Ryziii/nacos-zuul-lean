package com.rysiw.aidoo.common.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.rysiw.aidoo.common.constant.RespCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * 通用返回VO
 * @author Rysiw
 * @date 2022/2/24 20:45
 */
@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVO<T> {
    private String code;
    private String msg;
    private T data;

    public ResultVO(){

    }

    public static ResultVO otherError(Exception e) {
        ResultVO resultVO = new ResultVO();
        resultVO.code = RespCode.ERROR.getCode();
        resultVO.msg = e.getMessage();
        resultVO.data = e.getStackTrace();
        return resultVO;
    }

    public ResultVO buildMessage(String message){
        this.setMsg(message);
        return this;
    }

    public ResultVO buildData(T data){
        this.data = data;
        return this;
    }

}
