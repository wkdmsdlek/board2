package com.example.dbtest.controller;

import com.example.dbtest.board;
import com.example.dbtest.boardService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReadController {

    @Autowired
    private boardService boardService;

    @GetMapping("/read/{bid}")
    public String read(@PathVariable int bid, Model model) {
        //게시물 ID를 기반으로 게시물 정보 조회
        board board = boardService.getBoardById(bid);

        //조회된 게시물 정보를 모델에 추가
        model.addAttribute("board", board);

        //read페이지로 이동
        return "read";
    }




}
