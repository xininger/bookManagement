package com.aaa.service.impl;

import com.aaa.domain.Book;
import com.aaa.mapper.BookMapper;
import com.aaa.service.BookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Dear Zhang
 * @description 针对表【book】的数据库操作Service实现
 * @createDate 2023-03-11 17:31:28
 */
@Service("bookServiceImpl")
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> queryAll() {
        return bookMapper.queryAll();
    }

    @Override
    public int addOne(Book book) {
        return bookMapper.addOne(book);
    }

    @Override
    public Book queryByBookNameAndBookAuthor(String bookName, String bookAuthor) {
        return bookMapper.queryByBookNameAndBookAuthor(bookName,bookAuthor);
    }

    @Override
    public List<Book> queryAllByBookName(String bookName) {
        return bookMapper.queryAllByBookName(bookName);
    }

    @Override
    public List<Book> queryAllByBookAuthor(String bookAuthor) {
        return bookMapper.queryAllByBookAuthor(bookAuthor);
    }

    @Override
    public Book queryAllById(int id) {
        return bookMapper.queryAllById(id);
    }

    @Override
    public int deleteBook(int id) {
        return bookMapper.deleteBook(id);
    }

    @Override
    public int fakeDeleteBook(int id) {
        return bookMapper.fakeDeleteBook(id);
    }

    @Override
    public int updateBook(Book book) {
        return bookMapper.updateBook(book);
    }
}
