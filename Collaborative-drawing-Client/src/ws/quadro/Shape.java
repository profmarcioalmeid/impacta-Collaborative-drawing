/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ws.quadro;

/**
 *
 * @author marcio.mendes
 */
public interface Shape  {

     

    
    void getCanvasFormat();
    
    void svgToObj();
    public void setId(Long id);
    
    public void setX(Integer x);

    public void setY(Integer y);

    public void setZ(Integer z);

    public void setWidth(Integer width);

    public void setHeight(Integer height);

    public void setRadius(Integer radius);

    public void setStrokeWidth(Integer strokeWidth);

    public void setColor(String color);

    public void setStroke(String stroke);

    public void setFill(String fill);
    
    public void setSvg(String svg);     
    
    public Long getId();
     
    public Integer getX();

    public Integer getY();

    public Integer getZ();

    public Integer getWidth();

    public Integer getHeight();

    public Integer getRadius();

    public Integer getStrokeWidth();

    public String getColor();

    public String getStroke();

    public String getFill();

    public String getSvg();
    
    public void updateSvg();
    
    public boolean isValid();
   
    
}
