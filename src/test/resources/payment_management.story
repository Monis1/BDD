Scenario:  Shop Owner views all payments for some customer

Given customer is 1.
When I list all payments for this customer.
Then I should be able to view all payments made by this customer.


Scenario:  Shop Owner views specific payment for some customer

Given payment is 1 and customer is 1.
When I list this customer’s payment.
Then I should be able to view this specific payment.

Scenario:  Shop Owner views specific payments for some unregistered customer

Given payment is 1 and customer is -1.
When I list this customer’s payment.
Then I should receive a customer not found error.

Scenario:  Shop Owner deletes all payments for some customer

Given customer is 1.
When I delete all payments for this customer.
Then I should be able to perform this deletion successfully.
