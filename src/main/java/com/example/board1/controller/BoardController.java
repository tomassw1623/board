package com.example.board1.controller;

import com.example.board1.service.BoardService;
import com.example.board1.vo.BoardVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// 이 클래스가 REST API의 요청을 처리하는 컨트롤러임을 나타냅니다.
// '@RestController'는 '@Controller'와 '@ResponseBody'를 합친 것입니다.
// '@ResponseBody'는 이 클래스의 모든 메소드 반환 값이 View 이름이 아닌,
// 응답(response)의 본문(body)에 직접 JSON 또는 XML 형태로 작성됨을 의미합니다.
@RestController
// 이 컨트롤러의 모든 API 주소 앞에 공통적으로 '/board' 경로를 추가합니다.
@RequestMapping("/board")
public class BoardController {

    // 비즈니스 로직을 처리할 서비스에 대한 의존성 선언입니다.
    private final BoardService boardService;

    // 서비스를 생성자를 통해 주입받습니다.
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // HTTP POST 요청을 '/board/register' 주소로 매핑합니다.
    @PostMapping("/register")
    // '@RequestBody'는 요청의 본문(body)에 담겨온 JSON 데이터를 BoardVO 객체로 자동으로 변환(deserialize)해줍니다.
    public ResponseEntity<String> register(@RequestBody BoardVO board) {
        // 실제 로직은 서비스 계층에 위임합니다.
        boardService.register(board);
        // ResponseEntity를 사용하면 HTTP 응답 상태 코드(200 OK 등), 헤더, 본문을 모두 제어할 수 있습니다.
        return ResponseEntity.ok("게시글이 성공적으로 등록되었습니다.");
    }

    // HTTP GET 요청을 '/board/list' 주소로 매핑합니다.
    @GetMapping("/list")
    public List<BoardVO> getList() {
        // List<BoardVO> 객체는 Spring에 의해 자동으로 JSON 배열 형태로 변환되어 응답 본문에 담깁니다.
        return boardService.getList();
    }

    // HTTP PUT 요청을 '/board/update' 주소로 매핑합니다. (PUT은 주로 전체 리소스를 수정할 때 사용)
    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody BoardVO board) {
        boardService.update(board);
        return ResponseEntity.ok("게시글이 성공적으로 수정되었습니다.");
    }

    // HTTP DELETE 요청을 '/board/delete/{id}' 주소로 매핑합니다.
    // {id}는 경로 변수(Path Variable)로, 주소의 일부가 동적으로 변할 수 있음을 의미합니다.
    @DeleteMapping("/delete/{id}")
    // '@PathVariable'은 URL 경로의 일부({id})를 파라미터(int id)로 받아옵니다.
    public ResponseEntity<String> delete(@PathVariable int id) {
        boardService.delete(id);
        return ResponseEntity.ok("게시글이 성공적으로 삭제되었습니다.");
    }
}