package com.example.footballmanager.mapper;

import com.example.footballmanager.dto.TeamRequestDto;
import com.example.footballmanager.dto.TeamResponseDto;
import com.example.footballmanager.model.Team;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeamDtoMapper {
    TeamDtoMapper INSTANCE = Mappers.getMapper(TeamDtoMapper.class);

    Team mapToModel(TeamRequestDto dto);

    TeamResponseDto mapToDto(Team team);

}
