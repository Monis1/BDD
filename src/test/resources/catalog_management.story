Scenario:  Shop owner searches for category by name

Given a category name is marvel.
When I search for this category.
Then I should be able to view all categories with this name.

Scenario:  Shop owner searches for an unknown category id

Given an unknown category id is -500.
When I search for this category by id.
Then I should not be able to view the category.

Scenario:  Shop owner searches for product by id

Given a product id is 1.
When I search for this product.
Then I should be able to view the product with this id.

Scenario:  Shop owner searches for sku by id

Given a sku id is 1.
When I search for this sku.
Then I should be able to view the sku with this id.
