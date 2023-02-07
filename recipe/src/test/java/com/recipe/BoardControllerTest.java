package com.recipe;

import com.recipe.dto.Board;
import com.recipe.dto.Member;
import com.recipe.persistence.MemberRepo;
import com.recipe.service.BoardServiceImpl;
import com.recipe.service.MemberServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardControllerTest {
    @Autowired
    private BoardServiceImpl boardService;

    @Autowired
    private MemberRepo memberRepo;

    @Test
    public void dummydata(){
        for(int i = 0; i<150; i++){
            Board vo = new Board();
            Member mem = memberRepo.findById("test").get();
            vo.setBoardTitle(i+"번 게시물");
            vo.setBoardWriter(mem);
            vo.setBoardContent(i+"번째 게시물의 내용");

            boardService.insertBoard(vo);
        }
    }


}
