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
import com.inventory.model.TrainingQuestion;


@Repository("trainingQuestionDAO")
public class TrainingQuestionDAOImpl implements TrainingQuestionDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	
	@Override
	public void addTrainingQuestion(TrainingQuestion trainingQuestion) {
		sessionFactory.getCurrentSession().saveOrUpdate(trainingQuestion);
		
	}

	@Override
	public List<TrainingQuestion> getAllTrainingQuestion(String specs, String orderBy) {
		StringBuilder specification = new StringBuilder();
		specification.append("from ");
		specification.append(" TrainingQuestion ");
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
	public void deleteTrainingQuestion(Integer trainingQuestionId) {
		TrainingQuestion trainingQuestion= (TrainingQuestion) sessionFactory.getCurrentSession().load(TrainingQuestion.class, trainingQuestionId);
		if (null != trainingQuestion) {
			this.sessionFactory.getCurrentSession().delete(trainingQuestion);
		}
		
	}

	@Override
	public TrainingQuestion getTrainingQuestionById(int trainingQuestionId) {
		return (TrainingQuestion) sessionFactory.getCurrentSession().get(TrainingQuestion.class, trainingQuestionId);
	}

	@Override
	public TrainingQuestion updateTrainingQuestionById(TrainingQuestion trainingQuestionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TrainingQuestion> getAllTrainingQuestionByMSTID(int himId) {
		Session session = sessionFactory.openSession();
		List<TrainingQuestion> listID = new ArrayList<TrainingQuestion>();
		Query query = session.createQuery(
					" from TrainingQuestion where  trainingmstid = :himId  order by id asc  ");

		query.setParameter("himId", himId);
		listID = (List<TrainingQuestion>) query.list();
		session.close();	
		
		
		
		return listID;
	}

}
