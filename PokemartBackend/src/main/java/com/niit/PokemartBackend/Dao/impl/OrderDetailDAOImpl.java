/*package com.niit.PokemartBackend.Dao.impl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.PokemartBackend.Dao.OrderDetailDAO;
import com.niit.PokemartBackend.Model.OrderDetail;


@Repository("orderDetailDAO")

public class OrderDetailDAOImpl implements OrderDetailDAO 
{
	@Autowired
   	SessionFactory sessionFactory;
    
	@Transactional
	public boolean ConfirmOrderDetail(OrderDetail orderDetail) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(orderDetail);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	
	}

   	
   	
}*/