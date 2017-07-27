/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.editor.diagram.figures.elements;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import com.archimatetool.editor.diagram.figures.AbstractTextControlContainerFigure;

/**
 * Grouping Figure
 * 
 * @author Phillip Beauvoir
 */
public class GroupingFigure extends AbstractTextControlContainerFigure {
    
    private static final int TOPBAR_HEIGHT = 18;
    private static final float INSET = 1.4f;
    
    public GroupingFigure() {
        super(LABEL_CONTROL);
    }

    /**
     * Connection Anchor adjusts for Group shape
     */
    static class GroupingFigureConnectionAnchor extends ChopboxAnchor {
        public GroupingFigureConnectionAnchor(IFigure owner) {
            super(owner);
        }
        
        @Override
        public Point getLocation(Point reference) {
            Point pt = super.getLocation(reference);
            
            Rectangle r = getBox().getCopy();
            getOwner().translateToAbsolute(r);
            
            int shiftY = TOPBAR_HEIGHT - (pt.y - r.y) - 1;
            
            if(pt.x > r.x + (r.width / INSET) && shiftY > 0) {
                pt.y += shiftY;
            }
            
            return pt;
        };
    }

    @Override
    public ConnectionAnchor getDefaultConnectionAnchor() {
        return new GroupingFigureConnectionAnchor(this);
    }
}
