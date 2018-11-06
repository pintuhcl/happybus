package com.example.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.beans.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
	/*@Query("select d from Department  where d.departmentId = ?1")
	  Department findByDepartmentId(Long departmentId);
	
	
	 @Query("select d from Department d where d.departmentName like ?1%")
	  List<Department> findByAndSort(String departmentName, Sort sort);
*/
}
