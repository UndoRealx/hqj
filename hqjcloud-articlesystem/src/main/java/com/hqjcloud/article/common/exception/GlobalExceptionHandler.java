/*
package com.hqjcloud.article.common.exception;


import com.hqjcloud.article.common.ApiResultEntity;
import com.hqjcloud.article.common.enums.StateCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


*/
/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.base.exception
 * @ClassName: GlobalExceptionHandler
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/9/20 11:35
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/9/20 11:35
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 *//*

@RestControllerAdvice
public  class GlobalExceptionHandler{

    */
/*
     * 业务异常
     * @param e
     * @return
     *//*

    @ExceptionHandler(BusinessException.class)
    public ApiResultEntity handleHQJException(BusinessException e) {
        return general(e.getCode(),e);
    }


    @ExceptionHandler(RuntimeException.class)
    public ApiResultEntity handleException(RuntimeException e) {
        return general(StateCode.UNKNOWNERROR,e);
    }


  */
/*  private ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<Runnable>(5));*//*

    */
/*
     * 返回 spring 统一异常 后的信息
     * @param httpStatus
     * @return
     *//*

    protected ApiResultEntity general(StateCode stateCode, Exception e){
        e.printStackTrace();

        return ApiResultEntity.returnResult(stateCode.get());
    }

    private  static String getExceptionAllinformation(Exception ex){
        String sOut = "";
        sOut += ex.getMessage() + "\r\n";
        StackTraceElement[] trace = ex.getStackTrace();
        for (StackTraceElement s : trace) {
            sOut += "\tat " + s + "\r\n";
        }
        return sOut;
    }

}*/
