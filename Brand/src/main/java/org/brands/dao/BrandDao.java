package org.brands.dao;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

import org.brands.model.BrandModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BrandDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<BrandModel> getBrands() {
		List<BrandModel> brands = new ArrayList();
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			brands = session.createQuery("FROM Brand").list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return brands;
	}

	public void addBrand(BrandModel brand) {
		// TODO Auto-generated method stub
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(brand);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public BrandModel getBrand(int id) {
		
		Session session = null;
		BrandModel brand=null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			 brand=session.get(BrandModel.class, id );
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return brand;
	}

	public void deleteBrand(int id) {
		// TODO Auto-generated method stub
		
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
		    session.remove(getBrand(id));
		    session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
