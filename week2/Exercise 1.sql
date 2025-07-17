DECLARE
    num NUMBER := &enter_number;
BEGIN
    IF num > 0 THEN
        DBMS_OUTPUT.PUT_LINE('The number is positive.');
    ELSIF num < 0 THEN
        DBMS_OUTPUT.PUT_LINE('The number is negative.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('The number is zero.');
    END IF;
END;
/