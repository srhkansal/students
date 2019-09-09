package com.eskay.students.controllers;

import com.eskay.students.bean.Student;
import com.eskay.students.entity.StudentsEntity;
import com.eskay.students.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentsController {

    private String MY_STRING = "";

    @Autowired
    private StudentsService studentsService;

    @GetMapping("/students/{id}")
    public StudentsEntity getStudent(@PathVariable int id) {
        return studentsService.getStudent(id);
    }

    @PostMapping("/students")
    public String recordStudentsData(@RequestBody StudentsEntity student) {
        return studentsService.recordStudentsData(student);
    }


    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        List<Integer> rightMostNodes = new LinkedList<>();

        if(root == null)
            return rightMostNodes;

        nodes.add(root);

        while(!nodes.isEmpty()){
            int size = nodes.size();

            for ( int i = 0; i<size; i++) {
                TreeNode current = nodes.poll();
                if(i == size -1) {
                    rightMostNodes.add(current.val);
                }

                if(current.left!=null)
                    nodes.add(current.left);
                if(current.right!=null)
                    nodes.add(current.right);
            }
        }
        return rightMostNodes;
    }
}
