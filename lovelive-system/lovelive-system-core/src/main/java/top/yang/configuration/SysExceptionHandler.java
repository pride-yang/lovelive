package top.yang.configuration;

import com.google.common.collect.ImmutableMap;
import java.net.BindException;
import javax.validation.ValidationException;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.yang.spring.constants.GlobalsConstants;
import top.yang.spring.exception.ResultCode;
import top.yang.spring.exception.SystemException;
import top.yang.web.aspect.GlobalExceptionHandler;
import top.yang.web.exception.BusinessException;
import top.yang.web.exception.CommonCode;
import top.yang.web.response.ResponseResult;

/**
 * @author PrideYang
 */

@ControllerAdvice(basePackages = "top.yang")
public class SysExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(SysExceptionHandler.class);

    @ExceptionHandler(SystemException.class)
    @ResponseBody
    public ResponseResult<Void> systemException(SystemException systemException) {
        String requestId = MDC.get(GlobalsConstants.REQUEST_ID);
        systemException.printStackTrace();
        //记录日志
        logger.error("catch exception:{}", systemException.getMessage());
        return new ResponseResult<>(CommonCode.INVALID_PARAM, requestId);
    }
}
