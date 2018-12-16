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
		String sqlStatement = "select count(*) from classesoffers";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}
	
	//query and return a single object
	public Offer getOffer(String name) {
		String sqlStatement = "select * from classesoffers where name=?";
		
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
		String sqlStatement = "select * from classesoffers";
		
		return jdbcTemplate.query(sqlStatement,
				new RowMapper<Offer>() {
					public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						Offer offer = new Offer();
						offer.setId(rs.getInt("id"));
						offer.setYear(rs.getString("year"));
						offer.setSemester(rs.getString("semester"));
						offer.setCode(rs.getString("code"));
						offer.setName(rs.getString("name"));
						offer.setSort(rs.getString("sort"));
						offer.setCredit(rs.getString("credit"));
						
						return offer;
					}
				}
		);
	}
	
	// 년도와 학기만 뽑아 쓰는 함수
	public List<Offer> getOffers(String year, String semester) {
		String sqlStatement = "select * from classesoffers where (year, semester) = (?, ?) ";
		
		return jdbcTemplate.query(sqlStatement, new Object[]{year, semester},
				new RowMapper<Offer>() {
					public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						Offer offer = new Offer();
						offer.setId(rs.getInt("id"));
						offer.setYear(rs.getString("year"));
						offer.setSemester(rs.getString("semester"));
						offer.setCode(rs.getString("code"));
						offer.setName(rs.getString("name"));
						offer.setSort(rs.getString("sort"));
						offer.setCredit(rs.getString("credit"));
						
						return offer;
					}
				}
		);
	}
	
	public List<Offer> getYear() {
		String sqlStatement = "select year from classesoffers";
		
		return jdbcTemplate.query(sqlStatement,
				new RowMapper<Offer>() {
					public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
						Offer offer = new Offer();
						offer.setYear(rs.getString("year"));
						
						return offer;
					}
				}
		);
	}
	
	public List<Offer> getSemester() {
		String sqlStatement = "select year, semester, credit from semesteroffers";
		
		return jdbcTemplate.query(sqlStatement,
				new RowMapper<Offer>() {
					public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
						Offer offer = new Offer();
						offer.setYear(rs.getString("year"));
						offer.setSemester(rs.getString("semester"));
						offer.setCredit(rs.getString("credit"));
						
						return offer;
					}
				}
		);
	}
	
	public List<Offer> getRegisteredOffers() {
		String sqlStatement = "select * from registeredoffers";
		
		return jdbcTemplate.query(sqlStatement,
				new RowMapper<Offer>() {
					public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						Offer offer = new Offer();
						offer.setId(rs.getInt("id"));
						offer.setYear(rs.getString("year"));
						offer.setSemester(rs.getString("semester"));
						offer.setCode(rs.getString("code"));
						offer.setName(rs.getString("name"));
						offer.setSort(rs.getString("sort"));
						offer.setCredit(rs.getString("credit"));
						
						return offer;
					}
				}
		);
	}
	
	public boolean insert(Offer offer) {
		
		String year = offer.getYear();
		String name = offer.getName();
		String semester = offer.getSemester();
		String code = offer.getCode();
		String sort = offer.getSort();
		String credit = offer.getCredit();
		
		String sqlStatement = "insert into registeredoffers (year, semester, code, name, sort, credit) values (?, ?, ?, ?, ?, ?)";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester, code, name, sort, credit}) == 1);
	}
	
	public boolean update(Offer offer) {
		
		int id = offer.getId();
		String year = offer.getYear();
		String name = offer.getName();
		String semester = offer.getSemester();
		String code = offer.getCode();
		String sort = offer.getSort();
		String credit = offer.getCredit();
		
		String sqlStatement = "update classesoffers set year = ?, semester = ?, code = ?, name = ?, sort = ?, credit = ? where id = ?";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester, code, name, sort, credit, id}) == 1);
	}
	
	public boolean delete(int id) {
	
		String sqlStatement = "delete from classesoffers where id = ?";
		return (jdbcTemplate.update(sqlStatement, new Object[] {id}) == 1);
	}
}