
import busOperations.BussDestinationOperationImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class testJavaTables {
    
    BussDestinationOperationImpl buss = new BussDestinationOperationImpl();
    @Before
    public void setUp(){
        buss.setStartPointDertination("Tirane");
        buss.setEndPointDertination("Durres");
        buss.findBusDestinations();
    }
//    
//    @Test
//    public void testLengthOfElements(){
//        Assert.assertEquals(6, buss.getBussDestionation().size());
//    }
    
}
