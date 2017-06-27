/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.editor.diagram.figures.diagram;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

import com.archimatetool.editor.diagram.figures.AbstractTextControlContainerFigure;
import com.archimatetool.editor.diagram.figures.ToolTipFigure;
import com.archimatetool.model.IDiagramModelObject;


/**
 * Group Figure
 * 
 * @author Phillip Beauvoir
 */
public class GroupFigure extends AbstractTextControlContainerFigure {
    
    protected static final int TOPBAR_HEIGHT = 18;
    private static final float INSET = 2f;
    
    public GroupFigure(IDiagramModelObject diagramModelObject) {
        super(diagramModelObject, LABEL_CONTROL);
    }   

    @Override
    public IFigure getToolTip() {
        ToolTipFigure tooltip = (ToolTipFigure)super.getToolTip();
        
        if(tooltip == null) {
            return null;
        }
        
        tooltip.setText(Messages.GroupFigure_0);
        
        return tooltip;
    }
    
    /**
     * Connection Anchor adjusts for Group shape
     */
    static class GroupFigureConnectionAnchor extends ChopboxAnchor {
        public GroupFigureConnectionAnchor(IFigure owner) {
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
        return new GroupFigureConnectionAnchor(this);
    }

}
