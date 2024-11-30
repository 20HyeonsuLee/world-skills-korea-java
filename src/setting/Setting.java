package setting;

import static db.ConnectionManager.*;
import static utils.Common.*;

import java.sql.Connection;

public class Setting {
	
	public static void main(String[] args) {
		try {
			Connection conn = getNoConnectedConnection();
			conn.prepareStatement("set global local_infile =1;").executeUpdate();
			conn.prepareStatement("drop database if exists 2016j;").executeUpdate();
			conn.prepareStatement("create database 2016j;").executeUpdate();
			conn.prepareStatement("grant select,insert,delete,update on 2016j.* to 'user'@'localhost'").executeUpdate();
			conn.prepareStatement("use 2016j").executeUpdate();
			conn.prepareStatement("create table admin(name varchar(20) primary key not null ,passwd varchar(20) not null,position varchar(20),jumin char(14),inputDate date);").executeUpdate();
			conn.prepareStatement("create table customer(code char(7) primary key not null,name varchar(20) not null,birth date,tel varchar(20),address varchar(100),company varchar(20));").executeUpdate();
			conn.prepareStatement("create table contract(customerCode char(7) not null, contractName varchar(20) not null, rePrice int,reDate date not null,monthPrice int,adminNmae varchar(20));").executeUpdate();
			String[] tb = "admin,contract,customer".split(",");
			for (String string : tb) {
				conn.prepareStatement("load data local infile 'datafiles/"+string+".txt' into table "+ string +" lines terminated by '\r\n' ignore 1 lines").executeUpdate();
			}
			infoMessage("DB세팅 성공");
		} catch (Exception e) {
			e.printStackTrace();
			errorMessage("DB세팅 실패");
		}
	}
}
