package com.niit.PokemartBackend.DBConfig;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.PokemartBackend.Dao.CartItemDAO;
import com.niit.PokemartBackend.Dao.CategoryDAO;
import com.niit.PokemartBackend.Dao.SupplierDao;
//import com.niit.PokemartBackend.Dao.UserDAO;
import com.niit.PokemartBackend.Dao.ProductDAO;
import com.niit.PokemartBackend.Dao.impl.CartItemDAOImpl;
import com.niit.PokemartBackend.Dao.impl.CategoryDAOImpl;
import com.niit.PokemartBackend.Dao.impl.SupplierDaoImpl;
//import com.niit.PokemartBackend.Dao.impl.UserDAOImpl;
import com.niit.PokemartBackend.Dao.impl.ProductDAOImpl;
import com.niit.PokemartBackend.Model.CartItem;
import com.niit.PokemartBackend.Model.Category;
import com.niit.PokemartBackend.Model.OrderDetail;
import com.niit.PokemartBackend.Model.Product;
import com.niit.PokemartBackend.Model.Supplier;
import com.niit.PokemartBackend.Model.User;

import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class DBConfig 
{
	@Bean(name="dataSource")
	public DataSource getH2DataSource()
	{   
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/pokemart");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		
		System.out.println("---Data Source Created---");
		return dataSource;
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		
		Properties hibernateProp=new Properties();
		
		hibernateProp.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProp.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		
		LocalSessionFactoryBuilder factoryBuilder=new LocalSessionFactoryBuilder(getH2DataSource());
		factoryBuilder.addAnnotatedClass(Category.class);
		factoryBuilder.addAnnotatedClass(Supplier.class);
	    factoryBuilder.addAnnotatedClass(Product.class);
	    factoryBuilder.addAnnotatedClass(User.class);
	    factoryBuilder.addAnnotatedClass(CartItem.class);
	    //factoryBuilder.addAnnotatedClass(OrderDetail.class);
	    factoryBuilder.addProperties(hibernateProp);
		System.out.println("Creating SessionFactory Bean");
		return factoryBuilder.buildSessionFactory();
	}
	
	
	@Bean(name="categoryDAO")
	public CategoryDAO getCategoryDAO()
	{
		System.out.println("----Category DAO Implementation---");
		return new CategoryDAOImpl();
	}
	
	@Bean(name="supplierDao")
	public SupplierDao getSupplierDao()
	{
		System.out.println("----Supplier DAO Implementation---");
		return new SupplierDaoImpl();
	}
	
	/* @Bean(name="userDAO")
	public UserDAO getUserDAO()
	{
		System.out.println("----User DAO Implementation---");
		return new UserDAOImpl();
	}*/

	@Bean(name="ProductDAO")
	public ProductDAO getProductDAO()
	{
		System.out.println("----Product DAO Implementation---");
		return new ProductDAOImpl();
	}
	
	 @Bean(name="cartDAO")
	public CartItemDAO cartDAO()
	{
		System.out.println("----Cart DAO Implementation---");
		return new CartItemDAOImpl();
	}
	
	
	
	@Bean(name="txManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("---Transaction Manager----");
		return new HibernateTransactionManager(sessionFactory);
	}

	
}


