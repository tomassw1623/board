package com.example.board1.dao;

import com.example.board1.vo.BoardVO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

// 이 인터페이스가 MyBatis의 매퍼 인터페이스임을 Spring에게 알려줍니다.
// Spring Boot가 시작될 때 이 인터페이스의 구현체를 자동으로 생성하여
// 다른 곳(예: BoardService)에서 주입(inject)할 수 있도록 Bean으로 등록해줍니다.
@Mapper
public interface BoardDAO {

    // 여기에 정의된 메소드들은 BoardMapper.xml 파일의 <select>, <insert> 등의 태그와 연결됩니다.
    // 메소드 이름은 XML의 id와 일치해야 합니다.
    // 파라미터 타입은 XML의 parameterType과 일치해야 합니다.
    // 반환 타입은 XML의 resultType과 일치해야 합니다.

    List<BoardVO> selectAll();
    void insertBoard(BoardVO board);
    void update(BoardVO board);
    void delete(int id);
}