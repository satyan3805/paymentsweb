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
-- alter phoneno to unique
-- alter dateofbirth to date
-- alter userId auto increment.

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
select * from  BankAccounts;


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

