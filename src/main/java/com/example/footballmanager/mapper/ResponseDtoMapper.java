package com.example.footballmanager.mapper;

public interface ResponseDtoMapper<D, T> {
    D mapToDto(T t);
}
