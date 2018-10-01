package com.bus24.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bus24.beans.Issue;
import com.bus24.dao.util.SQLConstants;

@Repository
public class IssueDAOImpl implements IssueDAO{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Integer insertIssue(Issue issue) {
		Integer count=jdbcTemplate.update(SQLConstants.SQL_INSERT_ISSUE, issue.getIssueId(),issue.getIssueName());
		return count;
	}
	
	@Override
	public List<Issue> selectAllIssue() {
		return jdbcTemplate.query(SQLConstants.SQL_SELECT_ALL_ISSUE, new RowMapper<Issue>() {
			@Override
			public Issue mapRow(ResultSet rs, int number) throws SQLException {
				Issue issue=new Issue();
				issue.setIssueId(rs.getInt(1));
				issue.setIssueName(rs.getString(2));
				return issue;
				}
			});
	}

}
