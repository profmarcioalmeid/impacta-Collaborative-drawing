package ws.quadro;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author marcio.mendes
 */
public class Circle extends Observable implements Shape  {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String svg;
    private Integer x, y, z, width, height, radius, strokeWidth;
    private String color, stroke, fill;

    
     public Circle( Circle c){
           
     }
    
    
    public Circle() {
        this.svg="";
        this.fill="";
        this.stroke="";
        this.color="";
    }

    
    public Circle(Long id, Integer cx, Integer cy, Integer r, String stroke, String fill, Integer strokeWidth) {
        this.id = id;
        this.x = cx;
        this.y = cy;
        this.radius = r;
        this.stroke = stroke;
        this.fill = fill;
        this.strokeWidth = strokeWidth;
        this.svg = " <circle id=\"" + this.id + "\" cx=\"" + this.x + "\" cy=\"" + this.y + "\" r=\"" + this.radius + "\" stroke=\"" + this.stroke + "\" stroke-width=\"" + this.strokeWidth + "\" fill=\"" + this.fill + "\" />\n";
    }
 @Override
    public void setId(Long id) {
       if (!Objects.equals(id, this.id)) {
            System.err.println(this.id + " changed to " + id);
            setChanged();        // mark as value changed
            this.id = id;
            updateSvg();
          //  notifyObservers();// trigger notification
        }
    }
    
    @Override
    public void setX(Integer x) {
        if (!Objects.equals(x, this.x)) {
            System.err.println(this.x + " changed to " + x);
            setChanged();        // mark as value changed
            this.x = x;
            updateSvg();
          //  notifyObservers();// trigger notification
        }
    }

    @Override
    public void setY(Integer y) {

        if (!Objects.equals(y, this.y)) {
            System.err.println(this.y + " changed to " + y);
            setChanged();        // mark as value changed
            this.y = y;
            updateSvg();
            //notifyObservers();// trigger notification
        }
    }

    @Override
    public void setZ(Integer z) {

        if (!Objects.equals(z, this.z)) {
            System.err.println(this.z + " changed to " + z);
            setChanged();        // mark as value changed
            this.z = z;
            updateSvg();
           // notifyObservers();// trigger notification
        }
    }

    @Override
    public void setWidth(Integer width) {

        if (!Objects.equals(width, this.width)) {
            System.err.println(this.width + " changed to " + width);
            setChanged();        // mark as value changed
            this.width = width;
            updateSvg();
           // notifyObservers();// trigger notification
        }
    }

    @Override
    public void setHeight(Integer height) {

        if (!Objects.equals(height, this.height)) {
            System.err.println(this.height + " changed to " + height);
            setChanged();        // mark as value changed
            this.height = height;
            updateSvg();
           // notifyObservers();// trigger notification
        }
    }

    @Override
    public void setRadius(Integer radius) {

        if (!Objects.equals(radius, this.radius)) {
            System.err.println(this.radius + " changed to " + radius);
            setChanged();        // mark as value changed
            this.radius = radius;
            updateSvg();
           // notifyObservers();// trigger notification
        }
    }

    @Override
    public void setStrokeWidth(Integer strokeWidth) {

        if (!Objects.equals(strokeWidth, this.strokeWidth)) {
            System.err.println(this.strokeWidth + " changed to " + strokeWidth);
            setChanged();        // mark as value changed
            this.strokeWidth = strokeWidth;
            updateSvg();
           // notifyObservers();// trigger notification
        }

    }

    @Override
    public void setColor(String color) {

        if (!this.color.equals(color)) {
            System.err.println(this.color + " changed to " + color);
            setChanged();        // mark as value changed
            this.color = color;
            updateSvg();
           // notifyObservers();// trigger notification
        }
    }

    @Override
    public void setStroke(String stroke) {

        if (!this.stroke.equals(stroke)) {
            System.err.println(this.stroke + " changed to " + stroke);
            setChanged();        // mark as value changed
            this.stroke = stroke;
            updateSvg(); 
          //  notifyObservers();// trigger notification
        }
      
    }

