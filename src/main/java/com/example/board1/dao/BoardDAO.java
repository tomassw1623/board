//DB와 Java 코드 사이를 연결해주는 역할
package com.example.board1.dao;

import com.example.board1.vo.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper // MyBatis에서 이 인터페이스를 매퍼로 인식하게 함
public interface BoardDAO {
    void insertBoard(BoardVO board);      // 게시글 등록
    List<BoardVO> selectAll();            // 게시글 전체 조회
}
