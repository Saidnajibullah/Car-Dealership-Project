!-- creating the customer table
create table customer1(
      id serial primary key not null,
      firstname varchar(150) not null,
      lastname varchar(150) not null,
      password varchar(150) not null unique
);

!--creating the employee table

create table employee1(
      id serial primary key not null,
      firstname varchar(150) not null,
      lastname varchar(150) not null,
      password varchar(150) not null unique
);

!--creating the car table

create table car(
      id serial primary key not null,
      make varchar(150) not null,
      model varchar(150) not null,
      vin char(20) not null unique,
      price numeric not null
      
     
);

!-- creating the offer table
create table offer(
      id serial primary key not null,
      status varchar(150) default 'active' not null,
      offerdate date not null,
      cust_id int references customer1(id),
      car_id int references car(id)
);

!--altering offer table
alter table offer rename column offerdata to offerdate;
alter table offer album column offerdate set default current_date;



insert into customer1(id, firstname, lastname, "password")
      values(1, 'James', 'Smith', 'jmst78' ),
            (2, 'Maria', 'Garcia', 'mgy01' ),
            (3, 'Barak', 'Obama', 'bou86' );
           
insert into employee1(id, firstname, lastname, "password")
      values(1, 'James', 'Johnson', 'oo037' ),
            (2, 'Maria', 'Cigaro', 'rytu8' ),
            (3, 'Trump', 'Donald', 'bcnn2' ); 
           
insert into car(make, model, vin, price)
      values('Jeep', 'Gladiator', '2345', 44000);            
           
insert into offer(status, offerdate, cust_id, car_id)
      values('rejected', '2019-05-21', 2, 1),
            ('rejected', '2019-05-02', 1, 1 ),
            ('rejected', '2019-04-29', 2, 2 );  
alter table offer alter column offerdate set default current_date;
select * from offer;


