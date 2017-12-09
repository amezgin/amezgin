--The result of this query will display all products whose type of  "Cheese".
SELECT product.name
FROM product INNER JOIN type ON product.type_id = type.id
WHERE type.name = 'Сыр';

--The result of this query will display all products whose name contains "мороженное".
SELECT *
FROM product
WHERE lower(name) LIKE '%мороженное%';

--The result of this query will display all products whose expiration date is next month.
SELECT *
FROM product as p
WHERE (date_part('year', now()) - date_part('year', p.expired_date) = 0
       and (date_part('month', p.expired_date) - date_part('month', now()) = 1))
       or (date_part('year', p.expired_date) - date_part('year', now()) = 1
       and (date_part('month', p.expired_date) - date_part('month', now()) = -11));

--The result of this query will display the product with maximal the price.
SELECT *
FROM product
WHERE price = (SELECT max(price)
               FROM product);

--The result of this query will display the count of product a certain type.
SELECT count(product.name)
FROM product INNER JOIN type ON product.type_id = type.id
WHERE type.name = 'Сыр';

--The result of this query will display the type of product where count products < 10.
SELECT type.name
FROM type INNER JOIN product ON type.id = product.type_id
GROUP BY type.name
HAVING count(type.name) < 10;

--The result of this query will display the all products and their types.
SELECT product.name, type.name
FROM product INNER JOIN type ON product.type_id = type.id