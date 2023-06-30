package com.jpa.board.myBoard.repository;

import com.jpa.board.myBoard.dao.BoardDao;
import com.jpa.board.myBoard.entity.Board;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BoardRepository implements BoardDao {

  @Override
  public void addBoard(Board board) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpalesson");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    tx.begin();
    try {
      em.persist(board);
      tx.commit();
    } catch (Exception e) {
      e.printStackTrace();
      tx.rollback();
    } finally {
      em.clear();
    }
    emf.close();
  }

  @Override
  public List<Board> getBoardList() {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpalesson");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    List<Board> boardList = new ArrayList<>();
    tx.begin();
    try {
      boardList = em.createQuery("SELECT b FROM Board b", Board.class).getResultList();
      tx.commit();
    } catch (Exception e) {
      e.printStackTrace();
      tx.rollback();
    } finally {
      em.clear();
    }
    emf.close();
    return boardList;
  }

  @Override
  public void updateBoard(Board board) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpalesson");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    tx.begin();
    try {
      Board updateBoard = em.find(Board.class, board.getId());
      updateBoard.setTitle(board.getTitle());
      tx.commit();
    } catch (Exception e) {
      e.printStackTrace();
      tx.rollback();
    } finally {
      em.clear();
    }
    emf.close();
  }

  @Override
  public void removeBoard(Board board) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpalesson");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    tx.begin();
    try {
      Board removeBoard = em.find(Board.class, board.getId());
      removeBoard.setIsHide(board.getIsHide());
      //em.remove(removeBoard);
      tx.commit();
    } catch (Exception e) {
      e.printStackTrace();
      tx.rollback();
    } finally {
      em.clear();
    }
    emf.close();
  }
}
