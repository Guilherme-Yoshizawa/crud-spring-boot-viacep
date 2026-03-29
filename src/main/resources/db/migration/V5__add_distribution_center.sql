alter table product add column distribution_center varchar(255);

update product set distribution_center = 'Mogi das Cruzes' where id in ('p1', 'p2');

update product set distribution_center = 'Recife' where id in ('p3', 'p4');

update product set distribution_center = 'Porto Alegre' where id in ('p5', 'p6');
