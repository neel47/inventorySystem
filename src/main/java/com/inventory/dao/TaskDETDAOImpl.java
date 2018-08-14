package com.inventory.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inventory.model.TaskDET;
import com.inventory.model.TaskMST;

@Repository("taskDETDAO")
public class TaskDETDAOImpl implements TaskDETDAO {

	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public void addTaskDET(TaskDET taskDET) {
		sessionFactory.getCurrentSession().saveOrUpdate(taskDET);
		
	}

	@Override
	public List<TaskDET> getAllTaskDET(String specs, String orderBy) {
		StringBuilder specification = new StringBuilder();
		specification.append("from ");
		specification.append(" TaskDET ");
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
	public void deleteTaskDET(Integer taskDETId) {
		TaskDET taskdet= (TaskDET) sessionFactory.getCurrentSession().load(TaskDET.class, taskDETId);
		if (null != taskdet) {
			this.sessionFactory.getCurrentSession().delete(taskdet);
		}
		
	}

	@Override
	public TaskDET getTaskDETById(int taskDETId) {
		return (TaskDET) sessionFactory.getCurrentSession().get(TaskDET.class, taskDETId);
	}

	@Override
	public TaskDET updateTaskDETById(TaskDET taskDETId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskDET> getAllTaskDETByMSTID( int himId) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		List<TaskDET> listID = new ArrayList<TaskDET>();
		Query query = session.createQuery(
					" from TaskDET where  taskmstid = :himId  order by taskdate asc  ");

		query.setParameter("himId", himId);
		listID = (List<TaskDET>) query.list();
		session.close();	
		
		
		
		return listID;
	}

}
