package com.service.sys;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.sys.AdminMapper;
import com.model.sys.Admin;
import com.service.base.CrudService;

@Service
@Transactional
public class AdminService extends CrudService<AdminMapper,Admin>{
	
}
