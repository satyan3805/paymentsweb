create database paymentsweb;
use paymentsweb;

CREATE TABLE users (
    UserId INT NOT NULL,
    FirstName VARCHAR(25),
    LastName VARCHAR(25),
    PhoneNo varchar(15),
    DateOfBirth VARCHAR(25),
    Address VARCHAR(100),
    PassWord VARCHAR(25),
    CurrWalletBal double(7,2),
    PRIMARY KEY (UserId)
);
alter table users add column email varchar(200);
-- alter phoneno to unique
alter table users add unique(PhoneNo);
-- alter dateofbirth to date
alter table users modify column DateOfBirth Date;
-- alter userId auto increment.
alter table users modify column UserId int unique key auto_increment;

select * from users;
select * from users where phoneno='989898' and PassWord='pass';
desc users;

select * from users;

create table BankAccountTypes(
	BankAcctTypeId int,
    BankAcctTypeCode varchar(3),
    BankAcctTypeDesc varchar(50),
    primary key(BankAcctTypeId)
 );
 desc BankAccountTypes;
 select * from BankAccountTypes;
insert into BankAccountTypes values(1,'SA','SAVINGS ACCOUNT');
insert into BankAccountTypes values(2,'CA','CURRENT ACCOUNT');

CREATE TABLE BankAccounts (
    BankAcctNo varchar(16) NOT NULL,
    BankName VARCHAR(50),
    AcctTypeId int,
    BankIFSCCode VARCHAR(10),
    BankAcctPin INT,
    UserId INT,
    CurrBankAcctBalance double(12,2),
    FOREIGN KEY (UserId) REFERENCES users (UserId),
    FOREIGN KEY (AcctTypeId) REFERENCES BankAccountTypes (BankAcctTypeId),
    PRIMARY KEY (BankAcctNo)
);

alter table BankAccounts add foreign key (UserId) references Users(UserId);
alter table TxnDetails add foreign key (UserId) references Users(UserId);


select * from INFORMATION_SCHEMA.key_column_usage
where table_name ='TxnDetails';


select * from  INFORMATION_SCHEMA.TABLE_CONSTRAINTS 
where table_name ='BankAccounts'
and column_name='userid';

CREATE TABLE TxnDetails (
    TxnId int(10) NOT NULL,
    TxnDate datetime,
    TxnAmount DOUBLE,
    source_type ENUM("BA","WA"),
    source_id int,
    dest_type ENUM("BA","WA"),
    dest_id int,
    UserId int,
    FOREIGN KEY (UserId) REFERENCES users (UserId),
    PRIMARY KEY (TxnId)
);

select * from TxnDetails;



