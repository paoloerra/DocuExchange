SET GLOBAL innodb_lock_wait_timeout = 20;
use docuexchange;
delete from docuexchange.note where email_user="m.derosa1@studenti.unisa.it";
delete from docuexchange.user where email_user="m.derosa2@studenti.unisa.it";