package com.thomascook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import com.thomascook.models.Employee;
import com.thomascook.repositories.BonusRepo;
import com.thomascook.repositories.EmployeeRepository;
import com.thomascook.services.EmployeeBonusServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@SpringBootTest(classes = ThomasCookAssignmentApplication.class)
public class ThomasCookAssignmentApplicationTests {

    @Mock
    private EmployeeRepository employeeRepository;
    
    @Mock
    private BonusRepo bonusrepo;

    @InjectMocks
    private EmployeeBonusServiceImpl employeeService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

   
    @Test
    public void testGetEmployeesEligible() {
    	
        LocalDate date = LocalDate.of(2022, 5, 27);
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Khushi", "CSE", 0.0, "USD", LocalDate.of(2020, 5, 1), LocalDate.of(2022, 5, 1)));
        
        when(bonusrepo.getActiveEmployeesOnDate(date))
        .thenReturn(employees);

        assertNotNull(employeeService.getEmployeesEligible(date));

        verify(bonusrepo, times(1)).getActiveEmployeesOnDate(date);
    }
}