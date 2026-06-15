package com.pconil

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
class ExampleResourceTest {

    @Test
    fun testHelloEndpoint() {
        given()
            .`when`().get("/hello")
            .then()
            .statusCode(200)
            .body(`is`("{\"message\":\"Hello from Quarkus REST\"}"))
    }

    @Test
    fun testStatusEndpoint() {
        given()
            .`when`().get("/status")
            .then()
            .statusCode(200)
            .body(`is`("{\"status\":\"ok\",\"name\":\"usage-sample\",\"version\":\"v1\",\"components\":[]}"))
    }
}
