package com.inventory.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inventory.model.InventoryDET;


@Repository("inventoryDETDAO")
public class InventoryDETDAOImpl implements InventoryDETDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	
	
	
	@Override
	public void addInventoryDET(InventoryDET inventoryDET) {
		sessionFactory.getCurrentSession().saveOrUpdate(inventoryDET);
		
	}

	@Override
	public List<InventoryDET> getAllInventoryDET(String specs, String orderBy) {
		StringBuilder specification = new StringBuilder();
		specification.append("from ");
		specification.append(" InventoryDET ");
		specification.append(" ");
		if (null != specs && !"".equals(specs)) {
			specification.append(" where ");
			/*
			 * if(specs.lastIndexOf(",") >= 0) specs=specs.substring(0,
			 * specs.lastIndexOf(","));
			 */

			String[] filters = specs.split("&");
			for (String filter : filters) {
				String[] filterKeyValuePairs = filter.split(":");

				if (filterKeyValuePairs[1].trim().lastIndexOf("!") >= 0) {
					specification
							.append(" " + filterKeyValuePairs[1].trim().substring(1, filterKeyValuePairs[1].length())
									+ " not in (" + filterKeyValuePairs[0].trim() + " )");
				} else if (filterKeyValuePairs[1].trim().lastIndexOf("^") >= 0) {
					specification
							.append(" " + filterKeyValuePairs[1].trim().substring(1, filterKeyValuePairs[1].length())
									+ " in (" + filterKeyValuePairs[0].trim() + " )");
				} else {
					specification.append(
							" " + filterKeyValuePairs[1].trim() + " = '" + filterKeyValuePairs[0].trim() + "' ");
				}

				specification.append(" and ");
			}
		}

		if (specification.lastIndexOf("and") >= 0)
			specs = specification.substring(0, specification.lastIndexOf("and"));
		else
			specs = specification.toString();

		if (null != orderBy && !"".equals(orderBy)) {
			specs += " order by " + orderBy;
		}
		return sessionFactory.getCurrentSession().createQuery(specs).list();
	}

	@Override
	public void deleteInventoryDET(Integer inventoryDETId) {
		InventoryDET inventoryDET= (InventoryDET) sessionFactory.getCurrentSession().load(InventoryDET.class, inventoryDETId);
		if (null != inventoryDET) {
			this.sessionFactory.getCurrentSession().delete(inventoryDET);
		}
		
	}

	@Override
	public InventoryDET getInventoryDETById(int inventoryDETId) {
		return (InventoryDET) sessionFactory.getCurrentSession().get(InventoryDET.class, inventoryDETId);
	}

	@Override
	public InventoryDET updateInventoryDETById(InventoryDET inventoryDETId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InventoryDET> getAllInventoryDETByMSTID(int himId) {

		Session session = sessionFactory.openSession();
		List<InventoryDET> listID = new ArrayList<InventoryDET>();
		Query query = session.createQuery(
					" from InventoryDET where  taskmstid = :himId  order by taskdate asc  ");

		query.setParameter("himId", himId);
		listID = (List<InventoryDET>) query.list();
		session.close();	
		
		
		
		return listID;
	}

}
