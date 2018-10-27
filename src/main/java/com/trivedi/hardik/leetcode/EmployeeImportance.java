package com.trivedi.hardik.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hatrivedi
 * @date Oct 23, 2018
 * @since 2.5
 */
public class EmployeeImportance {
	class Employee {
		// It's the unique id of each node;
		// unique id of this employee
		public int id;
		// the importance value of this employee
		public int importance;
		// the id of direct subordinates
		public List<Integer> subordinates;
	}
	
	public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee emp : employees) {
            map.put(emp.id, emp);
        }
        return calculateImportance(map, id);
    }
    
    public int calculateImportance(Map<Integer, Employee> map, int id) {
        if(!map.containsKey(id)) {
            return 0;
        }
        
        Employee emp = map.get(id);
        int sum = emp.importance;
        for(int subordinate : emp.subordinates) {
            sum += calculateImportance(map, subordinate);
        }
        return sum;
    }
}
