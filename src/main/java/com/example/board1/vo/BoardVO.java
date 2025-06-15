// 이 클래스가 속한 패키지를 정의합니다.
package com.example.board1.vo;

// Lombok 라이브러리를 사용하기 위해 import 합니다.
import lombok.Data;

// '@Data'는 Lombok의 가장 강력한 어노테이션 중 하나입니다.
// 아래 모든 필드에 대한 getter, setter, toString(), equals(), hashCode() 메소드를
// 컴파일 시점에 자동으로 생성해줍니다. 덕분에 코드가 매우 깔끔해집니다.
@Data
public class BoardVO { // VO(Value Object) 또는 DTO(Data Transfer Object)라고 부릅니다.
    // 계층 간의 데이터 전송을 목적으로 하는 객체입니다.

    // 이 필드들은 데이터베이스 'board' 테이블의 컬럼들과 일대일로 매칭됩니다.
    // 또한, 클라이언트(포스트맨)가 보내는 JSON 데이터의 key와도 이름이 일치해야 합니다.

    private Long id;         // 게시글 고유 ID
    private String title;    // 게시글 제목
    private String content;  // 게시글 내용
    private String writer;   // 작성자
}