package com.example.footballmanager.mapper;

public interface RequestDtoMapper<D, T> {
    T mapToModel(D dto);
}
