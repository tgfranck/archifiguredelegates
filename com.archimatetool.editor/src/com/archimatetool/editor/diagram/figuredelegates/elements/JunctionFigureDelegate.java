package com.archimatetool.editor.diagram.figuredelegates.elements;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;

import com.archimatetool.editor.diagram.figuredelegates.AbstractFigureDelegate;
import com.archimatetool.editor.diagram.figures.IDiagramModelObjectFigure;
import com.archimatetool.model.IJunction;
import com.archimatetool.model.impl.DiagramModelArchimateObject;

public class JunctionFigureDelegate extends AbstractFigureDelegate {

	public JunctionFigureDelegate(IDiagramModelObjectFigure owner) {
		super(owner);
	}
	
	public void drawFigure(Graphics graphics){
		graphics.pushState();
        
        graphics.setAntialias(SWT.ON);
        
        if(!isEnabled()) {
            setDisabledState(graphics);
        }
        
        Rectangle bounds = getBounds().getCopy();
        
        String type = ((IJunction)((DiagramModelArchimateObject)getOwner().getDiagramModelObject()).getArchimateElement()).getType();
        switch(type) {
            case IJunction.AND_JUNCTION_TYPE:
            default:
                graphics.setBackgroundColor(getFillColor());
                graphics.fillOval(bounds.getCopy());                
                break;

            case IJunction.OR_JUNCTION_TYPE:
                graphics.setBackgroundColor(getFillColor());
                graphics.drawOval(bounds.x, bounds.y, bounds.width - 1, bounds.height - 1);
                break;
        }
        
        graphics.popState();
	}

	@Override
	public void drawShape(Graphics graphics) {
		graphics.pushState();
        
        graphics.setAntialias(SWT.ON);	
        
        Rectangle bounds = getBounds().getCopy();
        
        String type = ((IJunction)((DiagramModelArchimateObject)getOwner().getDiagramModelObject()).getArchimateElement()).getType();
        switch(type) {
            case IJunction.AND_JUNCTION_TYPE:
            default:
                graphics.fillOval(bounds.getCopy());                
                break;
            case IJunction.OR_JUNCTION_TYPE:
                graphics.drawOval(bounds.x, bounds.y, bounds.width - 1, bounds.height - 1);
                break;
        }
        
        graphics.popState();
	}

}
