package com.service.sys;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.sys.BookMapper;
import com.model.sys.Book;
import com.service.base.CrudService;

@Service
@Transactional
public class BookService extends CrudService<BookMapper,Book>{


}
