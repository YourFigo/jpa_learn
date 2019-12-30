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

    /**
     * 根据id查询客户
     *  使用find方法查询：
     *      1.查询的对象就是当前客户对象本身
     *      2.在调用find方法的时候，就会发送sql语句查询数据库
     *  立即加载
     */
    @Test
    public  void testFind() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Customer customer = entityManager.find(Customer.class, 2l);
        System.out.print(customer);
        tx.commit();
        entityManager.close();
    }

    /**
     * 根据id查询客户
     *  getReference方法
     *    1.获取的对象是一个动态代理对象
     *    2.调用getReference方法不会立即发送sql语句查询数据库
     *    当调用查询结果对象的时候，才会发送查询的sql语句：什么时候用，什么时候发送sql语句查询数据库
     * 延迟加载（懒加载）
     *    得到的是一个动态代理对象
     *    什么时候用，什么使用才会查询
     */
    @Test
    public  void testReference() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Customer customer = entityManager.getReference(Customer.class, 2l);
        System.out.print(customer);
        tx.commit();
        entityManager.close();
    }

    /**
     * 删除客户的案例
     */
    @Test
    public  void testRemove() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Customer customer = entityManager.find(Customer.class,1l);
        entityManager.remove(customer);
        tx.commit();
        entityManager.close();
    }

    /**
     * 更新客户的操作
     *      merge(Object)
     */
    @Test
    public  void testUpdate() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Customer customer = entityManager.find(Customer.class,1l);
        customer.setCustIndustry("it");
        entityManager.merge(customer);
        tx.commit();
        entityManager.close();
    }
}
