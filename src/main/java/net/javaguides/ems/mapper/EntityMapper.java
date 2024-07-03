package net.javaguides.ems.mapper;

import java.util.List;

public interface EntityMapper<ENTITY,DTO> {
    ENTITY toEntity(DTO dto);

    DTO toDto(ENTITY entity);

    List<ENTITY> toEntity(List<DTO> dtoList);

    List<DTO> toDto(List<ENTITY> entityList);
}
