package org.example.mapper;

import org.example.dto.ContentTypeDto;
import org.example.entity.ContentType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ContentTypeMapper {

  @Mapping(target = "contentTypeId", ignore = true)
  ContentType contentTypeDtoToContentType(ContentTypeDto contentTypeDto);

  ContentTypeDto contentTypeToContentTypeDto(ContentType contentType);
}
