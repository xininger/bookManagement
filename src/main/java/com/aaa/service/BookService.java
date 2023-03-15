package com.aaa.service;

import com.aaa.domain.Book;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Dear Zhang
 * @description 针对表【book】的数据库操作Service
 * @createDate 2023-03-11 17:31:28
 */
public interface BookService extends IService<Book> {
    /**
     * 查询全部图书
     * @return
     */
    List<Book> queryAll();

    /**
     * 添加图书
     * @return
     */
    int addOne(Book book);

    /**
     * 通过书名和作者查询图书
     * @param bookName
     * @param bookAuthor
     * @return
     */
    Book queryByBookNameAndBookAuthor(@Param("bookName")String bookName, @Param("bookAuthor")String bookAuthor);

    /**
     * 通过图书名称进行模糊查询
     * @param bookName
     * @return
     */
    List<Book> queryAllByBookName(@Param("bookName")String bookName);

    /**
     * 根据作者姓名进行模糊查询
     * @param bookAuthor
     * @return
     */
    List<Book> queryAllByBookAuthor(@Param("bookAuthor")String bookAuthor);

    Book queryAllById(@Param("id")int id);

    int deleteBook(@Param("id") int id);

    int fakeDeleteBook(@Param("id") int id);

    int updateBook(Book book);

}
