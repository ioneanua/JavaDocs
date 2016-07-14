package ro.teamnet.zth.api.em;

import org.junit.Test;
import ro.teamnet.zth.appl.domain.Department;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 7/8/2016.
 */
public class EntityManagerImplTest {

    @Test
    public void testInsertMethod() throws ClassNotFoundException, SQLException, IllegalAccessException, NoSuchFieldException {

        Department department = new Department();
        department.setDepatmentName("Vanzari");

        EntityManagerImpl entityManager = new EntityManagerImpl();
        Department deptNeew = (Department) entityManager.insert(department);

        assertEquals("Vanzari", deptNeew.getDepatmentName());
    }


}
