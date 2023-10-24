package ch07;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class News {
  private int id;
  private String title;
  private String img;
  private String date;
  private String content;
}
