CREATE OR REPLACE FUNCTION GetOrderAmount(
    p_orderid IN NUMBER
)
RETURN NUMBER
AS
    v_amount NUMBER;
BEGIN
    SELECT OrderAmount
    INTO v_amount
    FROM Orders
    WHERE OrderID = p_orderid;

    RETURN v_amount;
END;
/