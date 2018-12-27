package cn.tuoren.ed.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tuoren.ed.base.BaseServiceImpl;
import cn.tuoren.ed.domain.Authentication;

@Transactional
@Service
public class AuthenticationService extends BaseServiceImpl<Authentication> {

}
