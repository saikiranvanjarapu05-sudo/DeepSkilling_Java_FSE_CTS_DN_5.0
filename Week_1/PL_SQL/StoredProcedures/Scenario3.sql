SELECT * FROM SAVINGS_ACCOUNT;

CREATE OR REPLACE PROCEDURE TransferFunds(
    fromAccId IN NUMBER,
    toAccId IN NUMBER,
    amount IN NUMBER
)
AS

    sourceBalance NUMBER;

BEGIN

    SELECT balance
    INTO sourceBalance
    FROM SAVINGS_ACCOUNT
    WHERE accId = fromAccId;

    IF sourceBalance < amount THEN

        DBMS_OUTPUT.PUT_LINE(
            'Transfer Failed: Insufficient Balance'
        );

    ELSE

        UPDATE SAVINGS_ACCOUNT
        SET balance = balance - amount
        WHERE accId = fromAccId;

        UPDATE SAVINGS_ACCOUNT
        SET balance = balance + amount
        WHERE accId = toAccId;

        COMMIT;

        DBMS_OUTPUT.PUT_LINE(
            'Transfer Successful'
        );

    END IF;

END;
/

BEGIN
   TransferFunds(2,4,5000);
END;
/

SELECT * FROM SAVINGS_ACCOUNT;