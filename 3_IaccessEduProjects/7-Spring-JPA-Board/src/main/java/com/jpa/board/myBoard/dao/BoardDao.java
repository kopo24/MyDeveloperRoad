package com.jpa.board.myBoard.dao;

import com.jpa.board.myBoard.entity.Board;

import java.util.List;

public interface BoardDao {

  void addBoard(Board board);

  List<Board> getBoardList();

  void updateBoard(Board board);

  void removeBoard(Board board);
}
