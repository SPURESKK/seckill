package com.codehuu.seckill.exception;


import com.codehuu.seckill.vo.RespBean;
import com.codehuu.seckill.vo.RespBeanEnum;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 如果全部异常处理返回json，那么可以使用 @RestControllerAdvice 代替 @ControllerAdvice ，
 * 这样在方法上就可以不需要添加 @ResponseBody
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public RespBean ExceptionHandler(Exception e){
        if(e instanceof GlobalException){
            GlobalException ex = (GlobalException) e;
            return RespBean.error(ex.getRespBeanEnum());
        }else if(e instanceof BindException){
            //类转换
            BindException ex = (BindException) e;
            RespBean respBean = RespBean.error(RespBeanEnum.BIND_ERROR);
            //codes [loginVo.mobile,mobile]; arguments []; default message [mobile],true]; default message [手机号码格式错误]]
            //获取第一个BindError的错误信息
            respBean.setMessage("参数校验异常-->" + ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
            return respBean;
        }
        return RespBean.error(RespBeanEnum.ERROR);
    }
}
