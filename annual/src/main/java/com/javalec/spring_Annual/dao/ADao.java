package com.javalec.spring_Annual.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.javalec.spring_Annual.dto.ADto;
import com.javalec.spring_Annual.util.Constant;


public class ADao {
JdbcTemplate template=null;
	
	public ADao() {
		template=Constant.template;
	}
	
	public ArrayList<ADto> view(){
		String sql="select anu.aid aId,anu.aname aName,anu.RANK rank,ran.annual,count(log.ADATE) use,LISTAGG(log.adate, ',') WITHIN GROUP (ORDER BY anu.aid) adate from annual anu " + 
				"inner join annual_rank ran on anu.RANK=ran.RANK " +
				"left outer join annual_log log on anu.aid=log.AID " + 
				"group by anu.aid,anu.aname,anu.RANK,ran.annual";
		
		return (ArrayList<ADto>) template.query(sql, new BeanPropertyRowMapper(ADto.class));
	}
	
	public ArrayList<ADto> log(){
		String sql="select aId,aComent,aDate from annual_log";
		
		return (ArrayList<ADto>) template.query(sql, new BeanPropertyRowMapper(ADto.class));
	}
	
	public ADto add(String name) {
		String sql="select anu.aid aId,anu.aname aName,anu.RANK rank,ran.annual,count(log.ADATE) use,LISTAGG(log.adate, ',') WITHIN GROUP (ORDER BY anu.aid) adate from annual anu " + 
				"inner join annual_rank ran on anu.RANK=ran.RANK " +
				"left outer join annual_log log on anu.aid=log.AID " +
				"where aname like '%"+name+"%' "+
				"group by anu.aid,anu.aname,anu.RANK,ran.annual";
		
		return template.queryForObject(sql,new BeanPropertyRowMapper<ADto>(ADto.class));
	}
	
	public void Insert(final String id,final String coment,final String date) {
		String sql="insert into annual_log values(?,?,?)";
		template.update(sql,new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setString(1, id);
				pstmt.setString(2, coment);
				pstmt.setString(3, date);
			}
		});
	}
}
