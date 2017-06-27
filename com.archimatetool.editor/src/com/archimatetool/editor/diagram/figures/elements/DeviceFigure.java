/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.editor.diagram.figures.elements;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import com.archimatetool.editor.diagram.figures.AbstractTextControlContainerFigure;
import com.archimatetool.model.IDiagramModelArchimateObject;

/**
 * Figure for a Device
 * 
 * @author Phillip Beauvoir
 */
public class DeviceFigure extends AbstractTextControlContainerFigure {
    
//    protected IFigureDelegate fFigureDelegate;
    
    public DeviceFigure() {
        super(TEXT_FLOW_CONTROL);
//        fFigureDelegate = new BoxFigureDelegate(this, 20 - getTextControlMarginWidth());
    }
    
    @Override
    public void drawFigure(Graphics graphics) {
        super.drawFigure(graphics);
        drawIcon(graphics);
    }
    
    /**
     * Draw the icon
     */
    protected void drawIcon(Graphics graphics) {
        graphics.pushState();
        
        graphics.setLineWidth(1);
        graphics.setForegroundColor(isEnabled() ? ColorConstants.black : ColorConstants.gray);
        
        Point pt = getIconOrigin();
        
        graphics.drawRoundRectangle(new Rectangle(pt.x, pt.y, 11, 8), 3, 3);
        
        graphics.drawPolygon(new int[] {
                pt.x - 1, pt.y + 12,
                pt.x + 2, pt.y + 8,
                pt.x + 9, pt.y + 8,
                pt.x + 12, pt.y + 12
        });
        
        graphics.popState();
    }
    
    /**
     * @return The icon start position
     */
    protected Point getIconOrigin() {
        Rectangle bounds = getBounds();
        return new Point(bounds.x + bounds.width - 31, bounds.y + 20);
    }
    
//    @Override
//    public IFigureDelegate getFigureDelegate() {
//        int type = getDiagramModelObject().getType();
//        return type == 1 ? fFigureDelegate : null;
//    }
    
    @Override
    public IDiagramModelArchimateObject getDiagramModelObject() {
        return (IDiagramModelArchimateObject)super.getDiagramModelObject();
    }

}