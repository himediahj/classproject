import com.firstcoding.firstapp.dept.Dept;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeptTest {
    @Test
    public void DeptTest(){ // 롬복 어노테이션 테스트
        Dept dept = new Dept(10, "text", "loc");
        dept.setDeptno(60);
        System.out.println(dept);

        Assertions.assertEquals(60, dept.getDeptno(), "부서 번호 테스트");
    }
}
