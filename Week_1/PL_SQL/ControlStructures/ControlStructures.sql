--creating the required tables (Customer , Loans)
create table customers (
   customerid number primary key,
   name       varchar2(50),
   age        number,
   balance    number,
   isvip      varchar2(5)
);

create table loans (
   loanid       number primary key,
   customerid   number,
   interestrate number,
   duedate      date
);

--Now we should insert the values into the table

insert into customers values ( 1,  'Sai',  21,  150000,  'FALSE' );
insert into customers values ( 2,'Kiran', 25,35000, 'FALSE' );
insert into customers values ( 3,'Jackie',22,25000,'FALSE');
insert into customers values ( 4,'SudhaSagar',26,125000,'FALSE');
insert into customers values ( 5,'Alex',65,5000,'FALSE');
insert into customers values ( 6,'Shah Rukh',79,28000,'FALSE');



insert into loans values ( 101,1,5, sysdate + 35 );
insert into loans values ( 102,2,8,sysdate + 40 );
insert into loans values ( 103,3,7,sysdate + 15 );
insert into loans values ( 104,4,6,sysdate + 35 );
insert into loans values ( 105,5,9,sysdate + 19 );
insert into loans values ( 106,6,10,sysdate + 29 );

commit;

-->display tables 

select *
  from customers;

select *
  from loans;

-->Scenario-1  The bank wants to apply a discount to loan interest rates for customers above 60 years old.

   SET SERVEROUTPUT ON;

begin
   for cust in (
      select customerid
        from customers
       where age > 60
   ) loop
      update loans
         set
         interestrate = interestrate - 1
       where customerid = cust.customerid;

   end loop;
 dbms_output.put_line('Discount Applied Successfully');
end;
/

select *
  from loans;

-->Scenario-2 A customer can be promoted to VIP status based on their balance.

begin
   for cust in (
      select customerid
        from customers
       where balance > 10000
   ) loop
      update customers
         set
         isvip = 'TRUE'
       where customerid = cust.customerid;

   end loop;

   dbms_output.put_line('VIP Status Updated');
end;
/

select *
  from customers;


-->Scenario-3 The bank wants to send reminders to customers whose loans are due within the next 30 days.

begin
   for loan_rec in (
      select c.name,
             l.duedate
        from customers c
        join loans l
      on c.customerid = l.customerid
       where l.duedate between sysdate and sysdate + 30
   ) loop
      dbms_output.put_line('Reminder: '
                           || loan_rec.name
                           || ' Loan Due on ' || loan_rec.duedate);
   end loop;
end;
/