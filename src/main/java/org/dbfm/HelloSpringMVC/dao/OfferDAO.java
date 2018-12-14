package org.dbfm.HelloSpringMVC.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.dbfm.HelloSpringMVC.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class OfferDAO {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate =new JdbcTemplate(dataSource);
	}
	public int getRowCount() {
		String sqlStatement = "select count(*) from classes_offers";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}
	
	//query and return a single object
	public Offer getOffer(String name) {
		String sqlStatement = "select * from classes_offers where name=?";
		
		return jdbcTemplate.queryForObject(sqlStatement, new Object[]{name},
				new RowMapper<Offer>() {
					public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
						// TODO Auto-generated method stub
						Offer offer = new Offer();
						
						offer.setId(rs.getInt("id"));
						offer.setName(rs.getString("name"));

						return offer;
					}
				}
		);
	}
	
	//query and return multiple objects
	public List<Offer> getOffers() {
		String sqlStatement = "select * from classes_offers";
		
		return jdbcTemplate.query(sqlStatement,
				new RowMapper<Offer>() {
					public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						Offer offer = new Offer();
						offer.setId(rs.getInt("id"));
						offer.setYear(rs.getInt("year"));
						offer.setSemester(rs.getInt("semester"));
						offer.setCode(rs.getString("code"));
						offer.setName(rs.getString("name"));
						offer.setSort(rs.getString("sort"));
						offer.setCredit(rs.getInt("credit"));
						
						return offer;
					}
				}
		);
	}
	
	public boolean insert(Offer offer) {
		int year = offer.getYear();
		String name = offer.getName();
		int semester = offer.getSemester();
		String code = offer.getCode();
		String sort = offer.getSort();
		int credit = offer.getCredit();
		
		String sqlStatement = "insert into offers (year, semester, code, name, sort, credit) values (?, ?, ?, ?, ?, ?)";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester, code, name, sort, credit}) == 1);
	}
	
	public boolean update(Offer offer) {
		
		int id = offer.getId();
		int year = offer.getYear();
		String name = offer.getName();
		int semester = offer.getSemester();
		String code = offer.getCode();
		String sort = offer.getSort();
		int credit = offer.getCredit();
		
		String sqlStatement = "update classes_offers set name = ?, semester = ?, code = ?, name = ?, sort = ?, credit = ?, where id = ?";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester, code, name, sort, credit, id}) == 1);
	}
	
	public boolean delete(int id) {
	
		String sqlStatement = "delete from classes_offers where id = ?";
		return (jdbcTemplate.update(sqlStatement, new Object[] {id}) == 1);
	}
}