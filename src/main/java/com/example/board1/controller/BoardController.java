// 컨드롤러는 외부에서 API 요청을 받아 Service를 호출하고, 실제로 게시글을 등록하거나 조회하는 역할을 함
// 패키지 정의 – 현재 이 클래스가 com.example.board1.controller 패키지 안에 있다는 뜻
package com.example.board1.controller;

// 필요한 클래스들 import (Service 호출, 데이터 전달용 객체, REST 컨트롤러 기능 등)
import com.example.board1.service.BoardService;
import com.example.board1.vo.BoardVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 이 클래스는 REST API 컨트롤러임을 나타냄 (응답을 JSON으로 처리)
@RestController

// 이 클래스의 모든 요청 앞에 "/board" 경로가 붙음
@RequestMapping("/board")
public class BoardController {

    // 비즈니스 로직을 담당할 서비스 객체를 선언 (final → 생성자에서 주입)
    private final BoardService boardService;

    // 생성자를 통해 BoardService를 주입받음 (스프링이 자동으로 연결해줌)
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // [POST] /board/register
    // 게시글 등록 요청을 처리함
    // 클라이언트에서 JSON 형식으로 데이터를 보내면 → BoardVO 객체로 자동 매핑됨
    @PostMapping("/register")
    public String register(@RequestBody BoardVO board) {
        // 서비스에 등록 요청 (DB에 INSERT 진행)
        boardService.register(board);
        return "등록 완료!";
    }

    // [GET] /board/list
    // 게시글 목록을 가져오는 API
    @GetMapping("/list")
    public List<BoardVO> getList() {
        // 서비스에서 게시글 리스트를 받아옴 → JSON 배열로 자동 변환돼서 응답됨
        return boardService.getList();
    }
}
