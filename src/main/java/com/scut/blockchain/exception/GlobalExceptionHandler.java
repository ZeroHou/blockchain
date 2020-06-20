package com.scut.blockchain.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = CompanyPointsException.class)
    public void companyPointsExceptionHandler(Exception e, HttpServletResponse res) throws IOException {
        res.sendError(400,"企业积分异常，错误请求");
    }

    @ResponseBody
    @ExceptionHandler(value = UserPointsException.class)
    public void userPointsExceptionHandler(Exception e, HttpServletResponse res) throws IOException {
        res.sendError(400,"用户积分异常，错误请求");
    }

    @ResponseBody
    @ExceptionHandler(value = BlockChainException.class)
    public void blockChainExceptionHandler(Exception e, HttpServletResponse res) throws IOException {
        res.sendError(500,"区块链异常，服务器错误");
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public void exceptionHandler(Exception e, HttpServletResponse res) throws IOException {
        res.sendError(500,"区块链异常，服务器错误");
    }

    @ResponseBody
    @ExceptionHandler(value = LoginException.class)
    public void loginExceptionHandler(Exception e, HttpServletResponse res) throws IOException {
        res.sendError(400,"登陆异常，错误请求");
    }
}
