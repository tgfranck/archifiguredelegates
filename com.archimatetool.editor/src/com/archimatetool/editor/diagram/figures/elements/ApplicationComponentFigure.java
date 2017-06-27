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
import com.archimatetool.model.IDiagramModelArchimateObject;


/**
 * Figure for an Application Component
 * 
 * @author Phillip Beauvoir
 */
public class ApplicationComponentFigure extends AbstractTextControlContainerFigure {
    

    
//    protected IFigureDelegate fMainFigureDelegate;
    
    public ApplicationComponentFigure() {
        super(TEXT_FLOW_CONTROL);
        
        //fMainFigureDelegate = new RectangleFigureDelegate(this, 20 - getTextControlMarginWidth());
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
        
        // start bottom left
        path.moveTo(pt.x, pt.y);
        path.lineTo(pt.x, pt.y - 4);
        
        path.moveTo(pt.x, pt.y - 6);
        path.lineTo(pt.x, pt.y - 8);
        
        path.moveTo(pt.x, pt.y - 11);
        path.lineTo(pt.x, pt.y - 13);

        // line right
        path.lineTo(pt.x + 10, pt.y - 13);
        // line down
        path.lineTo(pt.x + 10, pt.y);
        // line left
        path.lineTo(pt.x - 0.5f, pt.y);
        
        path.addRectangle(pt.x - 3, pt.y - 11, 6, 2.5f);
        path.addRectangle(pt.x - 3, pt.y - 6, 6, 2.5f);

        graphics.drawPath(path);
        path.dispose();
        
        graphics.popState();
    }
    
    /**
     * @return The icon start position
     */
    protected Point getIconOrigin() {
        Rectangle bounds = getBounds();
        return new Point(bounds.x + bounds.width - 15, bounds.y + 19);
    }

//    @Override
//    public IFigureDelegate getFigureDelegate() {
//        int type = getDiagramModelObject().getType();
//        return type == 1 ? fMainFigureDelegate : null;
//    }
    
    @Override
    public IDiagramModelArchimateObject getDiagramModelObject() {
        return (IDiagramModelArchimateObject)super.getDiagramModelObject();
    }
    
    
}