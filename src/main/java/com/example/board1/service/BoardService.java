// 비즈니스 로직 처리
package com.example.board1.service;

import com.example.board1.dao.BoardDAO;
import com.example.board1.vo.BoardVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final BoardDAO boardDAO;

    public BoardService(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    // 게시글 등록 비즈니스 로직
    public void register(BoardVO board) {
        boardDAO.insertBoard(board);
    }

    // 게시글 전체 조회 로직
    public List<BoardVO> getList() {
        return boardDAO.selectAll();
    }
}
