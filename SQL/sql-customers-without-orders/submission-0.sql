-- Write your query below
select c.name from customers c where c.id not in (select customer_id from orders)