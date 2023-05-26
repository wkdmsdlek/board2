package com.example.dbtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.dbtest.boardService;

@Controller
public class DeleteController {

    private final boardService boardService;

    public DeleteController(boardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/delete/{bid}")
    public String showDeletePage(@PathVariable("bid") int bid, Model model) {
        model.addAttribute("bid", bid);
        return "delete";
    }

    @PostMapping("/delete/{bid}")
    public String deleteBoard(@PathVariable("bid") int bid) {
        boardService.deleteBoard(bid);
        return "redirect:/list";
    }



}
