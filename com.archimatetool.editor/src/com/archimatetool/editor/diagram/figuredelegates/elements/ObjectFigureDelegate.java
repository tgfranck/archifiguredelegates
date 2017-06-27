package com.archimatetool.editor.diagram.figuredelegates.elements;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Pattern;

import com.archimatetool.editor.diagram.figures.FigureUtils;
import com.archimatetool.editor.diagram.figures.IDiagramModelObjectFigure;
import com.archimatetool.editor.preferences.IPreferenceConstants;
import com.archimatetool.editor.preferences.Preferences;
import com.archimatetool.model.ITextPosition;

public class ObjectFigureDelegate extends RectangleFigureDelegate{
	
    protected static final int TOP_MARGIN = 12;

	public ObjectFigureDelegate(IDiagramModelObjectFigure owner) {
		super(owner);
	}
	
	@Override
    public void drawFigure(Graphics graphics) {
        graphics.pushState();
        
        Rectangle bounds = getBounds();
        
        if(!isEnabled()) {
            setDisabledState(graphics);
        }
        
        // Main Fill
        graphics.setBackgroundColor(getFillColor());
        
        Pattern gradient = null;
        if(Preferences.STORE.getBoolean(IPreferenceConstants.SHOW_GRADIENT)) {
            gradient = FigureUtils.createGradient(graphics, bounds, getFillColor());
            graphics.setBackgroundPattern(gradient);
        }
        
        graphics.fillRectangle(bounds);
        
        if(gradient != null) {
            gradient.dispose();
        }

        // Outline
        graphics.setForegroundColor(getLineColor());

        bounds.width--;
        bounds.height--;
        graphics.drawLine(bounds.x, bounds.y + TOP_MARGIN, bounds.x + bounds.width, bounds.y + TOP_MARGIN);
        graphics.drawRectangle(bounds);
        
        graphics.popState();
    }
    
    @Override
    public Rectangle calculateTextControlBounds() {
        Rectangle bounds = getBounds();
        
        int textPosition = ((ITextPosition)getOwner().getDiagramModelObject()).getTextPosition();
        
        if(textPosition == ITextPosition.TEXT_POSITION_TOP) {
            bounds.y += TOP_MARGIN - 4;
        }
        
        return bounds;
    }

}
