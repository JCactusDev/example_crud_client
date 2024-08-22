package com.github.jcactusdev.example_crud_client.contrller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ServerErrorException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = NoResourceFoundException.class)
    public String handleNotFoundException(NoResourceFoundException e) {
        return "error/404";
    }

    @ExceptionHandler(value = HttpClientErrorException.NotFound.class)
    public String handleNotFoundException(HttpClientErrorException.NotFound e) {
        return "error/404";
    }

    @ExceptionHandler(value = HttpClientErrorException.UnprocessableEntity.class)
    public String handleUnprocessableEntityException(HttpClientErrorException.UnprocessableEntity e) {
        return "error/422";
    }

    @ExceptionHandler(value = ServerErrorException.class)
    public String handleServerErrorException(ServerErrorException e) {
        return "error/500";
    }

}
