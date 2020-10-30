# webApp

**Version 1.0.0**

## Contributors
- John Wilkinson <jwilkinsondev@gmail.com>

## Future work
I didn't have time to hook up my unit tests and build the frontend for the app.
My understanding is that the point of the project is to determine what I can do in a few hours, so I'm going to call this a good stopping spot.
For the front end I planned to stand up a react app using https://create-react-app.dev/.
I would then hook it up to the backend api. The end goal would be for that to be bundled with the docker compose file as well so that you can start the whole app with one command.

## Initial setup
NOTE: normally I would use an actual date for the target delivery date, but in the interest of time, I will just use a string.
You'll need to start up the project with `docker-compose up --build`

Then connect to the running postgres db and use the following script to initialize the db tables.
In the future this would be setup with initialization scripts, or you would point to a proper db.
create table features (
    feature_id int primary key,
    title text,
    description text,
    client_id int,
    priority int,
    target_delivery_date text,
    product_area text
);