import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.json.JSONObject;
import org.json.XML;

import static com.sun.org.apache.xml.internal.serialize.Method.XML;

public class Convertidor {

    /**
     * Metodo para convertir Clase a JSON
     * @param clase texto en formato clase para convertir
     * @return Clase convertira a JSON
     */
    public String convertirClaseToJson(String clase){
        Gson gson  = new Gson();
        String cadena = gson.toJson(clase);
        return cadena;
    }

    /**
     * Metodo para convertir Clase a JSON
     * @param xml texto en formato xml para convertir
     * @return xml convertira a JSON
     */
    public String convertirXmlToJson(String xml, int ident){
        JSONObject jo = org.json.XML.toJSONObject(xml);
        String cadena = jo.toString(ident);
        return cadena;
    }

}
