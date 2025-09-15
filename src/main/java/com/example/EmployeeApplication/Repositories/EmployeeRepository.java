package com.example.EmployeeApplication.Repositories;

import com.example.EmployeeApplication.Entities.Employee;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public class EmployeeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Employee createEmployee(Integer id, String fname, String mname, String lname,
                               Date dob, String currAddr, String permAddr,
                               String email, String contact,
                               Integer projectId, Integer companyId) {

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_create_employee");

        query.registerStoredProcedureParameter("employee_id", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("employee_fname", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("employee_mname", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("employee_lname", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("employee_dob", Date.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("employee_curr_addr", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("employee_perm_addr", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("employee_email_id", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("employee_contact_no", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("project_id", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("company_id", Integer.class, ParameterMode.IN);

        query.setParameter("employee_id", id);
        query.setParameter("employee_fname", fname);
        query.setParameter("employee_mname", mname);
        query.setParameter("employee_lname", lname);
        query.setParameter("employee_dob", dob);
        query.setParameter("employee_curr_addr", currAddr);
        query.setParameter("employee_perm_addr", permAddr);
        query.setParameter("employee_email_id", email);
        query.setParameter("employee_contact_no", contact);
        query.setParameter("project_id", projectId);
        query.setParameter("company_id", companyId);
        query.execute();
        return this.getEmployeeById(id);
    }

    public List<Employee> getAllEmployees() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_get_employees", Employee.class);
        return query.getResultList();
    }

    public Employee getEmployeeById(Integer id) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_get_employee", Employee.class);
        query.registerStoredProcedureParameter("employee_id", Integer.class, ParameterMode.IN);
        query.setParameter("employee_id", id);

        return (Employee) query.getSingleResult();
    }

    public List<Employee> getEmployeesByProjectId(Integer projectId) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_get_employees_by_projectid", Employee.class);
        query.registerStoredProcedureParameter("project_id", Integer.class, ParameterMode.IN);
        query.setParameter("project_id", projectId);

        return query.getResultList();
    }

    @Transactional
    public Employee updateEmployee(Integer id, String fname, String mname, String lname,
                               Date dob, String currAddr, String permAddr,
                               String email, String contact,
                               Integer projectId, Integer companyId) {

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_update_employee");

        query.registerStoredProcedureParameter("employee_id", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("employee_fname", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("employee_mname", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("employee_lname", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("employee_dob", Date.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("employee_curr_addr", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("employee_perm_addr", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("employee_email_id", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("employee_contact_no", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("project_id", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("company_id", Integer.class, ParameterMode.IN);

        query.setParameter("employee_id", id);
        query.setParameter("employee_fname", fname);
        query.setParameter("employee_mname", mname);
        query.setParameter("employee_lname", lname);
        query.setParameter("employee_dob", dob);
        query.setParameter("employee_curr_addr", currAddr);
        query.setParameter("employee_perm_addr", permAddr);
        query.setParameter("employee_email_id", email);
        query.setParameter("employee_contact_no", contact);
        query.setParameter("project_id", projectId);
        query.setParameter("company_id", companyId);
        query.execute();
        return this.getEmployeeById(id);
    }

    @Transactional
    public boolean deleteEmployee(Integer id) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_delete_employee");
        query.registerStoredProcedureParameter("employee_id", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("IsDeleted", Integer.class, ParameterMode.OUT);
        query.setParameter("employee_id", id);
        query.execute();
        int rowsAffected = (int) query.getOutputParameterValue("IsDeleted");
        return rowsAffected > 0;

    }
}
