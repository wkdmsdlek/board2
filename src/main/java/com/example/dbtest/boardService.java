package com.example.dbtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;



@Service
public class boardService {
    private final boardRepository boardRepository;

    @Autowired
    public boardService(boardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<board> getLatestBoards() {
        return boardRepository.findTop20ByOrderByBoardTimeDesc();
    }


    public board createBoard(board board) {
        board.setBoardTime(LocalDateTime.now());
        return boardRepository.save(board);
    }

    public List<board> getAllBoards() {
        return boardRepository.findAll();
    }

    public board getBoardById(int bid) {
        return boardRepository.findById(bid)
                .orElseThrow(() -> {
                    throw new NoSuchElementException("게시물이 존재하지 않습니다.");
                });
    }

    public board updateBoard(board board) {
        return boardRepository.save(board);
    }

    public void deleteBoard(int bid) {
        boardRepository.deleteById(bid);
    }
}
