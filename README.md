# Rest Full Crud application 

### In this repository
> #### I’ve attempted to create an application that encompasses all CRUD operations and utilizes REST FULL technology


## request :

> ### post:
create operation
> http://localhost:9090/product
```JSON
{
    "name": "Car",
    "color": "Red",
    "price": "10000",
    "exist": 0
}
```
___

> #### Get 
read operation
> http://localhost:9090/product?productId=1 

___

#### get (all product):
> http://localhost:9090/products

___
#### Delete:
delete operation
> http://localhost:9090/product?productId=1 

___

# PATCH:
update operation
> http://localhost:9090/product?productId=1 

```JSON
{
    "name": "Car",
    "color": "Blue",
    "price": "12345",
    "exist": 1
}
```