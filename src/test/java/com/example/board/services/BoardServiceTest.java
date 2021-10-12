package com.example.board.services;

import com.example.board.beans.vo.BoardVO;
import com.example.board.beans.vo.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.Cipher;

//public void register(BoardVO board);
//public BoardVO get(Long bno);
//public  boolean modify(BoardVO board);
//public  boolean remove(Long bno);
//public List<BoardVO> getList();

@SpringBootTest
@Slf4j
public class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Test
    public void testRegister(){

        BoardVO board = new BoardVO();
        board.setTitle("새로 작성하는 제목5");
        board.setContent("새로 작성하는 글 내용5");
        board.setWriter("hds1204");

        boardService.register(board);
        log.info("-----------------------------------------");
        log.info(board.getBno() + "");
        log.info("-----------------------------------------");
    }

    @Test
    public void testGet(){
        log.info(boardService.get(8L).toString());
    }

    @Test
    public void testModify(){
        BoardVO board = new BoardVO();
        board.setBno(8L);
        board.setTitle("제목 수정 테스트2");
        board.setContent("내용 수정 테스트2");
        log.info("update : " + boardService.modify(board));
    }

    @Test
    public void testRemove(){
        log.info("DELETE : " + boardService.remove(8L));
    }

    @Test
    public void testGetList(){
        Criteria criteria = new Criteria();
        boardService.getList(criteria).forEach(board -> log.info(board.toString()));
    }
}
