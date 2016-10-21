package com.hzit.services;

import com.fc.platform.commons.page.Page;
import com.hzit.entity.Book;

/**
 * Created by Administrator on 2016/10/9.
 */
public interface BookServices {
    /*查询全部，有分页*/
    Page<Book> findpageall(int page,int count);

    /*根据图书编号查找图书*/
    Book findbookbyid(String bookid);
}
