package bednarhalaj.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class PositionTest {
    @Test
    public void positionBuild(){
        Position position = new Position.Builder("accountant")
                .departmentId(32)
                .baseSalary(new BigDecimal("2520.5"))
                .idPosition(752)
                .build();
        Assertions.assertEquals("accountant", position.getName());
        Assertions.assertEquals(32, position.getDepartmentId());
        Assertions.assertEquals(new BigDecimal("2520.5"), position.getBaseSalary());
        Assertions.assertEquals(752, position.getIdPosition());
    }
}
