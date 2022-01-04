package com.yuye.service;

import java.beans.PropertyVetoException;
import java.sql.SQLException;

public interface UserService {
    void save() throws PropertyVetoException, SQLException;
}
