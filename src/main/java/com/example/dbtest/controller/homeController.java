package com.example.dbtest.controller;

import com.example.dbtest.board;
import com.example.dbtest.boardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.dbtest.boardRepository;

import java.util.List;

@Controller
public class homeController {

    private final boardService boardService;

    @Autowired
    public homeController(boardService boardService) {
        this.boardService = boardService;
    }
    @GetMapping("/")
    public String home(Model model) {
        // 최신 10개의 게시물 목록 조회

        // 모델에 최신 게시물 목록 추가
        model.addAttribute("latestBoards", boardService.getLatestBoards());
        return "home";
    }

}
