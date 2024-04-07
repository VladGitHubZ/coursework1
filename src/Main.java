import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final int AMOUNT_EMPLOYEE = 10;
    private static final  int percentIndexation = 10;
    private static final int department = 5;

    public static void main(String[] args) {
        final Employee[] employees = new Employee[AMOUNT_EMPLOYEE];

        employees[0] = new Employee("John",1,15000);
        employees[1] = new Employee("John1",2,11000);
        employees[2] = new Employee("John2",4,12000);
        employees[3] = new Employee("John3",5,13000);
        employees[4] = new Employee("John4",2,14000);
        employees[5] = new Employee("John5",3,16000);
        employees[6] = new Employee("John6",5,17000);
        employees[7] = new Employee("John7",1,19000);
        employees[8] = new Employee("John8",2,29000);
        employees[9] = new Employee("John9",3,42000);

        printEmployees(employees);
        printFullNames(employees);

        System.out.println("Суммарная зарплата = "+ getSalarySum(employees));
        System.out.println("Минимальная зарплата = "+ getMinSalary(employees));
        System.out.println("Максимальная зарплата = "+ getMaxSalary(employees));
        System.out.println("Средняя зарплата = "+ getAverageSalary(employees));

        indexSalary(employees,percentIndexation);
        printEmployees(employees);

        System.out.println("Минимальная зарплата отдела "+ department +" " + getMinSalaryEmployeeDepart(employees,department));
        System.out.println("Максимальная зарплата отдела "+ department +" " + getMaxSalaryEmployeeDepart(employees,department));


    }

    private static void printEmployees(Employee[] employees){
        for (int i = 0; i < employees.length; i++){
            System.out.println(employees[i]);
        }
    }
    private static int getSalarySum(Employee[] employees){
        int salarySum = 0;
        for (Employee employee : employees) {
            salarySum += employee.getSalary();
        }
        return salarySum;
    }
    private static int getMinSalary(Employee[] employees){
        int minSalary = employees[0].getSalary();
        for (Employee employee : employees) {
            if (employee.getSalary() < minSalary){
                minSalary = employee.getSalary();
            }
        }
        return minSalary;
    }
    private static int getMaxSalary(Employee[] employees){
        int maxSalary = employees[0].getSalary();
        for (Employee employee : employees) {
            if (employee.getSalary() > maxSalary){
                maxSalary = employee.getSalary();
            }
        }
        return maxSalary;
    }
    private static double getAverageSalary(Employee[] employees){
        int salarySum = getSalarySum(employees);
        return (double) salarySum / employees.length;
    }
    private static void printFullNames(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());

        }
    }

    private static void indexSalary(Employee[] employees, double percentIndexation){
        for (Employee employee : employees) {
            int newSalary = (int) (employee.getSalary() * (1 + percentIndexation / 100));
            employee.setSalary(newSalary);
        }
    }
    private static Employee getMinSalaryEmployeeDepart(Employee[] employees, int department){
        Employee minSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department && (minSalaryEmployee == null || employee.getSalary() < minSalaryEmployee.getSalary())) {
                minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }
    private static Employee getMaxSalaryEmployeeDepart(Employee[] employees, int department){
        Employee maxSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department && (maxSalaryEmployee == null || employee.getSalary() > maxSalaryEmployee.getSalary())) {
                maxSalaryEmployee = employee;
            }
        }
        return maxSalaryEmployee;
    }

}

