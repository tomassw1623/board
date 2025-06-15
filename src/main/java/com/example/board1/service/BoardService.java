package com.example.board1.service;

import com.example.board1.dao.BoardDAO;
import com.example.board1.vo.BoardVO;
import org.springframework.stereotype.Service;
import java.util.List;

// 이 클래스가 비즈니스 로직을 처리하는 '서비스' 계층의 컴포넌트임을 나타냅니다.
// '@Service' 어노테이션을 통해 Spring은 이 클래스를 자동으로 Bean으로 등록하고 관리합니다.
@Service
public class BoardService {

    // DAO에 대한 의존성을 선언합니다. 'final' 키워드를 사용하면
    // 이 객체는 생성 시에만 초기화될 수 있으므로, 불변성을 보장하여 안전합니다.
    private final BoardDAO boardDAO;

    // 생성자를 통한 의존성 주입(Constructor Injection) 방식입니다.
    // Spring이 시작될 때, 미리 만들어 둔 BoardDAO Bean을 이 생성자의 파라미터로 자동으로 전달해줍니다.
    // 이 방식은 의존성이 누락되는 것을 방지해주기 때문에 Spring에서 가장 권장하는 방식입니다.
    public BoardService(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    // 게시글 등록 로직입니다. 지금은 단순히 DAO를 호출만 하지만,
    // 나중에는 '글 등록 시 사용자 포인트 증가'와 같은 추가적인 비즈니스 로직이 여기에 들어갈 수 있습니다.
    public void register(BoardVO board) {
        boardDAO.insertBoard(board);
    }

    // 게시글 목록 조회 로직입니다.
    public List<BoardVO> getList() {
        return boardDAO.selectAll();
    }

    // 게시글 수정 로직입니다.
    public void update(BoardVO board) {
        boardDAO.update(board);
    }

    // 게시글 삭제 로직입니다.
    public void delete(int id) {
        boardDAO.delete(id);
    }
}