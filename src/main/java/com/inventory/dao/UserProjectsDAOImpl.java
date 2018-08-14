package com.inventory.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inventory.model.UserProjects;

@Repository("userProjectsDAO")
public class UserProjectsDAOImpl implements UserProjecstDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addUserProjects(UserProjects userProjects) {
		sessionFactory.getCurrentSession().saveOrUpdate(userProjects);

	}

	@Override
	public List<UserProjects> getAllUserProjects(String specs, String orderBy) {
		StringBuilder specification = new StringBuilder();
		specification.append("from ");
		specification.append(" UserProjects ");
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
	public void deleteUserProjects(Integer userProjectsId) {
		UserProjects userProjects = (UserProjects) sessionFactory.getCurrentSession().load(UserProjects.class,
				userProjectsId);
		if (null != userProjects) {
			this.sessionFactory.getCurrentSession().delete(userProjects);
		}

	}

	@Override
	public UserProjects getUserProjectsById(int userProjectsId) {
		return (UserProjects) sessionFactory.getCurrentSession().get(UserProjects.class, userProjectsId);
	}

	@Override
	public UserProjects updateUserProjectsById(UserProjects userProjectsId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String userIdUnderHimById(String category, int himId) {

		Session session = sessionFactory.openSession();
		List<Integer> listID = new ArrayList<Integer>();
		Query query = null;
		if ("PROJECTMANAGER".equals(category)) {
			query = session.createQuery(
					" select userid from UserProjects where managerid = :username and category='SUPERVISOR' ");
		} else if ("SUPERVISOR".equals(category)) {
			query = session.createQuery(
					" select userid from UserProjects where supervisorid = :username and category='EMPLOYEE' ");

		}
		query.setParameter("username", himId);
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

	@Override
	public String userIdInTable(String category) {

		Session session = sessionFactory.openSession();
		List<Integer> listID = new ArrayList<Integer>();
		Query query = null;
		if ("PROJECTMANAGER".equals(category)) {
			query = session.createQuery(" select userid from UserProjects where category='SUPERVISOR' ");
		} else if ("SUPERVISOR".equals(category)) {
			query = session.createQuery(" select userid from UserProjects where category='EMPLOYEE' ");

		}
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

	@Override
	public String supervisorIdFromUserId(String category, int himId) {
		Session session = sessionFactory.openSession();
		List<Integer> listID = new ArrayList<Integer>();
		Query query = null;
		if ("EMPLOYEE".equals(category)) 
		{
			
			query = session.createQuery(" select supervisorid from UserProjects where category='EMPLOYEE' and userid=:himId ");

		}
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
