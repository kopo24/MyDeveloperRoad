package com.jpa.board.myBoard.service;

import com.jpa.board.myBoard.entity.Board;
import com.jpa.board.myBoard.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

  @Autowired
  BoardRepository boardRepository;

  public void addBoard(Board board) {
    boardRepository.addBoard(board);
  }

  public List<Board> getBoardList() {
    return boardRepository.getBoardList();
  }

  public void updateBoard(Board board) {
    boardRepository.updateBoard(board);
  }

  public void removeBoard(Board board) {
    boardRepository.removeBoard(board);
  }
}
