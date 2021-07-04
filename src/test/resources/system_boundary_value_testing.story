Scenario:  Shop Owner views all payments for some customer

Given customer is <id>.
When I list all payments for this customer.
Then I should be able to view all payments made by this customer.
!-- min, min+, nom, max-, max in this order
Examples:
|id                          |
|-9,223,372,036,854,775,808  |
|-9,223,372,036,854,775,807  |
|0                           |
|9,223,372,036,854,775,806   |
|9,223,372,036,854,775,807   |


Scenario:  Shop Owner views specific payment for some customer

Given payment is <payment_id> and customer is <customer_id>.
When I list this customer’s payment.
Then I should be able to view this specific payment.
!-- (x1nom, x2min), (x1nom, x2min+), (x1nom, x2nom)
!-- (x1nom, x2max-), (x1nom, x2max),(x1min, x2nom)
!-- (x1min+, x2nom), (x1max-, x2nom), (x1max, x2nom)
Examples:
|payment_id                  |customer_id                  |
|0                           | -9,223,372,036,854,775,808  |
|0                           |-9,223,372,036,854,775,807   |
|0                           |0                            |
|0                           |9,223,372,036,854,775,806    |
|0                           |9,223,372,036,854,775,807    |
|9,223,372,036,854,775,808   |0                            |
|-9,223,372,036,854,775,807  |0                            |
|9,223,372,036,854,775,806   |0                            |
|9,223,372,036,854,775,807   |0                            |

Scenario:  Shop Owner views specific payments for some unregistered customer

Given payment is <payment_id> and customer is <customer_id>.
When I list this customer’s payment.
Then I should receive a customer not found error.
!-- (x1nom, x2min), (x1nom, x2min+), (x1nom, x2nom)
!-- (x1nom, x2max-), (x1nom, x2max),(x1min, x2nom)
!-- (x1min+, x2nom), (x1max-, x2nom), (x1max, x2nom)
Examples:
|payment_id                  |customer_id                  |
|0                           | -9,223,372,036,854,775,808  |
|0                           |-9,223,372,036,854,775,807   |
|0                           |0                            |
|0                           |9,223,372,036,854,775,806    |
|0                           |9,223,372,036,854,775,807    |
|9,223,372,036,854,775,808   |0                            |
|-9,223,372,036,854,775,807  |0                            |
|9,223,372,036,854,775,806   |0                            |
|9,223,372,036,854,775,807   |0                            |

Scenario:  Shop Owner deletes all payments for some customer

Given customer is <id>.
When I delete all payments for this customer.
Then I should be able to perform this deletion successfully.
!-- min, min+, nom, max-, max in this order
Examples:
|id    |
|-9,223,372,036,854,775,808  |
|-9,223,372,036,854,775,807  |
|0                           |
|9,223,372,036,854,775,806   |
|9,223,372,036,854,775,807   |


Scenario:  Customer list all of their addresses

Given my customer id is <id>.
When I list all my addresses.
Then I should be able to view all of them.
!-- min, min+, nom, max-, max in this order
Examples:
|id                          |
|-9,223,372,036,854,775,808  |
|-9,223,372,036,854,775,807  |
|0                           |
|9,223,372,036,854,775,806   |
|9,223,372,036,854,775,807   |

Scenario:  Customer list specific address

Given my address title is new and my customer id is <id>.
When I list this address.
Then I should be able to view this address.
!-- min, min+, nom, max-, max in this order
Examples:
|id                          |
|-9,223,372,036,854,775,808  |
|-9,223,372,036,854,775,807  |
|0                           |
|9,223,372,036,854,775,806   |
|9,223,372,036,854,775,807   |

Scenario:  Customer deletes an address

Given my customer id is <id>.
When I delete the address home.
Then I should be able to perform this address deletion successfully.
!-- min, min+, nom, max-, max in this order
Examples:
|id                          |
|-9,223,372,036,854,775,808  |
|-9,223,372,036,854,775,807  |
|0                           |
|9,223,372,036,854,775,806   |
|9,223,372,036,854,775,807   |

Scenario:  Customer add a new address

Given my customer id is <id>.
When I add a new address with title work.
Then I should be able to add this address successfully.
!-- min, min+, nom, max-, max in this order
Examples:
|id                          |
|-9,223,372,036,854,775,808  |
|-9,223,372,036,854,775,807  |
|0                           |
|9,223,372,036,854,775,806   |
|9,223,372,036,854,775,807   |


Scenario:  Shop owner searches for an unknown category id

Given an unknown category id is <id>.
When I search for this category by id.
Then I should not be able to view the category.
!-- min, min+, nom, max-, max in this order
Examples:
|id                          |
|-9,223,372,036,854,775,808  |
|-9,223,372,036,854,775,807  |
|0                           |
|9,223,372,036,854,775,806   |
|9,223,372,036,854,775,807   |

Scenario:  Shop owner searches for product by id

Given a product id is <id>.
When I search for this product.
Then I should be able to view the product with this id.
!-- min, min+, nom, max-, max in this order
Examples:
|id                          |
|-9,223,372,036,854,775,808  |
|-9,223,372,036,854,775,807  |
|0                           |
|9,223,372,036,854,775,806   |
|9,223,372,036,854,775,807   |

Scenario:  Shop owner searches for sku by id

Given a sku id is <id>.
When I search for this sku.
Then I should be able to view the sku with this id.
!-- min, min+, nom, max-, max in this order
Examples:
|id                          |
|-9,223,372,036,854,775,808  |
|-9,223,372,036,854,775,807  |
|0                           |
|9,223,372,036,854,775,806   |
|9,223,372,036,854,775,807   |


