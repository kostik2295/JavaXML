import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class PowerTools {
    private String Model;
    private String Handy;
    private String Origin;
    private ArrayList<TechnicalCharacteristic> TC;
    private String Material;

    public PowerTools(String Model, String Handy, String Origin, ArrayList<TechnicalCharacteristic> TC,
                      String Material) {
        this.Model = Model;
        this.Handy = Handy;
        this.Origin = Origin;
        this.TC = TC;
        this.Material = Material;
    }

    @Override
    public String toString() {
        return "Model: " + Model + ", Handy: " + Handy + ", Origin: " + Origin + ", TC: " + TC + ", Material: "
                + Material;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public String getHandy() {
        return Handy;
    }

    public void setHandy(String Handy) {
        this.Handy = Handy;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String Origin) {
        this.Origin = Origin;
    }

    public ArrayList<TechnicalCharacteristic> getTC() {
        return TC;
    }

    public void setTC(ArrayList<TechnicalCharacteristic> TC) {
        this.TC = TC;
    }

    public String getMaterial() {
        return Material;
    }

    public void setMaterial(String Material) {
        this.Material = Material;
    }
}