package com.service.sys;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.sys.StaffMapper;
import com.model.sys.Staff;
import com.service.base.CrudService;

@Service
@Transactional
public class StaffService extends CrudService<StaffMapper,Staff>{

}
