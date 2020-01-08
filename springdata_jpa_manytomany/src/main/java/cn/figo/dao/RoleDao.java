package cn.figo.dao;

import cn.figo.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author Figo
 * @Date 2020/1/8 23:32
 */
public interface RoleDao extends JpaRepository<Role,Long>, JpaSpecificationExecutor<Role> {
}
