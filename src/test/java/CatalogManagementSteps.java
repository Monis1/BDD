import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.jbehave.core.annotations.*;

import static io.restassured.RestAssured.given;

public class CatalogManagementSteps {

    private RequestSpecification specification;
    private Response response;
    private String categoryId;
    private String productId;
    private String skuId;

    @BeforeScenario
    public void setup() {
        specification = given().header(new Header("Authorization",
                "Basic bW9uaXNhaG1lZDhAZ21haWwuY29tOmFiYzEyMzQ1"))
                .log().all();
    }

    @Given("a category name is $name.")
    public void categoryNameIs(String name) {
        specification.queryParam("name", name);
    }

    @Given("an unknown category id is $id.")
    public void categoryIdIs(String id) {
        this.categoryId = id;
    }

    @Given("a product id is $id.")
    public void productIdIs(String id) {
        this.productId = id;
    }

    @Given("a sku id is $id.")
    public void skuIdIs(String id) {
        this.skuId = id;
    }

    @When("I search for this product.")
    public void searchProductById() {
        response = specification.when().get("http://localhost:8082/api/v1/catalog/product/" + productId);
    }

    @When("I search for this sku.")
    public void searchSkuById() {
        response = specification.when().get("http://localhost:8082/api/v1/catalog/sku/" + skuId);
    }

    @When("I search for this category.")
    public void searchCategoryByName() {
        response = specification.when().get("http://localhost:8082/api/v1/catalog/categories");
    }

    @When("I search for this category by id.")
    public void searchCategoryById() {
        response = specification.when().get("http://localhost:8082/api/v1/catalog/category/" + categoryId);
    }

    @Then("I should be able to view all categories with this name.")
    @Aliases(values={"I should be able to view the product with this id.",
            "I should be able to view the sku with this id."})
    public void successful() {
        response.then().statusCode(HttpStatus.SC_OK);
    }

    @Then("I should not be able to view the category.")
    public void categoryNotFound() {
        response.then().statusCode(HttpStatus.SC_NOT_FOUND);
    }

}
