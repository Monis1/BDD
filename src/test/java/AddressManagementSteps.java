import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.jbehave.core.annotations.*;

import static io.restassured.RestAssured.given;

public class AddressManagementSteps {

    private RequestSpecification specification;
    private Response response;

    @BeforeStories
    public void init() {
        EncoderConfig encoderConfig = RestAssured.config().getEncoderConfig()
                .appendDefaultContentCharsetToContentTypeIfUndefined(false);
        RestAssured.config = RestAssured.config().encoderConfig(encoderConfig);
    }

    @BeforeScenario
    public void setup() {
        specification = given().header(new Header("Authorization",
                "Basic bW9uaXNhaG1lZDhAZ21haWwuY29tOmFiYzEyMzQ1"))
                .log().all();
    }

    @Given("my customer id is $customerId.")
    public void customerIdIs(long customerId) {
       specification.queryParam("customerId", customerId);
    }

    @Given("my address title is $addressTitle and my customer id is $customerId.")
    public void addressCustomerIdIs(String addressTitle, long customerId) {
        specification = specification.queryParam("addressName", addressTitle);
        specification = specification.queryParam("customerId", customerId);
    }

    @When("I delete the address $addressTitle.")
    public void deleteAddress(String addressTitle) {
        response = specification.when().delete("http://localhost:8082/api/v1/customer/address/" + addressTitle);
    }

    @When("I list all my addresses.")
    public void listAllAddresses() {
        response = specification.when().get("http://localhost:8082/api/v1/customer/addresses");
    }

    @When("I list this address.")
    public void listAddress() {
        response = specification.when().get("http://localhost:8082/api/v1/customer/address");
    }

    @When("I add a new address with title $addressTitle.")
    public void addAddress(String addressTitle) {
        String body = "<?xml version=\"1.0\"?>\n" +
                "<CustomerAddressWrapper>\n" +
                "  <address>\n" +
                "    <addressLine1>string</addressLine1>\n" +
                "    <addressLine2>string</addressLine2>\n" +
                "    <addressLine3>string</addressLine3>\n" +
                "    <city>string</city>\n" +
                "    <companyName>string</companyName>\n" +
                "    <country>\n" +
                "      <abbreviation>string</abbreviation>\n" +
                "      <name>string</name>\n" +
                "    </country>\n" +
                "    <firstName>string</firstName>\n" +
                "    <id>1</id>\n" +
                "    <isBusiness>true</isBusiness>\n" +
                "    <isDefault>true</isDefault>\n" +
                "    <isoCountryAlpha2>\n" +
                "      <alpha2>string</alpha2>\n" +
                "      <name>string</name>\n" +
                "    </isoCountryAlpha2>\n" +
                "    <isoCountrySubdivision>string</isoCountrySubdivision>\n" +
                "    <lastName>string</lastName>\n" +
                "    <phoneFax>\n" +
                "      <id>1</id>\n" +
                "      <isActive>true</isActive>\n" +
                "      <isDefault>true</isDefault>\n" +
                "      <phoneNumber>string</phoneNumber>\n" +
                "    </phoneFax>\n" +
                "    <phonePrimary>\n" +
                "      <id>1</id>\n" +
                "      <isActive>true</isActive>\n" +
                "      <isDefault>true</isDefault>\n" +
                "      <phoneNumber>string</phoneNumber>\n" +
                "    </phonePrimary>\n" +
                "    <phoneSecondary>\n" +
                "      <id>1</id>\n" +
                "      <isActive>true</isActive>\n" +
                "      <isDefault>true</isDefault>\n" +
                "      <phoneNumber>string</phoneNumber>\n" +
                "    </phoneSecondary>\n" +
                "    <postalCode>string</postalCode>\n" +
                "    <state>\n" +
                "      <abbreviation>string</abbreviation>\n" +
                "      <name>string</name>\n" +
                "    </state>\n" +
                "    <stateProvinceRegion>string</stateProvinceRegion>\n" +
                "  </address>\n" +
                "  <addressName>" + addressTitle + "</addressName>\n" +
                "</CustomerAddressWrapper>\n";
        response = specification.when()
                .contentType(ContentType.XML)
                .accept(ContentType.XML)
                .body(body)
                .put("http://localhost:8082/api/v1/customer/address");
    }

    @Then("I should be able to view all of them.")
    @Aliases(values={"I should be able to perform this address deletion successfully.",
                     "I should be able to view this address.",
                     "I should be able to add this address successfully."})
    public void successful() {
        response.then().statusCode(HttpStatus.SC_OK);
    }

}
