import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.jbehave.core.annotations.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;


public class PaymentManagementSteps {

    private RequestSpecification specification;
    private Response response;

    @BeforeScenario
    public void setup() {
        specification = given().header(new Header("Authorization",
                "Basic YnJvYWRsZWFXBpOjVhMDc0MjcxLTM0MmItNDcxNC04YjdmLWQyZWVlZmMzNDZkNA=="));
    }

    @Given("customer is $customer")
    public void customerIs(long customer) {
          specification.queryParam("customerId", customer);
    }

    @Given("payment is $payment and customer is $customer.")
    public void customerPaymentsIs(long customer, long payment) {
        specification.queryParam("customerId", customer);
        specification.queryParam("paymentId", payment);
    }

    @When("I list all payments for this customer.")
    public void listAllPayments() {
         response = specification.when().get("http://localhost:8082/api/v1/customer/payments");
    }

    @When("I list this customer’s payment.")
    public void listSpecificPayment() {
        response = specification.when().get("http://localhost:8082/api/v1/customer/payment");
    }

    @When("I delete all payments for this customer.")
    public void deletePayments() {
        response = specification.when().delete("http://localhost:8082/api/v1/customer/payments");
    }

    @Then("I should be able to view all payments made by this customer.")
    @Alias("I should be able to perform this deletion successfully.")
    public void successfulReturnCode() {
        response.then().statusCode(200);
    }


    @Then("I should be able to view this specific payment.")
    public void viewSpecificPayment() {
        response.then().statusCode(HttpStatus.SC_OK)
                .body("size()", is(1));
    }

    @Then("I should receive a customer not found error.")
    public void specificPaymentError() {
        response.then().statusCode(400);
    }

}
