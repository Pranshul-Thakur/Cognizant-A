CREATE OR REPLACE PROCEDURE GetEmployeeDetails(p_emp_id IN NUMBER) IS
    v_name   VARCHAR2(100);
    v_salary NUMBER;
BEGIN
    SELECT ename, sal INTO v_name, v_salary
    FROM emp
    WHERE empno = p_emp_id;

    DBMS_OUTPUT.PUT_LINE('Name: ' || v_name || ', Salary: ' || v_salary);
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Employee not found.');
END;
/
