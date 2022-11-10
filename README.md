

# SpringBoot Commerce Service Project

There are three servers (inventory, shopping, commerce).


## Endpoints & Screenshots

#### GetProductById:

```
GET /commerce/inventory/product/{productId}
```

<img src="https://i.hizliresim.com/cg6jb29.png" alt="photo-1"/><br>

#### DeleteCartProduct:

```
DELETE /commerce/shopping/cart/{cartId}/remove/{productID}
```

<img src="https://i.hizliresim.com/2i21rri.png" alt="photo-2"/><br>

#### GetCartById:

```
GET /commerce/shopping/cart/find/{cartId}
```

<img src="https://i.hizliresim.com/c29ph15.png" alt="photo-3"/><br>

#### CreateCart:

```
GET /commerce/shopping/cart/create
```

<img src="https://i.hizliresim.com/8v6yz6s.png" alt="photo-4"/><br>

#### Checkout:

```
GET /commerce/shopping/checkout/{cartId}
```

<img src="https://i.hizliresim.com/hwyjg6c.png" alt="photo-5"/><br>

#### GetCategories:

```
GET /commerce/inventory/categories
```

<img src="https://i.hizliresim.com/orlfypa.png" alt="photo-6"/><br>

#### GetCategoryByName:

```
GET /commerce/inventory/products/{categoryName}
```

<img src="https://i.hizliresim.com/se3f0qj.png" alt="photo-7"/><br>

#### CreateCartDto:

```
POST /commerce/shopping/cart/add
```

<img src="https://i.hizliresim.com/8rq4lbj.png" alt="photo-8"/><br>
(Note: This error returns despite adding it to the database. I attribute the error to the two microservices of the error being forced to connect to the database server from the same port and perform operations. It is a fixable error, but unfortunately I am submitting this as there is no time left.)

<br>
<br>
<br>

## Homeworks and Applications:
    -employeeDepartment
    -inventory
    -orm
    -rest -> employeeApplication, rest examples(restTemplate etc.)