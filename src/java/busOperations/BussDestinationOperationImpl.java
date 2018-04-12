package busOperations;

import DatabaseOperation.DatabaseInstance;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Olti
 */
@ManagedBean(name = "buss")
public class BussDestinationOperationImpl implements BussDestinationsOperation {

    private String seatPlace;
    private String bussIndentificationStrip;
    private Buss buss;
    ArrayList<Buss> arrayList;
    private PreparedStatement pstmt = null;
    private ResultSet rs;
    private String startPointDertination;
    private String endPointDertination;
    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

    public void setStartPointDertination(String startPointDertination) {
        this.startPointDertination = startPointDertination;
    }

    public void setEndPointDertination(String endPointDertination) {
        this.endPointDertination = endPointDertination;
    }

    public String getStartPointDertination() {
        return startPointDertination;
    }

    public String getEndPointDertination() {
        return endPointDertination;
    }

    public String getSeatPlace() {
        return seatPlace;
    }

    public void setSeatPlace(String seatPlace) {
        this.seatPlace = seatPlace;
    }

    public String getBussIndentificationStrip() {
        return bussIndentificationStrip;
    }

    public void setBussIndentificationStrip(String bussIndentificationStrip) {
        this.bussIndentificationStrip = bussIndentificationStrip;
    }

    @Override
    public void findBusDestinations() {
        arrayList = new ArrayList<>();
        try {
            String searchQuery = "SELECT * FROM busdestinations WHERE startP=? AND endP=?";
            pstmt = DatabaseInstance.getConnection().prepareStatement(searchQuery);
            pstmt.setString(1, getStartPointDertination());
            pstmt.setString(2, getEndPointDertination());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                buss = new Buss(
                        rs.getString("startP"),
                        rs.getString("endP"),
                        rs.getString("startPTime"),
                        rs.getString("endPTime"),
                        rs.getString("busId")
                );
                arrayList.add(buss);
            }
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void select() {
        System.out.println("thiss butttonnn should work");
    }

    public void makeRezervation() throws SQLException {
        pstmt = DatabaseInstance.getConnection().prepareStatement("INSERT INTO bussreservationseat(seatPlace, idOfBuss) VALUES(?, ?)");
        pstmt.setString(1, getSeatPlace());
        pstmt.setString(2, getBussIndentificationStrip());
        pstmt.executeUpdate();
        pstmt.close();

    }

    public ArrayList<Buss> getListOfDestionations() {
        return arrayList;
    }

    public static class Buss {

        public Buss(String startP, String endP, String startPTime, String endPTime, String bussId) {
            this.startP = startP;
            this.endP = endP;
            this.startPTime = startPTime;
            this.endPTime = endPTime;
            this.bussId = bussId;
        }

        public String getStartP() {
            return startP;
        }

        public String getEndP() {
            return endP;
        }

        public String getStartPTime() {
            return startPTime;
        }

        public String getEndPTime() {
            return endPTime;
        }

        public String getBussId() {
            return bussId;
        }

        private final String startP;
        private final String endP;
        private final String startPTime;
        private final String endPTime;
        private final String bussId;

    }
}
