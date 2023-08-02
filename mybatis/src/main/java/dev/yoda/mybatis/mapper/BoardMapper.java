package dev.yoda.mybatis.mapper;

import dev.yoda.mybatis.dto.BoardDto;

public interface BoardMapper {
    int createBoard(BoardDto dto);
}
