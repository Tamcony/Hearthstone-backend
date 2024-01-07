package com.example.hearthstone.advice;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.example.hearthstone.annotion.NoWrapper;
import com.example.hearthstone.utils.http.HttpResponse;
import org.springframework.core.MethodParameter;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.List;

@RestControllerAdvice(basePackages = "com.example.hearthstone.controller")
public class ResponseBody implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return !returnType.getDeclaringClass().isAnnotationPresent(NoWrapper.class);//不拦截
//所有都拦截
    }
    @ExceptionHandler(Exception.class)
    public HttpResponse exceptionHandler(Exception e){
        HttpResponse httpResponse = new HttpResponse();
        httpResponse.error();
        return httpResponse;
    }
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        HttpResponse httpResponse = new HttpResponse();
        if (body instanceof Page<?> pageBody) {
            long total = pageBody.getTotalElements();
            List<?> items = pageBody.getContent();
            Object data = JSONUtil.createObj().set("total",total).set("items",items);
            httpResponse.success(data);
        }else{
            httpResponse.success(body);
        }

        if(selectedConverterType.equals(StringHttpMessageConverter.class)){
            return JSONUtil.toJsonStr(httpResponse);
        }else{
            return httpResponse;
        }
    }
}
