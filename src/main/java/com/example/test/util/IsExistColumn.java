package com.example.test.util;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author laoqiang
 * ResultSet �Ƿ����ĳһ��
 *
 */
public class IsExistColumn {
    public static boolean isExistColumn(ResultSet rs,String columnName) {
    	try {
			if(rs.findColumn(columnName)>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
    	return false;
    }
    
}
