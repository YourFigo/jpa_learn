package cn.figo.test;

import cn.figo.domain.Customer;
import cn.figo.utils.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @Author Figo
 * @Date 2019/12/29 21:59
 */
public class JpaTest {

    /**
     * 测试jpa 保存一个客户到数据库中
     *  Jpa的操作步骤
     *     1.加载配置文件创建工厂（实体管理器工厂）对象
     *     2.通过实体管理器工厂获取实体管理器
     *     3.获取事务对象，开启事务
     *     4.完成增删改查操作
     *     5.提交事务（回滚事务）
     *     6.释放资源
     */
    @Test
    public void testSave() {
        //1.加载配置文件创建工厂（实体管理器工厂）对象
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa");
        //2.通过实体管理器工厂获取实体管理器
//        EntityManager em = factory.createEntityManager();
        // 通过工具类获取实体管理器
        EntityManager em = JpaUtils.getEntityManager();
        //3.获取事务对象，开启事务
        EntityTransaction tx = em.getTransaction(); //获取事务对象
        tx.begin();//开启事务
        //4.完成增删改查操作：保存一个客户到数据库中
        Customer customer = new Customer();
        customer.setCustName("腾讯");
        customer.setCustIndustry("科技公司");
        //保存，
        em.persist(customer); //保存操作
        //5.提交事务
        tx.commit();
        //6.释放资源
        em.close();
//        factory.close();
    }
}
