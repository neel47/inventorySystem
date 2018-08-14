package com.inventory.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inventory.model.TrainingMST;

@Repository("trainingMSTDAO")
public class TrainingMSTDAOImpl implements TrainingMSTDAO {

	@Autowired
	private SessionFactory sessionFactory;


	
	@Override
	public void addTrainingMST(TrainingMST trainingMST) {
		sessionFactory.getCurrentSession().saveOrUpdate(trainingMST);
		
	}

	@Override
	public List<TrainingMST> getAllTrainingMST(String specs, String orderBy) {
		StringBuilder specification = new StringBuilder();
		specification.append("from ");
		specification.append(" TrainingMST ");
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
	public void deleteTrainingMST(Integer trainingMSTId) {
		TrainingMST trainingMST = (TrainingMST) sessionFactory.getCurrentSession().load(TrainingMST.class, trainingMSTId);
		if (null != trainingMST) {
			this.sessionFactory.getCurrentSession().delete(trainingMST);
		}
		
	}

	@Override
	public TrainingMST getTrainingMSTById(int trainingMSTId) {
		return (TrainingMST) sessionFactory.getCurrentSession().get(TrainingMST.class, trainingMSTId);
	}

	@Override
	public TrainingMST updateTrainingMSTById(TrainingMST trainingMSTId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAllTrainingMSTByUserID(String category, int himId) {
		Session session = sessionFactory.openSession();
		List<Integer> listID = new ArrayList<Integer>();
		
		Query query = null;
			if("PROJECTMANAGER".equals(category))
			query = session.createQuery(" select id from InventoryMST where managerid=:himId  order by id desc ");
			else
				query = session.createQuery(" select id from InventoryMST where supervisorid=:himId  order by id desc ");		
		query.setParameter("himId", himId);
		////query.setParameter("category", category);
		listID = (List<Integer>) query.list();
		session.close();

		String sb = "";
		for (Integer i : listID) {
			sb += i + ",";
		}
		if (sb.lastIndexOf(",") >= 0)
			sb = sb.substring(0, sb.lastIndexOf(","));

		return sb;
	}
	
	
	
	
	

}
