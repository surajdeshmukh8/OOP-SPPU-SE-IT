/**3.Inheritance -- CO3
Design and develop inheritance for a given case study, identify objects and relationships and
implement inheritance wherever applicable. Employee class hasEmp_name, Emp_id, Address,
Mail_id, and Mobile_noas members. Inherit the classes: Programmer, Team Lead, Assistant Project
Manager and Project Manager from employee class. Add Basic Pay (BP) as the member of all the
inherited classes with 97% of BP as DA, 10 % of BP as HRA, 12% of BP as PF, 0.1% of BP for staff
club fund. Generate pay slips for the employees with their gross and net salary. */

public class Employee {
    protected String empName;
    protected String empAddress;
    protected String empMail;
    protected int empID;
    protected long empMbNo;

    public Employee(String empName, String empAddress, String empMail, int empID, long empMbNo) {
        this.empName = empName;
        this.empAddress = empAddress;
        this.empMail = empMail;
        this.empID = empID;
        this.empMbNo = empMbNo;
    }

    public void display() {
        System.out.println("Name: " + empName + 
                           "\nAddress: " + empAddress + 
                           "\nMail: " + empMail + 
                           "\nID Number: " + empID + 
                           "\nMobile Number: " + empMbNo);
    }

    public void grossSalary(double bp) {
        double gross = bp + (bp * 0.10) + (bp * 0.97) + (bp * 0.12);
        System.out.println("Gross Salary: " + gross);
    }

    public void netSalary(double bp) {
        double net = bp + (bp * 0.10) + (bp * 0.97) + (bp * 0.12) + (bp * 0.1);
        System.out.println("Net Salary: " + net);
    }
}

class Programmer extends Employee {
    private double bp;

    public Programmer(String empName, String empAddress, String empMail, int empID, long empMbNo, double bp) {
        super(empName, empAddress, empMail, empID, empMbNo);
        this.bp = bp;
    }

    @Override
    public void display() {
        System.out.println("\nProgrammer Information:");
        super.display();
    }

    public void calculateSalary() {
        grossSalary(bp);
        netSalary(bp);
    }
}

class TeamLead extends Employee {
    private double bp;

    public TeamLead(String empName, String empAddress, String empMail, int empID, long empMbNo, double bp) {
        super(empName, empAddress, empMail, empID, empMbNo);
        this.bp = bp;
    }

    @Override
    public void display() {
        System.out.println("\nTeam Lead Information:");
        super.display();
    }

    public void calculateSalary() {
        grossSalary(bp);
        netSalary(bp);
    }
}

class AssistantProjectManager extends Employee {
    private double bp;

    public AssistantProjectManager(String empName, String empAddress, String empMail, int empID, long empMbNo, double bp) {
        super(empName, empAddress, empMail, empID, empMbNo);
        this.bp = bp;
    }

    @Override
    public void display() {
        System.out.println("\nAssistant Project Manager Information:");
        super.display();
    }

    public void calculateSalary() {
        grossSalary(bp);
        netSalary(bp);
    }
}

class ProjectManager extends Employee {
    private double bp;

    public ProjectManager(String empName, String empAddress, String empMail, int empID, long empMbNo, double bp) {
        super(empName, empAddress, empMail, empID, empMbNo);
        this.bp = bp;
    }

    @Override
    public void display() {
        System.out.println("\nProject Manager Information:");
        super.display();
    }

    public void calculateSalary() {
        grossSalary(bp);
        netSalary(bp);
    }
}

class Inheritance {
    public static void main(String[] args) {
        Programmer prog = new Programmer("Suraj", "Sangamner", "surajdeshmukh@gmail.com", 23, 9284115612L, 9000.20);
        prog.display();
        prog.calculateSalary();

        TeamLead lead = new TeamLead("Sham", "JK", "sohamdeshmukh@gmail.com", 24, 9565267159L, 2000.12);
        lead.display();
        lead.calculateSalary();

        AssistantProjectManager asstPM = new AssistantProjectManager("Akash", "Sangamner", "Akash96k@gmail.com", 8, 97675895521L, 1200.12);
        asstPM.display();
        asstPM.calculateSalary();

        ProjectManager pm = new ProjectManager("Viru", "Pune", "viru87@gmail.com", 89, 89254752892L, 6765.12);
        pm.display();
        pm.calculateSalary();
    }
}
