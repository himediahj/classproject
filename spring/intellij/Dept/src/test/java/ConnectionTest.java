import com.app.manager.domain.DeptDTO;
import com.app.manager.domain.DeptSearchOption;
import com.app.manager.mapper.DeptMapper;
import com.app.manager.mapper.TimeMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ConnectionTest {

    @Autowired
    private DataSource dataSource;

    @Autowired(required = false)
    private TimeMapper timeMapper;

    @Autowired(required = false)
    private DeptMapper deptMapper;


    @Test
    public void connectionTest() throws SQLException {

        Connection connection = dataSource.getConnection();
        log.info(connection);

        Assertions.assertNotNull(connection);

        connection.close();
    }

    @Test
    public void getTimeTest(){
        log.info(timeMapper.getTime());
    }

    @Test
    public void getDEPTListTest(){
        log.info(deptMapper.selectAll());
    }

    @Test
    public void getDEPTInfoTest(){
        log.info(deptMapper.selectByDeptno(10));
    }

    @Test
    public void getDeptInsertTest(){
        DeptDTO deptDTO = new DeptDTO(50, "test", "testLoc");
        log.info(deptMapper.insertDept(deptDTO));
    }

    @Test
    public void getDeptUpdateTest(){
        DeptDTO deptDTO = new DeptDTO(50, "DEV", "SEOUL");
        log.info(deptMapper.updateDept(deptDTO));
    }

    @Test
    public void getDeptDeleteTest(){
        log.info(deptMapper.deleteByDeptno(50));
    }


    //////////////////////////////////////////////////////////
    @Test
    public void deptSelectByOptionTest(){
        log.info(deptMapper.selectByOption(DeptSearchOption.builder().searchType("dname").keyword("AC").build()));
    }

    @Test
    public void deptSelectByDeptnosTest(){
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(30);
        log.info(deptMapper.selectByDeptnos(list));
    }
}
