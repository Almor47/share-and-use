package org.example.service;

import java.util.List;
import org.example.dto.ContentDto;
import org.example.dto.FullContentDto;

public interface ContentService {

  List<FullContentDto> getAllContents();

  FullContentDto saveContent(ContentDto contentDto);

}
