Scenario:  Customer list all of their addresses

Given my customer id is 400.
When I list all my addresses.
Then I should be able to view all of them.

Scenario:  Customer list specific address

Given my address title is new and my customer id is 1.
When I list this address.
Then I should be able to view this address.

Scenario:  Customer deletes an address

Given my customer id is 400.
When I delete the address home.
Then I should be able to perform this address deletion successfully.

Scenario:  Customer add a new address

Given my customer id is 400.
When I add a new address with title work.
Then I should be able to add this address successfully.


