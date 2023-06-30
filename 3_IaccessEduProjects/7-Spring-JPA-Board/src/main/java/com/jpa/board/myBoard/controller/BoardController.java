package com.jpa.board.myBoard.controller;

import com.jpa.board.myBoard.entity.Board;
import com.jpa.board.myBoard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

  @Autowired
  BoardService boardService;

//  ModelAndView mv = new ModelAndView(); --> 전역변수로 선언하면 동일성 문제로 동기화를 해줘야 하는 불편함이 있다.

  /*
  * 모든 메소드핸들러가 작동할 때 자동으로 실행되어 Model에 저장되고 그 Model을 가리킨ㄴ ViewName도 저장하는 메소드
  */
  @ModelAttribute
  public void myBoardList(ModelAndView mv) {
    System.out.println("-----------ModelAttributeMethodHandler Activated-----------");
    List<Board> boardList = boardService.getBoardList();
    boardList.stream().forEach(System.out::println); // foreach문 코드 압축
    System.out.println("-----------ModelAttributeMethodHandler Complete-----------");

    mv.addObject("maBoardList", boardList);
  }

  /*
  * List 호출
  */
  @RequestMapping("/home")
  public ModelAndView home(ModelAndView mv) {
    System.out.println("-----------------HomeMethodHandler Activated-----------------");
    mv.setViewName("board"); // ModelAndView를 어떤 이름의 JSP파일(view)에 넣어 줄껀지를 정함.
    System.out.println("-----------------HomeMethodHandler Complete-----------------");

    return mv;
  }

  /*
  * Add 화면 호출
  */
  @GetMapping("/add")
  public ModelAndView addBoard(ModelAndView mv) {
    System.out.println("-----------------GetAddMethodHandler Activated-----------------");
    mv.setViewName("/board/add");
    System.out.println("-----------------GetAddMethodHandler Complete-----------------");

    return mv;
  }

  @PostMapping("/add")
  public String addBoard(@RequestParam String title) {
    System.out.println("-----------------PostAddMethodHandler Activated-----------------");
    ModelAndView mv = new ModelAndView();
    Board board = new Board();

    board.setTitle(title);
    boardService.addBoard(board);
    System.out.println("-----------------PostAddMethodHandler Complete-----------------");

    return "redirect:/board/home";
  }

  @GetMapping("/update")
  public ModelAndView updateBoard(ModelAndView mv, @RequestParam Long id, @RequestParam String title) {
    System.out.println("-----------------GetUpdateMethodHandler Activated-----------------");
    mv.addObject("updateId", id);
    mv.addObject("updateTitle", title);
    mv.setViewName("/board/update");
    System.out.println("-----------------GetUpdateMethodHandler Complete-----------------");

    return mv;
  }

  @PostMapping("/update")
  public String updateBoard(@RequestParam String id,@RequestParam String title) {
    System.out.println("-----------------PostUpdateMethodHandler Activated-----------------");
    ModelAndView mv = new ModelAndView();
    Board board = new Board();
    Long updateId = Long.valueOf(id);

    board.setId(updateId);
    board.setTitle(title);
    boardService.updateBoard(board);
    System.out.println("-----------------PostUpdateMethodHandler Complete-----------------");

    return "redirect:/board/home";
  }

  @GetMapping("/remove")
  public ModelAndView removeBoard(ModelAndView mv, @RequestParam Long id) {
    System.out.println("-----------------GetRemoveMethodHandler Activated-----------------");
    mv.addObject("removeId", id);
    mv.setViewName("/board/remove");
    System.out.println("-----------------GetRemoveMethodHandler Complete-----------------");

    return mv;
  }

  @PostMapping("/remove")
  public String removeBoard(@RequestParam String id) {
    System.out.println("-----------------PostRemoveMethodHandler Activated-----------------");
    ModelAndView mv = new ModelAndView();
    Board board = new Board();

    Long boardId = Long.valueOf(id);
    board.setId(boardId);
    board.setIsHide("Y");
    boardService.removeBoard(board);
    System.out.println("-----------------PostRemoveMethodHandler Complete-----------------");

    return "redirect:/board/home";
  }
}
