package org.example.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.dto.ContentDto;
import org.example.dto.ContentTypeDto;
import org.example.dto.FullContentDto;
import org.example.entity.Content;
import org.example.mapper.ContentMapper;
import org.example.repository.ContentRepository;
import org.example.service.ContentService;
import org.example.service.ContentTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ContentServiceImpl implements ContentService {

  private final ContentRepository contentRepository;
  private final ContentTypeService contentTypeService;
  private final ContentMapper mapper;

  @Override
  public List<FullContentDto> getAllContents() {
    return contentRepository.findAll().stream().map(mapper::contentToFullContentDto).toList();
  }

  @Override
  @Transactional
  public FullContentDto saveContent(ContentDto contentDto) {
    ContentTypeDto contentType = contentTypeService.getContentTypeById(
        contentDto.getContentTypeId());
    Content contentToSave = mapper.contentDtoToContent(contentDto, contentType);
    return mapper.contentToFullContentDto(contentRepository.save(contentToSave));
  }

}
