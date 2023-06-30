import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {
    public static void createXmlFile() throws TransformerException, ParserConfigurationException {

        ArrayList<PowerTools> list = new ArrayList<PowerTools>();

        // Создание технических характеристик для электроинструментов
        ArrayList<TechnicalCharacteristic> tc1 = new ArrayList<TechnicalCharacteristic>();
        tc1.add(new TechnicalCharacteristic("Low", 10, true));
        tc1.add(new TechnicalCharacteristic("Medium", 20, false));

        ArrayList<TechnicalCharacteristic> tc2 = new ArrayList<TechnicalCharacteristic>();
        tc2.add(new TechnicalCharacteristic("High", 30, true));
        tc2.add(new TechnicalCharacteristic("Medium", 25, false));

        ArrayList<TechnicalCharacteristic> tc3 = new ArrayList<TechnicalCharacteristic>();
        tc3.add(new TechnicalCharacteristic("Medium", 15, true));
        tc3.add(new TechnicalCharacteristic("High", 35, true));

        list.add(new PowerTools("Model 1", "Single-handed", "USA", tc1, "Metal"));
        list.add(new PowerTools("Model 2", "Double-handed", "Germany", tc2, "Plastic"));
        list.add(new PowerTools("Model 3", "Single-handed", "China", tc3, "Metal"));

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.newDocument();
        Element rootElement = doc.createElement("PowerTools");
        doc.appendChild(rootElement);

        for (PowerTools tool : list) {
            Element toolElement = doc.createElement("Tool");
            rootElement.appendChild(toolElement);

            Element modelElement = doc.createElement("Model");
            modelElement.setTextContent(tool.getModel());
            toolElement.appendChild(modelElement);

            Element handyElement = doc.createElement("Handy");
            handyElement.setTextContent(tool.getHandy());
            toolElement.appendChild(handyElement);

            Element originElement = doc.createElement("Origin");
            originElement.setTextContent(tool.getOrigin());
            toolElement.appendChild(originElement);

            for (TechnicalCharacteristic tc : tool.getTC()) {
                Element tcElement = doc.createElement("TC");
                toolElement.appendChild(tcElement);

                Element energyElement = doc.createElement("EnergyConsumption");
                energyElement.setTextContent(tc.getEnergyConsumption());
                tcElement.appendChild(energyElement);

                Element performanceElement = doc.createElement("Performance");
                performanceElement.setTextContent(Integer.toString(tc.getPerformance()));
                tcElement.appendChild(performanceElement);

                Element autonomousElement = doc.createElement("Autonomous");
                autonomousElement.setTextContent(Boolean.toString(tc.isAutonomous()));
                tcElement.appendChild(autonomousElement);
            }

            Element materialElement = doc.createElement("Material");
            materialElement.setTextContent(tool.getMaterial());
            toolElement.appendChild(materialElement);
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("PowerTools.xml"));
        transformer.transform(source, result);

        System.out.println("XML file created successfully!");
    }

    public static void convertXmlWithXsl() throws TransformerException, FileNotFoundException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer(new javax.xml.transform.stream.StreamSource(
                new File("conversion.xsl")));
        transformer.transform(new javax.xml.transform.stream.StreamSource(new File("PowerTools.xml")),
                new javax.xml.transform.stream.StreamResult(new FileOutputStream("ConvertedPowerTools.xml")));

        System.out.println("XML file converted successfully using XSL transformation!");
    }

    public static void convertHTMLWithXsl() throws TransformerException, FileNotFoundException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer(new javax.xml.transform.stream.StreamSource(
                new File("transformation.xsl")));
        transformer.transform(new javax.xml.transform.stream.StreamSource(new File("PowerTools.xml")),
                new javax.xml.transform.stream.StreamResult(new FileOutputStream("ConvertedPowerTools.html")));

        System.out.println("XML file converted successfully to HTML using XSL transformation!");
    }



    public static void displayXmlFile() {
        try {
            File file = new File("PowerTools.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("Tool");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (((Node) node).getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    System.out.println("Model: " + element.getElementsByTagName("Model").item(0).getTextContent());
                    System.out.println("Handy: " + element.getElementsByTagName("Handy").item(0).getTextContent());
                    System.out.println("Origin: " + element.getElementsByTagName("Origin").item(0).getTextContent());

                    NodeList tcList = element.getElementsByTagName("TC");

                    for (int j = 0; j < tcList.getLength(); j++) {
                        Node tcNode = tcList.item(j);

                        if (tcNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element tcElement = (Element) tcNode;

                            System.out.println("Energy Consumption: "
                                    + tcElement.getElementsByTagName("EnergyConsumption").item(0).getTextContent());
                            System.out.println("Performance: "
                                    + tcElement.getElementsByTagName("Performance").item(0).getTextContent());
                            System.out.println("Autonomous: "
                                    + tcElement.getElementsByTagName("Autonomous").item(0).getTextContent());
                        }
                    }

                    System.out.println("Material: " + element.getElementsByTagName("Material").item(0).getTextContent());

                    System.out.println("-------------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int choice;

            System.out.println("Выберите действие:");
            System.out.println("1. create XML");
            System.out.println("2. convert XML");
            System.out.println("3. display XML");
            System.out.println("0. exit");

            do {
                System.out.print("Choose!!!: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        createXmlFile();
                        break;
                    case 2:
                        convertXmlWithXsl();
                        break;
                    case 3:
                        displayXmlFile();
                        break;
                    case 4:
                        convertHTMLWithXsl();
                    case 0:
                        System.out.println("Программа завершена.");
                        break;
                    default:
                        System.out.println("Некорректный выбор. Попробуйте еще раз.");
                        break;
                }
            } while (choice != 0);

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}