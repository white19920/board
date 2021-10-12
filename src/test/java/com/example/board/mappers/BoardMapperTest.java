package com.example.board.mappers;

import com.example.board.beans.vo.BoardVO;
import com.example.board.beans.vo.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardMapperTest {

    @Autowired
    private BoardMapper mapper;

    @Test
    public void testGetList(){
        Criteria cri = new Criteria();
        cri.setPageNum(2);
        cri.setAmount(10);
        mapper.getList(cri).forEach(board -> log.info(board.toString()));
    }

    @Test
    public void testInsert(){
        BoardVO board = new BoardVO();
        board.setTitle("제목 테스트");
        board.setContent("제목 테스트");
        board.setWriter("제목 테스트");
        mapper.insert(board);
    }

    @Test
    public void testInsetSelectKey_bno(){
        BoardVO board = new BoardVO();
        board.setTitle("제목 테스트2");
        board.setContent("내용 테스트2");
        board.setWriter("작성자 테스트2");
        mapper.insertSelectKey_bno(board);
    }

    @Test
    public void testRead(){
        /*게시물 번호 3번으로  상세보기*/
        mapper.read(3L);
    }

    @Test
    public void testUpdate(){
        if(mapper.read(2L) == null){
            log.info("없는 게시물 입니다.");
        }else {
            BoardVO board = new BoardVO();
            /*3번 게시물 수정*/
            board.setBno(2L);
            /*수정할 제목*/
            board.setTitle("제목 수정 테스트2");
            /*수정할 내용*/
            board.setContent("내용 수정 테스트2");
            /*3번 게시물 수정*/
            log.info("updatacount : " + mapper.update(board));
            /*3번 게시물 출력*/
            mapper.read(2L);
        }
    }

//    @Test
//    public void testDelete(){
//        /*3번 게시물 삭제*/
//        if(mapper.read(4L) == null){
//            log.info("delete : " + mapper.delete(3L));
//        }else {
//            log.info("delete : " + mapper.delete(3L));
//        }
//        /*게시물 리스트 출력*/
//        mapper.getList().forEach(board -> log.info(toString()));
//    }


}
