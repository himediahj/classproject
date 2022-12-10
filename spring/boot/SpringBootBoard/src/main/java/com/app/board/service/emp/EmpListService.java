package com.app.board.service.emp;

import com.app.board.domain.emp.EmpDTO;
import com.app.board.domain.emp.EmpListPage;
import com.app.board.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpListService {
    @Autowired
    private EmpMapper empMapper;

    public EmpListPage getPage(int pageNum){
        // 게시물의 리스트
        List<EmpDTO> list = empMapper.selectList((pageNum-1)*10, 10);

        // 전체 게시물 개수
        int totalCount = empMapper.totalCount();

        EmpListPage empListPage = new EmpListPage(10, pageNum, list, totalCount);

        return empListPage;
    }

}
