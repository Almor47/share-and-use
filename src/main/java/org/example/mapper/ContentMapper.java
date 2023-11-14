package org.example.mapper;

import org.example.dto.ContentDto;
import org.example.dto.ContentTypeDto;
import org.example.dto.FullContentDto;
import org.example.entity.Content;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ContentMapper {

  @Mapping(target = "contentId", ignore = true)
  Content contentDtoToContent(ContentDto contentDto, ContentTypeDto contentType);

  ContentDto contentToContentDto(Content content);

  FullContentDto contentToFullContentDto(Content content);
}
