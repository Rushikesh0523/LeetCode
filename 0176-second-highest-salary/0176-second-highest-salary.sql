/* Write your T-SQL query statement below */

/*Select max(salary) as SecondHighestSalary
from employee
where salary not in (
    select max(salary) from employee
);*/

with cte as(
    select salary, Dense_rank()
    over (order by salary desc) as rnk
    from employee
    
)
select max(salary) as SecondHighestSalary
from cte 
where rnk = 2;