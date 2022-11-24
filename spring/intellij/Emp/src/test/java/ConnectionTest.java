import com.app.emp.domain.EmpDTO;
import com.app.emp.mapper.EmpMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ConnectionTest {

    @Autowired
    private DataSource dataSource;

    @Autowired(required = false)
    private EmpMapper empMapper;

    @Test
    public void connectionTest() throws SQLException {
        Connection connection = dataSource.getConnection();
        log.info(connection);

        Assertions.assertNotNull(connection);
        connection.close();
    }

    @Test
    public void getEmpListTest(){
        log.info(empMapper.selectAll());
    }

    @Test
    public void getEmpInfoTest(){
        log.info(empMapper.selectByEmpno(7844));
    }

    @Test
    public void getEmpInsertTest(){
        EmpDTO empDTO = new EmpDTO(1234, "test", "tester", 1234, Date.valueOf("2020-01-01").toLocalDate(), 1234, 1234, 40);
        log.info(empMapper.insertEmp(empDTO));
    }

    @Test
    public void getEmpUpdateTest(){
        EmpDTO empDTO = new EmpDTO(7935, "test", "tester", 0, Date.valueOf("2022-01-01").toLocalDate(), 0, 0, 40);
        log.info(empMapper.updateEmp(empDTO));
    }

    @Test
    public void getEmpDeleteTest(){
        log.info(empMapper.deleteByEmpno(7935));
    }
}
