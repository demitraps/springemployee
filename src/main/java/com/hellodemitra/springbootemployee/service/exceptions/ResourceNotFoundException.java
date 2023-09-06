package com.hellodemitra.springbootemployee.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Class<?> entityClass, Long id) {
        super("Resource " + entityClass.getSimpleName() + " with id: " + id + " does not exist.");
    }


}
