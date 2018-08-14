package com.inventory.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inventory.model.InventoryDET;
import com.inventory.model.TrainingDET;


@Repository("trainingDETDAO")
public class TrainingDETDAOImpl implements TrainingDETDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	
	@Override
	public void addTrainingDET(TrainingDET trainingDET) {
		sessionFactory.getCurrentSession().saveOrUpdate(trainingDET);
		
	}

	@Override
	public List<TrainingDET> getAllTrainingDET(String specs, String orderBy) {
		StringBuilder specification = new StringBuilder();
		specification.append("from ");
		specification.append(" TrainingDET ");
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
	public void deleteTrainingDET(Integer trainingDETId) {
		TrainingDET trainingDET= (TrainingDET) sessionFactory.getCurrentSession().load(TrainingDET.class, trainingDETId);
		if (null != trainingDET) {
			this.sessionFactory.getCurrentSession().delete(trainingDET);
		}
		
	}

	@Override
	public TrainingDET getTrainingDETById(int trainingDETId) {
		return (TrainingDET) sessionFactory.getCurrentSession().get(TrainingDET.class, trainingDETId);
	}

	@Override
	public TrainingDET updateTrainingDETById(TrainingDET trainingDETId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TrainingDET> getAllTrainingDETByMSTID(int himId) {

		Session session = sessionFactory.openSession();
		List<TrainingDET> listID = new ArrayList<TrainingDET>();
		Query query = session.createQuery(
					" from TrainingDET where  taskmstid = :himId  order by taskdate asc  ");

		query.setParameter("himId", himId);
		listID = (List<TrainingDET>) query.list();
		session.close();	
		
		
		
		return listID;
	}

	@Override
	public String mstIDfromUserId(int himId) {

		Session session = sessionFactory.openSession();
		List<Integer> listID = new ArrayList<Integer>();
		Query query = null;
		
			query = session.createQuery(" select trainingmstid from TrainingDET where  trainingassigneeid= :himId and trainingassigneecategory='EMPLOYEE' ");
			query.setParameter("himId", himId);

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
