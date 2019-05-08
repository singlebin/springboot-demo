package springboot.demo.controller;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.*;
import springboot.demo.bean.Book;
import springboot.demo.elasticsearch.BookRepository;

import java.util.*;

/**
 * @description:
 * @Author: wub
 * @Date: 2019/3/12 16:11
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    /**
     * 1、查  id
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Book getBookById(@PathVariable Integer id) {
        Optional<Book> byId = bookRepository.findById(id);
        return byId.get();
    }

    /**
     * 2、查  ++:全文检索（根据整个实体的所有属性，可能结果为0个）
     * * TermQueryBuilder 对词条进行完全匹配   计算机=计算机
     * * WildcardQueryBuilder  对词条进行模糊匹配  "计算机" =  *算*
     * * QueryStringQueryBuilder 对查询的词进行分词 再进行匹配
     *  NestedQueryBuilder 查询对象中存在list集合属性
     * @param q
     * @return
     */
    @GetMapping("/select/{q}")
    public List<Book> testSearch(@PathVariable String q) {
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(q);
        Iterable<Book> searchResult = bookRepository.search(builder);
        Iterator<Book> iterator = searchResult.iterator();
        List<Book> list = new ArrayList<Book>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }

    /**
     * 3、查   +++：分页、分数、分域（结果一个也不少）
     * @param page
     * @param size
     * @param q
     * @return
     * @return
     */
    @GetMapping("/{page}/{size}/{q}")
    public List<Book> searchCity(@PathVariable Integer page, @PathVariable Integer size, @PathVariable String q) {

        // 分页参数
//        Pageable pageable = new PageRequest(page, size);
//
//        // 分数，并自动按分排序
//        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery()
//                .add(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("name", q)),
//                        // 权重：name 1000分
//                        ScoreFunctionBuilders.weightFactorFunction(1000))
//                .add(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("message", q)),
//                        // 权重：message 100分
//                        ScoreFunctionBuilders.weightFactorFunction(100));
//
//        // 分数、分页
//        SearchQuery searchQuery = new NativeSearchQueryBuilder().withPageable(pageable)
//                .withQuery(functionScoreQueryBuilder).build();
//
//        Page<Book> searchPageResults = bookRepository.search(searchQuery);
//        return searchPageResults.getContent();
        return null;

    }

    /**
     * 4、增
     * @param book
     * @return
     */
    @PostMapping("/insert")
    public Book insertBook(@RequestBody Book book) {
        bookRepository.save(book);
        return book;
    }
    /**
     * 5、删 id
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Book insertBook(@PathVariable Integer id) {
        Book book = bookRepository.findById(id).get();
        bookRepository.delete(book);
        return book;
    }

    /**
     * 6、改
     * @param book
     * @return
     */
    @PutMapping("/update")
    public Book updateBook(@RequestBody Book book) {
        bookRepository.save(book);
        return book;
    }

    /**
     * 查询所有
     * @throws Exception
     */
    @GetMapping("/all")
    public List<Map<String, Object>> searchAll() throws Exception {
        //这一步是最关键的
        Client client = elasticsearchTemplate.getClient();
        // @Document(indexName = "product", type = "book")
        SearchRequestBuilder srb = client.prepareSearch("atguigu").setTypes("book");
        // 查询所有
        SearchResponse sr = srb.setQuery(QueryBuilders.matchAllQuery()).execute().actionGet();
        SearchHits hits = sr.getHits();
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (SearchHit hit : hits) {
            Map<String, Object> source = hit.getSourceAsMap();
            list.add(source);
            System.out.println(hit.getSourceAsString());
        }
        return list;
    }



}
