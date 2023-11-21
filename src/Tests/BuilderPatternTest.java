package Tests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import Domain.Shipment;

public class BuilderPatternTest {

    @Test
    public void testShipmentBuilder() {

        Shipment shipment = Shipment.builder()
                .setShipmentId(1)
                .setOrderId(101)
                .setCompany("Test Company")
                .setPlace("Test Place")
                .build();


        assertEquals(1, shipment.getShipmentId());
        assertEquals(101, shipment.getOrderId());
        assertEquals("Test Company", shipment.getCompany());
        assertEquals("Test Place", shipment.getPlace());
    }
}
