package com.example.service.admin;

import com.example.dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminService {

    @Autowired
    private AdminDao adminDao;

    public AdminDao getAdminDao() {
        return adminDao;
    }

}
