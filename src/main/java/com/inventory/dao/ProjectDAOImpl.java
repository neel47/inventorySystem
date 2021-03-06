package com.inventory.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inventory.model.Project;

@Repository("projectDAO")
public class ProjectDAOImpl implements ProjectDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addProject(Project project) {
		sessionFactory.getCurrentSession().saveOrUpdate(project);

	}

	@Override
	public List<Project> getAllProjects(String specs, String orderBy) {
		StringBuilder specification = new StringBuilder();
		specification.append("from ");
		specification.append(" Project ");
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
	public void deleteProject(Integer projectId) {
		Project project = (Project) sessionFactory.getCurrentSession().load(Project.class, projectId);
		if (null != project) {
			this.sessionFactory.getCurrentSession().delete(project);
		}

	}

	@Override
	public Project getProjectById(int projectId) {
		return (Project) sessionFactory.getCurrentSession().get(Project.class, projectId);
	}

	@Override
	public Project updateProjectById(Project projectId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String managerIdUnderHimById(String category, int himId) {
		Session session = sessionFactory.openSession();
		List<Integer> listID = new ArrayList<Integer>();
		Query query = null;
		if ("REGIONALMANAGER".equals(category)) {
			query = session.createQuery(
					" select managerid from Project where regionalmanagerid = :himId  ");

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
