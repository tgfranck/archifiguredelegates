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
import org.eclipse.swt.graphics.Path;

import com.archimatetool.editor.diagram.figures.AbstractTextControlContainerFigure;
import com.archimatetool.editor.diagram.figures.IFigureDelegate;
import com.archimatetool.model.IDiagramModelArchimateObject;

/**
 * Event Figure
 * 
 * @author Phillip Beauvoir
 */
public class EventFigure extends AbstractTextControlContainerFigure {
    
    protected IFigureDelegate fMainFigureDelegate;

    public EventFigure() {
        super(TEXT_FLOW_CONTROL);
        //fMainFigureDelegate = new RoundedRectangleFigureDelegate(this, 22 - getTextControlMarginWidth());
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
        
        Path path = new Path(null);
        
        // arc
        path.moveTo(pt.x, pt.y);
        path.addArc(pt.x - 4, pt.y, 8, 9, 270, 180);
        graphics.drawPath(path);
        path.dispose();
        
        path = new Path(null);
        path.moveTo(pt.x, pt.y);
        path.addArc(pt.x + 8, pt.y, 8, 9, 270, 180);

        // lines
        path.moveTo(pt.x, pt.y);
        path.lineTo(pt.x + 12, pt.y);
        
        path.moveTo(pt.x, pt.y + 9);
        path.lineTo(pt.x + 12, pt.y + 9);
        
        graphics.drawPath(path);
        path.dispose();
        
        graphics.popState();
    }
    
    /**
     * @return The icon start position
     */
    protected Point getIconOrigin() {
        Rectangle bounds = getBounds();
        return new Point(bounds.x + bounds.width - 20, bounds.y + 7);
    }
    
    @Override
    public IDiagramModelArchimateObject getDiagramModelObject() {
        return (IDiagramModelArchimateObject)super.getDiagramModelObject();
    }

}
