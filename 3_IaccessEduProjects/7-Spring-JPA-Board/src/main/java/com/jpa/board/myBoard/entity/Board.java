package com.jpa.board.myBoard.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@DynamicInsert
public class Board {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "BOARD_ID")
  private Long id;

  private String title;

  @Column(columnDefinition = "varchar(1) default 'N'")
  private String isHide;
}
