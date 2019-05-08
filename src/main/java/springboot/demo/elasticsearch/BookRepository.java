package springboot.demo.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import springboot.demo.bean.Book;

import java.util.List;

/**
 * @description:
 * @Author: wub
 * @Date: 2019/3/12 15:31
 */
public interface BookRepository extends ElasticsearchRepository<Book, Integer> {

    public List<Book> findByBookNameLike(String bookName);
}
