package com.example.board.beans.dao;

import com.example.board.beans.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardDAO_test {
    @Autowired
    private BoardDAO boardDAO;

    @Test
    public void testRegister(){
        BoardVO board = new BoardVO();
        board.setTitle("새로 작성하는 글3");
        board.setContent("새로 작성하는 내용3");
        board.setWriter("hds1204");

        boardDAO.register(board);
        log.info("--------------------------------------");
        log.info(board.getBno() + "");
        log.info("--------------------------------------");
    }

    @Test
    public void testGet(){
        log.info(boardDAO.get(2L).toString());
    }

    @Test
    public void testModify(){
        if(boardDAO.get(2L) == null){
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
            log.info("updatacount : " + boardDAO.modify(board));
            /*3번 게시물 출력*/
            boardDAO.get(2L);
        }
    }

    @Test
    public void testRemove(){
        if(boardDAO.get(2L) == null){
            log.info("없는 게시물 입니다.");
        }else {
            log.info("remove : " + boardDAO.remove(2L));
        }
    }

    @Test
    public void testGetList(){
        boardDAO.getList().forEach(board -> log.info(board.toString()));
    }
}
