CREATE OR REPLACE PROCEDURE GetCustomer(
    p_customerid IN NUMBER
)
AS
    v_name Customers.CustomerName%TYPE;
BEGIN
    SELECT CustomerName
    INTO v_name
    FROM Customers
    WHERE CustomerID = p_customerid;

    DBMS_OUTPUT.PUT_LINE('Customer Name: ' || v_name);
END;
/