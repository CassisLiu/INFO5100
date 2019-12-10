package m3.model.TableOperation;



import java.io.IOException;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

import m3.model.Incentive;

public class DataFormatConversion {

    public static String FilterToString(Incentive I) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String filterList = null;
		try {
			filterList = mapper.writeValueAsString(I.getConditions());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //convert filter list to string
        return filterList;
    }
    
    
    
    public static String OfferToString(Incentive I) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String Offer = null;
		try {
			Offer = mapper.writeValueAsString(I.getOffer());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //convert offer to string
        return Offer;
    }

}
