package cn.tuoren.ed.dao.impl;

import java.util.List;

import javax.management.Query;

import org.springframework.stereotype.Repository;

import cn.tuoren.ed.base.BaseDaoImpl;
import cn.tuoren.ed.domain.Role;

@Repository
public class RoleDao extends BaseDaoImpl<Role> {
	
	
	public List<Role> getRoleByName(String roleName,String code) {
		String hql=" from Role where roleName=? or code=?";
		org.hibernate.Query listQuery= getSession().createQuery(hql);
		listQuery.setParameter(0, roleName);
		listQuery.setParameter(1, code);
		List<Role> rtnRoles=listQuery.list();
		return rtnRoles;
	}
	
}
