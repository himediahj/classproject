package com.app.manager.controller.rest;

import com.app.manager.domain.DeptDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DeptJsonMessageController {
    @GetMapping("/dept/json")
    @ResponseBody
    public List<DeptDTO> listJson(){
        List<DeptDTO> list = new ArrayList<>();
        list.add(new DeptDTO(10, "test10", "loc10"));
        list.add(new DeptDTO(20, "test20", "loc20"));
        list.add(new DeptDTO(30, "test30", "loc30"));

        return list;    // [{"deptno":10,"dname":"test10","loc":"loc10"},{"deptno":20,"dname":"test20","loc":"loc20"},{"deptno":30,"dname":"test30","loc":"loc30"}]
    }

}
