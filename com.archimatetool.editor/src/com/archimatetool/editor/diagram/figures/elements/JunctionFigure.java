/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.editor.diagram.figures.elements;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.EllipseAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;

import com.archimatetool.editor.diagram.figures.AbstractDiagramModelObjectFigure;

/**
 * Junction Figure
 * 
 * @author Phillip Beauvoir
 */
public class JunctionFigure extends AbstractDiagramModelObjectFigure {

    @Override
    public void refreshVisuals() {
        repaint(); // repaint when figure changes
    }
    
    @Override
    public IFigure getTextControl() {
        return null;
    }

    @Override
    public void dispose() {
    }

    @Override
    public boolean didClickTextControl(Point requestLoc) {
        return false;
    }

    @Override
    protected void setUI() {
    }
    
    @Override
    public ConnectionAnchor getDefaultConnectionAnchor() {
        return new EllipseAnchor(this);
    }
}