    @Override
    public void setFill(String fill) {
        if (!this.fill.equals(fill)) {
            System.err.println(this.fill +" changed to" + fill);
            setChanged();        // mark as value changed
            this.fill = fill;
          //   updateSvg(); 
        //    notifyObservers();// trigger notification
        }
    }

    
    @Override
    public void setSvg(String svg) {
        if (!this.svg.equals(svg)) {
            System.err.println(this.svg +" changed to " + svg);
            this.svg = svg;
            svgToObj();
            
            setChanged();        // mark as value changed
            notifyObservers();// trigger notification
        }
       
    }

    
    
    @Override
    public String getSvg() {
        return this.svg;
    }

    @Override
    public void getCanvasFormat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }
    
    @Override
    public Integer getX() {
        return x;
    }

    @Override
    public Integer getY() {
        return y;
    }

    @Override
    public Integer getZ() {
        return z;
    }

    @Override
    public Integer getWidth() {
        return width;
    }

    @Override
    public Integer getHeight() {
        return height;
    }

    @Override
    public Integer getRadius() {
        return radius;
    }

    @Override
    public Integer getStrokeWidth() {
        return strokeWidth;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getStroke() {
        return stroke;
    }

    @Override
    public String getFill() {
        return fill;
    }

  
    @Override
    public void svgToObj() {

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = builderFactory.newDocumentBuilder();
            Document xmlDocument = builder.parse(new ByteArrayInputStream(this.getSvg().getBytes()));

            XPath xPath = XPathFactory.newInstance().newXPath();
            String tmp;
            
            if (this.id == null) {
                String expressionId = "/circle[1]/@id";
                tmp = xPath.compile(expressionId).evaluate(xmlDocument);
                this.id = Long.parseLong(tmp);

            }
            String expressionCx = "//*[@id=\"" + this.id + "\"]/@cx";
            String expressionCy = "//*[@id=\"" + this.id + "\"]/@cy";
            String expressionR = "//*[@id=\"" + this.id + "\"]/@r";
            String expressionStroke = "//*[@id=\"" + this.id + "\"]/@stroke";
            String expressionStrokeWidth = "//*[@id=\"" + this.id + "\"]/@stroke-width";
            String expressionFill = "//*[@id=\"" + this.id + "\"]/@fill";

            
            try {
                tmp = xPath.compile(expressionCx).evaluate(xmlDocument);
                if( isValid(tmp)) this.x = Integer.parseInt(tmp);
                
                tmp = xPath.compile(expressionCy).evaluate(xmlDocument);
                if( isValid(tmp)) this.y = Integer.parseInt(tmp);
                
                tmp = xPath.compile(expressionR).evaluate(xmlDocument);
                if( isValid(tmp)) this.radius = Integer.parseInt(tmp);

                this.stroke = xPath.compile(expressionStroke).evaluate(xmlDocument);
                
                tmp = xPath.compile(expressionStrokeWidth).evaluate(xmlDocument);
                if( isValid(tmp)) this.strokeWidth = Integer.parseInt(tmp);
                
                this.fill = xPath.compile(expressionFill).evaluate(xmlDocument);

            } catch (XPathExpressionException ex) {
                Logger.getLogger(Circle.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SAXException | IOException e) {
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Circle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XPathExpressionException ex) {
            Logger.getLogger(Circle.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void updateSvg() {
        if(!isValid()){
            System.err.println(" SVG inválido !");
        }else{
            
        this.svg =" <circle id=\"" + this.id + "\" cx=\"" + this.x + "\" cy=\"" + this.y + "\" r=\"" + this.radius + "\" stroke=\"" + this.stroke + "\" stroke-width=\"" + this.strokeWidth + "\" fill=\"" + this.fill + "\" />\n";
        System.out.println(" SVG Atualizado!");
        }
    }
    
    @Override
   public boolean isValid(){
      return this.getX()!=null && this.getY()!= null && this.getX()!= null;
    }

  public boolean isValid( String o ){
     return  o!=null && !o.isEmpty();
  }
 
  
 
   

   

}
