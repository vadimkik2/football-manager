package com.example.footballmanager.mapper;

import com.example.footballmanager.dto.PlayerRequestDto;
import com.example.footballmanager.dto.PlayerResponseDto;
import com.example.footballmanager.model.Player;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlayerDtoMapper {
    PlayerDtoMapper INSTANCE = Mappers.getMapper(PlayerDtoMapper.class);

    PlayerResponseDto mapToDto(Player player);

    Player mapToModel(PlayerRequestDto dto);
}
