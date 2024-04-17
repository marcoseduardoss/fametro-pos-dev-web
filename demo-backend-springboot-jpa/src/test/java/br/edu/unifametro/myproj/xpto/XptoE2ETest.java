//package br.edu.unifametro.myproj.xpto;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import br.edu.unifametro.myproj.v1.xpto.dto.XptoDto;
//
////comente o @Disabled, caso queira executar este teste
//@Disabled("Desabilitado devido à manutenção")
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//class XptoE2ETest {
//
//    @LocalServerPort
//    private int port;
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    private String baseUrl;
//
//    @BeforeEach
//    void setUp() {
//        this.baseUrl = "http://localhost:" + port + "/v1/xptos";
//    }
//
//    @Test
//    void testCreateReadUpdateDeleteXpto() {
//    	
//        // Create
//        XptoDto newXpto = new XptoDto(null, "Test Create", "Test Create Description", null);
//        ResponseEntity<XptoDto> responsePost = restTemplate.postForEntity(baseUrl, newXpto, XptoDto.class);
//        //Creation confirmation
//        assertThat(responsePost.getStatusCode()).isEqualTo(HttpStatus.CREATED);
//        XptoDto createdXpto = responsePost.getBody();
//        assertThat(createdXpto).isNotNull();
//        assertThat(createdXpto.getValor1()).isEqualTo("Test Create");
//
//        // Read
//        ResponseEntity<XptoDto> responseGet = restTemplate.getForEntity(baseUrl + "/" + createdXpto.getId(), XptoDto.class);
//        //Read confirmation
//        assertThat(responseGet.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(responseGet.getBody().getValor1()).isEqualTo("Test Create");
//
//        // Update
//        createdXpto.setValor1("Test Update");
//        restTemplate.put(baseUrl + "/" + createdXpto.getId(), createdXpto);
//        //Update confirmation
//        responseGet = restTemplate.getForEntity(baseUrl + "/" + createdXpto.getId(), XptoDto.class);
//        assertThat(responseGet.getBody().getValor1()).isEqualTo("Test Update");
//
//        // Delete
//        restTemplate.delete(baseUrl + "/" + createdXpto.getId());
//        ResponseEntity<String> responseDelete = restTemplate.getForEntity(baseUrl + "/" + createdXpto.getId(), String.class);
//        //Deletion confirmation
//        assertThat(responseDelete.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
//    }
//}
