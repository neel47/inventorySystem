package com.inventory.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inventory.model.TaskMST;

@Repository("taskMSTDAO")
public class TaskMSTDAOImpl implements TaskMSTDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addTaskMST(TaskMST taskMST) {
		sessionFactory.getCurrentSession().saveOrUpdate(taskMST);

	}

	@Override
	public List<TaskMST> getAllTaskMST(String specs, String orderBy) {
		StringBuilder specification = new StringBuilder();
		specification.append("from ");
		specification.append(" TaskMST ");
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
	public void deleteTaskMST(Integer taskMSTId) {
		TaskMST taskMST = (TaskMST) sessionFactory.getCurrentSession().load(TaskMST.class, taskMSTId);
		if (null != taskMST) {
			this.sessionFactory.getCurrentSession().delete(taskMST);
		}

	}

	@Override
	public TaskMST getTaskMSTById(int taskMSTId) {
		return (TaskMST) sessionFactory.getCurrentSession().get(TaskMST.class, taskMSTId);
	}

	@Override
	public TaskMST updateTaskMSTById(TaskMST taskMSTId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAllTaskByUserID(String category, int himId, boolean creator) {
		Session session = sessionFactory.openSession();
		List<Integer> listID = new ArrayList<Integer>();
		
		Query query = null;

		if(creator)
			query = session.createQuery(" select id from TaskMST where taskcreatorcategory = :category  and taskcreatorid = :himId  order by id desc ");
		else
			 query = session.createQuery(" select id from TaskMST where taskassigneecategory = :category  and taskassigneeid = :himId  order by id desc ");	

		query.setParameter("himId", himId);
		query.setParameter("category", category);
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
