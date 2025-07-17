### Views in DB
- A view is an imp db object in dbms environment to manage data in db. 
- Generally we use tables to store and manage data when we perform data manupulation operations , table are primary db objects also called base tables. 
- Some times in addition to tables we use view for storing and managing data, views are secondary db objects , aview is created only from existing table without base table vies cant be created , a view is a virtual table or temporary table created based on an SQL query that means we define sql quries and save it when ever this query is executed it extracts dta from another base table places in a temp memory and now onwards this temp memory acts as a table on this temp memory we can insert, delete  and we can update records just like any table .the view is a permanent query acts as a table.
#### Uses in views
1. In a client server n/w environment we use central db in a server which is accessed by multiple concurrent users at a time from different client computer systems perfoming diff db operations . in this environment some times multiple users executing multiple programs perfoming operation on same db table in such a case the ececution of programs becomes slow means performance decreses.now to avoid this problem and to improve the performance we use views there for a base table diff views are created some users perfoming db operations on base table and some users on diff views because of this load on db table is reduced and balanced
2. views are useful for data access control 
3. view doesnt occupy any disk space

### What is Synonym in DB
- It is another db object created from base table it also secondary db object it is like a view and used for implementing same benefits as view 
- It is also a permanent query but it has separete disk space

## Codd's Rules
- Initially we have dbms and db is create using dbms it has some problems and issues to overcome those problems EF Codd designed 12 rules and proposed evry db must satify these 12 rules , When a db is satisfy these 12 rules then is called as RDBMS, That 12 rules are(13 rules)
#### 0. Foundation Rule
- The db system must manage data entirly through the relational capabilities
#### 1. Information Rule
- All data including meta data must be stored as data records in db
#### 2. Rule of Guaranteed Access
- Every piece of data must be accessible by user using combination of table name, column name and primary key
#### 3. Systematic treatement of null values
- If any data is not available at the time of storage that shoulb be treated as null value
#### 4. Dynamic online catalog
- This rule says that meta data should be stored and accesible like regular data and in a sepatrate built in table
#### 5. Comprehensive data sub-Language rule
- This rule says that a separate sub-language is must me avilable
1. for data definition
2. data manupulation
3. for date retrival
4. trasaction management
5. data access control
#### 6. view updation rule
- views must be support updation operations (change of data in table through view should be possible)
#### 7. High level insert, update and delete
- According to this rule DML operations Insert, update , delete should suppert sets of rows not just single row
#### 8. Physical data independence
- changes to physical storage of data should not required changes to application programs
- application programms or logical data structure
#### 9. Logical data independence
- changes to logical structure of db should not reqired changes to physical storage
#### 10. Intregrity independence rule
- Intrigrity constraints should ne define and stored in db
#### 11. Distribution independence rule
- It should be transparent to end user whether db is centralized or distributed 
#### 12. Non-sub version rule
- the system should not allow acces to data that bypass the integrity constraints

### Queries

- flights :- aid int, fno int, from str, to str, dist int, depart time, arrive tme, price real
- AirCraft :- aid int , aname str,cruisingrange int
- certified :- eid int, enam int
- emp:- eid int, ename str, sal int
- Note : EMployees means pilotes , every pilot is certified for some aircraft only and those pilots certified for aitcraft allowed to fly
- Note : only some employs are pilots in emp table
1. find names of aircraft such that all pilots certified to operate them have more than 80k sal
- select a.aname from AirCraft a, certified c, emp e where a.aid=c.aid and c.eid=e.eid and e.sal>80000;
2. For each pilot who is certified for more than 3 aircrafts find eid, and maximum crusing range of the aircraft for which he/she certtified
- select c.eid, max(a.cruisingrange)from certified c
  join AirCraft a on c.aid = a.aid
  group by c.eid
  having count(c.aid) > 3; 
3. find names of pilots who's sal < price of cheapest route from loseangels to honolulu
- select ename from emp where sal<(select min(price) from flights where from='loseangels' and to='honolulu' );
4. for all the aircraft with crusing range over 1000miles find the name of the aircraft and avg sal for all pilots certified for the aircraft
- select a.aname, avg(e.sal) from AirCraft a, certified c, emp e where a.cruisingRange > 1000 and a.aid=c.aid and c.eid=e.eid group by a.aname;
5. find the names of pilots certified for some boing aitcraft
- select e.ename from emp e, AirCraft a,Certified c where e.eid=c.eid and c.aid=a.aid and a.aname='boing'; 
6. find aid's of all aircrafts that can be used on routes from loseangels to chicago
- select a.aid from AirCraft a, flight f where a.aid=f.aid and from='loseangles' and to='chicago';
7. Identify the routes that can be piloted by every pilot who makes more than 1 lac
- select f.from, f.to from flights f where not exists (    select 1 from emp e where e.sal > 100000 and not exists (select 1 from certified c join AirCraft a on c.aid = a.aid where c.eid = e.eid and a.aid = f.aid));
8. print names of pilots who can operate aircrafts with crusing range > 3000 miles but are not certified on any boing aircraft
- select distinct e.ename
  from emp e
  join certified c on e.eid = c.eid
  join AirCraft a on c.aid = a.aid
  where a.cruisingrange > 3000
    and e.eid not in (
      select c2.eid
      from certified c2
      join AirCraft a2 on c2.aid = a2.aid
      where a2.aname = 'boing'
    );
9. compute the diff b/w avg sal of pilots and avg sal all other employees 
Note : only some employs are pilots in emp table
-  (select avg(e1.sal) from emp e1 where e1.eid in (select eid from certified)) -
    (select avg(e2.sal) from emp e2 where e2.eid not in (select eid from certified)) as diff;
10. print name and sal of every non pilot who's sal is> avg sal of the pilots
- select e.ename, e.sal
  from emp e
  where e.eid not in (select eid from certified)
    and e.sal > (select avg(sal) from emp where eid in (select eid from certified));
11. Print names of pilots who are certified only on aircraft with crusing range more than 2000miles
- select e.ename
  from emp e
  where e.eid in (
    select c.eid
    from certified c
    join AirCraft a on c.aid = a.aid
    group by c.eid
    having min(a.cruisingrange) > 2000
  );
12. print names of pilots who are certified only on air craft with crusing range > 2000 miles but there should be atleats 2 such aircrafts
- select e.ename
  from emp e
  where e.eid in (
    select c.eid
    from certified c
    join AirCraft a on c.aid = a.aid
    group by c.eid
    having min(a.cruisingrange) > 2000 and count(distinct c.aid) >= 2
  );


### Embedded SQL
1. ODBC
2. JDBC
3. ADODAR
- What do u mean by Dynamic SQl - using prepared statement in JDBC is nothing but Dynamic SQL
- What do u mean by cursor :- using resultset in JDBC is nothing but cursor
- temporary buffer to store the data we get