package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.ContentTypeDto;
import org.example.exception.NotFoundException;
import org.example.mapper.ContentTypeMapper;
import org.example.repository.ContentTypeRepository;
import org.example.service.ContentTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ContentTypeServiceImpl implements ContentTypeService {

  private final ContentTypeRepository contentTypeRepository;
  private final ContentTypeMapper contentTypeMapper;

  @Override
  public ContentTypeDto getContentTypeById(Integer contentTypeId) {
    return contentTypeMapper.contentTypeToContentTypeDto(
        contentTypeRepository.findById(contentTypeId)
            .orElseThrow(
                () -> new NotFoundException("КонтентТайп " + contentTypeId + " не найден")));
  }

}
