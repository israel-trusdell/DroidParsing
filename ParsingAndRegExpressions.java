package parsing.and.reg.expressions;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.w3c.dom.Text;
import java.io.FileOutputStream;

import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import java.io.IOException;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import static java.util.Collections.list;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class ParsingAndRegExpressions {

    public static int droid_total;


    public static void main(String[] args) throws FileNotFoundException, ParserConfigurationException, IOException {

        //opening file
        File file = new File("C:\Java_WorkSpace\DroidParse\Resource\droids_in.txt");
        Scanner droid_file = new Scanner(file);

        String droidStr;
        String R = "(R[2-5][A-Z][0-9]|R[2-5]-[A-Z][0-9])|"
                + "(P2[A-Z][0-9]|P2-[A-Z][0-9])|"
                + "([^-]{4}R4-P[0-9][0-9])"
                + "|(BB-[0-9][A-Z][0-9]|BB-[0-9]|BB-[0-9][A-Z])"
                + "|([A-Z]-3PO|[A-Z][0-9]-3PO)"
                + "|(TC-[0-9][0-9])"
                + "|(IG-[0-9A-Z][0-9A-Z])"
                + "|(>[0-9]{3,5}.[0-9]{2}|>[0-9]{3,5})";
        String costT =">";
        String g1 = null;
        String cc = null;
 
        
        int group1 = 0, group2 = 0, group3 = 0, group4 = 0, group5 = 0, group6 = 0, group7 = 0;
        //Droids lists
        ArrayList<String> d1 = new ArrayList<>(); 
        ArrayList<String> d2 = new ArrayList<>(); 
        ArrayList<String> d3 = new ArrayList<>(); 
        ArrayList<String> d4 = new ArrayList<>(); 
        ArrayList<String> d5 = new ArrayList<>(); 
        ArrayList<String> d6 = new ArrayList<>(); 
        ArrayList<String> d7 = new ArrayList<>(); 
        //Cost lists  for droids
        ArrayList<String> c1 = new ArrayList<>(); 
        ArrayList<String> c2 = new ArrayList<>(); 
        ArrayList<String> c3 = new ArrayList<>(); 
        ArrayList<String> c4 = new ArrayList<>(); 
        ArrayList<String> c5 = new ArrayList<>(); 
        ArrayList<String> c6 = new ArrayList<>(); 
        ArrayList<String> c7 = new ArrayList<>(); 
        //Cost list in int
        ArrayList<Integer> nc1 = new ArrayList<>(); 
        ArrayList<Integer> nc2 = new ArrayList<>(); 
        ArrayList<Integer> nc3 = new ArrayList<>(); 
        ArrayList<Integer> nc4 = new ArrayList<>(); 
        ArrayList<Integer> nc5 = new ArrayList<>(); 
        ArrayList<Integer> nc6 = new ArrayList<>(); 
        ArrayList<Integer> nc7 = new ArrayList<>();
        //getting lines from file
        while (droid_file.hasNext()) {
           // System.out.println(line++);
            droidStr = droid_file.nextLine();

            Pattern check = Pattern.compile("R4-P[0-9]");
            Matcher regex = check.matcher(droidStr);
            Pattern checkRegex = Pattern.compile(R);
            Matcher regexMatcher = checkRegex.matcher(droidStr);
            
            Pattern c = Pattern.compile(costT);
            

            //checking for the droid
            while (regexMatcher.find()) {
                //String copystr = regexMatcher.group();
                //System.out.println(copystr);
                
                if (regexMatcher.group().equals(regexMatcher.group(3))){   
                    g1 = regexMatcher.group();
                    StringBuffer sb = new StringBuffer(regexMatcher.group());
                    
                    regexMatcher.appendReplacement(sb,"");
                    
                    if (regexMatcher.find(regexMatcher.end(3))) { 
                        cc= regexMatcher.group();
                        c3.add(cc);
                        d3.add(g1); 
                        System.out.println("Droid : " + g1 + " Cost: " + regexMatcher.group());                        
                        group3++; 
                        
                        
                    }    
                   
                } else if (regexMatcher.group().equals(regexMatcher.group(2))) {
                    g1 = regexMatcher.group();
                    if (regexMatcher.find(regexMatcher.end(2))) {
                        cc= regexMatcher.group();
                        c2.add(cc);
                        d2.add(g1); 
                        System.out.println("Droid : " + g1 + " Cost: " + regexMatcher.group());
                        group2++;
                    }
                } else if (regexMatcher.group().equals(regexMatcher.group(1))) {
                    
                    if(!regex.find()){
                    g1 = regexMatcher.group();
           
                    if (regexMatcher.find(regexMatcher.end(1))) {
                        cc= regexMatcher.group();
                        c1.add(cc);
                        d1.add(g1);                        
                        System.out.println("Droid : " + g1 + " Cost: " + regexMatcher.group());  
                                       
                        group1++;
                    }
                    }
                } else if (regexMatcher.group().equals(regexMatcher.group(4))) {
                    g1 = regexMatcher.group();
                    if (regexMatcher.find(regexMatcher.end(4))) {
                        cc= regexMatcher.group();
                        c4.add(cc);
                        d4.add(g1); 
                        System.out.println("Droid : " + g1 + " Cost: " + regexMatcher.group());
                        group4++;
                    }
                } else if (regexMatcher.group().equals(regexMatcher.group(5))) {
                    g1 = regexMatcher.group();
                    if (regexMatcher.find(regexMatcher.end(5))) {
                        cc= regexMatcher.group();
                        c5.add(cc);
                        d5.add(g1); 
                        System.out.println("Droid : " + g1 + " Cost: " + regexMatcher.group());
                        group5++;
                    }
                } else if (regexMatcher.group().equals(regexMatcher.group(6))) {
                    g1 = regexMatcher.group();
                    if (regexMatcher.find(regexMatcher.end(6))) {
                        cc= regexMatcher.group();
                        c6.add(cc);
                        d6.add(g1); 
                        System.out.println("Droid : " + g1 + " Cost: " + regexMatcher.group());
                        group6++;
                    }
                } else if (regexMatcher.group().equals(regexMatcher.group(7))) {
                    g1 = regexMatcher.group();
                    if (regexMatcher.find(regexMatcher.end(7))) {
                        cc= regexMatcher.group();
                        c7.add(cc);
                        d7.add(g1); 
                        System.out.println("Droid : " + g1 + " Cost: " + regexMatcher.group());
                        group7++;
                    }
                } else {
                    System.out.println("No matching Droid for Cost");
                }

            }

        }
         
            
        for(int i=0; i< d1.size();i++){         
            c1.set(i,removeCharAt(c1.get(i),0)); 
            if(!c1.get(i).contains(".")){
                c1.set(i,c1.get(i)+"00");                
            }else {
                int len = c1.get(i).length() -3;
                c1.set(i,removeCharAt(c1.get(i),len ));                
            }              
        }
        for(int i=0; i< d2.size();i++){                  
            c2.set(i,removeCharAt(c2.get(i),0));        
            if(!c2.get(i).contains(".")){
                c2.set(i,c2.get(i)+"00");                
            }else {
                int len = c2.get(i).length() -3;
                c2.set(i,removeCharAt(c2.get(i),len ));                
            }
        }
        for(int i=0; i< d3.size();i++){            
            c3.set(i,removeCharAt(c3.get(i),0));
            if(!c3.get(i).contains(".")){
                c3.set(i,c3.get(i)+"00");                
            }else {
                int len = c3.get(i).length() -3;
                c3.set(i,removeCharAt(c3.get(i),len ));                
            }
        }
        for(int i=0; i< d4.size();i++){            
            c4.set(i,removeCharAt(c4.get(i),0)); 
            if(!c4.get(i).contains(".")){
                c4.set(i,c4.get(i)+"00");                 
            }else {
                int len = c4.get(i).length() -3;
                c4.set(i,removeCharAt(c4.get(i),len ));                
            }
        }
        for(int i=0; i< d5.size();i++){            
            c5.set(i,removeCharAt(c5.get(i),0));  
            if(!c5.get(i).contains(".")){
                c5.set(i,c5.get(i)+"00");                
            }else {
                int len = c5.get(i).length() -3;
                c5.set(i,removeCharAt(c5.get(i),len ));                
            }
        }
        for(int i=0; i< d6.size();i++){            
            c6.set(i,removeCharAt(c6.get(i),0));  
            if(!c6.get(i).contains(".")){
                c6.set(i,c6.get(i)+"00");                
            }else {
                int len = c6.get(i).length() -3;
                c6.set(i,removeCharAt(c6.get(i),len ));                
            }
        }
        for(int i=0; i< d7.size();i++){            
            c7.set(i,removeCharAt(c7.get(i),0));  
            if(!c7.get(i).contains(".")){
                c7.set(i,c7.get(i)+"00");                
            }else {
                int len = c7.get(i).length() -3;
                c7.set(i,removeCharAt(c7.get(i),len ));                
            }
        }
        
        c1.forEach((str) -> {
            nc1.add(Integer.parseInt(str));
        });
        c2.forEach((str) -> {
            nc2.add(Integer.parseInt(str));
        });
        c3.forEach((str) -> {
            nc3.add(Integer.parseInt(str));
        });
        c4.forEach((str) -> {
            nc4.add(Integer.parseInt(str));
        });
        c5.forEach((str) -> {
            nc5.add(Integer.parseInt(str));
        });
        c6.forEach((str) -> {
            nc6.add(Integer.parseInt(str));
        });
        c7.forEach((str) -> {
            nc7.add(Integer.parseInt(str));
        });

        //Collections.sort(nc1);
        
        PrintWriter write = new PrintWriter("droidcostlist.txt");
                write.println("*****************************");
                write.println("* R# Units                  *");
                write.println("*****************************");
                write.println(group1 + " R# units available");
                write.println("--Name------------Price-----");
            for(int i=0; i< d1.size();i++){
                double aD = nc1.get(i)*.01;
                write.printf("%s           %.2f  Cr%n",d1.get(i),aD);                
            }
                write.println("*****************************");
                write.println("* P2 Units                  *");
                write.println("*****************************");
                write.println(group2 + " R# units available");
                write.println("--Name------------Price-----");
            for(int i=0; i< d2.size();i++){
                double aD = nc2.get(i)*.01;
                write.printf("%s           %.2f  Cr%n",d2.get(i),aD);                
            }
                write.println("*****************************");
                write.println("* R4 Units                  *");
                write.println("*****************************");
                write.println(group3 + " R4 units available");
                write.println("--Name------------Price-----");
            for(int i=0; i< d3.size();i++){
                double aD = nc3.get(i)*.01;
                write.printf("%s           %.2f  Cr%n",d3.get(i),aD);                
            }
                write.println("*****************************");
                write.println("* BB Units                  *");
                write.println("*****************************");
                write.println(group4 + " BB units available");
                write.println("--Name------------Price-----");
            for(int i=0; i< d4.size();i++){
                double aD = nc4.get(i)*.01;
                write.printf("%s           %.2f  Cr%n",d4.get(i),aD);                
            }
                write.println("*****************************");
                write.println("* 3PO Units                 *");
                write.println("*****************************");
                write.println(group5 + " 3PO units available");
                write.println("--Name------------Price-----");
            for(int i=0; i< d5.size();i++){
                double aD = nc5.get(i)*.01;
                write.printf("%s           %.2f  Cr%n",d5.get(i),aD);                
            }
                write.println("*****************************");
                write.println("* TC Units                  *");
                write.println("*****************************");
                write.println(group6 + " TC units available");
                write.println("--Name------------Price-----");
            for(int i=0; i< d6.size();i++){
                double aD = nc6.get(i)*.01;
                write.printf("%s           %.2f  Cr%n",d6.get(i),aD);                
            }
                write.println("*****************************");
                write.println("* IG Units                  *");
                write.println("*****************************");
                write.println(group7 + " IG units available");
                write.println("--Name------------Price-----");
            for(int i=0; i< d7.size();i++){
                double aD = nc7.get(i)*.01;
                write.printf("%s           %.2f  Cr%n",d7.get(i),aD);                
            }
                write.println("*****************************");
           write.close();
           
        

        System.out.println("R# standard astromech droids: " + group1);
        System.out.println("P2-series astromech droids: " + group2);
        System.out.println("R4-P## series astromech droids: " + group3);
        System.out.println("BB series astromech droids: " + group4);
        System.out.println("3PO protocol droids: " + group5);
        System.out.println("TC protocol droids: " + group6);
        System.out.println("IG assassin droids: " + group7);
        System.out.println(d1.size() +"" + c1.size());

        for(int i=0; i< d1.size();i++){
            System.out.println("R# droids: "+d1.get(i));
            System.out.println("Cost CRD:  "+c1.get(i));            
        }
        
        droid_file.close();
        
      
        
        
        
        
        
        // creating XML doc
        //Doc builderfactory
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        //doc builder
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        //document
        Document xmlDoc = docBuilder.newDocument();
        //buiding XML         
        //root element
        Element rootElement = xmlDoc.createElement("Droid");
        //second level droid type
        Element mainElementAstro = xmlDoc.createElement("Astromech");
            //third level droid type
            Element SubElementR = xmlDoc.createElement("R-Series");
                mainElementAstro.appendChild(SubElementR);
            Element SubElementP = xmlDoc.createElement("P-Series");
                mainElementAstro.appendChild(SubElementP);
            Element SubElementR4 = xmlDoc.createElement("R4-Series");
                mainElementAstro.appendChild(SubElementR4);                
        //second level droid type        
        Element mainElementBB = xmlDoc.createElement("BB-Series");
        //second level droid type
        Element mainElementProto = xmlDoc.createElement("Protocol");
             //third level droid type
            Element SubElement3po = xmlDoc.createElement("ThreePO");
                mainElementProto.appendChild(SubElement3po);
            Element SubElementTC = xmlDoc.createElement("TC-Series");
                mainElementProto.appendChild(SubElementTC);
        //second level droid type        
        Element mainElementIG = xmlDoc.createElement("IG-Assassin");
        //third level droid names w/cost
        //AstroMech as parent      
         
        for(int i=0; i< d1.size();i++){//R-Series
            double aD = nc1.get(i)*.01;
           Element droidNameAstro = xmlDoc.createElement("name");
                SubElementR.appendChild(droidNameAstro);
            Text droidName= xmlDoc.createTextNode(d1.get(i)); 
                droidNameAstro.appendChild(droidName);
            Element droidCostAstro = xmlDoc.createElement("cost");
                droidCostAstro.setAttribute("Currency","Imerial Credits");
                droidNameAstro.appendChild(droidCostAstro);
            Text droidCost= xmlDoc.createTextNode(Double.toString(aD)); 
                droidCostAstro.appendChild(droidCost);
        }
        for(int i=0; i< d2.size();i++){//P-Series
            double aD = nc2.get(i)*.01;
           Element droidNameP = xmlDoc.createElement("name");
                SubElementP.appendChild(droidNameP);
            Text droidName= xmlDoc.createTextNode(d2.get(i)); 
                droidNameP.appendChild(droidName);
            Element droidCostP = xmlDoc.createElement("cost");
            droidCostP.setAttribute("Currency","Imerial Credits");
                droidNameP.appendChild(droidCostP);
            Text droidCost= xmlDoc.createTextNode(Double.toString(aD)); 
                droidCostP.appendChild(droidCost);
        }
        for(int i=0; i< d3.size();i++){//R4-Series
            double aD = nc3.get(i)*.01;
           Element droidNameR4 = xmlDoc.createElement("name");
                SubElementR4.appendChild(droidNameR4);
            Text droidName= xmlDoc.createTextNode(d3.get(i)); 
                droidNameR4.appendChild(droidName);
            Element droidCostR4 = xmlDoc.createElement("cost");
            droidCostR4.setAttribute("Currency","Imerial Credits");
                droidNameR4.appendChild(droidCostR4);
            Text droidCost= xmlDoc.createTextNode(Double.toString(aD)); 
                droidCostR4.appendChild(droidCost);
        }
        for(int i=0; i< d4.size();i++){//BB-Series
            double aD = nc4.get(i)*.01;
           Element droidNameBB = xmlDoc.createElement("name");
                mainElementBB.appendChild(droidNameBB);
            Text droidName= xmlDoc.createTextNode(d4.get(i)); 
                droidNameBB.appendChild(droidName);
            Element droidCostBB = xmlDoc.createElement("cost");
            droidCostBB.setAttribute("Currency","Imerial Credits");
                droidNameBB.appendChild(droidCostBB);
            Text droidCost= xmlDoc.createTextNode(Double.toString(aD)); 
                droidCostBB.appendChild(droidCost);
        }
        //Protocol as parent
        for(int i=0; i< d5.size();i++){//3PO
            double aD = nc5.get(i)*.01;
           Element droidName3po = xmlDoc.createElement("name");
                SubElement3po.appendChild(droidName3po);
            Text droidName= xmlDoc.createTextNode(d5.get(i)); 
                droidName3po.appendChild(droidName);
            Element droidCost3po = xmlDoc.createElement("cost");
            droidCost3po.setAttribute("Currency","Imerial Credits");
                droidName3po.appendChild(droidCost3po);
            Text droidCost= xmlDoc.createTextNode(Double.toString(aD)); 
                droidCost3po.appendChild(droidCost);
        }
        for(int i=0; i< d6.size();i++){//TC-Series
            double aD = nc6.get(i)*.01;
           Element droidNameTC = xmlDoc.createElement("name");
                SubElementTC.appendChild(droidNameTC);
            Text droidName= xmlDoc.createTextNode(d6.get(i)); 
                droidNameTC.appendChild(droidName);
            Element droidCostTC= xmlDoc.createElement("cost");
            droidCostTC.setAttribute("Currency","Imerial Credits");
                droidNameTC.appendChild(droidCostTC);
            Text droidCost= xmlDoc.createTextNode(Double.toString(aD)); 
                droidCostTC.appendChild(droidCost);
        }
        for(int i=0; i< d7.size();i++){//IG Assasin
            double aD = nc7.get(i)*.01;
           Element droidNameIG = xmlDoc.createElement("name");
                mainElementIG.appendChild(droidNameIG);
            Text droidName= xmlDoc.createTextNode(d7.get(i)); 
                droidNameIG.appendChild(droidName);
            Element droidCostIG= xmlDoc.createElement("cost");
            droidCostIG.setAttribute("Currency","Imerial Credits");
                droidNameIG.appendChild(droidCostIG);
            Text droidCost= xmlDoc.createTextNode(Double.toString(aD)); 
                droidCostIG.appendChild(droidCost);
        }
     
        //creating tree
        rootElement.appendChild(mainElementAstro);
        rootElement.appendChild(mainElementBB);
        rootElement.appendChild(mainElementProto);
        rootElement.appendChild(mainElementIG);
        
        xmlDoc.appendChild(rootElement);
        //set output format
        OutputFormat outFormat = new OutputFormat(xmlDoc);
        outFormat.setIndenting(true);
        //declare file
        File xmlFile = new File("droidlist.xml");
        //declare file OS
        FileOutputStream outStream = new FileOutputStream(xmlFile);
        // XML serializer to serializ XML data
        XMLSerializer serializer = new XMLSerializer (outStream, outFormat);
        // sepecified OutputFormat
        serializer.serialize(xmlDoc);
    }

public static String removeCharAt(String s, int pos) {
      return s.substring(0, pos) + s.substring(pos + 1);
   }

}

/*
Check the string for droids. then prices. if there are 2 droids then check for the 
amount of prices. if the prices are 2 the mathch then but if there are 2 droids 
and one price then mathch the price to the clostest droid.

R#          "R[2-5][A-Z][0-9]|R[2-5](-)?[A-Z][0-9]"
P2-series   "P2[A-Z][0-9]|P2(-)?[A-Z][0-9]
R4-P##      "R4-P[0-9][0-9]"
BB          "BB-[0-9]|BB-[0-9][A-Z]|BB-[0-9][A-Z][0-9]"
3PO         "[A-Z]-3PO|[A-Z][0-9]-3PO"
TC          "TC-[0-9][0-9]"
IG          "IG-[0-9A-Z][0-9A-Z]"
 */
