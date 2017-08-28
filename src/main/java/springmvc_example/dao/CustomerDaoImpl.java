package springmvc_example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import springmvc_example.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
    
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException{
		
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	public List<Customer> listAllCustomer() {
		String sql = "SELECT id, fistname, lastname, gender, address FROM customer";
		List<Customer> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new CustomerMapper());
		
		return list;
	}

	
	public void addCustomer(Customer customer) {
		String sql = "INSERT INTO customer(firstname,lastname,gender,address) VALUES (:firstname, :lastname, :gender, :address)";
		
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(customer));

	}

	
	public void deleteCustomer(int id) {
	    String sql = "DELETE FROM customer where id= :id";
	    
	    namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(id));
  
	}

	
	public void updateCustomer(Customer customer) {
		String sql = "UPDATE customer SET firstname= :firstname, lastname = :lastname, gender = :gender, address = :address";
		
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(customer));

	}

	
	public Customer findCustomerById(int id) {
		String sql = "SELECT * FROM customer WHERE id= :id";
		
		Customer customer = namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(id), new CustomerMapper());
		
		return customer;
	}
	
	private SqlParameterSource getSqlParameterByModel(int id) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("id", id);
		
		return parameterSource;
	}
	
	private SqlParameterSource getSqlParameterByModel(Customer customer) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if(customer!=null) {
			paramSource.addValue("firstname", customer.getFirsname());
			paramSource.addValue("lastname", customer.getLastname());
			paramSource.addValue("gender", customer.getGender());
			paramSource.addValue("address", customer.getAddress());
		}
		return paramSource;
	}
	
	private static final class CustomerMapper implements RowMapper<Customer>{
		
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException{
			Customer customer = new Customer();
			customer.setId(rs.getInt("id"));
			customer.setFirsname(rs.getString("firstname"));
			customer.setLastname(rs.getString("lastname"));
			customer.setGender(rs.getString("gender"));
			customer.setAddress(rs.getString("address"));
			
			return customer;
			
		}
	}
}

