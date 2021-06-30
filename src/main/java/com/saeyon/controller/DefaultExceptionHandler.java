package com.saeyon.controller;

import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @BelongProjecet my-springboot-example
 * @BelongPackage com.saeyon.controller
 * @Date: 2021/6/27 7:29 下午
 * @Version V1.0
 * @Description:
 */
@ControllerAdvice
@EnableWebMvc
class DefaultExceptionHandler implements HandlerExceptionResolver {

    @Override
    public @ResponseBody
    ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        MappingJackson2JsonView view = new MappingJackson2JsonView();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setView(view);
        modelAndView.addObject("code", -999);
        modelAndView.addObject("msg", e.getMessage());
        return modelAndView;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    public @ResponseBody
    ModelAndView handleMethodArgumentNotValidException(Exception e) {
        BindingResult bindingResult = null;
        if (e instanceof MethodArgumentNotValidException) {
            bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
        }
        if (e instanceof BindException) {
            bindingResult = ((BindException) e).getBindingResult();
        }
        MappingJackson2JsonView view = new MappingJackson2JsonView();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setView(view);
        modelAndView.addObject("code", -31);
        modelAndView.addObject("msg", "入参数据校验失败：" + e.getMessage());
        modelAndView.addObject("originInput", bindingResult.getTarget());
        return modelAndView;
    }
}
