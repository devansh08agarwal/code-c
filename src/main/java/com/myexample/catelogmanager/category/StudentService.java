package com.myexample.catelogmanager.category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public GroupBean getAllStudent() {
		Map<String, List<Student>> m = new HashMap<String, List<Student>>();
		studentRepository.findAll().forEach(as -> {
			if (m.containsKey(as.getStatus())) {
				m.get(as.getStatus()).add(as);
			} else {
				List<Student> s = new ArrayList<>();
				s.add(as);
				m.put(as.getStatus(), s);
			}
			System.out.println(as);
		});
		List<StudentGroupBean> group = new ArrayList<StudentGroupBean>();

		GroupBean g = new GroupBean();
		for (String k : m.keySet()) {
			StudentGroupBean sg = new StudentGroupBean();
			sg.setName(k);
			sg.setStudents(m.get(k));
			group.add(sg);
		}
		g.setGroup(group);
		return g;
	}

	public void updateStudent(int id, String status) {
		Student s = studentRepository.findById(id);
		s.setStatus(status);
		studentRepository.save(s);
	}
	public void createStudent(Student s) {
		studentRepository.save(s);
	}
}
