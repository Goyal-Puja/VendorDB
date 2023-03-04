## Vendor Management API

This is a REST API for managing vendors using CRUD (Create, Read, Update, Delete) operations.
The API is built using Spring Boot, Spring Data JPA, and Hibernate,
with Java 8 as the primary technologies. MySQL is used as the database to store the Vendor entities.
<br/>
<br/>

## API Endpoints

Create a new vendor
<pre>
POST /vendors: create a new vendor with the provided data in the request body.
</pre>
Get all vendors
GET /vendors/getAll: retrieve a list of all vendors.
Get a vendor by id
GET /vendors/get/{id}: retrieve the vendor with the specified id.
Update a vendor
PUT /vendors/update/{id}: update the vendor with the specified id using the data provided in the request body.
Delete a vendor
DELETE /vendors/delete/{id}: delete the vendor with the specified id.
