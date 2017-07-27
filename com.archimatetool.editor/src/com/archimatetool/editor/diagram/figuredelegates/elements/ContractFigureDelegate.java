package com.archimatetool.editor.diagram.figuredelegates.elements;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;

import com.archimatetool.editor.diagram.figures.IDiagramModelObjectFigure;
import com.archimatetool.model.ITextPosition;

public class ContractFigureDelegate extends ObjectFigureDelegate {

	public ContractFigureDelegate(IDiagramModelObjectFigure owner) {
		super(owner);
	}
	
	@Override
    public void drawFigure(Graphics graphics) {
        super.drawFigure(graphics);
        
        graphics.pushState();
        
        Rectangle bounds = getBounds();
        
        // Line
        graphics.setForegroundColor(getLineColor());

        bounds.width--;
        graphics.drawLine(bounds.x, bounds.getBottom().y - TOP_MARGIN, bounds.getRight().x, bounds.getBottom().y - TOP_MARGIN);
        
        graphics.popState();
    }
    
    @Override
    public Rectangle calculateTextControlBounds() {
        int textPosition = ((ITextPosition)getOwner().getDiagramModelObject()).getTextPosition();
        if(textPosition == ITextPosition.TEXT_POSITION_BOTTOM) {
            Rectangle bounds = getBounds();
            bounds.y -= TOP_MARGIN - 4;
            return bounds;
        }
        else {
            return super.calculateTextControlBounds();
        }
    }

}
