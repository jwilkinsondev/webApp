

## Initial setup
You'll need to start up the project with `docker-compose up --build`
In the future this would be setup with initialization scripts, or you would point to a proper db.

Then connect to the running postgres db and use the following script to initialize the db tables.

create table features (
    feature_id int primary key,
    title text,
    description text,
    client_id int,
    priority int,
    target_delivery_date date,
    product_area text
);