package com.hzit.services.impl;

import com.fc.platform.commons.page.Page;
import com.fc.platform.commons.page.PageRequest;
import com.hzit.entity.Book;
import com.hzit.mapper.BookMapper;
import com.hzit.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/9.
 */
@Service
public class BookServicesImpl implements BookServices {
    @Autowired
    private BookMapper bookMapper;
    @Override
    public Page<Book> findpageall(int page,int count) {
        PageRequest  pa=new PageRequest(page,count);
        Page<Book>   listbook=bookMapper.searchBookByParams(null, pa);
        return listbook;
    }

    @Override
    public Book findbookbyid(String bookid) {
           if(bookid!=null){
               Map map=new HashMap();
               map.put("bookId",bookid);
               List<Book> books=bookMapper.searchBookByParams(map);
               if(books!=null&&books.size()>0){
                   return books.get(0);
               }else{
                   return null;
               }
           }else{
               return null;
           }
    }
}
