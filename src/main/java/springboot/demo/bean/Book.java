package springboot.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Document(indexName = "atguigu",type = "book")
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Integer id;
    public String bookName = "1";
    private String author;

}
