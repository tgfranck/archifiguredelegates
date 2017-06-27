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

/**
 * Figure for a Goal
 * 
 * @author Phillip Beauvoir
 */
public class GoalFigure extends AbstractMotivationFigure {

    @Override
    protected void drawFigure(Graphics graphics) {
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
        graphics.setBackgroundColor(isEnabled() ? ColorConstants.black : ColorConstants.gray);
        
        Point pt = getIconOrigin();
        
        Path path = new Path(null);

        graphics.setLineWidthFloat(1.2f);
        
        path.addArc(pt.x, pt.y, 13, 13, 0, 360);
        path.addArc(pt.x + 2.5f, pt.y + 2.5f, 8, 8, 0, 360);
        
        graphics.drawPath(path);
        path.dispose();

        graphics.fillOval(pt.x + 5, pt.y + 5, 4, 4);
        
        graphics.popState();
    }
    
    /**
     * @return The icon start position
     */
    protected Point getIconOrigin() {
        Rectangle bounds = getBounds();
        return new Point(bounds.x + bounds.width - 20, bounds.y + 6);
    }
    
    @Override
    protected int getIconOffset() {
        return 22;
    }

}