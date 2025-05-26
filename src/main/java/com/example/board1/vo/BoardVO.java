// getter/setter 자동 생성
package com.example.board1.vo;

import lombok.Data;

@Data // Lombok - getter, setter, toString 자동 생성
public class BoardVO {
    private Long id;         // 게시글 고유 ID (자동 증가)
    private String title;    // 게시글 제목
    private String content;  // 게시글 내용
}
