package cursogetafe.dianotaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.Properties;

import javax.sql.DataSource;

//import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test04B {
	
	private DataSource dataSource;
	
	public Test04B() {}
	
	public Test04B(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void consulta() throws SQLException {
		Connection con = dataSource.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from productos");
		ResultSet rs = ps.executeQuery();	
		
		while(rs.next()) {
			System.out.println(rs.getInt(1) + " : " + rs.getString(2));
		
		}
		con.close();
		
	}
	
	
	
	public static void main(String[] args) throws SQLException {

		
		BeanFactory ctx = new ClassPathXmlApplicationContext("a04_ctx.xml");
		
		
		
		Test04B test = ctx.getBean(Test04B.class);
		test.consulta();
		
	}

}
