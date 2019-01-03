package cn.tuoren.ed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tuoren.ed.base.BaseServiceImpl;
import cn.tuoren.ed.dao.impl.BookDao;
import cn.tuoren.ed.dao.impl.RoleDao;
import cn.tuoren.ed.domain.Role;

@Transactional
@Service
public class RoleService extends BaseServiceImpl<Role> {
	@Autowired
	private RoleDao roleDao;
	public List<Role> getRoleByName(String roleName,String code) {
		return roleDao.getRoleByName(roleName, code);
	}
}
